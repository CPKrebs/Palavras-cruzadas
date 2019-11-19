package com.example.palavrascruzadas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Tela_Regras extends AppCompatActivity {

    private Button btnVoltar;
    private String Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__regras);

        btnVoltar = findViewById(R.id.btnVoltar);

        Intent itRecebedora = getIntent();
        Bundle bundle = itRecebedora.getExtras();
        Login = bundle.getString("Login");

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent( Tela_Regras.this, Tela_Menu.class);
                it.putExtra("Login", Login);
                startActivity(it);
            }
        });
    }
}
