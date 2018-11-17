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
        cat = new Categorie("c", 15, -1);
    }
    
    @After
    public void tearDown() {
    }

//    @Test
//    public void testGetNomCategorie() {
//        assertEquals("cours", cat.getNomCategorie());
//    }
    
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
    
}
