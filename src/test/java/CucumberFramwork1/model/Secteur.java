package CucumberFramwork1.model;

import java.util.Objects;

public class Secteur {

    private String secteur;
    private String nb_SU;
    private String nb_Emploi;
    private String mnt_Levee;
    private String pourcentage_SU;
    private String pourcentage_Emploi;
    private String pourcentage_Montant;


    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getNb_SU() {
        return nb_SU;
    }

    public void setNb_SU(String nb_SU) {
        this.nb_SU = nb_SU;
    }

    public String getNb_Emploi() {
        return nb_Emploi;
    }

    public void setNb_Emploi(String nb_Emploi) {
        this.nb_Emploi = nb_Emploi;
    }

    public String getMnt_Levee() {
        return mnt_Levee;
    }

    public void setMnt_Levee(String mnt_Levee) {
        this.mnt_Levee = mnt_Levee;
    }

    public String getPourcentage_SU() {
        return pourcentage_SU;
    }

    public void setPourcentage_SU(String pourcentage_SU) {
        this.pourcentage_SU = pourcentage_SU;
    }

    public String getPourcentage_Emploi() {
        return pourcentage_Emploi;
    }

    public void setPourcentage_Emploi(String pourcentage_Emploi) {
        this.pourcentage_Emploi = pourcentage_Emploi;
    }

    public String getPourcentage_Montant() {
        return pourcentage_Montant;
    }

    public void setPourcentage_Montant(String pourcentage_Montant) {
        this.pourcentage_Montant = pourcentage_Montant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Secteur secteur1 = (Secteur) o;
        return Objects.equals(secteur, secteur1.secteur) && Objects.equals(nb_SU, secteur1.nb_SU) && Objects.equals(nb_Emploi, secteur1.nb_Emploi) && Objects.equals(mnt_Levee, secteur1.mnt_Levee) && Objects.equals(pourcentage_SU, secteur1.pourcentage_SU) && Objects.equals(pourcentage_Emploi, secteur1.pourcentage_Emploi) && Objects.equals(pourcentage_Montant, secteur1.pourcentage_Montant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(secteur, nb_SU, nb_Emploi, mnt_Levee, pourcentage_SU, pourcentage_Emploi, pourcentage_Montant);
    }

    @Override
    public String toString() {
        return "Secteur{" +
                "secteur='" + secteur + '\'' +
                ", nb_SU='" + nb_SU + '\'' +
                ", nb_Emploi='" + nb_Emploi + '\'' +
                ", mnt_Levee='" + mnt_Levee + '\'' +
                ", pourcentage_SU='" + pourcentage_SU + '\'' +
                ", pourcentage_Emploi='" + pourcentage_Emploi + '\'' +
                ", pourcentage_Montant='" + pourcentage_Montant + '\'' +
                '}';
    }
}

