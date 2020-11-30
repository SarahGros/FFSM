/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Moniteur extends Plongeur {

    public int numeroDiplome;

    public List<Embauche> Emplois = new LinkedList<>();

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, String niveau, GroupeSanguin gs, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance, niveau, gs);
        this.numeroDiplome = numeroDiplome;
    }

    public List<Embauche>  getEmplois() {
        return Emplois;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est
     * terminée, ce moniteur n'a pas d'employeur.
     *
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() throws Exception {
        // TODO: Implémenter cette méthode
        if (this.Emplois.isEmpty()) throw new Exception("Aucun emploi");

        if (Emplois.get(Emplois.size()-1).estTerminee()) throw new Exception("Dernier emploi déjà terminé");
        return Optional.ofNullable(this.Emplois.get(Emplois.size()-1).getEmployeur());
    }

    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     *
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {
        // DONE: Implémenter cette méthode
        Embauche e = new Embauche(debutNouvelle, this , employeur );
        this.Emplois.add(e);
        
    }

    public List<Embauche> emplois() {
        // DONE: Implémenter cette méthode
        return Emplois;
    }

}
