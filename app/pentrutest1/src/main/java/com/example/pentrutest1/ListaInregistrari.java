package com.example.pentrutest1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListaInregistrari extends AppCompatActivity {

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
        //Găsești elementul, Îi pui un senzor de apăsare,  Faci acțiunea.
        //declaram variabilele de tip buton
        Button btnAdauga = findViewById(R.id.btnAdauga);
        Button btnIesire = findViewById(R.id.btnIesire);

        btnAdauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aici creezi un intent cu numele intent si ii zici ca de aici (this) vrei sa mergi in class
                Intent intent= new Intent(ListaInregistrari.this, AdaugaInregistrare.class);
                startActivity(intent);
            }
        });

        btnIesire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}