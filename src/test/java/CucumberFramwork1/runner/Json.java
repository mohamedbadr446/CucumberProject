package CucumberFramwork1.runner;

import com.google.gson.JsonElement;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import static gherkin.util.FixJava.readStream;

public class Json {
    public static void main(String args[])
    {
        // Create a HashMap object ob
        HashMap<Integer, String> ob=new HashMap<Integer, String>();
        //addding keys and values
        ob.put(23, "Vedant");
        ob.put(7, "Aryan");
        ob.put(17, "Tarun");
        ob.put(9, "Farhan");
        Iterator<Integer> it = ob.keySet().iterator();
        System.out.println("Before Sorting");
        while(it.hasNext())
        {
            int key=(int)it.next();
            System.out.println("Roll number:  "+key+"     name:   "+ob.get(key));
        }
        System.out.println("\n");
        Map<Integer, String> map=new HashMap<Integer, String>();
        System.out.println("After Sorting");
        //using the TreeMap constructor in order to sort the HashMap
        TreeMap<Integer,String> tm=new  TreeMap<Integer,String> (ob);
        Iterator itr=tm.keySet().iterator();
        while(itr.hasNext())
        {
            int key=(int)itr.next();
            System.out.println("Roll no:  "+key+"     name:   "+ob.get(key));
        }
    }

}


