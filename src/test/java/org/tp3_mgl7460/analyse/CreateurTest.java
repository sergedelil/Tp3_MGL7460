
package org.tp3_mgl7460.analyse;

import java.io.IOException;
import net.sf.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.tp3_mgl7460.domain.Membre;
import org.tp3_mgl7460.file.FormationContinueException;


public class CreateurTest {
    String fichierEntre;
    String fichierCat;
    
    @Before
    public void setUp() {
        fichierEntre = "resources/input.json";
        fichierCat = "resources/categories.json";
    }
    
    @After
    public void tearDown() {
       fichierEntre = null;
       fichierCat = null;
    }

    
    @Test
    public void testChargerFormation() throws Exception {
        boolean thrown = false;
        try {
          Createur.chargerFormation(fichierEntre, fichierCat);
        } catch (IOException | JSONException | FormationContinueException e) {
          thrown = true;
        }
        assertFalse(thrown);
    }
    @Test
    public void testChargerFormation_2() throws Exception {
        Membre unMembre = Createur.chargerFormation(fichierEntre, fichierCat);
        assertNotNull(unMembre);
    }
}
