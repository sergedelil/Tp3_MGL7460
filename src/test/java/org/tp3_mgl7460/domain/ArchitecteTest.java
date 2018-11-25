
package org.tp3_mgl7460.domain;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.tp3_mgl7460.analyse.Message;

public class ArchitecteTest {
    int heureMinCycle = 40; 
    int heureTransfereeZero = 0;
    int heureTransfereePositive = 10;    
    int heureTransfereeNegative = -10; 
    
    String cycleLong = "2012-20155";
    String cycleShort = "2012-201";    
    String cycleNumber = "201A-2015";
    String cycleDash = "201202015";
    String cycleGood = "2012-2014";
    String cycleBad = "2013-2014";       
        
    String permisLong = "A12345"; 
    String permisShort = "T123";
    String permisGoodA = "A0000";
    String permisGoodT = "T9999";  
    String permisBadLetter = "X5432";
    String permisBadNumber = "AB432";    

    Architecte obj;
    Message msg;    
    
    public ArchitecteTest() {
        
    }   
    
    
    @Test
    public void testValiderCycle_GoodCycle() {
      obj=new Architecte(1, "nom", "prenom", 1, "ordre", cycleGood, "numeroPermis");
      assertTrue(obj.validerCycle());
    }     
    
    @Test
    public void testValiderCycle_BadCycle() {
      obj=new Architecte(1, "nom", "prenom", 1, "ordre", cycleBad, "numeroPermis");
      assertFalse(obj.validerCycle());
    }   
    
    @Test
    public void testValiderNumeroPermis_BadLong() {
        obj=new Architecte(1, "nom", "prenom", 1, "ordre", "cycle", permisLong);      
        assertFalse(obj.validerNumeroPermis());
    }
    
    @Test
    public void testValiderNumeroPermis_BadShort() { 
        obj=new Architecte(1, "nom", "prenom", 1, "ordre", "cycle", permisShort);       
        assertFalse(obj.validerNumeroPermis());
    }
    
    @Test
    public void testValiderNumeroPermis_GoodA() { 
        obj=new Architecte(1, "nom", "prenom", 1, "ordre", "cycle", permisGoodA);
        assertTrue(obj.validerNumeroPermis());
    }
    
    @Test
    public void testValiderNumeroPermis_GoodT() { 
        obj=new Architecte(1, "nom", "prenom", 1, "ordre", "cycle", permisGoodT);
        assertTrue(obj.validerNumeroPermis());
    }    
    
    @Test
    public void testValiderNumeroPermis_BadLettre() { 
        obj=new Architecte(1, "nom", "prenom", 1, "ordre", "cycle", permisBadLetter);                
        assertFalse(obj.validerNumeroPermis());
    }    

    @Test
    public void testValiderNumeroPermis_BadNumber() { 
        obj=new Architecte(1, "nom", "prenom", 1, "ordre", "cycle", permisBadNumber);
        assertFalse(obj.validerNumeroPermis());
    } 

    @Test
    public void testAtteintHeureMinCycle_GoodMinHour() {
        obj=new Architecte(1, "nom", "prenom", 1, "ordre", "cycle", "numeroPermis");
        assertTrue(obj.atteintHeureMinCycle(heureMinCycle));        
    }
    
    @Test
    public void testAtteintHeureMinCycle_GoodMoreHour() {
        obj=new Architecte(1, "nom", "prenom", 1, "ordre", "cycle", "numeroPermis");
        assertTrue(obj.atteintHeureMinCycle(heureMinCycle+1));        
    }  
    
    @Test
    public void testAtteintHeureMinCycle_BadLessHour() {
        obj=new Architecte(1, "nom", "prenom", 1, "ordre", "cycle", "numeroPermis");
        assertFalse(obj.atteintHeureMinCycle(heureMinCycle-1));        
    }     

    @Test
    public void testValiderHeureTranferee_GoodPositive() {
        obj=new Architecte(heureTransfereePositive, "nom", "prenom", 1, "ordre", "cycle", "numeroPermis");
        assertTrue(obj.validerHeureTranferee());
    }
  
    @Test
    public void testValiderHeureTranferee_BadZero() {
        obj=new Architecte(heureTransfereeZero, "nom", "prenom", 1, "ordre", "cycle", "numeroPermis");
        assertFalse(obj.validerHeureTranferee());
    } 
    
    @Test
    public void testValiderHeureTranferee_BadNegative() {
        obj=new Architecte(heureTransfereeNegative, "nom", "prenom", 1, "ordre", "cycle", "numeroPermis");
        assertFalse(obj.validerHeureTranferee());
    }    

    @Test
    public void testExaminerDemande() {
        obj = new Architecte(1, "nom", "prenom", 1, "ordre", "cycle", "numeroPermis");
        msg = new Message("filename");
        assertTrue(obj.examinerDemande(msg));        
    }
    
    @Test
    public void testGetActiviteCategorieHeure_true() {
        obj = new Architecte(1, "nom", "prenom", 1, "ordre", "cycle", "numeroPermis");
        Categorie categorie = new Categorie("categorie", 0, 10);
        Activite act = new Activite("description", categorie, 5,"date");
        // Less than max hour: 5<10
        boolean bResult = obj.GetActiviteCategorieHeure(act, "categorie", 5) == 5;
        assertTrue(bResult);        
    }    
    
    @Test
    public void testGetActiviteCategorieHeure_false() {
        obj = new Architecte(1, "nom", "prenom", 1, "ordre", "cycle", "numeroPermis");
        Categorie categorie = new Categorie("categorie", 0, 10);
        Activite act = new Activite("description", categorie, 15,"date");
        // more than max hour: 15>10
        boolean bResult = obj.GetActiviteCategorieHeure(act, "categorie", 15) == 15;
        assertFalse(bResult);        
    }      
    
    @Test
    public void testConstruireListeCategorie() { 
        obj = new Architecte(1, "nom", "prenom", 1, "ordre", "cycle", "numeroPermis");
        Categorie categorie = new Categorie("categorie1", 0, 10);
        ArrayList<Categorie> arrListCat = new ArrayList<Categorie>();
        arrListCat.add(categorie);        
        obj.setCategories(arrListCat);
        
        ArrayList<String> arrList = obj.ConstruireListeCategorie();
        assertTrue(arrList.get(0) == "categorie1");
    } 
    
    @Test
    public void testestCategorieDes6() {   
       obj = new Architecte(1, "nom", "prenom", 1, "ordre", "cycle", "numeroPermis"); 
       
       boolean bestCategorieDes6 = obj.estCategorieDes6("cours") && 
                                   obj.estCategorieDes6("atelier") &&
                                   obj.estCategorieDes6("séminaire") &&
                                   obj.estCategorieDes6("colloque") &&
                                   obj.estCategorieDes6("conférence") &&
                                   obj.estCategorieDes6("lecture dirigée");
              
       assertTrue(bestCategorieDes6);
    } 
    
}
