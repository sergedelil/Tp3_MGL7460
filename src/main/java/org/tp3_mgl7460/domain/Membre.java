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
    String sexe;
    String cycle;
    String numeroPermis;
    ArrayList<Activite> activites;

    public Membre(String nom, String prenom, String sexe, String cycle, String numeroPermis) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.cycle = cycle;
        this.numeroPermis = numeroPermis;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe() {
        return sexe;
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
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
        return false;
    }
    public boolean validerCycle(){
        return false;
    }
    
    public boolean validerNumeroPermis(){
        return false;
    }
    
    public boolean atteintHeureMinCycle(){
        return false;
    }
    
    
    
    
    
    
    
    
}
