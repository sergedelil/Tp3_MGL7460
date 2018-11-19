/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tp3_mgl7460.domain;

import org.tp3_mgl7460.analyse.Message;

/**
 *
 * @author sergedelil
 */
public class Psychologue extends Membre{
    
    private final int heureMinCycle = 90;

    public Psychologue(String nom, String prenom, int sexe, String ordre, String cycle, String numeroPermis) {
        super(nom, prenom, sexe, ordre, cycle, numeroPermis);
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
    public boolean examinerDemande(Message msg){
        // à redefinir
        // implementer toute la logique d'affaire selon le type de Membre
        // examiner la demande et produire les msg dans la sortie
        return false;
    }

    @Override
    public boolean atteintHeureMinCycle(int heure) {
        return false;
    }

    @Override
    public String toString() {
        return "Psychologue{" + "nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", ordre=" + ordre +", cycle=" + cycle + ", numeroPermis=" + numeroPermis + ", heureMinCycle=" + heureMinCycle + ", activites=" + activites + '}';
    }
   
}
