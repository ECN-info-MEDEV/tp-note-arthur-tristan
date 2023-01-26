package org.centrale.mastermind;

/**
 * Classe hello world
 * 
 * @author Arthur
 */
public class Partie {

    Code codeATrouver;
    int nombreTDJ;
    Joueur j1;
    Joueur j2;

    public Partie(){
        codeATrouver = null;
        nombreTDJ = 0;
        j1 = null;
        j2 = null;
    }

    public Partie(Code codeAtrouver, int nbT, Joueur j1, Joueur j2){
        this.codeATrouver = codeAtrouver;
        this.nombreTDJ = nbT;
        this.j1 = j1;
        this.j2 = j2;
    }

    public void launch(){
        
    }

    public Code getCodeATrouver() {
        return codeATrouver;
    }

    public int getNombreTDJ() {
        return nombreTDJ;
    }

    public Joueur getJ1() {
        return j1;
    }

    public Joueur getJ2() {
        return j2;
    }

    public void setCodeATrouver(Code codeATrouver) {
        this.codeATrouver = codeATrouver;
    }

    public void setNombreTDJ(int nombreTDJ) {
        this.nombreTDJ = nombreTDJ;
    }

    public void setJ1(Joueur j1) {
        this.j1 = j1;
    }

    public void setJ2(Joueur j2) {
        this.j2 = j2;
    }

}