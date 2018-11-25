package org.tp3_mgl7460.domain;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author ADB
 */
public class ActiviteTest {
   Activite activite;
   Categorie categorieCours;
    
    
    @Before
    public void setUp() {
        
        categorieCours = new Categorie("cours", 17, 0);
        activite = new Activite("Cours sur la déontologie", categorieCours, 10, "2014-01-07");
         
    }
    
    @After
    public void tearDown() {
        categorieCours = null;
        activite = null;
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
