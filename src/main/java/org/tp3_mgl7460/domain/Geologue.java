/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tp3_mgl7460.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.tp3_mgl7460.analyse.Message;

/**
 *
 * @author sergedelil
 */
public class Geologue extends Membre {

    public final int heureMinCycle = 55;

    public Geologue(String nom, String prenom, int sexe, String ordre, String cycle, String numeroPermis) {
        super(nom, prenom, sexe, ordre, cycle, numeroPermis);
    }

    @Override
    public boolean validerCycle() { 
        // return cycle.matches("^2013-2016$"); plus simple
        boolean isValiderCycle = false;
        
        if("2013-2016".equals(cycle))
        {
            isValiderCycle = true;
        }
        return isValiderCycle;
    }

    @Override
    public boolean validerNumeroPermis() {
        String firstLetterNom = nom.substring(0, 1);
        String firstLetterPrenom = prenom.substring(0, 1);

        if (Character.isUpperCase(firstLetterNom.charAt(0)) && Character.isUpperCase(firstLetterPrenom.charAt(0))) {
            String firstCharacterNomAndPrenom = firstLetterNom + firstLetterPrenom;

            return (String.valueOf(numeroPermis).matches(firstCharacterNomAndPrenom + "[0-9]{4}"));
        }
        return false;
    }

    @Override
    public boolean atteintHeureMinCycle(int heure) {
        return heure >= heureMinCycle ;
    }
    
    @Override
    public boolean examinerDemande(Message msg){
       for (Activite activite : this.getActivites()){
           msg.getErreurs().add(validerDate(activite));
           msg.getErreurs().add(validerHeure(activite));
           ArrayList<String> tabCat = ConstruireListeCategorie();
            if( (activite.getCategorie() == null) || (! tabCat.contains(activite.getCategorie().getNomCategorie())) ){
                msg.getErreurs().add("L'activité «"+activite.getDescription()+"» est dans une catégorie non reconnue. Elle sera ignorée.");
            }
       }
       msg.getErreurs().add(validerNbHeureMinCours(this.getActivites()));
       msg.getErreurs().add(validerNbHeureMinProjetRecherche(this.getActivites()));
       msg.getErreurs().add(validerNbHeureMinGroupeDiscussion(this.getActivites()));

        return true;
    }
    
     public String validerNbHeureMinCours(ArrayList<Activite> activites){
    
        final int heureMin = 22;
        int heureCount = 0;
        String msg = null;
        
        for (Activite activite : activites){
            if((activite.getCategorie() != null) && activite.getCategorie().getNomCategorie().equals("cours")){
                    heureCount = heureCount + activite.getHeure();
                }
                
        }
        if (heureCount < heureMin){
                int diff = heureMin - heureCount;
                msg = "Il manque "+ diff+" heures de formation pour la categorie cours.";
            }
        return msg;
    }
     
     public String validerNbHeureMinProjetRecherche(ArrayList<Activite> activites){
    
        final int heureMin = 3;
        int heureCount = 0;
        String msg = null;
        
        for (Activite activite : activites){
            if((activite.getCategorie() != null) && activite.getCategorie().getNomCategorie().equals("projet de recherche")){
                    heureCount = heureCount + activite.getHeure();
                }
                
        }
        if (heureCount < heureMin){
                int diff = heureMin - heureCount;
                msg = "Il manque "+ diff+" heures de formation pour la categorie projet de recherche.";
            }
        return msg;
    }
    
     public String validerNbHeureMinGroupeDiscussion(ArrayList<Activite> activites){
    
        final int heureMin = 1;
        int heureCount = 0;
        String msg = null;
        
        for (Activite activite : activites){
            if((activite.getCategorie() != null) && activite.getCategorie().getNomCategorie().equals("groupe de discussion")){
                    heureCount = heureCount + activite.getHeure();
                }
                
        }
        if (heureCount < heureMin){
                int diff = heureMin - heureCount;
                msg = "Il manque "+ diff + " heures de formation pour la categorie groupe de discussion.";
            }
        return msg;
    }
     
    public String validerDate(Activite activite){
        
        String dateDebut = "2013-06-01";
        String dateFin = "2016-0-01";
        String msg = null;

        boolean apres = string2Date(activite.getDate()).after(string2Date(dateDebut));
        boolean avant = string2Date(activite.getDate()).before(string2Date(dateFin));
            if (! (avant && apres) ){
                msg = "La date de l'activité «"+activite.getDescription()+"» n'est pas valide. Elle sera ignorée.";
            }
         return msg;
    }
    
    private Date string2Date(String uneDate){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(uneDate);
        } 
        catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    } 
    
    public String validerHeure(Activite activite){
    
        String msg = null;
        if(! activite.validerHeure()){
                msg = "L'heure de l'activité «"+activite.getDescription()+"» n'est pas valide. Elle sera ignorée.";
           }
        return msg;
    }
    
    private ArrayList<String> ConstruireListeCategorie(){
        ArrayList<String> tab = new ArrayList<>();
        this.getCategories().forEach((cat) -> {
            tab.add(cat.getNomCategorie());
        });
        return tab;
    }
 
    @Override
    public String toString() {
        return "Geologue{" + "nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe +", ordre=" + ordre + ", cycle=" + cycle + ", numeroPermis=" + numeroPermis + ", heureMinCycle=" + heureMinCycle + ", activites=" + activites + '}';
    }

}
