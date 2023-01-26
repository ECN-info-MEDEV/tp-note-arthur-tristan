package org.centrale.mastermind;

/**
 * Classe qui représente un pion, il est défini par une couleur et un code
 * correspondant à cette couleur :
 * B = Bleu, R = rouge, V = vert, J = jaune, N = noir, W = blanc
 * 
 * @author Arthur et Tristan
 */
public class Pion {
    String couleur;
    char codeCouleur;

    /**
     * Constructeur de Pion 
     * 
     * @param couleur chaine de caractères rerésentant une couleur (bleu, blanc, ...)
     * @param codeCouleur code de la couleur (B pour Bleu, ...)
     */
    public Pion(String couleur, char codeCouleur) {
        this.couleur = couleur;
        this.codeCouleur = codeCouleur;
    }

    /**
     * Permet d'afficher un pion dans la console
     */
    public void affiche() {
        System.out.print(couleur);
    }
}
