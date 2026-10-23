package com.example.seminar4_exercitii_individuale;

import java.io.Serializable;

public class mancare implements Serializable {
    private String denumire;
    private int calorii;
    private String tip;
    private String categorie;
    private boolean esteBio;
    private boolean estePicant;
    private float ratingGust;

    public mancare(String denumire, int calorii, String tip, String categorie, boolean esteBio, boolean estePicant, float ratingGust) {
        this.denumire = denumire;
        this.calorii = calorii;
        this.tip = tip;
        this.categorie = categorie;
        this.esteBio = esteBio;
        this.estePicant = estePicant;
        this.ratingGust = ratingGust;
    }

    // Getters
    public String getDenumire() { return denumire; }
    public int getCalorii() { return calorii; }
    public String getTip() { return tip; }
    public String getCategorie() { return categorie; }
    public boolean isEsteBio() { return esteBio; }
    public boolean isEstePicant() { return estePicant; }
    public float getRatingGust() { return ratingGust; }

    // Reprezentarea text pe ecranul principal
    @Override
    public String toString() {
        return "Denumire: " + denumire +
                "\nCategorie: " + categorie +
                "\nCalorii: " + calorii + " kcal";
    }
}