package CucumberFramwork1.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class EtreObs {

    private String nom;
    private String secteur;
    private String anneeCreation;
    private String logo;

    private String url;

    private String chiffreAffaire;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getAnneeCreation() {
        return anneeCreation;
    }

    public void setAnneeCreation(String anneeCreation) {
        this.anneeCreation = anneeCreation;
    }

    public String getLogo() {
        return logo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(String chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EtreObs etreObs = (EtreObs) o;
        return Objects.equals(nom, etreObs.nom) && Objects.equals(secteur, etreObs.secteur) && Objects.equals(anneeCreation, etreObs.anneeCreation) && Objects.equals(logo, etreObs.logo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, secteur, anneeCreation, logo);
    }

    @Override
    public String toString() {
        return "EtreObs{" +
                "nom='" + nom + '\'' +
                ", secteur='" + secteur + '\'' +
                ", anneeCreation='" + anneeCreation + '\'' +
                ", logo='" + logo + '\'' +
                ", url='" + url + '\'' +
                ", chiffreAffaire='" + chiffreAffaire + '\'' +
                '}';
    }

    public static void main(String[] args) {
        EtreObs etreObs = new EtreObs();
        EtreObs etreObs1 = new EtreObs();
        List list = new ArrayList();
        list.add("Secteur 1");
        list.add("Secetur 2");
        etreObs1.setLogo("Logo");
        etreObs1.setNom("Nom");
        etreObs1.setAnneeCreation("2023");
        etreObs1.setSecteur("Secteur 1");


        etreObs.setLogo("Logo");
        etreObs.setNom("Nom");
        etreObs.setAnneeCreation("2023");
        etreObs.setSecteur("Secteur 1");

        System.out.println(etreObs1.equals(etreObs));
       // System.out.println("1 => " + etreObs1);
       // System.out.println("2 => " + etreObs);


    }
}
