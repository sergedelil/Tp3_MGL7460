
package org.tp3_mgl7460.domain;

import java.util.Objects;

public class Activite {
    private String description;
    Categorie categorie;
    private int heure;
    private String date;

    public Activite(String description, Categorie categorie, int heure, String date) {
        this.description = description;
        this.categorie = categorie;
        this.heure = heure;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public int getHeure() {
        return heure;
    }

    public String getDate() {
        return date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public void setHeure(int heure) {
        this.heure = heure;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Activit {" + "description=" + description + ", categorie=" + categorie + ", heure=" + heure + ", date=" + date + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + Objects.hashCode(this.categorie);
        hash = 67 * hash + Objects.hashCode(this.heure);
        hash = 67 * hash + Objects.hashCode(this.date);
        return hash;
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
        final Activite other = (Activite) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.heure, other.heure)) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return Objects.equals(this.categorie, other.categorie);
    }
    
    public boolean validerDescription(){
        return this.description.length() > 20;
    }
    
    public boolean validerHeure(){
        return heure >= 1;
    }
    
    public boolean validerDate(){
        String[] dates = this.date.split("-");
            return (Integer.parseInt(dates[0]) >= 2010 && Integer.parseInt(dates[0]) <= 2015);
       
    }
    
    public boolean validerActivite(){
        return false;
    }
    
    
}
