/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tp3_mgl7460.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author sergedelil
 */
public class Architecte extends Membre{
    private final String GOODCYCLE = "2012-2014";
    
    private int heureMinCycle = 40;        
    //private int heureTransferee;

    public Architecte(String nom, String prenom, int sexe, String ordre, String cycle, String numeroPermis, int heureTransfereesDuCyclePrecedent) {
        super(nom, prenom, sexe, ordre, cycle, numeroPermis, heureTransfereesDuCyclePrecedent);
        //this.heureTransferee = heureTransferee; 
        //this.heureMinCycle = heureMinCycle;
    }
    
    /**
     * @return the heureTransferee
     */
    //public int getHeureTransferee() {
        //return heureTransferee;
    //}

    /**
     * @param heureTransferee the heureTransferee to set
     */
    //public void setHeureTransferee(int heureTransferee) {
        //this.heureTransferee = heureTransferee;
    //}
    
    //public int getHeureMinCycle() {
        //return heureMinCycle;
    //}

    //public void setHeureMinCycle(int heureMinCycle) {
        //this.heureMinCycle = heureMinCycle;
    //}    

    @Override
    public boolean validerCycle() {
        String sPatternCycle = "^\\d{4}-\\d{4}$";
        Pattern p = Pattern.compile(sPatternCycle);
        Matcher m = p.matcher(cycle);
        
        boolean isGoodFormat = m.find();
        boolean isGoodCycle = (cycle == GOODCYCLE);
        
        return isGoodFormat && isGoodCycle;
    }

    @Override
    public boolean validerNumeroPermis() {
        String sPatternPermis = "^[AT]\\d{4}$";
        Pattern p = Pattern.compile(sPatternPermis);
        Matcher m = p.matcher(numeroPermis);
        
        boolean isGoodPermis = m.find();
        
        return isGoodPermis;
    }

    @Override
    public boolean atteintHeureMinCycle() {
        return heureTotalActiviteCycle >= heureMinCycle;
        //int heureActiviteCycle = 0; 
        
        //if (activites != null){
            //for (Activite activity : activites) {
                //if (activity != null) {
                    //this.ajouterHeureTotalActivite(activity.getHeure());
                    //int heure = activity.getHeure();
                    //if (heure > 0){
                       // heureActiviteCycle = heureActiviteCycle + heure;                 
                    //}
                //}
            //}
        //}
        //return (heureTotalActiviteCycle >= heureMinCycle);
    }

    @Override
    public String toString() {
        return "Architecte{" + "nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", cycle=" + cycle + ", numeroPermis=" + numeroPermis + ", heureMinCycle=" + heureMinCycle + ", activites=" + activites + ", heureTransferee= " + heureTransfereesDuCyclePrecedent +'}';
    }
     
}
