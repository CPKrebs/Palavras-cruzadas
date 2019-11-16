package com.example.palavrascruzadas;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

public class Tela_Jogo extends AppCompatActivity {

    private TextView edtTema;
    private TextView edtPalavra;
    private TextView edtDel;

    private Chronometer Crono;

    private EditText edt1, edt2, edt3, edt4, edt5, edt6, edt7, edt8, edt9;
    private EditText edt21, edt22, edt23, edt24, edt25, edt26, edt27, edt28, edt29;
    private EditText edt31, edt32, edt33, edt34, edt35, edt36, edt37, edt38, edt39;
    private EditText edt41, edt42, edt43, edt44, edt45, edt46, edt47, edt48, edt49;
    private EditText edt51, edt52, edt53, edt54, edt55, edt56, edt57, edt58, edt59;
    private EditText edt61, edt62, edt63, edt64, edt65, edt66, edt67, edt68, edt69;

    private TextView btn1, btn2, btn3, btn4;
    private TextView btn21, btn22, btn23, btn24;
    private TextView btn31, btn32, btn33, btn34;

    int ACERTO = 0;
    long PONTO = 0;
    private String Login;
    private View view;
    int LEVEL_AUX = 0;

    private String L1, L2, L3, L4, L5, L6, L7, L8, L9, L10, L11, L12;


    BD_Class helper = new BD_Class(this);


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__jogo);

        INICIALIZA();

        Crono.start();
        Crono.setFormat("Tempo - %s");

        Intent Recebedora = getIntent();
        Bundle bundle = Recebedora.getExtras();
        int Level = bundle.getInt("LEVEL");
        Login = bundle.getString("Login");

        view = new View(getApplicationContext());
        view.setBackgroundResource(R.color.Preto);

        edtDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtPalavra.getText().length()>0) {
                    edtPalavra.setText(edtPalavra.getText().toString().substring(0, edtPalavra.getText().length() - 1));
                }
            }
        });

        switch (Level) {
            case 1:
                edtTema.setText("Insetos");

                LEVEL_AUX = 1;

                SET_MAP( 1,  1, 1,  1,  0,  1,  1,  1,  0,
                        1, 1, 0, 0, 0, 0, 0, 0, 0,
                        1, 1, 1, 1, 0, 1, 1, 1, 0,
                        1, 0, 0, 0, 0, 0, 0, 1, 0,
                        1, 1, 1, 1, 0, 1, 1, 1, 0,
                        1, 1, 1, 1, 1, 1, 1, 1, 0);

                L1 = "H";  L2 = "F";  L3 = "R";  L4 = "T";
                L5 = "A";  L6 = "G";  L7 = "M";  L8 = "L";
                L9 = "E"; L10 = "O"; L11 = "I"; L12 = "B";

                SET_LETRA( );

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L1);
                    }
                });
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L2);
                    }
                });
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L3);
                    }
                });
                btn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L4);
                    }
                });
                btn21.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L5);
                        if(edtPalavra.getText().toString().equals("ABELHA")){
                            edt42.setText("A");
                            edt43.setText("B");
                            edt44.setText("E");
                            edt45.setText("L");
                            edt46.setText("H");
                            edt47.setText("A");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 4){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                        if(edtPalavra.getText().toString().equals("FORMIGA")){
                            edt23.setText("F");
                            edt24.setText("0");
                            edt25.setText("R");
                            edt26.setText("M");
                            edt27.setText("I");
                            edt28.setText("G");
                            edt29.setText("A");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 4){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                        if(edtPalavra.getText().toString().equals("BARATA")){
                            edt9.setText("B");
                            edt29.setText("A");
                            edt39.setText("R");
                            edt49.setText("A");
                            edt59.setText("T");
                            edt69.setText("A");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 4){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                    }
                });
                btn22.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L6);
                    }
                });
                btn23.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L7);
                    }
                });
                btn24.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L8);
                    }
                });
                btn31.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L9);
                    }
                });
                btn32.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L10);
                        if(edtPalavra.getText().toString().equals("GRILO")){
                            edt5.setText("G");
                            edt25.setText("R");
                            edt35.setText("I");
                            edt45.setText("L");
                            edt55.setText("O");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 1){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                    }
                });
                btn33.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L11);
                    }
                });
                btn34.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L12);
                }
                });

                break;
            case 2:
                edtTema.setText("Brinquedos");

                LEVEL_AUX = 2;

                SET_MAP( 1, 1,  0,  1,  0,  0,  0,  0,  1,
                        1, 1, 0, 1, 0, 1, 1, 1, 1,
                        0, 0, 0, 0, 0, 0, 0, 0, 1,
                        1, 1, 0, 1, 0, 1, 1, 1, 1,
                        0, 0, 0, 0, 0, 0, 0, 0, 0,
                        1, 1, 0, 1, 0, 1, 1, 1, 1 );

                L1 = "M";  L2 = "L";  L3 = "O";  L4 = "P";
                L5 = "B";  L6 = "A";  L7 = "S";  L8 = "T";
                L9 = "C"; L10 = "E"; L11 = "N"; L12 = "I";

                SET_LETRA( );

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L1);
                    }
                });
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L2);
                    }
                });
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L3);
                    }
                });
                btn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L4);
                    }
                });
                btn21.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L5);
                    }
                });
                btn22.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L6);
                        if(edtPalavra.getText().toString().equals("BICICLETA")){
                            edt51.setText("B");
                            edt52.setText("I");
                            edt53.setText("C");
                            edt54.setText("I");
                            edt55.setText("C");
                            edt56.setText("L");
                            edt57.setText("E");
                            edt58.setText("T");
                            edt59.setText("A");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 5){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                        if(edtPalavra.getText().toString().equals("BOLA")){
                            edt5.setText("B");
                            edt6.setText("O");
                            edt7.setText("L");
                            edt8.setText("A");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 5){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                        if(edtPalavra.getText().toString().equals("PETECA")){
                            edt3.setText("P");
                            edt23.setText("E");
                            edt33.setText("T");
                            edt43.setText("E");
                            edt53.setText("C");
                            edt63.setText("A");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 5){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                        if(edtPalavra.getText().toString().equals("BONECA")){
                            edt5.setText("B");
                            edt25.setText("O");
                            edt35.setText("N");
                            edt45.setText("E");
                            edt55.setText("C");
                            edt65.setText("A");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 5){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                    }
                });
                btn23.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L7);
                    }
                });
                btn24.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L8);
                    }
                });
                btn31.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L9);
                    }
                });
                btn32.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L10);
                        if(edtPalavra.getText().toString().equals("PATINETE")){
                            edt31.setText("P");
                            edt32.setText("A");
                            edt33.setText("T");
                            edt34.setText("I");
                            edt35.setText("N");
                            edt36.setText("E");
                            edt37.setText("T");
                            edt38.setText("E");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 5){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                    }
                });
                btn33.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L11);
                    }
                });
                btn34.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L12);
                    }
                });


                break;
            case 3:
                edtTema.setText("Carros");

                LEVEL_AUX = 3;

                SET_MAP( 1, 1,  1,  1,  0,  1,  0,  1,  1,
                        0, 0, 0, 0, 0, 0, 0, 1, 1,
                        0, 1, 1, 1, 0, 1, 0, 1, 1,
                        0, 1, 1, 0, 0, 0, 0, 1, 1,
                        0, 1, 1, 1, 0, 1, 1, 1, 1,
                        1, 1, 1, 0, 0, 0, 0, 0, 1 );

                L1 = "B";  L2 = "D";  L3 = "E";  L4 = "K";
                L5 = "O";  L6 = "C";  L7 = "F";  L8 = "R";
                L9 = "M"; L10 = "A"; L11 = "I"; L12 = "T";

                SET_LETRA( );

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L1);
                    }
                });
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L2);
                        if(edtPalavra.getText().toString().equals("FORD")){
                            edt21.setText("F");
                            edt31.setText("O");
                            edt41.setText("R");
                            edt51.setText("D");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 6){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                    }
                });
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L3);
                    }
                });
                btn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L4);
                    }
                });
                btn21.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L5);
                        if(edtPalavra.getText().toString().equals("CAMARO")){
                            edt5.setText("C");
                            edt25.setText("A");
                            edt35.setText("M");
                            edt45.setText("A");
                            edt55.setText("R");
                            edt65.setText("O");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 6){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                    }
                });
                btn22.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L6);
                    }
                });
                btn23.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L7);
                    }
                });
                btn24.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L8);
                    }
                });
                btn31.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L9);
                    }
                });
                btn32.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L10);
                    }
                });
                btn33.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L11);
                        if(edtPalavra.getText().toString().equals("FERRARI")){
                            edt21.setText("F");
                            edt22.setText("E");
                            edt23.setText("R");
                            edt24.setText("R");
                            edt25.setText("A");
                            edt26.setText("R");
                            edt27.setText("I");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 6){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                        if(edtPalavra.getText().toString().equals("KOMBI")){
                            edt64.setText("K");
                            edt65.setText("O");
                            edt66.setText("M");
                            edt67.setText("B");
                            edt68.setText("I");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 6){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                    }
                });
                btn34.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L12);
                        if(edtPalavra.getText().toString().equals("FIAT")){
                            edt21.setText("F");
                            edt22.setText("I");
                            edt23.setText("A");
                            edt24.setText("T");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 6){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                        if(edtPalavra.getText().toString().equals("KART")){
                            edt44.setText("K");
                            edt45.setText("A");
                            edt46.setText("R");
                            edt47.setText("T");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 6){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                    }
                });

                break;

            case 4:
                edtTema.setText("Cores");

                LEVEL_AUX = 4;

                SET_MAP( 0, 1,  1,  1,  0,  1,  0,  1,  1,
                        0, 0, 0, 0, 0, 0, 0, 1, 1,
                        0, 1, 0, 1, 0, 1, 0, 1, 1,
                        0, 1, 0, 1, 0, 1, 0, 1, 1,
                        0, 1, 0, 1, 0, 1, 1, 1, 1,
                        0, 1, 1, 1, 1, 1, 1, 1, 1 );

                L1 = "A";  L2 = "V";  L3 = "R";  L4 = "U";
                L5 = "L";  L6 = "N";  L7 = "Z";  L8 = "E";
                L9 = "M"; L10 = "D"; L11 = "X"; L12 = "O";

                SET_LETRA( );

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L1);
                    }
                });
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L2);

                    }
                });
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L3);
                    }
                });
                btn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L4);
                    }
                });
                btn21.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L5);
                        if(edtPalavra.getText().toString().equals("AZUL")){
                            edt23.setText("A");
                            edt33.setText("Z");
                            edt43.setText("U");
                            edt53.setText("L");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 5){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                    }
                });
                btn22.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L6);
                    }
                });
                btn23.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L7);
                    }
                });
                btn24.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L8);
                        if(edtPalavra.getText().toString().equals("VERDE")){
                            edt5.setText("V");
                            edt25.setText("E");
                            edt35.setText("R");
                            edt45.setText("D");
                            edt55.setText("E");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 5){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                    }
                });
                btn31.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L9);
                        if(edtPalavra.getText().toString().equals("MARROM")){
                            edt1.setText("M");
                            edt21.setText("A");
                            edt31.setText("R");
                            edt41.setText("R");
                            edt51.setText("O");
                            edt61.setText("M");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 5){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                    }
                });
                btn32.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L10);
                    }
                });
                btn33.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L11);
                    }
                });
                btn34.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L12);
                        if(edtPalavra.getText().toString().equals("ROXO")){
                            edt7.setText("R");
                            edt27.setText("O");
                            edt37.setText("X");
                            edt47.setText("O");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 5){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                        if(edtPalavra.getText().toString().equals("AMARELO")){
                            edt21.setText("A");
                            edt22.setText("M");
                            edt23.setText("A");
                            edt24.setText("R");
                            edt25.setText("E");
                            edt26.setText("L");
                            edt27.setText("O");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 5){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                    }
                });

                break;


            case 5:
                edtTema.setText("Comida");

                LEVEL_AUX = 5;

                SET_MAP( 1, 0,  0,  0,  0,  0,  0,  1,  1,
                        1, 0, 1, 1, 1, 1, 0, 1, 1,
                        0, 0, 0, 0, 0, 1, 0, 0, 1,
                        1, 0, 1, 1, 1, 1, 1, 0, 1,
                        1, 0, 1, 1, 1, 1, 1, 0, 1,
                        0, 0, 0, 0, 0, 0, 0, 0, 1 );

                L1 = "J";  L2 = "A";  L3 = "Z";  L4 = "F";
                L5 = "R";  L6 = "Ã";  L7 = "M";  L8 = "C";
                L9 = "E"; L10 = "I"; L11 = "V"; L12 = "O";

                SET_LETRA( );

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L1);
                    }
                });
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L2);
                        if(edtPalavra.getText().toString().equals("FAROFA")){
                            edt2.setText("F");
                            edt22.setText("A");
                            edt32.setText("R");
                            edt42.setText("O");
                            edt52.setText("F");
                            edt62.setText("A");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 6){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                    }
                });
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L3);
                        if(edtPalavra.getText().toString().equals("ARROZ")){
                            edt31.setText("A");
                            edt32.setText("R");
                            edt33.setText("R");
                            edt34.setText("O");
                            edt35.setText("Z");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 6){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                    }
                });
                btn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L4);
                    }
                });
                btn21.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L5);
                    }
                });
                btn22.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L6);
                    }
                });
                btn23.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L7);
                    }
                });
                btn24.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L8);
                    }
                });
                btn31.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L9);
                    }
                });
                btn32.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L10);
                    }
                });
                btn33.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L11);
                    }
                });
                btn34.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L12);
                        if(edtPalavra.getText().toString().equals("OVO")){
                            edt7.setText("O");
                            edt27.setText("V");
                            edt37.setText("O");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 6){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                        if(edtPalavra.getText().toString().equals("COCO")){
                            edt38.setText("C");
                            edt48.setText("O");
                            edt58.setText("C");
                            edt68.setText("O");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 6){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                        if(edtPalavra.getText().toString().equals("FEIJÃO")){
                            edt2.setText("F");
                            edt3.setText("E");
                            edt4.setText("I");
                            edt5.setText("J");
                            edt6.setText("Ã");
                            edt7.setText("O");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 6){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                        if(edtPalavra.getText().toString().equals("MACARRÃO")){
                            edt61.setText("M");
                            edt62.setText("A");
                            edt63.setText("C");
                            edt64.setText("A");
                            edt65.setText("R");
                            edt66.setText("R");
                            edt67.setText("Ã");
                            edt68.setText("O");
                            edtPalavra.setText("");
                            ACERTO = ACERTO + 1;
                            if(ACERTO == 6){
                                CALULO_PONTO(LEVEL_AUX);
                            }
                        }
                    }
                });

                break;



            default:
                edtTema.setText("EM DESENVOLVIMENTO");
                Crono.stop();

                SET_MAP( 1, 1,  1,  1,  1,  1,  1,  1,  1,
                        1, 1, 1, 1, 1, 1, 1, 1, 1,
                        1, 1, 1, 1, 1, 1, 1, 1, 1,
                        1, 1, 1, 1, 1, 1, 1, 1, 1,
                        1, 1, 1, 1, 1, 1, 1, 1, 1,
                        1, 1, 1, 1, 1, 1, 1, 1, 1 );

                L1 = "";  L2 = "";  L3 = "";  L4 = "";
                L5 = "";  L6 = "";  L7 = "";  L8 = "";
                L9 = ""; L10 = ""; L11 = ""; L12 = "";

                SET_LETRA( );

                btn1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L1);
                    }
                });
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L2);
                    }
                });
                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L3);
                    }
                });
                btn4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L4);
                    }
                });
                btn21.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L5);
                    }
                });
                btn22.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L6);
                    }
                });
                btn23.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L7);
                    }
                });
                btn24.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L8);
                    }
                });
                btn31.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L9);
                    }
                });
                btn32.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L10);
                    }
                });
                btn33.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L11);
                    }
                });
                btn34.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtPalavra.setText(edtPalavra.getText().toString() + L12);
                    }
                });

                break;
        }
    }
    private void MSG_FINAL( int Ponto) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Tela_Jogo.this);
        alertDialogBuilder.setTitle("PARABENS!");
        alertDialogBuilder
                .setMessage("Sua pontuação foi de: "+ Ponto)
                .setCancelable(false)
                .setPositiveButton("Voltar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent it = new Intent(Tela_Jogo.this, Tela_Menu.class);
                        it.putExtra("Login", Login);
                        startActivity(it);
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    private void CALULO_PONTO(int Level){

        Crono.stop();
        PONTO = (int)SystemClock.elapsedRealtime() - Crono.getBase();
        int PONTO_aux = ((int) PONTO)/100;

        if(PONTO_aux <=300){
            PONTO_aux = 1000;
        } else if(PONTO_aux >=1200){
            PONTO_aux = 100;
        } else {
            PONTO_aux = 1300 - PONTO_aux;
        }

        helper.UpPonto( Login, PONTO_aux, Level-1);
        MSG_FINAL(PONTO_aux);
    }

    private void SET_LETRA( ){

        btn1.setText(L1);   btn2.setText(L2);   btn3.setText(L3);   btn4.setText(L4);
        btn21.setText(L5);  btn22.setText(L6);  btn23.setText(L7);  btn24.setText(L8);
        btn31.setText(L9);  btn32.setText(L10); btn33.setText(L11); btn34.setText(L12);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void SET_MAP( int B1,  int B2,  int B3,  int B4,  int B5,  int B6,  int B7,  int B8,  int B9,
                          int B21, int B22, int B23, int B24, int B25, int B26, int B27, int B28, int B29,
                          int B31, int B32, int B33, int B34, int B35, int B36, int B37, int B38, int B39,
                          int B41, int B42, int B43, int B44, int B45, int B46, int B47, int B48, int B49,
                          int B51, int B52, int B53, int B54, int B55, int B56, int B57, int B58, int B59,
                          int B61, int B62, int B63, int B64, int B65, int B66, int B67, int B68, int B69) {

        if( B1 == 1 ) edt1.setBackground(view.getBackground());
        if( B21 == 1 ) edt21.setBackground(view.getBackground());
        if( B31 == 1 ) edt31.setBackground(view.getBackground());
        if( B41 == 1 ) edt41.setBackground(view.getBackground());
        if( B51 == 1 ) edt51.setBackground(view.getBackground());
        if( B61 == 1 ) edt61.setBackground(view.getBackground());

        if( B2 == 1 ) edt2.setBackground(view.getBackground());
        if( B22 == 1 ) edt22.setBackground(view.getBackground());
        if( B32 == 1 ) edt32.setBackground(view.getBackground());
        if( B42 == 1 ) edt42.setBackground(view.getBackground());
        if( B52 == 1 ) edt52.setBackground(view.getBackground());
        if( B62 == 1 ) edt62.setBackground(view.getBackground());

        if( B3 == 1 ) edt3.setBackground(view.getBackground());
        if( B23 == 1 ) edt23.setBackground(view.getBackground());
        if( B33 == 1 ) edt33.setBackground(view.getBackground());
        if( B43 == 1 ) edt43.setBackground(view.getBackground());
        if( B53 == 1 ) edt53.setBackground(view.getBackground());
        if( B63 == 1 ) edt63.setBackground(view.getBackground());

        if( B4 == 1 ) edt4.setBackground(view.getBackground());
        if( B24 == 1 ) edt24.setBackground(view.getBackground());
        if( B34 == 1 ) edt34.setBackground(view.getBackground());
        if( B44 == 1 ) edt44.setBackground(view.getBackground());
        if( B54 == 1 ) edt54.setBackground(view.getBackground());
        if( B64 == 1 ) edt64.setBackground(view.getBackground());

        if( B5 == 1 ) edt5.setBackground(view.getBackground());
        if( B25 == 1 ) edt25.setBackground(view.getBackground());
        if( B35 == 1 ) edt35.setBackground(view.getBackground());
        if( B45 == 1 ) edt45.setBackground(view.getBackground());
        if( B55 == 1 ) edt55.setBackground(view.getBackground());
        if( B65 == 1 ) edt65.setBackground(view.getBackground());

        if( B6 == 1 ) edt6.setBackground(view.getBackground());
        if( B26 == 1 ) edt26.setBackground(view.getBackground());
        if( B36 == 1 ) edt36.setBackground(view.getBackground());
        if( B46 == 1 ) edt46.setBackground(view.getBackground());
        if( B56 == 1 ) edt56.setBackground(view.getBackground());
        if( B66 == 1 ) edt66.setBackground(view.getBackground());

        if( B7 == 1 ) edt7.setBackground(view.getBackground());
        if( B27 == 1 ) edt27.setBackground(view.getBackground());
        if( B37 == 1 ) edt37.setBackground(view.getBackground());
        if( B47 == 1 ) edt47.setBackground(view.getBackground());
        if( B57 == 1 ) edt57.setBackground(view.getBackground());
        if( B67 == 1 ) edt67.setBackground(view.getBackground());

        if( B8 == 1 ) edt8.setBackground(view.getBackground());
        if( B28 == 1 ) edt28.setBackground(view.getBackground());
        if( B38 == 1 ) edt38.setBackground(view.getBackground());
        if( B48 == 1 ) edt48.setBackground(view.getBackground());
        if( B58 == 1 ) edt58.setBackground(view.getBackground());
        if( B68 == 1 ) edt68.setBackground(view.getBackground());

        if( B9 == 1 ) edt9.setBackground(view.getBackground());
        if( B29 == 1 ) edt29.setBackground(view.getBackground());
        if( B39 == 1 ) edt39.setBackground(view.getBackground());
        if( B49 == 1 ) edt49.setBackground(view.getBackground());
        if( B59 == 1 ) edt59.setBackground(view.getBackground());
        if( B69 == 1 ) edt69.setBackground(view.getBackground());

    }

    private void INICIALIZA( ) {

        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        edt3 = findViewById(R.id.edt3);
        edt4 = findViewById(R.id.edt4);
        edt5 = findViewById(R.id.edt5);
        edt6 = findViewById(R.id.edt6);
        edt7 = findViewById(R.id.edt7);
        edt8 = findViewById(R.id.edt8);
        edt9 = findViewById(R.id.edt9);

        edt21 = findViewById(R.id.edt21);
        edt22 = findViewById(R.id.edt22);
        edt23 = findViewById(R.id.edt23);
        edt24 = findViewById(R.id.edt24);
        edt25 = findViewById(R.id.edt25);
        edt26 = findViewById(R.id.edt26);
        edt27 = findViewById(R.id.edt27);
        edt28 = findViewById(R.id.edt28);
        edt29 = findViewById(R.id.edt29);

        edt31 = findViewById(R.id.edt31);
        edt32 = findViewById(R.id.edt32);
        edt33 = findViewById(R.id.edt33);
        edt34 = findViewById(R.id.edt34);
        edt35 = findViewById(R.id.edt35);
        edt36 = findViewById(R.id.edt36);
        edt37 = findViewById(R.id.edt37);
        edt38 = findViewById(R.id.edt38);
        edt39 = findViewById(R.id.edt39);

        edt41 = findViewById(R.id.edt41);
        edt42 = findViewById(R.id.edt42);
        edt43 = findViewById(R.id.edt43);
        edt44 = findViewById(R.id.edt44);
        edt45 = findViewById(R.id.edt45);
        edt46 = findViewById(R.id.edt46);
        edt47 = findViewById(R.id.edt47);
        edt48 = findViewById(R.id.edt48);
        edt49 = findViewById(R.id.edt49);

        edt51 = findViewById(R.id.edt51);
        edt52 = findViewById(R.id.edt52);
        edt53 = findViewById(R.id.edt53);
        edt54 = findViewById(R.id.edt54);
        edt55 = findViewById(R.id.edt55);
        edt56 = findViewById(R.id.edt56);
        edt57 = findViewById(R.id.edt57);
        edt58 = findViewById(R.id.edt58);
        edt59 = findViewById(R.id.edt59);

        edt61 = findViewById(R.id.edt61);
        edt62 = findViewById(R.id.edt62);
        edt63 = findViewById(R.id.edt63);
        edt64 = findViewById(R.id.edt64);
        edt65 = findViewById(R.id.edt65);
        edt66 = findViewById(R.id.edt66);
        edt67 = findViewById(R.id.edt67);
        edt68 = findViewById(R.id.edt68);
        edt69 = findViewById(R.id.edt69);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);

        btn21 = findViewById(R.id.btn21);
        btn22 = findViewById(R.id.btn22);
        btn23 = findViewById(R.id.btn23);
        btn24 = findViewById(R.id.btn24);

        btn31 = findViewById(R.id.btn31);
        btn32 = findViewById(R.id.btn32);
        btn33 = findViewById(R.id.btn33);
        btn34 = findViewById(R.id.btn34);

        edtTema = findViewById(R.id.edtTema);
        edtPalavra = findViewById(R.id.edtPalavra);
        edtDel = findViewById(R.id.edtDel);

        Crono = findViewById(R.id.Crono);
    }
}
