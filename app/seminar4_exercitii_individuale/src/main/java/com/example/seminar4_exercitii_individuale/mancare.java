package com.example.seminar4_exercitii_individuale;

import java.io.Serializable;

public class mancare implements Serializable {
    private String denumire;

    private String tip;
    private String categorie;


    public mancare(String denumire, String tip, String categorie) {
        this.denumire = denumire;
        this.tip = tip;
        this.categorie = categorie;
    }

    // Getters
    public String getDenumire() { return denumire; }
    public String getTip() { return tip; }
    public String getCategorie() { return categorie; }


    // Reprezentarea text pe ecranul principal
    @Override
    public String toString() {
        return "Denumire: " + denumire +
                "\nCategorie: " + categorie ;
    }
}