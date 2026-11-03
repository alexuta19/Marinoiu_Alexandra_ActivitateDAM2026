package com.example.recap1;

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
        Bundle bundle3= getIntent().getExtras();
        String mesaj = bundle3.getString("mesaj2");
        int numar1= bundle3.getInt("nr1");
        int numar2= bundle3.getInt("nr2");

        Toast.makeText(this, mesaj , Toast.LENGTH_LONG).show();

        Button buton3= findViewById(R.id.button3);
        buton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int suma=numar1+numar2;
                Bundle bundle3_2 = new Bundle();
                bundle3_2.putString("mesaj3","Ai plecat din activitatea 2 si suma este: ");
                bundle3_2.putInt("suma", suma);

                Intent intent3= new Intent();
               intent3.putExtras(bundle3_2);
                setResult(RESULT_OK, intent3);
                finish();

            }
        });
    }
}