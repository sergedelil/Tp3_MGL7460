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
    Psychologue psyGood;
    Psychologue psyBad;
   
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
         psyGood = new Psychologue("John","Doe",1,"Psychologue", "2010-2015","12345-12");
         psyBad = new Psychologue("John","Doe",1,"Psychologue", "2010-2016","1235-12");
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testValiderCycle() {
        assertEquals(true, psyGood.validerCycle());
    }

    @Test
    public void testValiderNumeroPermis() {
        assertEquals(true, psyGood.validerNumeroPermis());
    }

    @Test
    public void testVatteintHeureMinCycle() {
        assertEquals(true, psyGood.atteintHeureMinCycle());
    }
        
}
