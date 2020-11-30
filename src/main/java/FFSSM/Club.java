/**
 * @(#) Club.java
 */
package FFSSM;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Club {

 
    public Moniteur president;

    public String nom;

    public String adresse;

    public String telephone;
    
    public List<Plongee>Plongees = new LinkedList<>();

    public Club(Moniteur président, String nom, String telephone) {
        this.president = président;
        this.nom = nom;
        this.telephone = telephone;
    }

    public List<Plongee> getPlongees() {
        return Plongees;
    }

    /**
     * Calcule l'ensemble des plongées non conformes organisées par ce club.
     * Une plongée est conforme si tous les plongeurs de la palanquée ont une licence
     * valide à la date de la plongée
     * @return l'ensemble des plongées non conformes
     */
    public Set<Plongee> plongeesNonConformes() throws Exception {
         // TODO: Implémenter cette méthode
         Set<Plongee>Plo = new HashSet<>();
        if (this.Plongees.isEmpty()) throw new Exception("Aucune plongée ajoutée");
        else {
            for (Plongee p:this.Plongees) {
                if(!p.estConforme()) {
                    Plo.add(p);
                }
            }
        }
        return Plo;
        
    }

    /**
     * Enregistre une nouvelle plongée organisée par ce club
     * @param p la nouvelle plongée
     */
    public void organisePlongee(Plongee p) {
         // DONE: Implémenter cette méthode
        this.Plongees.add(p);
    }
    
    
    public Moniteur getPresident() {
        return president;
    }

    public void setPresident(Moniteur président) {
        this.president = président;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Club{" + "président=" + president + ", nom=" + nom + ", adresse=" + adresse + ", telephone=" + telephone + '}';
    }

}
