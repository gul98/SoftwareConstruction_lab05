/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gul
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CatalogueAdder {
    
    
    public void readFile(String resourceLocation){
    
    
        String csvFile = resourceLocation;
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            br.readLine();
            br.readLine();
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                //System.out.println(country[2]);
                System.out.println("Country [loc= " + country[0] + " , name=" + country[1] + 
                        "Latitude= "+country[5]+"Longitude= "+country[6]+"]");

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void startProgram(){
    
        String resource="/home/gul/NetBeansProjects/SoftwareConstruction Lab05/src/GeoLiteCity-Location.csv";
        readFile(resource);
        
    }
}
    

