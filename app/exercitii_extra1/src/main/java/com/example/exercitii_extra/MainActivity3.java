package com.example.exercitii_extra;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Toast;
import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Bundle bundle2= getIntent().getExtras();
        String mesaj = bundle2.getString("mesaj");
        int numar1= bundle2.getInt("nr1");
        int numar2= bundle2.getInt("nr2");

        Toast.makeText(this, mesaj + " " + numar1 + " " + numar2, Toast.LENGTH_LONG).show();

        Button buton2 = findViewById(R.id.button3);
       buton2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int suma = numar1 +numar2;

               Bundle bundle2 = new Bundle();
               bundle2.putString("mesaj", "Salut din a treia activitate");
               bundle2.putInt("suma", suma);

               Intent intent = new Intent();
               intent.putExtras(bundle2);
               setResult(RESULT_OK, intent);
               finish();
           }
       });

    }
}