package com.example.aplicatieautomobil;
import android.os.Parcel;
import android.os.Parcelable;

public class Automobil implements Parcelable {
    private String marca;
    private double pret;
    private String combustibil;
    private String cutie;
    private boolean aerConditionat;
    private boolean noua;
    private float nota;
    public Automobil(String Marca, double Pret, String Combustibil, String Cutie,
                     boolean AerConditionat, boolean Noua, float Nota) {
        this.marca = Marca;
        this.pret = Pret;
        this.combustibil = Combustibil;
        this.cutie = Cutie;
        this.aerConditionat = AerConditionat;
        this.noua = Noua;
        this.nota = Nota;
    }
    protected Automobil(Parcel pachet) {
        marca = pachet.readString();
        pret = pachet.readDouble();
        combustibil = pachet.readString();
        cutie = pachet.readString();
        aerConditionat = pachet.readByte() != 0;
        noua = pachet.readByte() != 0;
        nota = pachet.readFloat();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel destinatie, int flags) {
        destinatie.writeString(marca);
        destinatie.writeDouble(pret);
        destinatie.writeString(combustibil);
        destinatie.writeString(cutie);
        destinatie.writeByte((byte) (aerConditionat ? 1 : 0));
        destinatie.writeByte((byte) (noua ? 1 : 0));
        destinatie.writeFloat(nota);
    }
    public static final Creator<Automobil> CREATOR = new Creator<Automobil>() {
        @Override
        public Automobil createFromParcel(Parcel pachet) {
            return new Automobil(pachet);
        }

        @Override
        public Automobil[] newArray(int dimensiune) {
            return new Automobil[dimensiune];
        }
    };
    public String getMarca() {
        return marca;
    }

    public double getPret() {
        return pret;
    }

    public String getCombustibil() {
        return combustibil;
    }

    public String getCutie() {
        return cutie;
    }

    public boolean isAerConditionat() {
        return aerConditionat;
    }

    public boolean isNoua() {
        return noua;
    }

    public float getNota() {
        return nota;
    }

    @Override
    public String toString() {
        return "Automobil{" +
                "marca='" + marca + '\'' +
                ", pret=" + pret +
                ", combustibil='" + combustibil + '\'' +
                ", cutie='" + cutie + '\'' +
                ", aerConditionat=" + aerConditionat +
                ", noua=" + noua +
                ", nota=" + nota +
                '}';
    }
}
