package com.example.pentrutest2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListaInregistrari extends AppCompatActivity {

    private ArrayList<Excursie> listaExcursii = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_inregistrari);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnAduaga = findViewById(R.id.btnAdauga);

        btnAduaga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 =  new Intent(ListaInregistrari.this, AdaugaInregistrare.class);
                startActivityForResult(intent1,101);
            }
        });


        Button btnIesire = findViewById(R.id.btnIesire);

        btnIesire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101 && resultCode == RESULT_OK && data!= null)
        {
            Excursie excursie = (Excursie)
                    data.getSerializableExtra("excursie");
            listaExcursii.add(excursie);
            Toast.makeText(this, "Adaugat: "+ excursie.getDestinatie(), Toast.LENGTH_SHORT).show();
        }
    }
}