package org.tp3_mgl7460.domain;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ADB
 */
public class ActiviteTest {
   Activite activite;
   Categorie categorieCours;
    
    
        @BeforeClass
    public static void setUpClass() {       
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        categorieCours = new Categorie("cours", 17, 0);
        activite = new Activite("Cours sur la déontologie", categorieCours, 10, "2014-01-07");
         
    }
    
    @After
    public void tearDown() {
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
