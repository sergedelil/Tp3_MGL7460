package org.tp3_mgl7460.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class CategorieTest {
    
    Categorie cat;
    
    @Before
    public void setUp() {
        cat = new Categorie("cours", 15, -1);
    }
    
    @After
    public void tearDown() {
        cat = null;
    }

    @Test
    public void testGetNomCategorie_1() {
        assertTrue(cat.getNomCategorie().matches("^[A-Za-z]{2}.+$"));
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
    
      @Test
    public void testValiderEquals_ObjectNonNull() {
        Categorie cat1 = new Categorie("cours", 15, -1);
        assertTrue(cat.equals(cat1));
    }

    @Test
    public void testValiderEquals_ObjectNull() {
        Object object = null;
        assertFalse(cat.equals(object));
    }

    @Test
    public void testValiderEquals_This_Dif_Object() {
        Categorie cat1 = new Categorie("cou", 15, -1);
        assertFalse(cat.equals(cat1));
    }

    @Test
    public void testValiderEquals_This_Dif_HeureMin() {
          Categorie cat1 = new Categorie("cours", 12, -1);
        assertFalse(cat.equals(cat1));
    }

     @Test
    public void testValiderEquals_This_Dif_HeureMax() {
          Categorie cat1 = new Categorie("cours", 15, 2);
        assertFalse(cat.equals(cat1));
    }
    
}
