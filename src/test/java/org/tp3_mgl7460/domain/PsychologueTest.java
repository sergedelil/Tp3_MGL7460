package org.tp3_mgl7460.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class PsychologueTest {
    Psychologue psy;
    Activite activiteUn, activiteDeux, activiteTrois, activiteQuatre;
    Categorie categorieUn, categorieDeux, categorieTrois, categorieQuatre;
   
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
         categorieTrois = new Categorie("groupe de discussion", 0, 0);
         categorieQuatre = new Categorie("conférence", 0, 0);
         activiteUn = new Activite("Cours sur la déontologie",categorieUn,15,"2013-03-20");
         activiteDeux = new Activite("Séminaire sur l'architecture contemporaine",categorieDeux,65,"2014-03-20");
         activiteTrois = new Activite("Participation à un groupe de discussion",categorieTrois,0,"2009-03-20");
         activiteQuatre = new Activite("Conférence sur la santé mentale",categorieQuatre,20,"2013-03-20");
         psy.ajouterActivite(activiteUn);
         psy.ajouterActivite(activiteDeux);
         psy.ajouterActivite(activiteTrois);
         psy.ajouterActivite(activiteQuatre);
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

    @Test
    public void testAtteintHeureMinCycle() {
        assertTrue(psy.atteintHeureMinCycle(psy.getHeureTotalActivité()));
    }
    
    @Test
    public void testValiderDateGood(){
        assertEquals(null, psy.validerDate(activiteDeux));
        
    }
    @Test
    public void testValiderDateBad(){
        assertEquals("La date de l'activité «Participation à un groupe de discussion» n'est pas valide. Elle sera ignorée.", psy.validerDate(activiteTrois));
        
    }
    
    @Test
    public void testValiderHeure(){
        assertEquals("L'heure de l'activité «Participation à un groupe de discussion» n'est pas valide. Elle sera ignorée.", psy.validerHeure(activiteTrois));
    }
      
    @Test
    public void testValiderNbHeureMinCours(){
        assertEquals("Il manque 10 heures de formation pour la categorie cours.", psy.validerNbHeureMinCours(psy.getActivites()));
    }
    
    @Test
    public void testValiderNbHeureMaxConference(){
        assertEquals("Un maximum de 15 heure est permis pour conférence. L'exédent sera ignoré", psy.validerNbHeureMaxConference(psy.getActivites()));
    }
    
    @Test
    public void testExaminerDemande(){
        
    }
}
