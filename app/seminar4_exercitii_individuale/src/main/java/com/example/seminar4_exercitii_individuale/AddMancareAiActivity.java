package com.example.seminar4_exercitii_individuale;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddMancareAiActivity extends AppCompatActivity {

    private EditText etDenumire;
    private Spinner spCategorie;
    private Button btnSalveaza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mancare_ai);

        etDenumire = findViewById(R.id.etDenumireAi);
        spCategorie = findViewById(R.id.spCategorieAi);
        btnSalveaza = findViewById(R.id.btnSalveazaAi);

        btnSalveaza.setOnClickListener(v -> {
            String denumire = etDenumire.getText().toString().trim();

            if (denumire.isEmpty()) {
                Toast.makeText(AddMancareAiActivity.this, "Introduceți denumirea!", Toast.LENGTH_SHORT).show();
                return;
            }

            String categorie = spCategorie.getSelectedItem().toString();

            // Obiectul creat prin forma AI
            mancare mancare = new mancare(denumire, 420, "Specialitate AI", categorie, true, true, 4.8f);

            Intent resultIntent = new Intent();
            resultIntent.putExtra("mancare_key", mancare);
            setResult(RESULT_OK, resultIntent);

            finish();
        });
    }
}