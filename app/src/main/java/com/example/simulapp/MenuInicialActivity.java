package com.example.simulapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.simulapp.EntrarComCodigoActivity;
import com.example.simulapp.GerarProvaActivity;
import com.example.simulapp.R;
import com.example.simulapp.RedacaoActivity;
import com.google.android.material.button.MaterialButton;

public class MenuInicialActivity extends AppCompatActivity {

    private MaterialButton btnGerarProva, btnRedacao;
    private TextView tvLoginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_inicial);
        btnGerarProva = findViewById(R.id.btnGerarProva);
        btnRedacao = findViewById(R.id.btnRedacao);
        tvLoginLink = findViewById(R.id.tvLoginLink);
        configurarCliques();
    }
    private void configurarCliques() {

        btnGerarProva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuInicialActivity.this, GerarProvaActivity.class);
                startActivity(intent);
            }
        });

        btnRedacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuInicialActivity.this, RedacaoActivity.class);
                startActivity(intent);
            }
        });

        tvLoginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuInicialActivity.this, EntrarComCodigoActivity.class);
                startActivity(intent);
            }
        });
    }
}