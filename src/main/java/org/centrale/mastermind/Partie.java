package org.centrale.mastermind;

/**
 * Classe hello world
 * 
 * @author Arthur
 */
public class Partie {

    private Code codeATrouver;
    private int nombreTDJ;
    private Joueur j1;
    private Joueur j2;

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
        if (nombreTDJ > 0){
            Joueur codeur;
            Joueur decodeur;

            if (nombreTDJ%2 == 0){
                codeur = j1;
                decodeur = j2;
            }
            else {
                codeur = j2;
                decodeur = j1;
            }
            System.out.println("Au tour de " + codeur.getPseudo() + ", c'est le codeur : il doit choisir un code que le décodeur va essayer de trouver");
            codeATrouver = new Code();
            System.out.println("-------     ------------------------------------------------------------");
            System.out.println("-------------     ------------------------------------------------------");
            System.out.println("---------------------     ----------------------------------------------");
            System.out.println("------------------------------     -------------------------------------");
            System.out.println("----------------------------------------     ---------------------------");
            System.out.println("-------------------------------------------------     ------------------");
            System.out.println("----------------------------------------------------------     ---------");
            System.out.println("------------------------------------------------------------------     -");
            tourDeJeu(codeur, decodeur);
        }
        else{
            System.out.println("Fin du jeu, voici les scores :");
            System.out.println(j1.getPseudo() + " : " + j1.getScore() + " points");
            System.out.println(j2.getPseudo() + " : " + j2.getScore() + " points");
        }
    }

    public void tourDeJeu(Joueur codeur,Joueur decodeur){
        int nbEssai = 12;

        while (nbEssai>0){
            if (!decodeur.essai(codeATrouver)){
                System.out.println("-------------------  Essais précédents   -----------------------------");
                for (Code x : decodeur.getCodeEssais()){                   
                    x.affiche();
                }
            }
            else{
                System.out.println("Bravo tu as trouvé !");
                break;
            }
            nbEssai--;      
        }
        if (nbEssai == 0){
            System.out.println("C'est perdu!");
        }

        System.out.println("Le codeur marque " + decodeur.getCodeEssais().size() + " points");
        codeur.setScore(codeur.getScore() + decodeur.getCodeEssais().size());
        nombreTDJ--;
        System.out.println("");
        System.out.println("-------------------------------------------------------------------");
        launch();
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