package com.info42022simulapp.simulapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.appbar.MaterialToolbar;

public class SobreActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        MaterialToolbar toolbar = findViewById(R.id.toolbarSobre);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(R.string.titulo_sobre);
        }
        toolbar.setTitleTextAppearance(this, R.style.TextAppearance_Simulapp_Title);
        toolbar.setNavigationOnClickListener(v -> finish());
    }
}
