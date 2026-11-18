package com.example.pentrutest2;

import java.io.Serializable;

public class Excursie implements Serializable {
    private String destinatie; //editbox
    private int pretPerPersoana; // seekbar
    private boolean bagajExtra; //checkbox
    private boolean pensionar; //switch
    private String anotimp; //radiogroup
    private float rating; //rating bar
    private String locatie; //spinner

    public Excursie() {
    }

    public Excursie(String destinatie, int pretPerPersoana, boolean bagajExtra, boolean pensionar, String anotimp, float rating, String locatie) {
        this.destinatie = destinatie;
        this.pretPerPersoana = pretPerPersoana;
        this.bagajExtra = bagajExtra;
        this.pensionar = pensionar;
        this.anotimp = anotimp;
        this.rating = rating;
        this.locatie = locatie;
    }

    public String getDestinatie() {
        return destinatie;
    }

    public void setDestinatie(String destinatie) {
        this.destinatie = destinatie;
    }

    public int getPretPerPersoana() {
        return pretPerPersoana;
    }

    public void setPretPerPersoana(int pretPerPersoana) {
        this.pretPerPersoana = pretPerPersoana;
    }

    public boolean isBagajExtra() {
        return bagajExtra;
    }

    public void setBagajExtra(boolean bagajExtra) {
        this.bagajExtra = bagajExtra;
    }

    public boolean isPensionar() {
        return pensionar;
    }

    public void setPensionar(boolean pensionar) {
        this.pensionar = pensionar;
    }

    public String getAnotimp() {
        return anotimp;
    }

    public void setAnotimp(String anotimp) {
        this.anotimp = anotimp;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getLocatie() {
        return locatie;
    }

    public void setLocatie(String locatie) {
        this.locatie = locatie;
    }

    @Override
    public String toString() {
        return "Excursie{" +
                "destinatie='" + destinatie + '\'' +
                ", pretPerPersoana=" + pretPerPersoana +
                ", bagajExtra=" + bagajExtra +
                ", pensionar=" + pensionar +
                ", anotimp='" + anotimp + '\'' +
                ", rating=" + rating +
                ", locatie='" + locatie + '\'' +
                '}';
    }
}
