
package org.tp3_mgl7460.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import org.tp3_mgl7460.analyse.Message;


public class Architecte extends Membre{
    
    private int heureMinCycle = 40;        
    private int heureTransferee;
    
    private int nbHeureFormationCumulee = 0;
    private int nbHeureDes6Cumulee = 0;
    private int nbHeurePresentation = 0;
    private int nbHeureGrpDiscussion = 0;
    private int nbHeureProjRech = 0;
    private int nbHeureRedacProfe = 0;

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
    
    public boolean estCategorieDes6(String categorie){
        ArrayList<String> catList = new ArrayList<>();
        String [] listCategorie = {"cours", "atelier", "séminaire", "colloque", "conférence", "lecture dirigée"};
        catList.addAll(Arrays.asList(listCategorie));
        return catList.contains(categorie);
    }
    
    @Override
    public boolean examinerDemande(Message msg){
        boolean reponse = false;
        try{
            int diff = 0;
            nbHeureFormationCumulee = 0;
            nbHeureDes6Cumulee = 0;
            nbHeurePresentation = 0;
            nbHeureGrpDiscussion = 0;
            nbHeureProjRech = 0;
            nbHeureRedacProfe = 0;
    
            GetToutCategoriesHeures(msg);
 
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
            nbHeureFormationCumulee = nbHeureDes6Cumulee + nbHeurePresentation + nbHeureGrpDiscussion + nbHeureProjRech + nbHeureRedacProfe;
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
    
    private void GetToutCategoriesHeures(Message msg){
        String dateDebut = "2012-04-01";
        String dateFin = "2014-04-01";
            
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
                nbHeureDes6Cumulee += activite.getHeure();
            }

            nbHeurePresentation += GetActiviteCategorieHeure(activite, "présentation", nbHeurePresentation);
                
            nbHeureGrpDiscussion += GetActiviteCategorieHeure(activite, "groupe de discussion", nbHeureGrpDiscussion);

            nbHeureProjRech += GetActiviteCategorieHeure(activite, "projet de recherche", nbHeureProjRech);
                
            nbHeureRedacProfe += GetActiviteCategorieHeure(activite, "rédaction professionnelle", nbHeureRedacProfe);                
        }        
    }
            
    
    public int GetActiviteCategorieHeure (Activite activite, String categorie, int heureAccumule){
        int result = 0;
        if(activite.getCategorie().getNomCategorie().equals(categorie)){
            if(heureAccumule < activite.getCategorie().getHeureMax())
                result = activite.getHeure();
            }
        return result;
    }
    
    public ArrayList<String> ConstruireListeCategorie(){
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