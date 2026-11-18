package com.example.pentrutest2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
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

        //referentiem controalele

        EditText etdestinatie= findViewById(R.id.et_destinatie);
        SeekBar sbPret= findViewById(R.id.sb_pret);
        CheckBox cbBagatExtra =findViewById(R.id.cb_bagaj_extra);
        Switch swPensionar=findViewById(R.id.sw_pensionar);
        RadioButton rbIarna=findViewById(R.id.rb_iarna);
        RadioButton rbPrimavara=findViewById(R.id.rb_primavara);
        RadioButton rbVara=findViewById(R.id.rb_vara);
        RadioButton rbToamna=findViewById(R.id.rb_toamna);
        RatingBar rbRating=findViewById(R.id.rbar_rating);
        Spinner spLocatie=findViewById(R.id.sp_locatie);
        Button btnSalveaza=findViewById(R.id.btnSalveaza);

        btnSalveaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //facem validarea
                String destinatie = etdestinatie.toString().trim();
                if (destinatie.isEmpty()) {
                    Toast.makeText(AdaugaInregistrare.this, "Adauga destinatie", Toast.LENGTH_SHORT).show();
                    return;
                }

                //ne cream obiectul
                Excursie excursie= new Excursie();
                excursie.setDestinatie(etdestinatie.getText().toString());
                excursie.setPretPerPersoana(sbPret.getProgress());
                excursie.setBagajExtra(cbBagatExtra.isChecked());
                excursie.setPensionar(swPensionar.isChecked());

                String anotimp ="";
                if (rbIarna.isChecked())
                {
                    anotimp = "Iarnă";
                } else if (rbPrimavara.isChecked()) {
                    anotimp = "Primăvară";
                } else if (rbVara.isChecked()) {
                    anotimp = "Vară";
                } else if (rbToamna.isChecked()) {
                    anotimp = "Toamnă";
                }

                excursie.setAnotimp(anotimp);

                excursie.setRating(rbRating.getRating());
                excursie.setLocatie(spLocatie.getSelectedItem().toString());

                Intent intent = new Intent();
                intent.putExtra("excursie", excursie);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}