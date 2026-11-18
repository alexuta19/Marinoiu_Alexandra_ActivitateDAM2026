package com.example.pentrutest1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdaugaInregistrare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adauga_inregistrare);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //referentierea unui control: adica luam fiecare control folosit in xml ca sa putem sa il folosim in java
        EditText etDenumire = findViewById(R.id.etDenumire);
        EditText etNrStudenti = findViewById(R.id.etNrStudenti);
        EditText etTaxa = findViewById(R.id.etTaxa);
        RatingBar ratingBar = findViewById(R.id.ratingBar);
        Button btnSalveaza = findViewById(R.id.btnSalveaza);
        CheckBox cbAreCamin = findViewById(R.id.cbAreCamin);
        Spinner spTip = findViewById(R.id.spTip);
        RadioButton rbZi = findViewById(R.id.rbZi);
        RadioButton rbSeral = findViewById(R.id.rbSeral);

        btnSalveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // citim textele din EditText-uri
                String denumire = etDenumire.getText().toString().trim();
                String nrText = etNrStudenti.getText().toString().trim();
                String taxaText = etTaxa.getText().toString().trim();

                // validare denumire: să nu fie goală
                if (denumire.isEmpty()) {
                    Toast.makeText(AdaugaInregistrare.this, "Introduceti denumirea", Toast.LENGTH_SHORT).show();
                    return;
                }
                // validare număr studenți: completat
                if (nrText.isEmpty()) {
                    Toast.makeText(AdaugaInregistrare.this, "Introduceți numărul de studenți", Toast.LENGTH_SHORT).show();
                    return;
                }
                // validare taxă: completată
                if (taxaText.isEmpty()) {
                    Toast.makeText(AdaugaInregistrare.this, "Introduceți taxa", Toast.LENGTH_SHORT).show();
                    return;
                }
                //verificam si sa aiba sens nr introdus
                int nrStudenti = Integer.parseInt(nrText);
                if (nrStudenti < 1 || nrStudenti > 100000) {
                    Toast.makeText(AdaugaInregistrare.this, "Numărul de studenți trebuie să fie între 1 și 100000", Toast.LENGTH_SHORT).show();
                    return;
                }

                double taxa = Double.parseDouble(taxaText);
                if (taxa < 0) {
                    Toast.makeText(AdaugaInregistrare.this, "Taxa trebuie să fie un număr pozitiv", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
    }
}