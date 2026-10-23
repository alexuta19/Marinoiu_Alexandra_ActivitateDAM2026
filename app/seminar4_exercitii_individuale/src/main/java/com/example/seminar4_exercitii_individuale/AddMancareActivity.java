package com.example.seminar4_exercitii_individuale;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddMancareActivity extends AppCompatActivity {

    private EditText etDenumire;
    private Spinner spCategorie;
    private Button btnSalveaza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mancare);

        etDenumire = findViewById(R.id.etDenumire);
        spCategorie = findViewById(R.id.spCategorie);
        btnSalveaza = findViewById(R.id.btnSalveaza);

        btnSalveaza.setOnClickListener(v -> {
            String denumire = etDenumire.getText().toString().trim();

            if (denumire.isEmpty()) {
                Toast.makeText(AddMancareActivity.this, "Introduceți denumirea!", Toast.LENGTH_SHORT).show();
                return;
            }

            String categorie = spCategorie.getSelectedItem().toString();

            // Creăm obiectul Mancare
            mancare mancare = new mancare(denumire, 350, "Fel Principal", categorie, true, false, 4.5f);

            // Trimitem obiectul înapoi în MainActivity
            Intent resultIntent = new Intent();
            resultIntent.putExtra("mancare_key", mancare);
            setResult(RESULT_OK, resultIntent);

            // Închidem ecranul curent
            finish();
        });
    }
}