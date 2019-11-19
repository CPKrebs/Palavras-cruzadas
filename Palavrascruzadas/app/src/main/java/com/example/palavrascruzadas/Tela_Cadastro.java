package com.example.palavrascruzadas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tela_Cadastro extends AppCompatActivity {

    private EditText edtNome, edtEmail, edtSenha, edtSenha2;
    private Button btnCadastrar;

    BD_Class helper = new BD_Class(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__cadastro);

        edtNome = findViewById(R.id.edtNome);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        edtSenha2 = findViewById(R.id.edtSenha2);

        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String t1 = edtNome.getText().toString();
                String t2 = edtEmail.getText().toString();
                String t3 = edtSenha.getText().toString();
                String t4 = edtSenha2.getText().toString();

                t1 = t1.replaceAll(" ","");
                t2 = t2.replaceAll(" ","");
                t3 = t3.replaceAll(" ","");
                t4 = t4.replaceAll(" ","");

                if(t1.isEmpty() || t2.isEmpty() || t3.isEmpty() || t4.isEmpty()) {
                    new AlertDialog.Builder(Tela_Cadastro.this).setTitle("Algum campo está vazio!")
                            .setMessage("").show();
                } else if( t3.equals(t4)) {
                    if(helper.LoginExist(t1)){
                        new AlertDialog.Builder(Tela_Cadastro.this).setTitle("Usuario já cadastrado!")
                                .setMessage("").show();
                    } else if(helper.EmailExist(t2)){
                        new AlertDialog.Builder(Tela_Cadastro.this).setTitle("Email já cadastrado!")
                                .setMessage("").show();
                    } else {
                        helper.insertData(t1, t2, t3);
                        new AlertDialog.Builder(Tela_Cadastro.this).setTitle("Usuario cadastrado com sucesso!")
                                .setMessage("").show();
                        Intent it = new Intent(Tela_Cadastro.this, MainActivity.class);
                        startActivity(it);
                    }
                } else {
                    new AlertDialog.Builder(Tela_Cadastro.this).setTitle("Senhas diferentes!")
                            .setMessage("").show();
                }
            }
        });
    }
}
