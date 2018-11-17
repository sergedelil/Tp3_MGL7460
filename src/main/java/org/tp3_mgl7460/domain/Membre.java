/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tp3_mgl7460.domain;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author sergedelil
 */
public class Membre {
    
    String nom;
    String prenom;
    int sexe;
    String ordre;
    String cycle;
    String numeroPermis;
    ArrayList<Activite> activites;
    int heureTransfereesDuCyclePrecedent;
    int heureTotalActiviteCycle;

  

    public Membre(String nom, String prenom, int sexe, String ordre, String cycle, String numeroPermis, int heureTransfereesDuCyclePrecedent) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.ordre = ordre;
        this.cycle = cycle;
        this.numeroPermis = numeroPermis;
        this.heureTransfereesDuCyclePrecedent = heureTransfereesDuCyclePrecedent;
        this.heureTotalActiviteCycle = 0;
    }

    
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getSexe() {
        return sexe;
    }
    
    public String getOrdre() {
        return ordre;
    }

    public String getCycle() {
        return cycle;
    }

    public String getNumeroPermis() {
        return numeroPermis;
    }

    public ArrayList<Activite> getActivites() {
        return activites;
    }

    public int getHeureTotalActiviteCycle() {
        return heureTotalActiviteCycle;
    }
     
    public int getHeureTransfereesDuCyclePrecedent() {
        return heureTransfereesDuCyclePrecedent;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(int sexe) {
        this.sexe = sexe;
    }
    
    public void setOrdre(String ordre) {
        this.ordre = ordre;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public void setNumeroPermis(String numeroPermis) {
        this.numeroPermis = numeroPermis;
    }

    public void setActivites(ArrayList<Activite> activites) {
        this.activites = activites;
    }

      public void setHeureTotalActiviteCycle(int heureTotalActiviteCycle) {
        this.heureTotalActiviteCycle = heureTotalActiviteCycle;
    }
      
    public void setHeureTransfereesDuCyclePrecedent(int heureTransfereesDuCyclePrecedent) {
        this.heureTransfereesDuCyclePrecedent = heureTransfereesDuCyclePrecedent;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Membre other = (Membre) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.sexe, other.sexe)) {
            return false;
        }
        if (!Objects.equals(this.cycle, other.cycle)) {
            return false;
        }
        if (!Objects.equals(this.numeroPermis, other.numeroPermis)) {
            return false;
        }
        return Objects.equals(this.activites, other.activites);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.nom);
        hash = 43 * hash + Objects.hashCode(this.prenom);
        hash = 43 * hash + Objects.hashCode(this.sexe);
        hash = 43 * hash + Objects.hashCode(this.cycle);
        hash = 43 * hash + Objects.hashCode(this.numeroPermis);
        return hash;
    }

    public void ajouterActivite(Activite activite){
        this.activites.add(activite);
    }
    
    public boolean validerNom(){
        return false;
    }
    
    public boolean validerPrenom(){
        return false;
    }
    
    public boolean validerSexe(){
        return (String.valueOf(nom).matches("^[012]$"));
    }
    public boolean validerCycle(){
        return false;
    }
    
    public boolean validerOrdre(){
        return ordre.equalsIgnoreCase("Architecte")
                || ordre.equalsIgnoreCase("Geologue")
                || ordre.equalsIgnoreCase("Psychologue");
    }
    
    public boolean validerNumeroPermis(){
        return false;
    }
    
    public boolean atteintHeureMinCycle(){
        return false;
    }
 
}
