package com.example.palavrascruzadas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class BD_Class extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "USUARIOS.db";
    private static final String TABLE_NAME = "usuarios";
    private static final int DATABASE_Version = 15;

    private static final String UID = "id";
    private static final String LOGIN = "Login";
    private static final String EMAIL = "Email";
    private static final String SENHA = "Senha";

    private static final String LV1 = "lv1", LV2 = "lv2", LV3 = "lv3";
    private static final String LV4 = "lv4", LV5 = "lv5", LV6 = "lv6";
    private static final String LV7 = "lv7", LV8 = "lv8", LV9 = "lv9";
    private static final String LV10 = "lv10", LV11 = "lv11", LV12 = "lv12";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                LOGIN + " VARCHAR(255) ," + EMAIL + " VARCHAR(255) ," +SENHA + " VARCHAR(255) ," +
                                                LV1 + " INTEGER ,"  + LV2 + " INTEGER ," + LV3 + " INTEGER ," +
                                                LV4 + " INTEGER ,"  + LV5 + " INTEGER ," + LV6 + " INTEGER ," +
                                                LV7 + " INTEGER ,"  + LV8 + " INTEGER ," + LV9 + " INTEGER ," +
                                                LV10 + " INTEGER ," + LV11 + " INTEGER ," + LV12 + " INTEGER );";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    private String[] LEVEL_AUX = { LV1, LV2, LV3, LV4, LV5, LV6, LV7, LV8, LV9, LV10, LV11, LV12 };

    private Context context;

    SQLiteDatabase db;

    public BD_Class(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
        this.db = db;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(DROP_TABLE);
        this.onCreate(db);
    }

    public void  insertData(String Login, String Email, String Senha) {

        db = this.getWritableDatabase();
        ContentValues Values = new ContentValues();

        String query = "select * from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        int count = cursor.getCount();

        if (count == 0){
            Values.put(UID, count);
        } else {
            Values.put(UID, Last_id() + 1);
        }

        Values.put(LOGIN, Login);
        Values.put(EMAIL, Email);
        Values.put(SENHA, Senha);

        for(int i = 0; i < LEVEL_AUX.length; i++) {
            Values.put(LEVEL_AUX[i], "0");
        }

        db.insert(TABLE_NAME, null , Values);
        db.close();
    }
    public void UpPonto(String Login, int Ponto, int Level) {

        db = this.getWritableDatabase();
        String query = "select * from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext())
        {
            String nome_aux = cursor.getString(cursor.getColumnIndex(LOGIN));
            if (Login.equals(nome_aux)){

                ContentValues Values = new ContentValues();
                int Ponto_aux = Integer.parseInt(cursor.getString(cursor.getColumnIndex(LEVEL_AUX[Level]))) ;

                if (Ponto > Ponto_aux ) {
                    Values.put(LEVEL_AUX[Level], String.valueOf(Ponto));
                    db.update(TABLE_NAME, Values, LOGIN + " = ?", new String[]{Login});
                }
            }
        }
    }

    public void delDta(String Nome) {

        db = this.getWritableDatabase();
        db.delete(TABLE_NAME, LOGIN + " = ?",new String[]{String.valueOf(Nome)});
    }
    /*******************

        SEARCH

     ********************/
    public int Last_id()
    {
        db = this.getReadableDatabase();
        String query = "select * from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToLast();
        String nome_aux;

        nome_aux = cursor.getString(cursor.getColumnIndex(UID));

        return Integer.parseInt(nome_aux);
    }
    public int Level_Ponto(String Login,int Level )
    {
        db = this.getReadableDatabase();
        String query = "select * from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext())
        {
            String nome_aux = cursor.getString(cursor.getColumnIndex(LOGIN));
            if (Login.equals(nome_aux)){

                int Ponto_aux = Integer.parseInt(cursor.getString(cursor.getColumnIndex(LEVEL_AUX[Level-1]))) ;

                return Ponto_aux;
            }
        }
        return 0;
    }
    public boolean LoginExist(String Login)
    {
        db = this.getReadableDatabase();
        String query = "select * from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext())
        {
            String Login_aux = cursor.getString(cursor.getColumnIndex(LOGIN));
            if (Login.equals(Login_aux)){
                return true;
            }
        }
        return false;
    }
    public boolean EmailExist(String email)
    {
        db = this.getReadableDatabase();
        String query = "select * from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext())
        {
            String email_aux = cursor.getString(cursor.getColumnIndex(EMAIL));
            if (email.equals(email_aux)){
                return true;
            }
        }
        return false;
    }
    public boolean LoginIsTrue(String Login, String Senha)
    {
        db = this.getReadableDatabase();
        String query = "select * from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        while (cursor.moveToNext())
        {
            String Login_aux = cursor.getString(cursor.getColumnIndex(LOGIN));
            if (Login.equals(Login_aux)){
                String Senha_aux = cursor.getString(cursor.getColumnIndex(SENHA));
                if (Senha.equals(Senha_aux)){
                    return true;
                }
            }
        }
        return false;
    }
    /*******************

        LIST

     ********************/
    public ArrayList<BD_Class_AUX> LIST_USER() {

        db = this.getReadableDatabase();
        ArrayList<BD_Class_AUX> List = new ArrayList<BD_Class_AUX>();
        String query = "select * from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);

        if(cursor!=null) {

            while (cursor.moveToNext()) {

                BD_Class_AUX dados = new BD_Class_AUX();

                String Login = cursor.getString(cursor.getColumnIndex(this.LOGIN));
                String Email = cursor.getString(cursor.getColumnIndex(this.EMAIL));

                dados.setLOGIN(Login);
                dados.setEMAIL(Email);
                int PONTO = 0 ;

                for(int i = 0; i < LEVEL_AUX.length; i++) {
                        PONTO = PONTO + cursor.getInt(cursor.getColumnIndex(this.LEVEL_AUX[i]));
                }

                dados.setPONTO(String.valueOf(PONTO));

                List.add(dados);
            }
            if(!cursor.isClosed()) {
                cursor.close();
            }
        }
        return List;
    }
}