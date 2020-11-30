package FFSSM;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Plongeur extends Personne {
    private String niveau;
    GroupeSanguin gs;
    private List<Licence>licences = new LinkedList<>();
    
	
    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, String niveau, GroupeSanguin gs) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
        this.gs = gs;
    }

    @Override
    public String getNumeroINSEE() {
        return numeroINSEE;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public String getPrenom() {
        return prenom;
    }

    @Override
    public String getAdresse() {
        return adresse;
    }

    @Override
    public String getTelephone() {
        return telephone;
    }

    @Override
    public LocalDate getNaissance() {
        return naissance;
    }

    public void setNumeroINSEE(String numeroINSEE) {
        this.numeroINSEE = numeroINSEE;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setNaissance(LocalDate naissance) {
        this.naissance = naissance;
    }
    
    public void ajouteLicence(String numero, LocalDate delivrance){
       Licence l = new Licence(numero, delivrance);
        this.licences.add(l);
        
    }


    public String getNiveau() {
        return niveau;
    }

    public GroupeSanguin getGs() {
        return gs;
    }

    public List<Licence> getLicences() {
        return licences;
    }

   

}
