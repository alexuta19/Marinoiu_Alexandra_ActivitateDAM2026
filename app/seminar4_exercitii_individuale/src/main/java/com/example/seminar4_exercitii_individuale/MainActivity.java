package com.example.seminar4_exercitii_individuale;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnDeschideAdaugare;
    private Button btnDeschideAdaugareAi;
    private TextView tvRezultat;

    private final ActivityResultLauncher<Intent> addMancareLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    mancare mancare = (mancare) result.getData().getSerializableExtra("mancare_key");
                    if (mancare != null) {
                        tvRezultat.setText(mancare.toString());
                        Toast.makeText(MainActivity.this, "Salvat: " + mancare.getDenumire(), Toast.LENGTH_LONG).show();
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDeschideAdaugare = findViewById(R.id.btnDeschideAdaugare);
        btnDeschideAdaugareAi = findViewById(R.id.btnDeschideAdaugareAi);
        tvRezultat = findViewById(R.id.tvRezultat);

        // Deschide activitatea clasică
        btnDeschideAdaugare.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddMancareActivity.class);
            addMancareLauncher.launch(intent);
        });

        // Deschide activitatea stilizată cu AI
        btnDeschideAdaugareAi.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddMancareAiActivity.class);
            addMancareLauncher.launch(intent);
        });
    }
}