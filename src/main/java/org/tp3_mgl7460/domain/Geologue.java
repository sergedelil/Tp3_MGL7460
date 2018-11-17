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
public class Geologue extends Membre {

    public final int heureMinCycle = 55;
    int heureCycle;

    public Geologue(String nom, String prenom, int sexe, String cycle, String numeroPermis, int heureCycle) {
        super(nom, prenom, sexe, cycle, numeroPermis);
        this.heureCycle = heureCycle;
    }

    @Override
    public boolean validerCycle() {        
        boolean isValiderCycle = false;
        
        if(cycle == "2013-2016")
        {
            isValiderCycle = true;
        }
        return isValiderCycle;
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
    public boolean atteintHeureMinCycle() {
        boolean isAtteintHeureMinCycle = false;

        if (heureCycle >= heureMinCycle) {
            isAtteintHeureMinCycle = true;
        }
        return isAtteintHeureMinCycle;
    }

    @Override
    public String toString() {
        return "Geologue{" + "nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", cycle=" + cycle + ", numeroPermis=" + numeroPermis + ", heureMinCycle=" + heureMinCycle + ", activites=" + activites + '}';
    }

}
