/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tp3_mgl7460.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.apache.commons.io.IOUtils;


/**
 *
 * @author sergedelil
 */
public class JSONHash {
    
    private final String filename;
    private JSONObject obj;

    public JSONHash(String filename) {
        this.obj = null;
        this.filename = filename;
    }

    public boolean load() throws FileNotFoundException, JSONException, FormationContinueException{
        boolean resultat = false;
        try {
            String stringJson = IOUtils.toString(new FileInputStream(this.filename),  "UTF-8");
            JSONObject jsonObj = (JSONObject) JSONSerializer.toJSON(stringJson);
            this.obj = jsonObj;
            resultat = true;
        }catch(FileNotFoundException e){
            throw new FormationContinueException("Le fichier d'entré n'exixte pas");
        }catch(JSONException e){
            throw new FormationContinueException("Le fichier json n'est pas valide");
        }catch(IOException e){
            throw new FormationContinueException(e.toString());
        }
        return resultat;
    }
    
    public boolean save(String path, boolean res, ArrayList<String> erreurs)throws IOException, FormationContinueException{
        boolean resultat;
        JSONObject jsonOutput = new JSONObject();
        jsonOutput.put("complet", res);
        JSONArray listErreurs = new JSONArray();
        erreurs.forEach((erreur) -> {
            listErreurs.add(erreur);
        });
        jsonOutput.put("erreurs", listErreurs);
        try (FileWriter output = new FileWriter(path)) {
            output.write(jsonOutput.toString(3));
            output.flush();
            output.close();
            resultat = true;
        }catch(IOException e){
            throw new FormationContinueException(e.toString());
        }
        return resultat;
    }

    public String getFilename() {
        return filename;
    }

    public JSONObject getObj() {
        return obj;
    }

    public void setObj(JSONObject obj) {
        this.obj = obj;
    }
}
