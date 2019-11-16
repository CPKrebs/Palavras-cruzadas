package com.example.palavrascruzadas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class Tela_Menu extends AppCompatActivity {

    TextView edtLogin;
    Button Level1, Level2 ,Level3, Level4, Level5, Level6;
    private String Login;
    private ListView lv;
    private Intent it;

    CustomAdapter Adapter;
    java.util.ArrayList<BD_Class_AUX> ArrayList ;
    BD_Class helper = new BD_Class(this);

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__menu);

        edtLogin = findViewById(R.id.edtLogin);
        Level1 = findViewById(R.id.Level1);
        Level2 = findViewById(R.id.Level2);
        Level3 = findViewById(R.id.Level3);
        Level4 = findViewById(R.id.Level4);
        Level5 = findViewById(R.id.Level5);
        Level6 = findViewById(R.id.Level6);

        lv = findViewById(R.id.LIST);

        Intent itRecebedora = getIntent();
        Bundle bundle = itRecebedora.getExtras();
        Login = bundle.getString("Login");

        edtLogin.setText("Seja bem vindo "+ Login +".");


        it = new Intent(Tela_Menu.this, Tela_Jogo.class);
        it.putExtra("Login", Login);

        Level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it.putExtra("LEVEL",1);
                startActivity(it);
            }
        });

        Level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it.putExtra("LEVEL",2);
                startActivity(it);
            }
        });

        Level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it.putExtra("LEVEL",3);
                startActivity(it);
            }
        });

        Level4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it.putExtra("LEVEL",4);
                startActivity(it);
            }
        });

        Level5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it.putExtra("LEVEL",5);
                startActivity(it);
            }
        });

        Level6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                it.putExtra("LEVEL",6);
                startActivity(it);
            }
        });

        ArrayList = helper.LIST_PROJ();
        Adapter = new CustomAdapter( Tela_Menu.this, ArrayList);
        lv.setAdapter(Adapter);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        switch (id){
            case R.id.itemExcluir:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Tela_Menu.this);
                alertDialogBuilder.setTitle("Tem certesa que quer excluir sua conta");
                alertDialogBuilder
                        .setMessage("Sua pontuação será perdida!")
                        .setCancelable(false)
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                helper.delDta(Login);

                                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Tela_Menu.this);
                                alertDialogBuilder.setTitle("Conta excluída");
                                alertDialogBuilder
                                        .setCancelable(false)
                                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {

                                                Intent it = new Intent( Tela_Menu.this, MainActivity.class);
                                                startActivity(it);
                                            }
                                        });
                                AlertDialog alertDialog = alertDialogBuilder.create();
                                alertDialog.show();
                            }
                        });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                return true;

            case R.id.itemSAIR:
                Intent it = new Intent( Tela_Menu.this, MainActivity.class);
                startActivity(it);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
