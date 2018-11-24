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
public class Geologue extends Membre {

    public final int heureMinCycle = 55;

    public Geologue(String nom, String prenom, int sexe, String ordre, String cycle, String numeroPermis) {
        super(nom, prenom, sexe, ordre, cycle, numeroPermis);
    }

    @Override
    public boolean validerCycle() { 
        return cycle.matches("^2013-2016$");
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
        // à redefinir
        // implementer toute la logique d'affaire selon le type de Membre
        // examiner la demande et produire les msg dans la sortie
        return false;
    }

    @Override
    public String toString() {
        return "Geologue{" + "nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe +", ordre=" + ordre + ", cycle=" + cycle + ", numeroPermis=" + numeroPermis + ", heureMinCycle=" + heureMinCycle + ", activites=" + activites + '}';
    }

}
