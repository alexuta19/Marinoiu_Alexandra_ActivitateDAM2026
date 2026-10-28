package com.example.seminar4_exercitii_individuale;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tvRezultat;

    private final ArrayList<mancare>ListaMancare= new ArrayList<>();
    private final ActivityResultLauncher<Intent> addMancareLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                    mancare mancareNoua = (mancare) result.getData().getSerializableExtra("mancare_key");
                    if (mancareNoua != null) {
                        ListaMancare.add(mancareNoua);
                        tvRezultat.setText(mancareNoua.toString());
                        afiseazaLista();
                        Toast.makeText(MainActivity.this, "Salvat: " + mancareNoua.getDenumire(), Toast.LENGTH_LONG).show();
                    }
                }
            }
    );

    private void afiseazaLista() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ListaMancare.size(); i++) {
            sb.append(i + 1).append(". ").append(ListaMancare.get(i).toString()).append("\n\n");
        }
        tvRezultat.setText(sb.toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnDeschideAdaugare = findViewById(R.id.btnDeschideAdaugare);
        Button btnDeschideAdaugareAi = findViewById(R.id.btnDeschideAdaugareAi);
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