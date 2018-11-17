/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tp3_mgl7460.domain;

/**
 *
 * @author sergedelil
 */
public class Psychologue extends Membre{
    
    private final int heureMinCycle = 90;
    private final int heureMinCategorieCours = 25;
    
    

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
    
    public boolean aucuneHeureTransfereDuCyclePrecedent() {   
        return heureTransfereesDuCyclePrecedent == 0;
    }
    
    @Override
    public String toString() {
        return "Psychologue{" + "nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", ordre=" + ordre +", cycle=" + cycle + ", numeroPermis=" + numeroPermis + ", heureMinCycle=" + heureMinCycle + ", activites=" + activites + '}';
    }
   
}
