package com.example.aplicatieautomobil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AdaugareAutomobilActivity extends AppCompatActivity {

    EditText editMarca2;
    EditText editPret2;
    Spinner listaCombustibil2;
    RadioGroup grupCutie2;
    CheckBox bifaAerConditionat2;
    Switch comutatorNoua2;
    RatingBar stele2;
    Button butonSalveaza2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adaugare_automobil);

        editMarca2 = findViewById(R.id.editMarca2);
        editPret2 = findViewById(R.id.editPret2);
        listaCombustibil2 = findViewById(R.id.listaCombustibil2);
        grupCutie2 = findViewById(R.id.grupCutie2);
        bifaAerConditionat2 = findViewById(R.id.bifaAerConditionat2);
        comutatorNoua2 = findViewById(R.id.comutatorNoua2);
        stele2 = findViewById(R.id.stele2);
        butonSalveaza2 = findViewById(R.id.butonSalveaza2);

        butonSalveaza2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editMarca2.getText().toString().isEmpty()
                        || editPret2.getText().toString().isEmpty()) {
                    Toast.makeText(AdaugareAutomobilActivity.this,
                            "Completează marca și prețul", Toast.LENGTH_SHORT).show();
                    return;
                }

                String marcaCitita2 = editMarca2.getText().toString();
                double pretCitit2 = Double.parseDouble(editPret2.getText().toString());
                String combustibilCitit2 = listaCombustibil2.getSelectedItem().toString();

                String cutieCitita2;
                if (grupCutie2.getCheckedRadioButtonId() == R.id.radioManuala2) {
                    cutieCitita2 = "Manuală";
                } else {
                    cutieCitita2 = "Automată";
                }

                boolean aerConditionatCitit2 = bifaAerConditionat2.isChecked();
                boolean nouaCitita2 = comutatorNoua2.isChecked();
                float notaCitita2 = stele2.getRating();

                Automobil automobilNou2 = new Automobil(marcaCitita2, pretCitit2,
                        combustibilCitit2, cutieCitita2, aerConditionatCitit2,
                        nouaCitita2, notaCitita2);

                Bundle bundleAutomobil2 = new Bundle();
                bundleAutomobil2.putParcelable("automobil", automobilNou2);

                Intent intentRezultat2 = new Intent();
                intentRezultat2.putExtras(bundleAutomobil2);
                setResult(RESULT_OK, intentRezultat2);
                finish();
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}