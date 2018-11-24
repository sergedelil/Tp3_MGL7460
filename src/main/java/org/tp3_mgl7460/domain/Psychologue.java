package org.tp3_mgl7460.domain;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.tp3_mgl7460.analyse.Message;

public class Psychologue extends Membre{
    
    private final int heureMinCycle = 90;
    private int heureTotalActivité = 0;

    public Psychologue(String nom, String prenom, int sexe, String ordre, String cycle, String numeroPermis) {
        super(nom, prenom, sexe, ordre, cycle, numeroPermis);
    }
    
    @Override
    public boolean validerCycle() {
        return cycle.matches("2010-2015");
    }

    @Override
    public boolean validerNumeroPermis() {
        return numeroPermis.matches("\\d{5}[-/.]\\d{2}");
    }

    @Override
    public boolean atteintHeureMinCycle(int heure) {
        return heureTotalActivité >= heureMinCycle;
    }

    public int getHeureTotalActivité() {
        return heureTotalActivité;
    }

    public void setHeureTotalActivité(int heureTotalActivité) {
        this.heureTotalActivité = heureTotalActivité;
    }

    @Override
    public void ajouterActivite(Activite activite){
        this.activites.add(activite);
        heureTotalActivité += activite.getHeure();
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
       msg.getErreurs().add(validerNbHeureMaxConference(this.getActivites()));

        return true;
    }
    
    public String validerDate(Activite activite){
        
        String dateDebut = "2010-01-01";
        String dateFin = "2015-01-01";
        String msg = null;

        boolean apres = string2Date(activite.getDate()).after(string2Date(dateDebut));
        boolean avant = string2Date(activite.getDate()).before(string2Date(dateFin));
            if (! (avant && apres) ){
                msg = "La date de l'activité «"+activite.getDescription()+"» n'est pas valide. Elle sera ignorée.";
            }
         return msg;
    }
    
    public String validerHeure(Activite activite){
    
        String msg = null;
        if(! activite.validerHeure()){
                msg = "L'heure de l'activité «"+activite.getDescription()+"» n'est pas valide. Elle sera ignorée.";
           }
        return msg;
    }
    
    public String validerNbHeureMinCours(ArrayList<Activite> activites){
    
        final int heureMinCours = 25;
        int heureCours = 0;
        String msg = null;
        
        for (Activite activite : activites){
            if((activite.getCategorie() != null) && activite.getCategorie().getNomCategorie().equals("cours")){
                    heureCours = heureCours + activite.getHeure();
                }
                
        }
        if (heureCours < heureMinCours){
                int diff = heureMinCours - heureCours;
                msg = "Il manque "+ diff+" heures de formation pour la categorie cours.";
            }
        return msg;
    }
    
    public String validerNbHeureMaxConference(ArrayList<Activite> activites){
    
        final int heureMaxConference = 15;
        int heureCours = 0;
        String msg = null;
        
        for (Activite activite : activites){
            if((activite.getCategorie() != null) && activite.getCategorie().getNomCategorie().equals("conférence")){
                    heureCours = heureCours + activite.getHeure();
                }
                
        }
        if (heureCours > heureMaxConference){
                msg = "Un maximum de " + heureMaxConference + " heure est permis pour conférence. L'exédent sera ignoré";
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
        return "Psychologue{" + "nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", ordre=" + ordre +", cycle=" + cycle + ", numeroPermis=" + numeroPermis + ", heureMinCycle=" + heureMinCycle + ", activites=" + activites + '}';
    }
   
}
