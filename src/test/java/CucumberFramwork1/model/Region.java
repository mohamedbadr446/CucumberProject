package CucumberFramwork1.model;

import org.apache.commons.lang.StringUtils;

public class Region {

    private String region;
    private String dr;
    private String nb_SU;
    private String mnt_Levee;
    private String porcentage_SU;
    private String pourcentage_Montant;
    private String nb_Emploi;

    private String pourcentage_emploi;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDr() {
        return dr;
    }

    public void setDr(String dr) {
        this.dr = dr;
    }

    public String getNb_SU() {
        return nb_SU;
    }

    public void setNb_SU(String nb_SU) {
        this.nb_SU = nb_SU;
    }

    public String getMnt_Levee() {
        return mnt_Levee;
    }

    public void setMnt_Levee(String mnt_Levee) {
        this.mnt_Levee = mnt_Levee;
    }

    public String getPorcentage_SU() {
        return porcentage_SU;
    }

    public void setPorcentage_SU(String porcentage_SU) {
        this.porcentage_SU = porcentage_SU;
    }

    public String getPourcentage_Montant() {
        return pourcentage_Montant;
    }

    public void setPourcentage_Montant(String pourcentage_Montant) {
        this.pourcentage_Montant = pourcentage_Montant;
    }

    public String getNb_Emploi() {
        return nb_Emploi;
    }

    public void setNb_Emploi(String nb_Emploi) {
        this.nb_Emploi = nb_Emploi;
    }

    public String getPourcentage_emploi() {
        return pourcentage_emploi;
    }

    public void setPourcentage_emploi(String pourcentage_emploi) {
        this.pourcentage_emploi = pourcentage_emploi;
    }

    @Override
    public String toString() {
        return "Region{" +
                "region='" + region + '\'' +
                ", dr='" + dr + '\'' +
                ", nb_SU='" + nb_SU + '\'' +
                ", mnt_Levee='" + mnt_Levee + '\'' +
                ", porcentage_SU='" + porcentage_SU + '\'' +
                ", pourcentage_Montant='" + pourcentage_Montant + '\'' +
                ", nb_Emploi='" + nb_Emploi + '\'' +
                ", pourcentage_emploi='" + pourcentage_emploi + '\'' +
                '}';
    }

    public String getPorcentage(String str) {
        String strDouble = StringUtils.substringAfterLast(str, ".") + "0";
        String strInt = StringUtils.substringBeforeLast(str, ".");
        System.out.println("strInt " + strInt);
        System.out.println("strDouble " + strDouble);

        double nbr = Integer.parseInt(String.valueOf(strDouble.charAt(1)));

        System.out.println(nbr);
        if (nbr >= 5) {

            return strInt + "." + (Integer.parseInt(String.valueOf(strDouble.charAt(0))) + 1) + " %";
        } else {
            if (Integer.parseInt(String.valueOf(strDouble.charAt(0))) == 0) {
                return strInt + " %";
            } else {
                return strInt + "." + strDouble.charAt(0) + "%";
            }

        }

    }

}

