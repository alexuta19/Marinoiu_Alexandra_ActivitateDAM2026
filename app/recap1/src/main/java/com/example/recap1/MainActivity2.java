package com.example.recap1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

        Button buton2= findViewById(R.id.button2);
        buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2= new Intent(MainActivity2.this, MainActivity3.class);

                Bundle bundle2= new Bundle();
                bundle2.putString("mesaj2", "Esti in activiatea 3");
                bundle2.putInt("nr1", 10);
                bundle2.putInt("nr2", 5);

                intent2.putExtras(bundle2);
                startActivityForResult(intent2,1);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode ==1 && resultCode== RESULT_OK)
        {
            Bundle bundle2_2 = data.getExtras();
            String mesaj= bundle2_2.getString("mesaj3");
            int suma= bundle2_2.getInt("suma");

            Toast.makeText(this,mesaj+" "+suma, Toast.LENGTH_LONG).show();
        }
    }
}