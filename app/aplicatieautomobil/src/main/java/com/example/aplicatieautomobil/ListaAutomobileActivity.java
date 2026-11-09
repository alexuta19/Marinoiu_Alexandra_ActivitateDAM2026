package com.example.aplicatieautomobil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ListaAutomobileActivity extends AppCompatActivity {


    ListView listaAutomobile3;
    ArrayList<Automobil> listaPrimita3;

    AutomobilAdapter adaptorAutomobile3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_automobile);

        listaAutomobile3 = findViewById(R.id.listaAutomobile3);

        listaPrimita3 = getIntent().getParcelableArrayListExtra("lista");

        adaptorAutomobile3 = new AutomobilAdapter(listaPrimita3, getApplicationContext(), R.layout.rand_automobil);
        listaAutomobile3.setAdapter(adaptorAutomobile3);

        listaAutomobile3.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Automobil automobilSelectat3 = listaPrimita3.get(position);
                Toast.makeText(ListaAutomobileActivity.this,
                        automobilSelectat3.toString(), Toast.LENGTH_LONG).show();
            }
        });

        listaAutomobile3.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                listaPrimita3.remove(position);
                adaptorAutomobile3.notifyDataSetChanged();

                Intent intentRezultat3 = new Intent();
                intentRezultat3.putParcelableArrayListExtra("lista", listaPrimita3);
                setResult(RESULT_OK, intentRezultat3);

                Toast.makeText(ListaAutomobileActivity.this,
                        "Automobil șters", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}