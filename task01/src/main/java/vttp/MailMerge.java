package vttp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MailMerge 
{
    public static void main(String[] args) {
    
    
        String csv = "";
        String txt = "";

        

        for (int i = 0; i < args.length; i++) {
            if (args[i].endsWith(".csv")) {
                csv = args[i];
                System.out.println("CSV file " + csv + " loaded");
            }
        }

        for (int i = 0; i < args.length; i++) {
            if (args[i].endsWith(".txt")){
                txt = args[i];
                System.out.println("Template file " + txt + " loaded");
            }
        }

        Path readme = Paths.get("src\\main\\java\\vttp\\", csv);
        // String csvDataFile = "data\\thankyou.csv";
        File formatFile = new File("data", txt);


        List<Contacts> contacts = readContactsfromCSV(readme);
        for (Contacts contacts2 : contacts) {
            System.out.println(contacts2);
        }

        // try (BufferedReader br = new BufferedReader(new FileReader("test.txt"))) {
        //     try (BufferedWriter bw = new BufferedWriter(new FileWriter("Copied.txt"))) {
        //         String text = null;
        //         while ((text = br.readLine()) != null) {
        //             System.out.println(text);
        //             bw.write(text);
        //             bw.newLine();
        //         }
        //     }
        // } catch (FileNotFoundException e) {
        //     System.out.println("Error: " + e.getMessage());
        // } catch (IOException e) {
        //     System.out.println("Error: " + e.getMessage());
        // }


    }

    private static List<Contacts> readContactsfromCSV(Path path) {
        List<Contacts> contacts = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(path)) {

            String line = br.readLine();

            while (line != null) {
                String[] attributes = line.split(",");
 
                Contacts contact = createContact(attributes);

     
                contacts.add(contact);

 
                line = br.readLine();


                }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return contacts;
    }

    private static Contacts createContact(String[] data) {
        String first_name = data[0];
        String last_name = data[1];
        String address = data[2];
        int years = Integer.parseInt(data[3]);

        return new Contacts(first_name, last_name, address, years);
    }


}
