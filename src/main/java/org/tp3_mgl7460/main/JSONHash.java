/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tp3_mgl7460.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 *
 * @author sergedelil
 */
public class JSONHash {
    
    String filename;
    JSONObject obj = null;

    public JSONHash(String filename) {
        this.filename = filename;
    }

    public boolean load()throws FileNotFoundException, JSONException,IOException{
        return false;
    }
    
    public boolean save()throws IOException{
        return false;
    }
    
    
}
