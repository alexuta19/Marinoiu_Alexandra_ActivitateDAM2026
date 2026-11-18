package com.example.seminar8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImagineAdapter extends BaseAdapter {
    private Context context;
    private int resursaLayout;
    private List<ImaginiDomeniu> lista;

    public ImagineAdapter(Context context, int resursaLayout, List<ImaginiDomeniu> lista) {
        this.context = context;
        this.resursaLayout = resursaLayout;
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(resursaLayout, parent, false);

        ImaginiDomeniu obiect = lista.get(position);

        ImageView imagineIV = view.findViewById(R.id.imagineIV);
        TextView textTV = view.findViewById(R.id.textTV);

        imagineIV.setImageBitmap(obiect.getImagine());
        textTV.setText(obiect.getTextAfisat());

        return view;
    }
}