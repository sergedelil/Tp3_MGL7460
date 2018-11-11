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
public class Geologue extends Membre{
    
    private final int heureMinCycle = 55;
    
    public Geologue(String nom, String prenom, String sexe, String cycle, String numeroPermis) {
        super(nom, prenom, sexe, cycle, numeroPermis);
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
        return "Geologue{" + "nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", cycle=" + cycle + ", numeroPermis=" + numeroPermis + ", heureMinCycle=" + heureMinCycle + ", activites=" + activites + '}';
    }
    
}
