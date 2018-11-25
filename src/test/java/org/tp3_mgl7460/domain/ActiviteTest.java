package org.tp3_mgl7460.domain;

import org.junit.After;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ADB
 */
public class ActiviteTest {
   Activite activite, activiteEqual;
   Categorie categorieCours;
    
    
    @Before
    public void setUp() {
        
        categorieCours = new Categorie("cours", 17, 0);
        activite = new Activite("Cours sur la déontologie", categorieCours, 10, "2014-01-07");
        activiteEqual = new Activite("Cours sur la déontologie", categorieCours, 10, "2014-01-07");
         
    }
    
    @After
    public void tearDown() {
        categorieCours = null;
        activite = null;
    }
    
    @Test
    public void testGetDescription() {
        assertEquals("Cours sur la déontologie", activite.getDescription());
    }
    
    @Test
    public void testGetCategorie_NomCathegorie() {
        assertEquals("cours", activite.getCategorie().getNomCategorie());
    }

    @Test
    public void testGetCategorie_HeureMax() {
        assertEquals(0, activite.getCategorie().getHeureMax());
    }
    
     @Test
    public void testGetCategorie_HeureMin() {
        assertEquals(17, activite.getCategorie().getHeureMin());
    }
    
    @Test
    public void testGetHeure() {
        assertEquals(10, activite.getHeure());
    }

    @Test
    public void testGetDate() {
        assertEquals("2014-01-07", activite.getDate());
    }
    
    @Test
    public void testEquals() {
        assertTrue(activite.equals(activiteEqual));
    }
    
    @Test
    public void testValiderDescription() {
        assertEquals(true, activite.validerDescription());
    }
    
    @Test
    public void testValiderHeure() {
        assertEquals(true, activite.validerHeure());
    }
    
    @Test
    public void testValiderDate() {
        assertEquals(true, activite.validerDate());
    }
}
