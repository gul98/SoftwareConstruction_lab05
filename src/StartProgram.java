
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gul
 */
public class StartProgram {
    
    
    public void SearchByLocId(int locId){
          Session sess= null;
         City city= new City();
        try{
         sess = NewHibernateUtil.currentSession();
         Transaction tx = sess.beginTransaction();
         //sql statement to select all the rows
         String hql= "select * FROM Country";
         Query query= sess.createSQLQuery(hql).addEntity(City.class);
         
         List results= query.list();
         if(results.size()>0){
             CatalogueAdder adder= new CatalogueAdder();
             //start reading from csv and adding data into MYSQL
             adder.startProgram();
              CitySearch instance= new CitySearch();
             instance.findCityByLocId(locId);
         }
         else{
             CitySearch instance= new CitySearch();
             instance.findCityByLocId(locId);
         }
         tx.commit();
         
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    } 
    public void SearchNearestCities(double lat, double lng){
    
         Session sess= null;
         City city= new City();
        try{
         sess = NewHibernateUtil.currentSession();
         Transaction tx = sess.beginTransaction();
         //sql statement to select all the rows
         String hql= "select * FROM Country";
         Query query= sess.createSQLQuery(hql).addEntity(City.class);
         
         List results= query.list();
         if(results.size()>0){
             CatalogueAdder adder= new CatalogueAdder();
             //start reading from csv and adding data into MYSQL
             adder.startProgram();
             CitySearch instance= new CitySearch();
             instance.SearchNearestCities(lat, lng);
         }
         else{
             CitySearch instance= new CitySearch();
             instance.SearchNearestCities(lat, lng);
         }
         tx.commit();
         
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
