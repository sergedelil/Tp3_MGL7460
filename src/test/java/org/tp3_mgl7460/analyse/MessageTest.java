
package org.tp3_mgl7460.analyse;

import java.io.IOException;
import java.util.ArrayList;
import net.sf.json.JSONException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sergedelil
 */
public class MessageTest {
    
    boolean thrown;
    
    String output;
    Message msgObj;
    
    ArrayList<String> liste;
    
    
    @Before
    public void setUp() {
        liste = new ArrayList<>();
        liste.add("msg 1");
        liste.add("msg 2");
        liste.add("msg 3");
        output = "resources/output.json";
        thrown = false;
        msgObj = new Message(output);
        msgObj.setReponse(thrown);
        msgObj.setErreurs(liste);
        
        
    }
    
    @After
    public void tearDown() {
        liste = null;
        msgObj = null;
    }

    @Test
    public void testSave() throws IOException{
        assertTrue(msgObj.save());
    }
    
    @Test
    public void testSave_1() throws Exception {
        try {
          assertTrue(msgObj.save());
        } catch (IOException e) {
          thrown = true;
        }
        assertFalse(thrown);
    }
    
    @Test
    public void testInit() throws JSONException{
        assertTrue(msgObj.init());
    }
    
    @Test
    public void testInit_1() throws JSONException {
        try {
          assertTrue(msgObj.init());
        } catch (JSONException e) {
          thrown = true;
        }
        assertFalse(thrown);
    }
}
