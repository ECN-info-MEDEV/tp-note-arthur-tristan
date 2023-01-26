package org.centrale.mastermind;

public class Pion {
    String couleur;
    char codeCouleur;
    
    public Pion(String couleur, char codeCouleur) {
        this.couleur = couleur;
        this.codeCouleur = codeCouleur;
    }

    public void affiche() {
        System.out.print(couleur);
    }
}
