/**
 * @(#) LicencePlongeur.java
 */
package FFSSM;

import java.time.LocalDate;

public class Licence {

    public Personne possesseur;

    public String numero;

    public LocalDate delivrance;

    public Club club;

    public Licence(Personne possesseur, String numero, LocalDate delivrance, Club club) {
        this.possesseur = possesseur;
        this.numero = numero;
        this.delivrance = delivrance;
        this.club = club;
    }

    public Licence(String numero, LocalDate delivrance) {
        this.numero = numero;
        this.delivrance = delivrance;
    }

    public Personne getPossesseur() {
        return possesseur;
    }

    public String getNumero() {
        return numero;
    }

    public LocalDate getDelivrance() {
        return delivrance;
    }

    public Club getClub() {
        return club;
    }

    /**
     * Est-ce que la licence est valide à la date indiquée ? Une licence est
     * valide pendant un an à compter de sa date de délivrance
     *
     * @param d la date à tester
     * @return vrai si valide à la date d
     *
     */
    public boolean estValide(LocalDate d) {
        // DONE: Implémenter cette méthode
        
        return this.delivrance.plusYears(1).isEqual(d)|| this.delivrance.plusYears(1).isAfter(d);       
    }

    public void setPossesseur(Personne possesseur) {
        this.possesseur = possesseur;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setDelivrance(LocalDate delivrance) {
        this.delivrance = delivrance;
    }

    public void setClub(Club club) {
        this.club = club;
    }

}
