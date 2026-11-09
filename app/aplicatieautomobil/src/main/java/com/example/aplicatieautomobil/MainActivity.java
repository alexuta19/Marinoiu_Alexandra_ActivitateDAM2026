package com.example.aplicatieautomobil;

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

public class MainActivity extends AppCompatActivity {

    private static final int COD_ACTIVITATE2 = 1;
    private static final int COD_ACTIVITATE3 = 2;
    private ArrayList<Automobil> listaAutomobile1 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button butonAdaugare1 = findViewById(R.id.butonAdaugare1);

        butonAdaugare1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentActivitate2 = new Intent(MainActivity.this, AdaugareAutomobilActivity.class);
                startActivityForResult(intentActivitate2, COD_ACTIVITATE2);
            }
        });

        Button butonVeziLista1 = findViewById(R.id.butonVeziLista1);

        butonVeziLista1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentActivitate3 = new Intent(MainActivity.this, ListaAutomobileActivity.class);
                intentActivitate3.putParcelableArrayListExtra("lista", listaAutomobile1);
                startActivityForResult(intentActivitate3, COD_ACTIVITATE3);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == COD_ACTIVITATE2 && resultCode == RESULT_OK && data != null) {
            Bundle bundlePrimit1 = data.getExtras();
            Automobil automobilPrimit1 = bundlePrimit1.getParcelable("automobil");            listaAutomobile1.add(automobilPrimit1);
            Toast.makeText(this, "Adăugat: " + automobilPrimit1.getMarca() + "\nTotal: " + listaAutomobile1.size(),
                    Toast.LENGTH_SHORT).show();
        }
        if (requestCode == COD_ACTIVITATE3 && resultCode == RESULT_OK && data != null) {
            listaAutomobile1 = data.getParcelableArrayListExtra("lista");
        }
    }
}