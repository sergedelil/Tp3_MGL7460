package org.tp3_mgl7460.domain;

import java.util.ArrayList;


/**
 *
 * @author sergedelil
 */
public class Psychologue extends Membre{
    
    private final int heureMinCycle = 90;
    private final int heureMinCategorieCours = 25;
    
    int heureTotalCategorieCours = 0;
    
    

    public Psychologue(String nom, String prenom, int sexe, String ordre, String cycle, String numeroPermis, int heureTransfereesDuCyclePrecedent) {
        super(nom, prenom, sexe, ordre, cycle, numeroPermis, heureTransfereesDuCyclePrecedent);
    }
    
    @Override
    public boolean validerCycle() {
        return cycle == ("2010-2015");
    }

    @Override
    public boolean validerNumeroPermis() {
        return numeroPermis.matches("\\d{5}[-/.]\\d{2}");
    }

    @Override
    public boolean atteintHeureMinCycle() {   
        return heureTotalActiviteCycle >= heureMinCycle;
    }
    
    public boolean atteintHeureMinCours() {
        return heureTotalCategorieCours >= heureMinCategorieCours;
    }
    
    public boolean aucuneHeureTransfereDuCyclePrecedent() {   
        return heureTransfereesDuCyclePrecedent == 0;
    }
    
    @Override
    public void ajouterActivite(Activite activite){
        if(activite.getCategorie().getNomCategorie() == "cours"){
            heureTotalCategorieCours += activite.getHeure();
        }
        this.ajouterHeureTotalActivite(activite.getHeure());
        
        this.activites = new ArrayList<Activite>();
        this.activites.add(activite);
    }
    
    @Override
    public String toString() {
        return "Psychologue{" + "nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", ordre=" + ordre +", cycle=" + cycle + ", numeroPermis=" + numeroPermis + ", heureMinCycle=" + heureMinCycle + ", activites=" + activites + '}';
    }
   
}
