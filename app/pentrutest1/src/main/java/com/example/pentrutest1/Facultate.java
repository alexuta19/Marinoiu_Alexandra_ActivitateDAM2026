package com.example.pentrutest1;

import java.io.Serializable;

public class Facultate implements Serializable {
    //definim atributele
    private String denumire;
    private int nrStudenti;
    private double taxa;
    private boolean areCamin;
    private String tip;
    private String formaInvatamant;
    private float rating;

    //constructorul gol;
    //se fol: Facultate  f = new Facultate si dupa completezi atributele unul cate unu;
    // cu f.setDenumire("FEAA"); f.setNrStudenti(1200); etc.
    public Facultate (){
    }

    //constructorul cu parametri;
    //se fol: Facultate f = new Facultate ("FEAA", 1200...) in ordinea in care le ai declarat
    public Facultate (String denumire, int nrStudenti, double taxa, boolean areCamin, String tip, String formaInvatamant, float rating)
    {
        this.denumire = denumire;
        this.nrStudenti=nrStudenti;
        this.taxa = taxa;
        this.areCamin = areCamin;
        this.tip = tip;
        this.formaInvatamant = formaInvatamant;
        this.rating = rating;
    }

    //scriem metodele set si get (cu generate..)
    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getNrStudenti() {
        return nrStudenti;
    }

    public void setNrStudenti(int nrStudenti) {
        this.nrStudenti = nrStudenti;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public boolean isAreCamin() {
        return areCamin;
    }

    public void setAreCamin(boolean areCamin) {
        this.areCamin = areCamin;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getFormaInvatamant() {
        return formaInvatamant;
    }

    public void setFormaInvatamant(String formaInvatamant) {
        this.formaInvatamant = formaInvatamant;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    //scriem metoda to string tot cu generate
    @Override
    public String toString() {
        return "Facultate{" +
                "denumire='" + denumire + '\'' +
                ", nrStudenti=" + nrStudenti +
                ", taxa=" + taxa +
                ", areCamin=" + areCamin +
                ", tip='" + tip + '\'' +
                ", formaInvatamant='" + formaInvatamant + '\'' +
                ", rating=" + rating +
                '}';
    }
}
