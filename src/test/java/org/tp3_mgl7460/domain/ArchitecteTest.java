/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tp3_mgl7460.domain;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mard
 */
public class ArchitecteTest {
    boolean thrown;
    String cycleLong, cycleShort, cycleNumber, cycleDash, cycleGood;
    String permisLong, permisShort, permisGoodA, permisGoodT, permisBadLetter, permisBadNumber;
    int heureMinCycle, heureTransferee; 

    Architecte obj;
       
    public ArchitecteTest() {
    }
    
    
    @Before
    public void setUp() {
       cycleLong = "2012-20155";
       cycleShort = "2012-201";    
       cycleNumber = "201A-2015";
       cycleDash = "201202015";
       cycleGood = "2012-2014";
        
       permisLong = "A12345"; 
       permisShort = "T123";
       permisGoodA = "A0000";
       permisGoodT = "T9999";  
       permisBadLetter = "X5432";
       permisBadNumber = "AB432";

       
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of atteintHeureMinCycle method, of class Architecte.
     */
    @Test
    public void testAtteintHeureMinCycle_GoodTrueNoActivities() {
      heureMinCycle = 10;
      heureTransferee = 10;
      obj=new Architecte("", "", 1, "", "", "", heureTransferee);
      // 10 >= 10
      assertFalse(obj.atteintHeureMinCycle());     
    } 
    
    @Test
    public void testAtteintHeureMinCycle_GoodTrueWithActivities() {
      heureTransferee = 40;
      obj=new Architecte("", "", 1, "", "", "", heureTransferee);
      Categorie categorie = new Categorie("cours", 10, 0);
      Activite activite = new Activite("Cours sur la déontologie",categorie,heureTransferee,"2013-03-20");
      obj.ajouterActivite(activite);
      assertTrue(obj.atteintHeureMinCycle());
    }       
    
    @Test
    public void testAtteintHeureMinCycle_GoodFalse() {
      heureMinCycle = 10;
      heureTransferee = 6;
      obj=new Architecte("", "", 1, "", "", "", heureTransferee);   
      Categorie categorie = new Categorie("cours", 10, 0);
      Activite activite = new Activite("Cours sur la déontologie",categorie,heureMinCycle,"2013-03-20");
      obj.ajouterActivite(activite);
      assertFalse(obj.atteintHeureMinCycle());     
    }     
 
    /**
     * Test of validerCycle method, of class Architecte.
     */
    @Test
    public void testValiderCycle_BadLong() {
      obj=new Architecte("", "", 1, "", cycleLong, "", 1);
      assertFalse(obj.validerCycle());      
    }
    
    @Test
    public void testValiderCycle_BadShort() {
      obj=new Architecte("", "", 1, "", cycleShort, "", 1);
      assertFalse(obj.validerCycle());
    }

    @Test
    public void testValiderCycle_BadNumber() {
      obj=new Architecte("", "", 1, "", cycleNumber, "", 1);
      assertFalse(obj.validerCycle());      
    }
    
    @Test
    public void testValiderCycle_BadDash() {
      obj=new Architecte("", "", 1, "", cycleDash, "", 1);
      assertFalse(obj.validerCycle());
    }
    
    @Test
    public void testValiderCycle_GoodCycle() {
      obj=new Architecte("", "", 1, "", cycleGood, "", 1);
      assertTrue(obj.validerCycle());
    }    
    
    /**
     * Test of validerNumeroPermis method, of class Architecte.
     */
    @Test
    public void testValiderNumeroPermis_BadLong() { 
        obj=new Architecte("", "", 1, "", "", permisLong, 1);
        assertFalse(obj.validerNumeroPermis());
    }
    
    @Test
    public void testValiderNumeroPermis_BadShort() { 
        obj=new Architecte("", "", 1, "", "", permisLong, 1);
        assertFalse(obj.validerNumeroPermis());
    }
    
    @Test
    public void testValiderNumeroPermis_GoodA() { 
        obj=new Architecte("", "", 1, "", "", permisGoodA, 1);
        assertTrue(obj.validerNumeroPermis());
    }
    
    @Test
    public void testValiderNumeroPermis_GoodT() { 
        obj=new Architecte("", "", 1, "", "", permisGoodT, 1);
        assertTrue(obj.validerNumeroPermis());
    }    
    
    @Test
    public void testValiderNumeroPermis_BadLettre() { 
        obj=new Architecte("", "", 1, "", "", permisBadLetter, 1);
        assertFalse(obj.validerNumeroPermis());
    }    

    @Test
    public void testValiderNumeroPermis_BadNumber() { 
        obj=new Architecte("", "", 1, "", "", permisBadLetter, 1);
        assertFalse(obj.validerNumeroPermis());
    }    
}
