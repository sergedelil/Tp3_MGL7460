package org.tp3_mgl7460.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MembreTest {

    Membre membre;
    Activite uneActivite;
    boolean resultat;
    Categorie cat;

    @Before
    public void setUp() {
        cat = new Categorie("cours", 15, -1);
        uneActivite = new Activite("cours de deontologie", cat, 6, "2012-10-22");
        membre = new Membre("Smith", "John", 1, "Architecte", "2012-2014", "T3443");

        resultat = false;
    }

    @After
    public void tearDown() {
        membre = null;
        uneActivite = null;
        cat = null;
    }

    @Test
    public void testGetNom() {
        assertEquals("Smith", membre.getNom());
    }

    @Test
    public void testGetPrenom() {
        assertEquals("John", membre.getPrenom());
    }

    @Test
    public void testGetSexe() {
        assertEquals(1, membre.getSexe());
    }

    @Test
    public void testGetCycle() {
        assertTrue("2012-2014".equals(membre.getCycle()));
    }

    @Test
    public void testGetNumeroPermis() {
        assertTrue("T3443".equals(membre.getNumeroPermis()));
    }

    @Test
    public void testSetActivites() {
        membre.ajouterActivite(uneActivite);
        assertEquals(1, membre.activites.size());
    }

    @Test
    public void testAjouterActivite() {
        membre.ajouterActivite(uneActivite);
        assertEquals(1, membre.activites.size());
    }

    @Test
    public void testValiderNom() {
        assertFalse(membre.validerNom());
    }

    @Test
    public void testValiderPrenom() {
        assertFalse(membre.validerPrenom());
    }

    @Test
    public void testValiderNom_1() {
        assertTrue(membre.getNom().length() > 1);
    }

    @Test
    public void testValiderPrenom_1() {
        assertTrue(membre.getPrenom().length() > 1);
    }

    @Test
    public void testValiderSexe() {
        assertTrue(membre.validerSexe());
    }

    @Test
    public void testValiderOrdre() {
        String listOrdre[] = {"Architecte", "Psychologue", "Geologue"};
        boolean trouve = false;
        for (String ordre : listOrdre) {
            if (ordre.equalsIgnoreCase(membre.getOrdre())) {
                trouve = true;
                break;
            }
        }
        assertTrue(trouve);
    }

    @Test
    public void testValiderOrdre_() {
        assertTrue(membre.validerOrdre());
    }

    @Test
    public void testValiderEquals_ObjectNonNull() {
        assertTrue(membre.equals(membre));
    }

    @Test
    public void testValiderEquals_ObjectNull() {
        Object object = null;
        assertFalse(membre.equals(object));
    }

    @Test
    public void testValiderEquals_This_Dif_Object() {
        Membre membre1 = new Membre("Andres", "Piraquive", 1, "Ar", "2012-2014", "T3443");
        assertFalse(membre.equals(membre1));
    }

    @Test
    public void testValiderEquals_This_Dif_Object_Prenom() {
        Membre membre1 = new Membre("Smith", "Piraquive", 1, "Ar", "2012-2014", "T3443");
        assertFalse(membre.equals(membre1));
    }

    @Test
    public void testValiderEquals_This_Dif_Object_Sex() {
        Membre membre1 = new Membre("Smith", "John", 4, "Ar", "2012-2014", "T3443");
        assertFalse(membre.equals(membre1));
    }

    @Test
    public void testValiderEquals_This_Dif_Object_Ordre() {
        Membre membre1 = new Membre("Smith", "John", 1, "Ar", "2012-2014", "T3443");
        assertFalse(membre.equals(membre1));
    }

    @Test
    public void testValiderEquals_This_Dif_Object_Cycle() {
        Membre membre1 = new Membre("Smith", "John", 1, "Architecte", "2010-2014", "T3443");
        assertFalse(membre.equals(membre1));
    }

    @Test
    public void testValiderEquals_This_Dif_Object_Permis() {
        Membre membre1 = new Membre("Smith", "John", 1, "Architecte", "2012-2014", "T34435");
        assertFalse(membre.equals(membre1));
    }
}
