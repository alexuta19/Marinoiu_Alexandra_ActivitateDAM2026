package com.example.seminar9;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VremeActivity extends AppCompatActivity {

   //1

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vreme);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText etOras = findViewById(R.id.etOras);
        Button btnCauta = findViewById(R.id.btnCauta);
        TextView tvRezultat = findViewById(R.id.tvRezultat);

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        btnCauta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oras = etOras.getText().toString().trim();

                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        //2
                        try {
                            URL url=new URL(link);
                            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                            StringBuilder builder = new StringBuilder("");

                            String linie; //deci e fiecare linie din textul despre vreme
                            while ((linie = reader.readLine()) != null) {
                                builder.append(linie);
                            }
                            reader.close();
                            conn.disconnect();

                                                                                             //scot din json codul
                            JSONArray vector = new JSONArray(builder.toString());
                            JSONObject obiect = vector.getJSONObject(0);
                            String cheieOras = obiect.getString("Key");

                            handler.post(new Runnable() { //modifica textul din text view
                                @Override
                                public void run() {
                                    tvRezultat.setText("Cheia orașului: " + cheieOras);
                                    Toast.makeText(VremeActivity.this, cheieOras, Toast.LENGTH_SHORT).show();
                                }
                            });
                        } catch (Exception e) {
                            e.printStackTrace(); //scrie eroarea in logcat
                            handler.post(new Runnable() { //ne lasa sa modificam
                                @Override
                                public void run() {
                                    tvRezultat.setText("Eroare: " + e.getMessage()); //afis si pe ecran
                                }
                            });
                        }



                    }
                });
            }
        });

        };
    }
