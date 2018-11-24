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
public class CategorieTest {
    
    Categorie cat;
    
    @Before
    public void setUp() {
        cat = new Categorie("cours", 15, -1);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetNomCategorie_1() {
        assertTrue(cat.getNomCategorie().matches("^[A-Za-z]{2}.+$"));
    }

    @Test
    public void testGetHeureMin() {
        
    }

    @Test
    public void testGetHeureMax() {
        
    }

    @Test
    public void testSetNomCategorie() {
        
    }

    @Test
    public void testSetHeureMin() {
        
    }

    @Test
    public void testSetHeureMax() {
        
    }

    @Test
    public void testHashCode() {
        
    }

    @Test
    public void testEquals() {
        
    }

    @Test
    public void testToString() {
        
    }

    @Test
    public void testValiderCategorie() {
       
    }

    @Test
    public void testAdmetHeureMin() {
        
    }

    @Test
    public void testAdmetHeureMax() {
    }

    @Test
    public void testAtteintHeureMin() {
       
    }

    @Test
    public void testAtteintHeureMax() {
        
    }
    
    
    @Test
    public void testValiderCategorie_cours() {
        cat = new Categorie("cours", 16, -1);
        assertEquals(true, cat.validerCategorie());
    }

    @Test
    public void testValiderCategorie_atelier() {
        cat = new Categorie("atelier", 16, -1);
        assertEquals(true, cat.validerCategorie());
    }

    @Test
    public void testValiderCategorie_seminaire() {
        cat = new Categorie("séminaire", 16, -1);
        assertEquals(true, cat.validerCategorie());
    }

    @Test
    public void testValiderCategorie_colloque() {
        cat = new Categorie("colloque", 16, -1);
        assertEquals(true, cat.validerCategorie());
    }

    @Test
    public void testValiderCategorie_conférence() {
        cat = new Categorie("conférence", 16, -1);
        assertEquals(true, cat.validerCategorie());
    }

    @Test
    public void testValiderCategorie_lecture_dirigee() {
        cat = new Categorie("lecture dirigée", 16, -1);
        assertEquals(true, cat.validerCategorie());
    }

    @Test
    public void testValiderCategorie_presentation() {
        cat = new Categorie("présentation", 16, -1);
        assertEquals(true, cat.validerCategorie());
    }

    @Test
    public void testValiderCategorie_groupeDiscussion() {
        cat = new Categorie("groupe de discussion", 16, -1);
        assertEquals(true, cat.validerCategorie());
    }

    @Test
    public void testValiderCategorie_projetDeRecherche() {
        cat = new Categorie("groupe de discussion", 16, -1);
        assertEquals(true, cat.validerCategorie());
    }

    @Test
    public void testValiderCategorie_RedactionProfessionnelle() {
        cat = new Categorie("rédaction professionnelle", 16, -1);
        assertEquals(true, cat.validerCategorie());
    }

    @Test
    public void testValiderCategorie_toto() {
        cat = new Categorie("toto", 16, -1);
        assertEquals(false, cat.validerCategorie());
    }

    @Test
    public void testAdmetHeureMin_cours() {
        cat = new Categorie("cours", 17, -1);
        assertEquals(true, cat.admetHeureMin());
    }

    @Test
    public void testAdmetHeureMin_atelier() {
        cat = new Categorie("atelier", 17, -1);
        assertEquals(true, cat.admetHeureMin());
    }

    @Test
    public void testAdmetHeureMin_seminaire() {
        cat = new Categorie("séminaire", 17, -1);
        assertEquals(true, cat.admetHeureMin());
    }

    @Test
    public void testAdmetHeureMin_colloque() {
        cat = new Categorie("colloque", 17, -1);
        assertEquals(true, cat.admetHeureMin());
    }

    @Test
    public void testAdmetHeureMin_conférence() {
        cat = new Categorie("conférence", 17, -1);
        assertEquals(true, cat.admetHeureMin());
    }

    @Test
    public void testAdmetHeureMin_lecture_dirigee() {
        cat = new Categorie("lecture dirigée", 17, -1);
        assertEquals(true, cat.admetHeureMin());
    }

    @Test
    public void testAdmetHeureMax_presentation() {
        cat = new Categorie("présentation", 23, 23);
        assertEquals(true, cat.admetHeureMax());
    }

    @Test
    public void testAdmetHeureMax_groupeDiscussion() {
        cat = new Categorie("groupe de discussion", 18, 17);
        assertEquals(true, cat.admetHeureMax());
    }

    @Test
    public void testAdmetHeureMax_projetRecherche() {
        cat = new Categorie("projet de recherche", 24, 23);
        assertEquals(true, cat.admetHeureMax());
    }

    @Test
    public void testAdmetHeureMax_RedactionProfessionnelle() {
        cat = new Categorie("rédaction professionnelle", 18, 17);
        assertEquals(true, cat.admetHeureMax());
    }

    @Test
    public void testAdmetHeureMax_False_RedactionProfessionnelle() {
        cat = new Categorie("rédaction professionnelle", 18, 18);
        assertEquals(false, cat.admetHeureMax());
    }

    @Test
    public void testAtteintHeureMin_cours() {
        cat = new Categorie("cours", 17, 18);
        assertEquals(true, cat.atteintHeureMin());
    }
    
     @Test
    public void testAtteintHeureMin_atelier() {
        cat = new Categorie("atelier", 17, 18);
        assertEquals(true, cat.atteintHeureMin());
    }
    
    @Test
    public void testAtteintHeureMin_seminaire() {
        cat = new Categorie("séminaire", 17, -1);
        assertEquals(true, cat.atteintHeureMin());
    }

    @Test
    public void testAtteintHeureMin_colloque() {
        cat = new Categorie("colloque", 17, -1);
        assertEquals(true, cat.atteintHeureMin());
    }

    @Test
    public void testAtteintHeureMin_conférence() {
        cat = new Categorie("conférence", 17, -1);
        assertEquals(true, cat.atteintHeureMin());
    }

    @Test
    public void testAtteintHeureMin_lecture_dirigee() {
        cat = new Categorie("lecture dirigée", 17, -1);
        assertEquals(true, cat.atteintHeureMin());
    }

    @Test
    public void testAtteintHeureMax_presentation() {
        cat = new Categorie("présentation", 17, 23);
        assertEquals(true, cat.atteintHeureMax());
    }
    
    @Test
    public void testAtteintHeureMax_groupeDiscussion() {
        cat = new Categorie("groupe de discussion", 17, 17);
        assertEquals(true, cat.atteintHeureMax());
    }
    
    @Test
    public void testAtteintHeureMax_projetRecherche() {
        cat = new Categorie("projet de recherche", 17, 23);
        assertEquals(true, cat.atteintHeureMax());
    }
    
    @Test
    public void testAtteintHeureMax_redactionProfessionnelle() {
        cat = new Categorie("rédaction professionnelle", 17, 17);
        assertEquals(true, cat.atteintHeureMax());
    }
    
}