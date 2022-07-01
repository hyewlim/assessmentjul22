package vttp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MailMerge 
{
    public static void main(String[] args) {
        
        String csv = "";
        String txt = "";  

        for (int i = 0; i < args.length; i++) {
            if (args[i].endsWith(".csv")) {
                csv = "data\\" + args[i];
                System.out.println("Finding csv file " + csv + " ...");
            }
        }

        for (int i = 0; i < args.length; i++) {
            if (args[i].endsWith(".txt")){
                txt = "data\\" + args[i];
                System.out.println("Finding template file " + txt + " ...");
            }
        }

       
       String delimiter = ",";
       String line;
       //read csv
       List<List<String>> list = new ArrayList();
        try (BufferedReader br =
                     new BufferedReader(new FileReader(csv))) {
            while((line = br.readLine()) != null){
                List<String> values = Arrays.asList(line.split(delimiter));
                list.add(values);
            }

        } catch (FileNotFoundException e){
            System.err.println("File not found: " + e.getMessage());
        }
        //csv header
        List<String> header = list.get(0);
        System.out.println( header.get(0));



       //read txt
       String newLine;
       String totalStr = "";
       
        try (BufferedReader brs = new BufferedReader(new FileReader(txt))) {
            while((newLine = brs.readLine()) != null){
                for (int i = 0; i < header.size(); i++) {
                    if (newLine.contains(header.get(i))) {
                        for (int j = 1; j < list.size(); j++) {
                            newLine = newLine.replaceAll(header.get(i), list.get(j));
                        }
                    }
                }
            }

            totalStr = totalStr.replace("first_name", "replacement");
            FileWriter fw = new FileWriter(new File(txt));
            fw.write(totalStr);
            fw.close();

        } catch (FileNotFoundException e){
            System.err.println("File not found: " + e.getMessage());
        }
    }
        

    private static Contacts createContact(String[] data) {
        String first_name = data[0];
        String last_name = data[1];
        String address = data[2];
        int years = Integer.parseInt(data[3]);

        return new Contacts(first_name, last_name, address, years);
    }

    }






