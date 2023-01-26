package org.centrale.mastermind;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private int score;
    private String pseudo;
    private List<Code> codeEssais;

    public Joueur(String pseudo){
        this.pseudo = pseudo;
        score = 0;
        codeEssais = new ArrayList<Code>();
    }

    public boolean essai(Code codeATrouver){
        System.out.println("");
        System.out.println("Au tour de " + pseudo + " c'est le décodeur");
        Code codeEssai = new Code();
        boolean verif = codeEssai.verification(codeATrouver);
        codeEssais.add(codeEssai);
        return verif;
    }

    public String getPseudo() {
        return pseudo;
    }

    public int getScore() {
        return score;
    }

    public List<Code> getCodeEssais() {
        return codeEssais;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCodeEssais(List<Code> codeEssais) {
        this.codeEssais = codeEssais;
    }
    
}
