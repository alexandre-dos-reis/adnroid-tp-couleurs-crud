package fr.supavenir.lsts.couleurs;

public class Couleur {

    public int a;
    public int r;
    public int g;
    public int b;
    public int id;
    public String nom;

    public Couleur(int a, int r, int g, int b, String nom) {
        this.a = a;
        this.r = r;
        this.g = g;
        this.b = b;
        this.nom = nom;
    }

    public int getId() {return id;}

    public void setId(int id) { this.id = id;}

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int v) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
