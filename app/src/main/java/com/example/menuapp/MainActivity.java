package com.example.menuapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        registerForContextMenu(btnAction);
        registerForContextMenu(edNom);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.itemCopier:
                Toast.makeText(this, "Copier", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemColler:
                Toast.makeText(this, "Coller", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemAjouter:
                Toast.makeText(this, "Ajouter", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemSupprimer:
                Toast.makeText(this, "Supprimer", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //menu.add("Vermeg");
        getMenuInflater().inflate(R.menu.menu_gen, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v ==  btnAction) {
            getMenuInflater().inflate(R.menu.menu_action, menu);
        }
        if (v ==  edNom) {
            getMenuInflater().inflate(R.menu.menu_edittext, menu);
        }

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.itemDial:
                Toast.makeText(this, "Dial", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemBrowser:
                Toast.makeText(this, "Browser", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemSMS:
                Toast.makeText(this, "SMS", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemEmail:
                Toast.makeText(this, "Email", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemCam:
                Toast.makeText(this, "Caméra", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemGalerie:
                Toast.makeText(this, "Galerie", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemAppel:
                Toast.makeText(this, "Appel", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemExplicit:
                int n = Integer.parseInt(edN.getText().toString());
                //Toast.makeText(this, "Explicit", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, CalculActivity.class);
                intent.putExtra("keyNom", edNom.getText().toString());
                intent.putExtra("keyN", n);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}