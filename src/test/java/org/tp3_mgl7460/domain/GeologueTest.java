/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tp3_mgl7460.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author andres.piraquive
 */
public class GeologueTest {
    Geologue geologue;
    
  
    public GeologueTest() {        
    }
    
    @BeforeClass
    public static void setUpClass() {       
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         geologue = new Geologue("Piraquive","Andres",1,"Geologue", "2013-2016","PA3223", 55, 2);     
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of validerCycle method, of class Geologue.
     */
    @Test
    public void testValiderCycle() {
       assertEquals(true, geologue.validerCycle());  
    }

    /**
     * Test of validerNumeroPermis method, of class Geologue.
     */
    @Test
    public void testValiderNumeroPermis() {     
        assertEquals(true, geologue.validerNumeroPermis());       
    }

    /**
     * Test of atteintHeureMinCycle method, of class Geologue.
     */
    @Test
    public void testAtteintHeureMinCycle() {
         assertEquals(true, geologue.atteintHeureMinCycle()); 
    }

    /**
     * Test of toString method, of class Geologue.
     */
    @Test
    public void testToString() {
        assertEquals("Geologue{" + "nom=" + geologue.nom 
                                 + ", prenom=" + geologue.prenom 
                                 + ", sexe=" + geologue.sexe 
                                 + ", ordre=" + geologue.ordre
                                 + ", cycle=" + geologue.cycle 
                                 + ", numeroPermis=" + geologue.numeroPermis 
                                 + ", heureMinCycle=" + geologue.heureMinCycle 
                                 + ", activites=" + geologue.activites 
                                 + '}', geologue.toString()); 
    }
    
}
