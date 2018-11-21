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
import java.util.Arrays;
import java.util.Date;
import org.tp3_mgl7460.analyse.Message;

/**
 *
 * @author sergedelil
 */
public class Architecte extends Membre{
    
    private int heureMinCycle = 40;        
    private int heureTransferee;

    public Architecte(int heureTransferee, String nom, String prenom, int sexe, String ordre, String cycle, String numeroPermis) {
        super(nom, prenom, sexe, ordre, cycle, numeroPermis);
        this.heureTransferee = heureTransferee;
        
    }
    
    public int getHeureTransferee() {
        return heureTransferee;
    }

    public void setHeureTransferee(int heureTransferee) {
        this.heureTransferee = heureTransferee;
    }

    @Override
    public boolean validerCycle() {
        return cycle.matches("^2012-2014$");

    }

    @Override
    public boolean validerNumeroPermis() {
        return numeroPermis.matches("^[AT]\\d{4}$");
    }

    @Override
    public boolean atteintHeureMinCycle(int heure) {
        return heure >= heureMinCycle;
    }
    
    public boolean validerHeureTranferee() {
        return heureTransferee > 0;
    }
    
    private boolean estCategorieDes6(String categorie){
        ArrayList<String> catList = new ArrayList<>();
        String [] listCategorie = {"cours", "atelier", "séminaire", "colloque", "conférence", "lecture dirigée"};
        catList.addAll(Arrays.asList(listCategorie));
        return catList.contains(categorie);
    }
    
    @Override
    public boolean examinerDemande(Message msg){
        boolean reponse = false;
        try{
            String dateDebut = "2012-04-01";
            String dateFin = "2014-04-01";

            int nbHeureFormationCumulee = 0;
            int nbHeureDes6Cumulee = 0;
            int heurePresentation = 0;
            int heureGrpDiscussion = 0;
            int heureProjRech = 0;
            int heureRedacProfe = 0;
            int diff = 0;

            for (Activite activite : this.getActivites()){

                boolean apres = string2Date(activite.getDate()).after(string2Date(dateDebut));
                boolean avant = string2Date(activite.getDate()).before(string2Date(dateFin));
                if (! (avant && apres) ){
                    msg.getErreurs().add("La date de l'activité «"+activite.getDescription()+"» n'est pas valide. Elle sera ignorée.");
                    continue;
                }
                if(! activite.validerHeure()){
                    msg.getErreurs().add("L'heure de l'activité «"+activite.getDescription()+"» n'est pas valide. Elle sera ignorée.");
                    continue;
                }
                ArrayList<String> tabCat = ConstruireListeCategorie();
                if( (activite.getCategorie() == null) || (! tabCat.contains(activite.getCategorie().getNomCategorie())) ){
                    msg.getErreurs().add("L'activité «"+activite.getDescription()+"» est dans une catégorie non reconnue. Elle sera ignorée.");
                    continue;
                }
                if(estCategorieDes6(activite.getCategorie().getNomCategorie())){
                    nbHeureDes6Cumulee = nbHeureDes6Cumulee + activite.getHeure();
                }


                if(activite.getCategorie().getNomCategorie().equals("présentation")){
                    if(heurePresentation < activite.getCategorie().getHeureMax())
                        heurePresentation = heurePresentation + activite.getHeure();
                }
                if(activite.getCategorie().getNomCategorie().equals("groupe de discussion")){
                    if(heureGrpDiscussion < activite.getCategorie().getHeureMax())
                        heureGrpDiscussion = heureGrpDiscussion + activite.getHeure();
                }
                if(activite.getCategorie().getNomCategorie().equals("projet de recherche")){
                    if(heureProjRech < activite.getCategorie().getHeureMax())
                        heureProjRech = heureProjRech + activite.getHeure();
                }
                if(activite.getCategorie().getNomCategorie().equals("rédaction professionnelle")){
                    if(heureRedacProfe < activite.getCategorie().getHeureMax())
                        heureRedacProfe = heureRedacProfe + activite.getHeure();
                }
            }
            if(! this.validerHeureTranferee())
                msg.getErreurs().add("Le nombre d'heures transférées n'est pas valide. Elle sera ignorée.");

            if(this.getHeureTransferee() > 7){
                msg.getErreurs().add("Le nombre d'heures transférées est superieur à 7. Seul 7 heures Elle seront comptabilisé.");
                this.setHeureTransferee(7);
            }
            nbHeureDes6Cumulee = nbHeureDes6Cumulee + this.heureTransferee;
            if (nbHeureDes6Cumulee < 17){
                diff = 17 - nbHeureDes6Cumulee;
                msg.getErreurs().add("Il manque "+ diff+" heures de formation pour l'ensemble des catégories 1 à 6.");
            }
            nbHeureFormationCumulee = nbHeureDes6Cumulee + heurePresentation + heureGrpDiscussion + heureProjRech + heureRedacProfe;
            if (nbHeureFormationCumulee < this.heureMinCycle){
                diff = this.heureMinCycle - nbHeureFormationCumulee;
                msg.getErreurs().add("Il manque "+ diff+" heures de formation pour compléter le cycle.");
            }
            reponse = true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return reponse;
    }
    
    private ArrayList<String> ConstruireListeCategorie(){
        ArrayList<String> tab = new ArrayList<>();
        this.getCategories().forEach((cat) -> {
            tab.add(cat.getNomCategorie());
        });
        return tab;
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

    @Override
    public String toString() {
        return "Architecte {" + "nom = " + nom 
                             + ", prenom = " + prenom 
                             + ", sexe = " + sexe 
                             +", ordre = " + ordre 
                             + ", cycle = " + cycle 
                             + ", numeroPermis = " + numeroPermis 
                             + ", heureMinCycle = " + heureMinCycle 
                             + ", heureTransferee = " + heureTransferee
                             + ", activites=" + activites 
                             +'}';
    }
}
