/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tp3_mgl7460.main;

import java.io.IOException;
import net.sf.json.JSONException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sergedelil
 */
public class JSONHashTest {
    
    public JSONHashTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {

    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testLoad() {
        boolean thrown;
        try {
          JSONHash obj = new JSONHash("fichier");
          thrown = obj.load();
              
        } catch (IOException | JSONException e) {
          thrown = true;
        }
        assertFalse(thrown);
    }

    @Test
    public void testSave() throws Exception {
        JSONHash obj = new JSONHash("fichier");
        assertNotEquals(true, obj.load());
    }
    
}
