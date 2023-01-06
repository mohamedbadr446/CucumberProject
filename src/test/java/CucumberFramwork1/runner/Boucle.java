package CucumberFramwork1.runner;

import CucumberFramwork1.model.Voiture;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boucle {

    public List a() {
        Voiture v;
        List list = new ArrayList<Voiture>();
        List list1 = new ArrayList<String>();
        list1.add("AAA");
        list1.add("BBB");
        for (int i = 0; i < 5; i++) {
            v = new Voiture();
            v.setId(i);
            v.setMatricule("Matricule v" + i);
            v.setModel("null");
            v.setList(list1);
            list.add(v);
        }

        return list;
    }

    public void b() {
        Voiture v;
        List list = new ArrayList<Voiture>();
        List listV = a();
        List list1 = new ArrayList<String>();
        list1.add("AAA");
        list1.add("BBB");
        for (int i = 0; i < 5; i++) {
            v = new Voiture();
            v.setId(i);
            v.setMatricule("Matricule v" + i);
            v.setModel("null");
            v.setList(list1);
            list.add(v);
        }

        for (int i = 0; i < list.size(); i++) {
            Voiture v1 = new Voiture();
            Voiture v2 = new Voiture();
            v1 = (Voiture) list.get(i);
            v2 = (Voiture) listV.get(i);

            if (v1.equals(v2)) {
                System.out.println("OK");
            } else {
                System.out.println("KO");
            }
        }

    }

    public List replaceNull() {
        List list;
        list = a();
        a().forEach(e -> System.err.println(e.toString()));
        System.out.println("----------------------");

        return list;
    }

    public String getTraitementMntLevee(String mnt_Levee) {
        // mnt_Levee = "78.57";
        String str = StringUtils.substringBefore(mnt_Levee, ".");
        int nbr = Integer.parseInt(String.valueOf(str.length()));
        //String nbr=String.valueOf(str.length());
        System.out.println(nbr);

        switch (nbr) {
            case 4:

                if (Integer.parseInt(String.valueOf(str.charAt(0))) == 1 && Integer.parseInt(String.valueOf(str.charAt(2))) >= 5) {
                    System.out.println("case 4: 1");
                    return str.charAt(0) + "." + (Integer.parseInt(String.valueOf(str.charAt(1))) + 1) + " Md €";
                } else {
                    if (Integer.parseInt(String.valueOf(str.charAt(0))) == 1 && Integer.parseInt(String.valueOf(str.charAt(2))) <= 5) {
                        System.out.println("case 4: 2");
                        return str.charAt(0) + "." + Integer.parseInt(String.valueOf(str.charAt(1))) + " Md €";
                    } else {
                        if (Integer.parseInt(String.valueOf(str.charAt(0))) > 1 && Integer.parseInt(String.valueOf(str.charAt(2))) < 5) {

                            System.out.println("case 4: 3");
                            return str.charAt(0) + "." + Integer.parseInt(String.valueOf(str.charAt(1))) + " Mds €";
                        } else {
                            if (Integer.parseInt(String.valueOf(str.charAt(0))) > 1 && Integer.parseInt(String.valueOf(str.charAt(2))) > 5) {
                                System.out.println("case 4: 4");
                                return str.charAt(0) + "." + (Integer.parseInt(String.valueOf(str.charAt(1))) + 1) + " Mds €";
                            }
                        }
                    }
                }
            case 3:
                if (Integer.parseInt(String.valueOf(str.charAt(1))) > 5) {
                    System.out.println("case 3: 1");
                    return "0" + "." + String.valueOf((Double.parseDouble(str) / 1000) + 0.1).charAt(2) + " Md €";
                } else if (Integer.parseInt(String.valueOf(str.charAt(1))) < 5) {
                    System.out.println("case 4: 2");
                    return "0" + "." + String.valueOf((Double.parseDouble(str) / 1000)).charAt(2) + " Md €";
                }
            case 2:
                System.err.println(Double.parseDouble("0" + mnt_Levee.charAt(2) + mnt_Levee.charAt(3)));
                System.out.println("0" + mnt_Levee.charAt(2) + mnt_Levee.charAt(3));
                if (Double.parseDouble("0" + mnt_Levee.charAt(2) + mnt_Levee.charAt(3)) <= 0.5) {
                    System.out.println("case 2: 1");
                    return mnt_Levee.charAt(0) + (Integer.parseInt(String.valueOf(mnt_Levee.charAt(1))) + 1) + " M €";
                } else {
                    if (Integer.parseInt(String.valueOf(mnt_Levee.charAt(3))) < 5) {
                        System.out.println("case 4: 2");
                        return mnt_Levee.charAt(0) + Integer.parseInt(String.valueOf(mnt_Levee.charAt(1))) + " M €";
                    }
                }

            default:
                throw new IllegalArgumentException("Unknown nbr " + nbr);

        }
    }

    public String getTraitementMntLevee2(String mnt_Levee) {
        //mnt_Levee = "78.57";
        String strE = StringUtils.substringAfter(mnt_Levee, "E");
        String str = StringUtils.substringBefore(mnt_Levee, "E");
        String strInt = StringUtils.substringBefore(str, ".");
        String strDouble = StringUtils.substringAfter(str, ".");
        int nbr = Integer.parseInt(String.valueOf(strE));
        //String nbr=String.valueOf(str.length());

/*   System.out.println(strE);
   System.out.println(str);

   System.out.println("strInt = "+strInt);
   System.out.println("strDouble = "+strDouble);*/

        switch (nbr) {
            case 9:

                if (Integer.parseInt(strInt) == 1 && Integer.parseInt(String.valueOf(strDouble.charAt(0))) < 5) {
                    return getEntier(strInt + "." + strDouble.charAt(0)) + "Md €";
                } else {
                    if (Integer.parseInt(strInt) == 1 && Integer.parseInt(String.valueOf(strDouble.charAt(0))) >= 5) {
                        return getEntier(strInt + "." + (Integer.parseInt(String.valueOf(strDouble.charAt(0))) + 1)) + "Md €";
                    } else {
                        if (Integer.parseInt(strInt) > 1 && Integer.parseInt(String.valueOf(strDouble.charAt(0))) < 5) {
                            return getEntier(strInt + "." + strDouble.charAt(0)) + "Mds €";
                        } else {
                            if (Integer.parseInt(strInt) > 1 && Integer.parseInt(String.valueOf(strDouble.charAt(0))) >= 5) {
                                return getEntier(strInt + "." + (Integer.parseInt(String.valueOf(strDouble.charAt(0))) + 1)) + "Mds €";
                            }
                        }
                    }
                }

            case 8:
                if (Integer.parseInt(String.valueOf(strDouble.charAt(2))) < 5) {
                    return strInt + strDouble.charAt(0) + strDouble.charAt(1) + "M €";
                } else {
                    if (Integer.parseInt(String.valueOf(strDouble.charAt(2))) >= 5) {
                        return strInt + strDouble.charAt(0) + (Integer.parseInt(String.valueOf(strDouble.charAt(1)) )+1) + "M €";
                    }
                }

            case 7:
                if (Integer.parseInt(String.valueOf(strDouble.charAt(0))) < 5) {
                    return strInt + strDouble.charAt(0) + "M €";
                } else {
                    if (Integer.parseInt(String.valueOf(strDouble.charAt(0))) >= 5) {
                        return strInt + (Integer.parseInt(String.valueOf(strDouble.charAt(0))) + 1) + "M €";
                    }
                }

            default:
                throw new IllegalArgumentException("Unknown nbr " + nbr);

        }
    }

    public String getPorcentage(String str) {
        String strDouble = StringUtils.substringAfterLast(str, ".");
        String strInt = StringUtils.substringBeforeLast(str, ".");
        System.out.println("strInt "+strInt);
        System.out.println("strDouble "+strDouble);
        int nbr = Integer.parseInt(String.valueOf(strDouble.charAt(0)));

        System.out.println(nbr);
        if (nbr >= 5) {

            return strInt + "." + (Integer.parseInt(String.valueOf(strDouble.charAt(0))) + 1) + "%";
        } else {
            if (Integer.parseInt(String.valueOf(strDouble.charAt(0)))==0){
                return strInt  + "%";
            }else {
                return strInt + "." + strDouble.charAt(0) + "%";
            }

        }

    }
    public String getEntier(String str){
        String strDouble = StringUtils.substringAfterLast(str, ".").replace("Mds €","").replace("Md €","");
        String strInt=StringUtils.substringBeforeLast(str, ".");

        if(Integer.parseInt(strDouble)==0){
            return strInt;
        }else {
            return strInt+"."+strDouble;
        }
    }

    public void bouc() {
        int j = 0;
        for (int i = -2; i < 12; i++) {
            i++;
            System.out.println("i = " + i);

            j++;
        }
        System.out.println(j);
    }


    public static void main(String[] args) {
        Boucle b = new Boucle();
        // b.b();

        // Collections.sort(list);

        //b.replaceNull().forEach(e-> System.out.println(e.toString()));
        //b.replaceNull().forEach(e-> System.out.println(e.toString()));
        System.out.println(b.getTraitementMntLevee2("3.517E8"));
       // System.out.println(b.getPorcentage("90.0"));
        // b.bouc();


    }

}
