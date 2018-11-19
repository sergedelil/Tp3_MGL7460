
package org.tp3_mgl7460.analyse;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 *
 * @author sergedelil
 */
public class Message {

    
    
    private JSONObject msgObj;
    private String filename;
    private boolean reponse;
    private ArrayList<String> erreurs;
    
    public Message(String filename){
        this.msgObj = new JSONObject();
        this.filename = filename;
        reponse = false;
        erreurs = new ArrayList<>();
        
    }
    
    public static void gestionErreur(String msg){
        System.out.println(msg);
    }
    
    public JSONObject getMsgObj() {
        return msgObj;
    }

    public void setMsgObj(JSONObject msgObj) {
        this.msgObj = msgObj;
    }
    
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }
    
    public boolean isReponse() {
        return reponse;
    }
    
    public void setReponse(boolean reponse) {
        this.reponse = reponse;
    }

    public ArrayList<String> getErreurs() {
        return erreurs;
    }

    public void setErreurs(ArrayList<String> erreurs) {
        this.erreurs = erreurs;
    }
    
    public void show(){
        System.out.println(this.msgObj.toString(3));
    }
    
    public boolean save() throws IOException{
        boolean resultat;
        try (FileWriter f = new FileWriter(filename)) {
            f.write(msgObj.toString(3));
            f.flush();
            f.close();
            resultat = true;
        }
        return resultat;
    }
    
    public boolean init() throws JSONException{
        boolean res;
        try {
            if(this.erreurs.isEmpty())
                this.reponse = true;
            this.msgObj.put("complet", this.reponse);
            this.msgObj.put("erreurs", this.erreurs);
            res = true;
        }catch(JSONException e){
            res = false;
        }
        return res;
    }
}
