package org.centrale.mastermind;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Classe de gestion des joueurs
 */
public class Joueur {

    private static final Logger LOGGER = Logger.getLogger(Joueur.class.getName());
    private int score; //Score du joueur
    private String pseudo; //Pseudo du joueur
    private List<Code> codeEssais; //Liste des codes qu'ils a essayé ce tour de jeu

    /**
     * Constructeur classique
     * @param pseudo
     */
    public Joueur(String pseudo){
        this.pseudo = pseudo;
        score = 0;
        codeEssais = new ArrayList<Code>();
    }

    /**
     * Fonction gérant les essais successifs du décodeur, elle renvoie un booléen représentant s'il a trouver ou non.
     * 
     * @param codeATrouver
     * @return
     */
    public boolean essai(Code codeATrouver, Scanner sc){
        LOGGER.info("");
        LOGGER.info("Au tour de " + pseudo + " c'est le décodeur");
        Code codeEssai = new Code(sc);
        boolean verif = codeEssai.verification(codeATrouver);
        codeEssais.add(codeEssai);
        return verif;
    }

    /**
     * Renvoie le pseudo du joueur
     * 
     * @return
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * Renvoie le score du joueur
     * 
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     * Renvoie la liste des essais du joueur
     * 
     * @return
     */
    public List<Code> getCodeEssais() {
        return codeEssais;
    }

    /**
     * Modifie le pseudo du joueur
     * 
     * @param pseudo
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * Modifie le score du joueur
     * 
     * @param score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Modifie la liste des essais du joueur
     * 
     * @param codeEssais
     */
    public void setCodeEssais(List<Code> codeEssais) {
        this.codeEssais = codeEssais;
    }
    
}
