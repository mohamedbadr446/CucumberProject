package CucumberFramwork1.excel;

import CucumberFramwork1.model.Secteur;
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
    private static String detailssudeeptech = "C:\\Users\\mohamine\\Downloads\\detailssudeeptech.csv";
    private static String detailsregions = "C:\\Users\\mohamine\\Downloads\\detailsregions (1).csv";
    private static String chiffresregionsstaging = "C:\\Users\\mohamine\\Downloads\\chiffresregionsstaging.csv";

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
        str =str+"\n";

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
        List map = new ArrayList();
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(json);

        JSONArray array = (JSONArray) obj;

        JSONObject ob;
       // System.out.println(str);


        for (int i = 0; i < array.size(); i++) {
            ob = (JSONObject) array.get(i);
            //Thread.sleep(2);
          if(!(ob.get("address_lng").toString().equals("")) && ob.get("secteur").equals("Mobilité et ville durable")){
                map.add(ob.get("secteur"));
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

    public static Integer getSommeCountMap() throws Exception {
        int somme=getElementsJson2(detailsregions).size()+getElementsJson2(detailssudeeptech).size();
        List detailsregionsList=getElementsJson2(detailsregions);
        List detailssudeeptechList=getElementsJson2(detailssudeeptech);

        System.out.println("la valeur de detailsregions est : "+getElementsJson2(detailsregions).size());
        System.out.println("la valeur de detailssudeeptech est : "+getElementsJson2(detailssudeeptech).size());
        System.out.println("La somme est :: "+somme);
        List<String> differences = (List<String>) detailsregionsList.stream()
                .filter(element -> !detailssudeeptechList.contains(element))
                .collect(Collectors.toList());

        List<String> differences2 = (List<String>) detailssudeeptechList.stream()
                .filter(element -> !detailsregionsList.contains(element))
                .collect(Collectors.toList());


        return differences2.size()+differences.size();
    }

    public static void main(String[] args) throws Exception {

        //getCsvJson(getCsv());
        //System.out.println(getCsvToJsonString());
        //List list=getElementsJson2(detailsregions);

        getElementsJson2(detailssudeeptech).forEach(e -> System.out.println(e.toString()));
        System.out.println(getElementsJson2(detailssudeeptech).size());
       // System.out.println(getElementsJson2(detailsregions));

       // System.out.println("La différence entre les deux list est : "+getSommeCountMap());

    }

}