package com.example.menuapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
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

    private final int codeCalcul = 66;
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
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == codeCalcul) {
            if (resultCode == RESULT_CANCELED)
                tvMsg.setText("Annulé!");
            if (resultCode == RESULT_OK){
                Bundle extras = data.getExtras();
                String ch= extras.getString("keyRes");
                tvMsg.setText(ch);
            }
        }
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
                Uri uri = Uri.parse("tel:"+edN.getText().toString());
                //Intent intentDial = new Intent(Intent.ACTION_DIAL, uri); OR
                Intent intentDial = new Intent(Intent.ACTION_DIAL);
                intentDial.setData(uri);
                startActivity(intentDial);
                //Toast.makeText(this, "Dial", Toast.LENGTH_SHORT).show();
                break;
            case R.id.itemBrowser:
                String url = "http://www.vermeg.com";
                Uri uriB=Uri.parse(url);
                Intent i = new Intent(Intent.ACTION_VIEW,uriB);
                startActivity(i);
                //Toast.makeText(this, "Browser", Toast.LENGTH_SHORT).show();
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
                //startActivity(intent);
                //Ay code yet7at
                startActivityForResult(intent, codeCalcul);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}