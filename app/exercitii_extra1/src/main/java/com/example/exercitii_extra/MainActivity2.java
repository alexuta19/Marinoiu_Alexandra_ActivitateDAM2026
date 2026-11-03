package com.example.exercitii_extra;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.Toast;
public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button ButonDeschidere = findViewById(R.id.button1);
        ButonDeschidere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(MainActivity2.this, MainActivity3.class);

                Bundle bundle1= new Bundle();
                bundle1.putString("mesaj", "mesajul din bundle");
                bundle1.putInt("nr1", 6);
                bundle1.putInt("nr2",7);

                intent1.putExtras(bundle1);
                startActivityForResult(intent1, 1);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle bundle = data.getExtras();
            String mesaj = bundle.getString("mesaj");
            int suma = bundle.getInt("suma");

            Toast.makeText(this, mesaj + " " + suma, Toast.LENGTH_LONG).show();
        }
    }
}