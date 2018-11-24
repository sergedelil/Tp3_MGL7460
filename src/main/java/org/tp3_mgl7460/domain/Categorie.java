
package org.tp3_mgl7460.domain;

import java.util.Objects;


public class Categorie {
    
    private String nomCategorie;
    private int heureMin;
    private int heureMax;

    public Categorie(String nomCategorie, int heureMin, int heureMax) {
        this.nomCategorie = nomCategorie;
        this.heureMin = heureMin;
        this.heureMax = heureMax;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public int getHeureMin() {
        return heureMin;
    }

    public int getHeureMax() {
        return heureMax;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public void setHeureMin(int heureMin) {
        this.heureMin = heureMin;
    }

    public void setHeureMax(int heureMax) {
        this.heureMax = heureMax;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.nomCategorie);
        hash = 73 * hash + this.heureMin;
        hash = 73 * hash + this.heureMax;
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
        final Categorie other = (Categorie) obj;
        if (this.heureMin != other.heureMin) {
            return false;
        }
        if (this.heureMax != other.heureMax) {
            return false;
        }
        return Objects.equals(this.nomCategorie, other.nomCategorie);
    }

    @Override
    public String toString() {
        return "Categorie{" + "nomCategorie=" + nomCategorie + ", heureMin=" + heureMin + ", heureMax=" + heureMax + '}';
    }
    
     public boolean validerCategorie() {
        boolean isValideCategorie = false;

        if (nomCategorie.equals("cours") || nomCategorie.equals("atelier") || nomCategorie.equals("séminaire")
                || nomCategorie.equals("colloque") || nomCategorie.equals("conférence") || nomCategorie.equals("lecture dirigée")
                || nomCategorie.equals("présentation") || nomCategorie.equals("groupe de discussion")
                || nomCategorie.equals("groupe de discussion") || nomCategorie.equals("rédaction professionnelle")) {
            isValideCategorie = true;
        }
        return isValideCategorie;
    }

    public boolean admetHeureMin() {
        boolean admetHeureMin = false;

        if ((nomCategorie.equals("cours") || nomCategorie.equals("atelier") || nomCategorie.equals("séminaire")
                || nomCategorie.equals("colloque") || nomCategorie.equals("conférence") || nomCategorie.equals("lecture dirigée")) && heureMin >= 17) {
            admetHeureMin = true;
        }
        return admetHeureMin;
    }

    public boolean admetHeureMax() {
        boolean admetHeureMax = false;

        switch (nomCategorie) {
            case "présentation": 
                if (heureMax <= 23) {
                    admetHeureMax = true;
                }
                break;

            case "groupe de discussion":
                if (heureMax <= 17) {
                    admetHeureMax = true;
                }
                break;

            case "projet de recherche":
                if (heureMax <= 23) {
                    admetHeureMax = true;
                }
                break;

            case "rédaction professionnelle":
                if (heureMax <= 17) {
                    admetHeureMax = true;
                }
                break;
        }

        return admetHeureMax;
    }

    public boolean atteintHeureMin() {
        boolean atteintHeureMin = false;

        if ((nomCategorie == "cours" || nomCategorie == "atelier" || nomCategorie == "séminaire"
                || nomCategorie == "colloque" || nomCategorie == "conférence" || nomCategorie == "lecture dirigée") && heureMin == 17) {
            atteintHeureMin = true;
        }
        return atteintHeureMin;

    }

    public boolean atteintHeureMax() {
        boolean atteintHeureMax = false;

        switch (nomCategorie) {
            case "présentation":
                if (heureMax == 23) {
                    atteintHeureMax = true;
                }
                break;

            case "groupe de discussion":
                if (heureMax == 17) {
                    atteintHeureMax = true;
                }
                break;

            case "projet de recherche":
                if (heureMax == 23) {
                    atteintHeureMax = true;
                }
                break;
                
            case "rédaction professionnelle":
                if (heureMax == 17) {
                    atteintHeureMax = true;
                }
                break;
        }
        return atteintHeureMax;
    }
}
