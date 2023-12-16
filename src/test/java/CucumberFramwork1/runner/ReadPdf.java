package CucumberFramwork1.runner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;

public class ReadPdf {


    private static String readFile(String url) throws Exception {

        File file = new File(url);

        PDDocument document = PDDocument.load(file);

        //Instantiate PDFTextStripper class
        PDFTextStripper pdfStripper = new PDFTextStripper();

        //Retrieving text from PDF document
        String text = pdfStripper.getText(document);

        //Closing the document
        document.close();
        return text;

    }

    public static boolean containsElement(String url, String element) throws Exception {

        String str[] = readFile(url).split("\n");
        boolean bool = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i].toString().trim().equals(element)) {

                bool = true;
                break;

            }

        }
        return bool;

    }

    public static void main(String[] args) throws Exception {
        System.out.println(containsElement("C:\\Users\\mohamine\\Documents\\Amine_Mohamed_Badr.pdf","Ingénieur Test"));
    }
}
