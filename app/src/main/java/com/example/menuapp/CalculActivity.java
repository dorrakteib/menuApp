package com.example.menuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CalculActivity extends AppCompatActivity {

    TextView tvNom, tvN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);
        tvNom = findViewById(R.id.editTextNom);
        tvN = findViewById(R.id.editTextNumber);
        Bundle bundle =getIntent().getExtras();
        String nom = bundle.getString("keyNom");
        int n = bundle.getInt("keyN");
        tvNom.setText(nom);
        tvN.setText(String.valueOf(n));
    }
}