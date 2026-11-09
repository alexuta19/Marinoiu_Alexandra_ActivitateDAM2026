package com.example.aplicatieautomobil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class AutomobilAdapter extends BaseAdapter {
    private List<Automobil> listaAutomobile;
    private Context contextAdaptor;
    private int resursaLayout;

    public AutomobilAdapter(List<Automobil> listaAutomobile, Context contextAdaptor, int resursaLayout) {
        this.listaAutomobile = listaAutomobile;
        this.contextAdaptor = contextAdaptor;
        this.resursaLayout = resursaLayout;
    }

    @Override
    public int getCount() { //cate masini sunt cate randuri am
        return listaAutomobile.size();
    }

    @Override
    public Object getItem(int i) { //ne da masina de pe randul i
        return listaAutomobile.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(contextAdaptor);
        View randAutomobil = inflater.inflate(resursaLayout, viewGroup, false);

        TextView textMarcaRand3 = randAutomobil.findViewById(R.id.textMarcaRand3);
        TextView textPretRand3 = randAutomobil.findViewById(R.id.textPretRand3);
        TextView textMotorRand3 = randAutomobil.findViewById(R.id.textMotorRand3);
        TextView textOptiuniRand3 = randAutomobil.findViewById(R.id.textOptiuniRand3);
        RatingBar steleRand3 = randAutomobil.findViewById(R.id.steleRand3);

        Automobil automobilCurent = (Automobil) getItem(i);

        String aerConditionatText;
        if (automobilCurent.isAerConditionat()) {
            aerConditionatText = "da";
        } else {
            aerConditionatText = "nu";
        }

        String nouaText;
        if (automobilCurent.isNoua()) {
            nouaText = "da";
        } else {
            nouaText = "nu";
        }



        textMarcaRand3.setText(automobilCurent.getMarca());
        textPretRand3.setText("Preț: " + automobilCurent.getPret() + " lei");
        textMotorRand3.setText(automobilCurent.getCombustibil() + ", cutie "
                + automobilCurent.getCutie().toLowerCase());
        textOptiuniRand3.setText("Aer condiționat: " + aerConditionatText
                + " | Nouă: " + nouaText);
        steleRand3.setRating(automobilCurent.getNota());

        return randAutomobil;
    }
}