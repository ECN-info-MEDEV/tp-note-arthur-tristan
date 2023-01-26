package org.centrale.mastermind;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;

import java.util.List;

import org.junit.Test;

public class CodeTest {
    @Test
    public void testVerifValidString() {
        List<Pion> listePion = new LinkedList<>();
        listePion.add(new Pion("Blanc",'W'));
        listePion.add(new Pion("Blanc",'W'));
        listePion.add(new Pion("Blanc",'W'));
        listePion.add(new Pion("Blanc",'W'));
        Code c = new Code("WWWW", listePion);
        try {
            c.verifValidString("AZERTYUU");
        } catch (Exception e) {
            assertEquals(e.getMessage(),"Le nombre de pion donné n'est pas cohérent !");
        }
        try {
            c.verifValidString("WWZW");
        } catch (Exception e) {
            assertEquals(e.getMessage(),"La couleur : 'Z' n'est pas valide !");
        }
        try {
            c.verifValidString("WWbW");
        } catch (Exception e) {
            assertEquals(e.getMessage(),"La couleur : 'b' n'est pas valide !");
        }

    }

    @Test
    public void testVerification() {
        List<Pion> listePion = new LinkedList<>();
        listePion.add(new Pion("Blanc",'W'));
        listePion.add(new Pion("Blanc",'W'));
        listePion.add(new Pion("Blanc",'W'));
        listePion.add(new Pion("Blanc",'W'));
        Code c1 = new Code("WWWW", listePion);
        
        List<Pion> listePion2 = new LinkedList<>();
        listePion2.add(new Pion("Bleu",'B'));
        listePion2.add(new Pion("Blanc",'W'));
        listePion2.add(new Pion("Vert",'V'));
        listePion2.add(new Pion("Rouge",'R'));
        Code c2 = new Code("BWVR", listePion2);

        assertFalse(c1.verification(c2));
        assertFalse(c2.verification(c1));
        
        assertEquals(c1.getVerif(),"O ~ ~ ~ ");
        assertEquals(c2.getVerif(),"O ");
        
        assertTrue(c1.verification(c1));
        assertEquals(c1.getVerif(),"O O O O ");
    }
}
