package com.example.menuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculActivity extends AppCompatActivity {

    TextView tvNom, tvN, tvFact;
    Button btnCalcul;
    int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcul);
        tvNom = findViewById(R.id.nom);
        tvN = findViewById(R.id.n);
        tvFact = findViewById(R.id.tvFact);
        btnCalcul = findViewById(R.id.btnCalcul);
        Bundle bundle =getIntent().getExtras();
        String nom = bundle.getString("keyNom");
        n = bundle.getInt("keyN");
        tvNom.setText(nom);
        tvN.setText(String.valueOf(n));
    }

    public void calculFact(View view) {
        int fact = 1;
        for (int i = 2; i < n; i++) {
            fact*=i;
        }
        tvFact.setText(String.valueOf(fact));
    }

    public void okClick(View view) {
        Intent intentRes = new Intent();
        intentRes.putExtra("keyRes", tvFact.getText().toString());
        setResult(RESULT_OK, intentRes);
        CalculActivity.this.finish();
    }

    public void Annuler(View view) {
        setResult(RESULT_CANCELED);
        CalculActivity.this.finish();
    }
}