package com.example.seminar8;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.seminar8.ImagineAdapter;
import com.example.seminar8.ImaginiDomeniu;
import com.example.seminar8.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ListaPreparateActivity extends AppCompatActivity {

    private List<ImaginiDomeniu> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_preparate);

        List<String> linkuriImagini = new ArrayList<>();
        linkuriImagini.add("https://cdn.pixabay.com/photo/2014/12/21/23/57/soup-576424_1280.png");
        linkuriImagini.add("https://cdn.pixabay.com/photo/2013/07/13/12/49/chips-160417_1280.png");
        linkuriImagini.add("https://cdn.pixabay.com/photo/2023/10/04/07/24/noodles-8293072_1280.png");
        linkuriImagini.add("https://cdn.pixabay.com/photo/2022/11/21/02/44/hot-dog-7605754_1280.jpg");
        linkuriImagini.add("https://cdn.pixabay.com/photo/2017/05/05/19/39/taco-2288132_1280.png");

        List<String> texte = new ArrayList<>();
        texte.add("Descriere scurtă 1");
        texte.add("Descriere scurtă 2");
        texte.add("Descriere scurtă 3");
        texte.add("Descriere scurtă 4");
        texte.add("Descriere scurtă 5");

        List<Bitmap> imagini = new ArrayList<>();

        Executor executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.myLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {
                for (String link : linkuriImagini) {
                    HttpURLConnection con = null;
                    try {
                        URL url = new URL(link);
                        con = (HttpURLConnection) url.openConnection();
                        InputStream is = con.getInputStream();
                        imagini.add(BitmapFactory.decodeStream(is));
                    } catch (IOException e) {
                        e.printStackTrace();
                        imagini.add(null);
                    } finally {
                        if (con != null) {
                            con.disconnect();
                        }
                    }
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        lista = new ArrayList<>();
                        for (int i = 0; i < linkuriImagini.size(); i++) {
                            ImaginiDomeniu obiect = new ImaginiDomeniu();
                            obiect.setTextAfisat(texte.get(i));
                            obiect.setImagine(imagini.get(i));
                            obiect.setLink("");
                            lista.add(obiect);
                        }

                        ListView lv = findViewById(R.id.imagini);
                        ImagineAdapter adapter = new ImagineAdapter(getApplicationContext(), R.layout.imagine, lista);
                        lv.setAdapter(adapter);
                    }
                });
            }
        });
    }
}