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
public class Architecte extends Membre{
    
    private final int heureMinCycle = 40;
    
    private int heureTransferee;

    public Architecte(int heureTransferee, String nom, String prenom, int sexe, String ordre, String cycle, String numeroPermis, int heureMinCycle) {
        super(nom, prenom, sexe, ordre, cycle, numeroPermis);
        this.heureTransferee = heureTransferee;
        
    }
    
    /**
     * @return the heureTransferee
     */
    public int getHeureTransferee() {
        return heureTransferee;
    }

    /**
     * @param heureTransferee the heureTransferee to set
     */
    public void setHeureTransferee(int heureTransferee) {
        this.heureTransferee = heureTransferee;
    }

    @Override
    public boolean validerCycle() {
        return false;
    }

    @Override
    public boolean validerNumeroPermis() {
        return false;
    }

    @Override
    public boolean atteintHeureMinCycle() {
        return false;
    }

    @Override
    public String toString() {
        return "Architecte{" + "nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe +", ordre=" + ordre + ", cycle=" + cycle + ", numeroPermis=" + numeroPermis + ", heureMinCycle=" + heureMinCycle + ", activites=" + activites + ", heureTransferee= " + heureTransferee +'}';
    }
     
}
