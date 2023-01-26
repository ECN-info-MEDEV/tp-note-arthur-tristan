package org.centrale.mastermind;

import java.util.List;

public class Joueur {
    int score;
    String pseudo;
    List<Code> codeEssais;

    public Joueur(String pseudo){
        this.pseudo = pseudo;
        score = 0;
        codeEssais = null;
    }

    public boolean essai(Code codeATrouver){
        System.out.println("Au tour du decodeur");
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
