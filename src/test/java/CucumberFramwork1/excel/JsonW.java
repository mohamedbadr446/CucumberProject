package CucumberFramwork1.excel;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.IOException;
import java.util.List;
import java.util.Map;
public class JsonW {
    public static void main(String[] args) {
        // Comma delimited text created using text blocks
       // String countries = CsvToJson.getCsv();
        String countries=null;
        CsvSchema csvSchema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();

        try {
            List<Map<?, ?>> list;
            try (MappingIterator<Map<?, ?>> mappingIterator = csvMapper.reader()
                    .forType(Map.class)
                    .with(csvSchema)
                    .readValues(countries)) {
                list = mappingIterator.readAll();
            }

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonPretty = objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValueAsString(list);
            System.out.println(jsonPretty);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

