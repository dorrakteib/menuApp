package com.example.menuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edNom, edN;
    Button btnAction;
    TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNom = findViewById(R.id.editTextNom);
        edN = findViewById(R.id.editTextNumber);
        tvMsg = findViewById(R.id.msg);
        btnAction = findViewById(R.id.btnAction);
    }


}