
package org.tp3_mgl7460.domain;

import java.util.ArrayList;
import java.util.Objects;
import org.tp3_mgl7460.analyse.Message;


public class Membre {
    
    String nom;
    String prenom;
    int sexe;
    String ordre;
    String cycle;
    String numeroPermis;
    ArrayList<Activite> activites;
    ArrayList<Categorie> categories;
  

    public Membre(String nom, String prenom, int sexe, String ordre, String cycle, String numeroPermis) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.ordre = ordre;
        this.cycle = cycle;
        this.numeroPermis = numeroPermis;
        this.activites = new ArrayList<>();
        this.categories = new ArrayList<>();

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
    
    public ArrayList<Categorie> getCategories() {
        return categories;
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
    public void setCategories(ArrayList<Categorie> cat){
        this.categories = cat;
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
        if (!Objects.equals(this.ordre, other.ordre)) {
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
        hash = 43 * hash + Objects.hashCode(this.ordre);
        hash = 43 * hash + Objects.hashCode(this.cycle);
        hash = 43 * hash + Objects.hashCode(this.numeroPermis);
        return hash;
    }

    public void ajouterActivite(Activite activite){
        if (activite != null)
            this.activites.add(activite);
    }
    
    public boolean validerNom(){
        return nom.matches("^\\w+$");
    }
    
    public boolean validerPrenom(){
        return prenom.matches("^\\w+$");
    }
    
    public boolean validerSexe(){
        return (String.valueOf(sexe).matches("^[012]$"));
    }
    
    public boolean validerOrdre(){
        return ordre.equalsIgnoreCase("Architecte")
                || ordre.equalsIgnoreCase("Geologue")
                || ordre.equalsIgnoreCase("Psychologue");
    }
    
    public boolean validerCycle(){
        // à redefinir
        return false;
    }
    
    public boolean validerNumeroPermis(){
        // à redefinir
        return false;
    }
    
    public boolean atteintHeureMinCycle(int heure){
        // à redefinir
        return false;
    }
    
    public boolean examinerDemande(Message msg){ 
        // à redefinir
        // implementer toute la logique d'affaire selon le type de Membre
        // examiner la demande et produire les msg dans la sortie
        return false;
    }
 
}
