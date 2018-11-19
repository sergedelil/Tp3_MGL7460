package org.tp3_mgl7460.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author ADB
 */
public class PsychologueTest {
    Psychologue psy;
    Activite activiteUn, activiteDeux;
    Categorie categorieUn, categorieDeux;
   
        public PsychologueTest() {        
    }
    
    @BeforeClass
    public static void setUpClass() {       
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         psy = new Psychologue("John","Doe",1,"Psychologue", "2010-2015","12345-12");
         categorieUn = new Categorie("cours", 25, 0);
         categorieDeux = new Categorie("séminaire", 0, 0);
         activiteUn = new Activite("Cours sur la déontologie",categorieUn,25,"2013-03-20");
         activiteDeux = new Activite("Séminaire sur l'architecture contemporaine",categorieDeux,65,"2014-03-20");
         psy.ajouterActivite(activiteUn);
         psy.ajouterActivite(activiteDeux);
         //psy.ajouterHeureTotalActivite(activiteUn.getHeure());
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testValiderCycle() {
        assertEquals(true, psy.validerCycle());
    }

    @Test
    public void testValiderNumeroPermis() {
        assertEquals(true, psy.validerNumeroPermis());
    }

    
    
    
      
}
