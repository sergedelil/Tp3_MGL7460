/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tp3_mgl7460.analyse;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;
import org.tp3_mgl7460.domain.Activite;
import org.tp3_mgl7460.domain.Architecte;
import org.tp3_mgl7460.domain.Categorie;
import org.tp3_mgl7460.domain.Geologue;
import org.tp3_mgl7460.domain.Membre;
import org.tp3_mgl7460.domain.Psychologue;
import org.tp3_mgl7460.file.FormationContinueException;
import org.tp3_mgl7460.file.JSONHash;

/**
 *
 * @author sergedelil
 */
public class Createur {
    
    public static Membre chargerFormation(String fichierEntre, String categorie) throws Exception{
        JSONHash jsonObj = new JSONHash(fichierEntre);
        JSONHash jsonCat = new JSONHash(categorie);
        Membre membre = creerMembre(jsonObj, jsonCat);
        return membre;
    }
    
    public static Membre creerMembre(JSONHash jsonObj, JSONHash jsonCat) throws FormationContinueException, FileNotFoundException {
        jsonObj.load();
        jsonCat.load();
        
        Membre leMembre = null;
        String nom          = (String)jsonObj.getObj().get("nom");
        String prenom       = (String)jsonObj.getObj().get("prenom");
        int sexe            = (int)jsonObj.getObj().get("sexe");
        String ordre        = (String)jsonObj.getObj().get("ordre");
        String cycle        = (String)jsonObj.getObj().get("cycle");
        String numeroPermis = (String)jsonObj.getObj().get("numero_de_permis");
        
        String activites    = (String)jsonObj.getObj().getString("activites");
        JSONArray listActivites = (JSONArray) JSONSerializer.toJSON(activites);
        
        if (jsonObj.getObj().get("ordre").equals("architecte")){
            
            int heureTransferee = (int)jsonObj.getObj().get("heures_transferees_du_cycle_precedent");
            JSONArray listCategorie = obtenirListCategorie(jsonCat, "architecte");
            leMembre = new Architecte(heureTransferee, nom, prenom, sexe, ordre, cycle, numeroPermis);
            leMembre.setCategories(creerListCategorie(listCategorie));
            creerListeActivitesObj(listActivites, leMembre); 
            
        }else if (jsonObj.getObj().get("ordre").equals("geologue")){
            
            JSONArray listCategorie = obtenirListCategorie(jsonCat, "geologue");
            leMembre = new Geologue(nom, prenom, sexe, ordre, cycle, numeroPermis);
            leMembre.setCategories(creerListCategorie(listCategorie));
            creerListeActivitesObj(listActivites, leMembre);   
            
        }else if (jsonObj.getObj().get("ordre").equals("psychologue")){
            
            JSONArray listCategorie = obtenirListCategorie(jsonCat, "psychologue");
            leMembre = new Psychologue(nom, prenom, sexe, ordre, cycle, numeroPermis);
            leMembre.setCategories(creerListCategorie(listCategorie));
            creerListeActivitesObj(listActivites, leMembre);   
            
        }
        return leMembre;
    }
    
    public static ArrayList<Categorie> creerListCategorie(JSONArray listCategorie){
        ArrayList<Categorie> categories = new ArrayList<>();
        for(int i = 0; i <  listCategorie.size(); i++){
            String cat = (String) listCategorie.getJSONObject(i).get("categorie");
            int min = (int)listCategorie.getJSONObject(i).get("heureMin");
            int max = (int)listCategorie.getJSONObject(i).get("heureMax");
            categories.add(new Categorie(cat, min, max));
        }
        return categories;
    }
    
    private static JSONArray obtenirListCategorie(JSONHash obj, String membre){
        JSONArray resultat = null;
        String cat    = (String)obj.getObj().getString("categories");
        JSONArray categories = (JSONArray) JSONSerializer.toJSON(cat);
        
        for(int i = 0; i <  categories.size(); i++){
            String type = (String)categories.getJSONObject(i).getString("type");
            if (type.equals(membre)){
                String listCat   = (String)categories.getJSONObject(i).getString("content");
                resultat = (JSONArray) JSONSerializer.toJSON(listCat);
                break;
            }
        }
        return resultat;
    }

    private static void creerListeActivitesObj(JSONArray listActivites, Membre leMembre) {
        for(int i = 0; i <  listActivites.size(); i++){
            JSONObject activite = (JSONObject)listActivites.getJSONObject(i);
            String description = (String)activite.get("description");
            String categorie = (String)activite.get("categorie");
            Categorie laCategorie = creerCategorie(categorie, leMembre.getCategories());
            int heure  = (int)activite.get("heures");
            String date = (String)activite.get("date");
            Activite uneActivite = new Activite(description, laCategorie, heure, date);
            leMembre.ajouterActivite(uneActivite);
        }
    }
    
    private static Categorie creerCategorie(String categorie, ArrayList<Categorie> listCategorie){
        Categorie objCategorie = null;
        for(int i = 0; i <  listCategorie.size(); i++){
            String cat = (String) listCategorie.get(i).getNomCategorie();
            if (cat.equals(categorie)){
                int min = (int)listCategorie.get(i).getHeureMin();
                int max = (int)listCategorie.get(i).getHeureMax();
                objCategorie = new Categorie(categorie, min, max);
                break;
            }
        }
        return objCategorie;
    }
}
