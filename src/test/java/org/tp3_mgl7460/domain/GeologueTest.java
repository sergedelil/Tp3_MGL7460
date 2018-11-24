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
import org.tp3_mgl7460.analyse.Message;

/**
 *
 * @author andres.piraquive
 */
public class GeologueTest {

    Geologue geologue;
    Activite activiteUn, activiteDeux, activiteTrois, activiteQuatre;
    Categorie categorieUn, categorieDeux, categorieTrois, categorieQuatre;
    Message msg;

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
        geologue = new Geologue("Piraquive", "Andres", 1, "Geologue", "2013-2016", "PA3223");
        categorieUn = new Categorie("cours", 22, 0);
        categorieDeux = new Categorie("projet de recherche", 3, 0);
        categorieTrois = new Categorie("groupe de discussion", 1, 0);

        activiteUn = new Activite("Cours sur la déontologie", categorieUn, 2, "2013-03-20");
        activiteDeux = new Activite("Séminaire sur l'architecture contemporaine", categorieDeux, 1, "2014-03-20");
        activiteTrois = new Activite("Participation à un groupe de discussion", categorieTrois, 0, "2009-03-20");

        geologue.ajouterActivite(activiteUn);
        geologue.ajouterActivite(activiteDeux);
        geologue.ajouterActivite(activiteTrois);
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
        assertEquals(true, geologue.atteintHeureMinCycle(55));
    }

    @Test
    public void testValiderDateMessageEqualsNull() {
        assertEquals(null, geologue.validerDate(activiteDeux));

    }

    @Test
    public void testValiderDateErrorMessage() {
        assertEquals("La date de l'activité «Participation à un groupe de discussion» n'est pas valide. Elle sera ignorée.", geologue.validerDate(activiteTrois));
    }

    @Test
    public void testValiderHeure() {
        assertEquals("L'heure de l'activité «Participation à un groupe de discussion» n'est pas valide. Elle sera ignorée.", geologue.validerHeure(activiteTrois));
    }

    @Test
    public void validateNbHeureMinCategorieCours() {
        assertEquals("Il manque 20 heures de formation pour la categorie cours.", geologue.validateNbHeureMinCategorie(geologue.getActivites(), 22, "cours"));
    }

    @Test
    public void validateNbHeureMinCategorieProjetRecherche() {
        assertEquals("Il manque 2 heures de formation pour la categorie projet de recherche.", geologue.validateNbHeureMinCategorie(geologue.getActivites(), 3, "projet de recherche"));
    }

    @Test
    public void validateNbHeureMinCategorieGroupeDiscussion() {
        assertEquals("Il manque 1 heures de formation pour la categorie groupe de discussion.", geologue.validateNbHeureMinCategorie(geologue.getActivites(), 1, "groupe de discussion"));
    }

    @Test
    public void testExaminerDemande_return_true() {
        msg = new Message("output");
        assertTrue(geologue.examinerDemande(msg));
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
