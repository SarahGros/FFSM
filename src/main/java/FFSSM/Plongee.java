/**
 * @(#) Plongee.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Plongee {

	public Site lieu;

	public Moniteur chefDePalanquee;

	public LocalDate date;

	public int profondeur;

	public int duree;
        
        private List<Licence>Participants = new LinkedList<>();

	public Plongee(Site lieu, Moniteur chefDePalanquee, LocalDate date, int profondeur, int duree) {
		this.lieu = lieu;
		this.chefDePalanquee = chefDePalanquee;
		this.date = date;
		this.profondeur = profondeur;
		this.duree = duree;
	}

	public void ajouteParticipant(Licence participant) {
		// Done : Implémenter cette méthode
                this.Participants.add(participant);
	}

	public LocalDate getDate() {
		return date;
	}

	/**
	 * Détermine si la plongée est conforme. 
	 * Une plongée est conforme si tous les plongeurs de la palanquée ont une
	 * licence valide à la date de la plongée
	 * @return vrai si la plongée est conforme
	 */
	public boolean estConforme() {
		// TODO: Implémenter cette méthode
                
		for(Licence l : this.Participants){
                    if(!l.estValide(date)) return false;
                    
                }
                return true;
	}

    public Site getLieu() {
        return lieu;
    }

    public Moniteur getChefDePalanquee() {
        return chefDePalanquee;
    }

    public int getProfondeur() {
        return profondeur;
    }

    public int getDuree() {
        return duree;
    }

    public List<Licence> getParticipants() {
        return Participants;
    }

        
}
