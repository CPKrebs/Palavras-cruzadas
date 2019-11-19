package com.example.palavrascruzadas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtSenha, edtLogin;
    private Button btnLogin, btnCadastrar;

    BD_Class helper = new BD_Class(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtLogin = findViewById(R.id.edtLogin);
        edtSenha = findViewById(R.id.edtSenha);

        btnLogin = findViewById(R.id.btnLogin);
        btnCadastrar = findViewById(R.id.btnCadastrar);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String t1 = edtLogin.getText().toString();
                String t2 = edtSenha.getText().toString();

                t1 = t1.replaceAll(" ","");
                t2 = t2.replaceAll(" ","");

                if(t1.isEmpty() || t2.isEmpty()) {
                    new AlertDialog.Builder(MainActivity.this).setTitle("Algum campo está vazio!").setMessage("").show();
                } else if(helper.LoginIsTrue(t1,t2)) {
                    Intent it = new Intent(MainActivity.this, Tela_Menu.class);
                    it.putExtra("Login", t1);
                    startActivity(it);
                } else {
                    new AlertDialog.Builder(MainActivity.this).setTitle("Usuario ou Senha incorretos").setMessage("").show();
                }
            }
        });

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Tela_Cadastro.class);
                startActivity(it);
            }
        });
    }
}
