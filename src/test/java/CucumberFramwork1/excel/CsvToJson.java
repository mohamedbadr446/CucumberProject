package CucumberFramwork1.excel;

import CucumberFramwork1.model.EtreObs;
import CucumberFramwork1.model.Region;
import CucumberFramwork1.model.Secteur;
import CucumberFramwork1.runner.DateBetwen;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
//import org.codehaus.jackson.map.MappingIterator;
import org.json.CDL;
//import org.json.JSONArray;
//import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.simpleflatmapper.csv.CsvParser;
//import org.simpleflatmapper.csv.CsvReader;
import org.simpleflatmapper.lightningcsv.CsvReader;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

// uses http://simpleflatmapper.org/0101-getting-started-csv.html for csv parser
// and jackson-core for JsonGenerator
// alternative to https://dzone.com/articles/how-to-convert-csv-to-json-in-java
// stream csv as we read it
// see https://gist.github.com/arnaudroger/cf7806de83766b51dbfe84a1fab559b0 for reduce garbage version
public class CsvToJson {

    private static String json;
    String fileName2 = "C:\\Users\\mohamine\\eclipse-workspace\\CucumberFramwork1\\excel\\pagessectorielles.csv";
    private static String detailssudeeptech = "C:\\Users\\mohamine\\Downloads\\detailssudeeptech.txt";
    private static String detailsregions = "C:\\Users\\mohamine\\Downloads\\detailsregions (1).csv";
    private static String chiffresregionsstaging = "C:\\Users\\mohamine\\Downloads\\chiffresregionsstaging.csv";
    private static String detailsregionsstaging = "C:\\Users\\mohamine\\Downloads\\detailsregionsstaging.csv";
    private static String defaultfileCsv="src/test/resources/FileCsvGene/fileCsv.csv";

    public static void getCsvJson(String str) throws IOException {
        CsvReader reader = CsvParser.reader(str);

        JsonFactory jsonFactory = new JsonFactory();

        Iterator<String[]> iterator = reader.iterator();
        String[] headers = iterator.next();
        String strr = "";


        try (StringWriter sw = new StringWriter();
             JsonGenerator jsonGenerator = jsonFactory.createGenerator(sw)) {
            jsonGenerator.useDefaultPrettyPrinter();
            // JsonGenerator jsonGenerator = jsonFactory.createGenerator(CharStreams.asWriter(json));
            // jsonGenerator.writeStartArray();

            while (iterator.hasNext()) {
                jsonGenerator.writeStartObject();
                String[] values = iterator.next();
                int nbCells = Math.min(values.length, headers.length);
                for (int i = 0; i < nbCells; i++) {
                    jsonGenerator.writeFieldName(headers[i]);
                    jsonGenerator.writeString(values[i]);

                }

                jsonGenerator.writeEndObject();

            }
            //jsonGenerator.writeEndArray();
            System.out.println("=>" + sw.getBuffer().toString());

        }

    }


    public static String getCsv(String fileName) {

        List<String> list = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

            //br returns as stream and convert it into a List
            list = br.lines().collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        // list.forEach(System.out::println);
        String str = String.join("\n", list);
        str = str.replace(",", ";");
        str = str.replace("|", ",");
        str = str + "\n";

        //System.out.println(str);
        //System.out.println(list.size());

        return str;
    }

    public static String getCsvToJsonString(String fileName) {


        String csv = getCsv(fileName);

        //String csv="902412337,0,,,Gensor développe des tests de dépistage de virus plus simples  plus rapides et plus précis basés sur la technologie des transistors à effet de champ génétiques.,Biotech,Paris,Île-de-France,75011,28 RUE MERLIN; 75011 PARIS; FRANCE,2.3795,48.8574,,2021,0";

        String json = CDL.toJSONArray(csv).toString(2);

        return json;
    }


    public static List getElementsJson2(String fileName) throws Exception {

        json = getCsvToJsonString(fileName);
        List<String> map = new ArrayList();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(json);

        JSONArray array = (JSONArray) obj;

        JSONObject ob;
        // System.out.println(str);


        List<String> deduped = null;
        for (int i = 0; i < array.size(); i++) {
            ob = (JSONObject) array.get(i);
            //Thread.sleep(2);
            if (!(ob.get("address_lng").toString().equals("") || ob.get("address_lat").toString().equals("")) && ob.get("secteur").equals("Biotech")) {
                map.add((String) ob.get("siren"));
                //System.out.println("i est : "+i);
            }

            deduped = map.stream().distinct().collect(Collectors.toList());

        /*   if (ob.get("companies_name").equals("CarbonWorks") && Double.parseDouble((String) ob.get("companies_total_funding")) >=5) {
                map.add(ob.get("companies_website_url"));
                map.add(ob.get("secteur"));

            }*/
        /*    if (ob.get("dr").equals("Paris")) {
                map.add(ob.get("Mnt_levee"));
            }*/

        }
        //System.out.println("array.size() = "+array.size());
        return deduped;
    }

    public static List getEtreObsAnnee(String fileName, String secteur, String name) throws Exception {

        json = getCsvToJsonString(fileName);
        List map = new ArrayList();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(json);

        JSONArray array = (JSONArray) obj;

        JSONObject ob;
        // System.out.println(str);
        EtreObs etreObs;

        for (int i = 0; i < array.size(); i++) {
            ob = (JSONObject) array.get(i);
            //Thread.sleep(2);
            if (ob.get("companies_name").toString().equals(name) && ob.get("secteur").toString().equals(secteur) && DateBetwen.getBeetwenYears(ob.get("date_de_creation").toString())) {
                etreObs = new EtreObs();
                etreObs.setAnneeCreation((String) ob.get("date_de_creation"));
                etreObs.setSecteur((String) ob.get("secteur"));
                etreObs.setLogo((String) ob.get("logo"));
                etreObs.setNom((String) ob.get("companies_name"));
                map.add(etreObs);
                //System.out.println("i est : "+i);
            }

        /*   if (ob.get("companies_name").equals("CarbonWorks") && Double.parseDouble((String) ob.get("companies_total_funding")) >=5) {
                map.add(ob.get("companies_website_url"));
                map.add(ob.get("secteur"));

            }*/
        /*    if (ob.get("dr").equals("Paris")) {
                map.add(ob.get("Mnt_levee"));
            }*/

        }
        //System.out.println("array.size() = "+array.size());
        return map;
    }

    public static EtreObs getEtreObsChiffre(String fileName, String secteur, String name) throws Exception {

        json = getCsvToJsonString(fileName);
        List map = new ArrayList();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(json);

        JSONArray array = (JSONArray) obj;

        JSONObject ob;
        // System.out.println(str);
        EtreObs etreObs = new EtreObs();

        for (int i = 0; i < array.size(); i++) {
            ob = (JSONObject) array.get(i);
            //Thread.sleep(2);
            if (ob.get("companies_name").toString().equals(name) && ob.get("secteur").toString().equals(secteur) && Double.parseDouble(ob.get("companies_total_funding").toString()) > 5) {
                etreObs.setAnneeCreation((String) ob.get("date_de_creation"));
                etreObs.setSecteur((String) ob.get("secteur"));
                etreObs.setLogo((String) ob.get("logo"));
                etreObs.setNom((String) ob.get("companies_name"));
                etreObs.setUrl((String) ob.get("companies_website_url"));
                etreObs.setChiffreAffaire((String) ob.get("companies_total_funding"));
            }

        }
        //System.out.println("array.size() = "+array.size());
        return etreObs;
    }

    public static String getNomRegion(String region) {
        String str="";
        List<String> listRegion = new ArrayList();
        listRegion.add("Bourgogne-Franche-Comté");
        listRegion.add("Bretagne");
        listRegion.add("Centre-Val de Loire");
        listRegion.add("Normandie");
        listRegion.add("Hauts-de-France");
        listRegion.add("Pays de la Loire");
        listRegion.add("Provence-Alpes-Côte d'Azur");
        listRegion.add("Clermont-Ferrand");
        listRegion.add("Grenoble");
        listRegion.add("Lyon");
        listRegion.add("Nancy");
        listRegion.add("Reims");
        listRegion.add("Strasbourg");
        for (int i=0;i<listRegion.size();i++){
            if (listRegion.get(i).equals(region.trim())){

              str=listRegion.get(i);
            }
        }

        return str;
    }

    public static List getSecteurJson(String fileName) throws Exception {


        json = getCsvToJsonString(fileName);
        List<Secteur> map = new ArrayList();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(json);

        JSONArray array = (JSONArray) obj;

        JSONObject ob;
        Secteur secteur;

        for (int i = 0; i < array.size(); i++) {
            secteur = new Secteur();
            ob = (JSONObject) array.get(i);
            if (ob.get("secteur").toString().equals("Cybersécuritée")) {
                secteur.setSecteur((String) ob.get("secteur"));
                secteur.setNb_SU((String) ob.get("nb_SU"));
                secteur.setNb_Emploi((String) ob.get("nb_emploi"));
                secteur.setMnt_Levee((String) ob.get("Mnt_levee"));
                secteur.setPourcentage_SU((String) ob.get("pourcentage_su"));
                secteur.setPourcentage_Emploi((String) ob.get("pourcentage_emploi"));
                secteur.setPourcentage_Montant((String) ob.get("pourcentage_montant"));

                map.add(secteur);
            }


        }
        return map;
    }

    public static List getRegionJson(String fileName, String directionRegional) throws Exception {


        json = getCsvToJsonString(fileName);
        List<Region> map = new ArrayList();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(json);

        JSONArray array = (JSONArray) obj;

        JSONObject ob;
        Region region;

        for (int i = 0; i < array.size(); i++) {
            region = new Region();
            ob = (JSONObject) array.get(i);
            if (ob.get("dr").toString().equals(directionRegional)) {
                region.setDr((String) ob.get("dr"));
                region.setRegion((String) ob.get("region"));
                region.setNb_SU((String) ob.get("nb_SU"));
                region.setMnt_Levee((String) ob.get("Mnt_levee"));
                region.setPorcentage_SU((String) ob.get("pourcentage_su"));
                region.setPourcentage_Montant((String) ob.get("pourcentage_montant"));
                region.setNb_Emploi((String) ob.get("nb_emploi"));
                region.setPourcentage_emploi((String) ob.get("pourcentage_emploi"));

                map.add(region);
            }


        }
        return map;
    }


    public static Integer getSommeCountMap() throws Exception {
        int somme = getElementsJson2(detailsregions).size() + getElementsJson2(detailssudeeptech).size();
        List detailsregionsList = getElementsJson2(detailsregions);
        List detailssudeeptechList = getElementsJson2(detailssudeeptech);

        System.out.println("la valeur de detailsregions est : " + getElementsJson2(detailsregions).size());
        System.out.println("la valeur de detailssudeeptech est : " + getElementsJson2(detailssudeeptech).size());
        System.out.println("La somme est :: " + somme);
        List<String> differences = (List<String>) detailsregionsList.stream()
                .filter(element -> !detailssudeeptechList.contains(element))
                .collect(Collectors.toList());

        List<String> differences2 = (List<String>) detailssudeeptechList.stream()
                .filter(element -> !detailsregionsList.contains(element))
                .collect(Collectors.toList());


        return differences2.size() + differences.size();
    }

    public static double getSommeNb_Su(String fileName, String dr) throws Exception {
        json = getCsvToJsonString(fileName);
        List map = new ArrayList();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(json);

        JSONArray array = (JSONArray) obj;

        JSONObject ob;
        double somme = 0;

        for (int i = 0; i < array.size(); i++) {
            ob = (JSONObject) array.get(i);

            if (ob.get("dr").toString().trim().contains(dr.trim())) {
                somme = somme + Double.parseDouble(ob.get("nb_SU").toString());
            }

        }

        return somme;
    }

    public static double getSommeMnt_levee(String fileName, String dr) throws Exception {
        json = getCsvToJsonString(fileName);
        List map = new ArrayList();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(json);

        JSONArray array = (JSONArray) obj;

        JSONObject ob;
        double somme = 0;

        for (int i = 0; i < array.size(); i++) {
            ob = (JSONObject) array.get(i);
            //Thread.sleep(2);
            if (ob.get("region").toString().trim().contains(dr.trim())) {
                somme = somme + Double.parseDouble(ob.get("Mnt_levee").toString());
            }

        }
        //System.out.println("array.size() = "+array.size());
        return somme;
    }

    public static double getpourcentageSu(String fileName, String region) throws Exception {
        json = getCsvToJsonString(fileName);
        List map = new ArrayList();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(json);

        JSONArray array = (JSONArray) obj;

        JSONObject ob;
        List listNb_SU = new ArrayList();
        List listPourcentage_SU = new ArrayList();

        for (int i = 0; i < array.size(); i++) {
            ob = (JSONObject) array.get(i);
            //Thread.sleep(2);
            if (ob.get("region").toString().trim().contains(region.trim())) {
                listPourcentage_SU.add(Double.parseDouble(ob.get("pourcentage_su").toString().trim()) * Double.parseDouble(ob.get("nb_SU").toString().trim()));
                listNb_SU.add(Double.parseDouble(ob.get("nb_SU").toString()));
            }

        }
        //System.out.println("array.size() = "+array.size());
        double sumNb_SU = listNb_SU.stream().mapToDouble(a -> (double) a).sum();
        double sumPourcentage_SU = listPourcentage_SU.stream().mapToDouble(a -> (double) a).sum();
        return sumPourcentage_SU / sumNb_SU;
    }
    public static List getElementJsonList(String url, String elment) throws Exception {
        String str = getCsvToJsonString(url);
        //System.out.println(str);

        List result = new ArrayList();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(str);

        JSONArray array = (JSONArray) obj;

        JSONObject ob;
        for (int i = 0; i < array.size(); i++) {
            ob = (JSONObject) array.get(i);

            // result.add(array.get(i));
            result.add(ob.get(elment));
            //map.put(ob.get("date_publication"), ob.get("id"));

        }
        return result;
    }

    public static List getElementJsonString(String json, String elment) throws Exception {
        String str = json;
        //System.out.println(str);

        List result = new ArrayList();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(str);

        JSONArray array = (JSONArray) obj;

        JSONObject ob;
        for (int i = 0; i < array.size(); i++) {
            ob = (JSONObject) array.get(i);

            // result.add(array.get(i));
            result.add(ob.get(elment));
            //map.put(ob.get("date_publication"), ob.get("id"));

        }
        return result;
    }
    public static void main(String[] args) throws Exception {

        //getCsvJson(getCsv("C:\\Users\\mohamine\\Desktop\\BPI\\dashboard (11).csv"));
       // System.out.println(getElementJsonList("C:\\Users\\mohamine\\Desktop\\BPI\\dashboard (11).csv","list_des_su").get(0));
        //System.out.println(getElementJsonList("C:\\Users\\mohamine\\Desktop\\BPI\\dashboard (11).csv","list_des_su").get(0).toString().replace(";",","));
        System.out.println(getElementJsonString(getElementJsonList("C:\\Users\\mohamine\\Desktop\\BPI\\dashboard11 (2).csv","list_des_su").get(5).toString().replace(";",","),"siren").size());

        //List list=getElementsJson2(detailsregions);

        //getElementsJson2(detailssudeeptech).forEach(e -> System.out.println(e.toString()));
     //s   System.out.println(getElementsJson2(detailssudeeptech).size());
       // System.out.println(getElementsJson2(detailssudeeptech));
      //  System.out.println(getSommeMnt_levee(chiffresregionsstaging, "Bretagne"));
       // System.out.println(getpourcentageSu(chiffresregionsstaging, "Normandie"));
        // System.out.println(getEtreObsChiffre(detailsregionsstaging,"Medtech","FineHeart"));
        // getEtreObsAnnee(detailsregionsstaging,"IA et Software","ADAXIS SAS").forEach(e-> System.out.println(e.toString()));
        // getRegionJson(chiffresregionsstaging,"Bordeaux").forEach(e-> System.out.println(e.toString()));
        // System.out.println("La différence entre les deux list est : "+getSommeCountMap());
        //System.out.println("Region est =>"+getNomRegion("Lyon"));

    }

}