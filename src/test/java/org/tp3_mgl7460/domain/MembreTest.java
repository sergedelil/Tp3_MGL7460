/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tp3_mgl7460.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sergedelil
 */
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
        assertNotNull(membre.getNom());
    }
    
    @Test
    public void testValiderNom_1() {
        assertTrue(membre.getNom().length() > 1);
    }

    @Test
    public void testValiderPrenom() {
        assertNotNull(membre.getPrenom());
    }
    
    @Test
    public void testValiderPrenom_1() {
        assertTrue(membre.getPrenom().length() > 1);
    }
    
    @Test
    public void testValiderSexe() {
        assertTrue(String.valueOf(membre.getSexe()).matches("^[012]$"));
    }
    
    @Test
    public void testValiderOrdre() {
        String listOrdre [] = {"Architecte","Psychologue","Geologue"};
        boolean trouve = false;
        for(String ordre : listOrdre){
            if (ordre.equalsIgnoreCase(membre.getOrdre())){
                trouve = true;
                break;
            }
        }
        assertTrue(trouve);
    }
}
