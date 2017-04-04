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


import javax.transaction.*;
import org.hibernate.Transaction;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.hibernate.cfg.*;
import java.util.*;

public class CatalogueAdder {
    
    
    private void readFile(String resourceLocation){
    
    
        String csvFile = resourceLocation;
        String line = "";
        String cvsSplitBy = ",";
        int counter=1;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            br.readLine();
            br.readLine();
            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                //printing progress after every 1000 cities have been uploaded
                if(counter==(1000*counter)){
                    System.out.println(String.valueOf(counter*1000)+" cities added");
                    counter++;    
                }
                
                City count= new City(Integer.parseInt(country[0]),
                country[1],Double.parseDouble(country[5]),Double.parseDouble(country[6]));
                //adding countries to the database.
                addCity(count);
               
               
               
              

            }
           
            NewHibernateUtil.SessionClose();

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
      
       

    }
    public void startProgram(){
    
        String resource="/home/gul/NetBeansProjects/SoftwareConstruction Lab05/src/GeoLiteCity-Location.csv";
        readFile(resource);        
    }
    
    private void addCity(City country){
         
        Session sess= null;
        try{
         sess = NewHibernateUtil.currentSession();
         Transaction tx = sess.beginTransaction();
         sess.save(country);
         tx.commit();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
    

