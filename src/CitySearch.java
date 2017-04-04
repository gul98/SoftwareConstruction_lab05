
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
public class CitySearch {
    
    
    public City[] SearchNearestCities(double lat, double lng){
        
        City[] cities= new City[5];
         Session sess= null;
        try{
         sess = NewHibernateUtil.currentSession();
         Transaction tx = sess.beginTransaction();
         //sql query to order the cities by the hypoteneus distance between given lat and lng
         // and then select the nearest 5 cities by using limit query
         String hql= "SELECT * FROM `Country`\n" +
"\n" +
"ORDER BY (SQRT(POWER((lat-"+String.valueOf(lat)+"),2)+"
                 + "POWER((lng-"+String.valueOf(lng)+"),2))) \n" +
"          limit 5;";
         Query query= sess.createSQLQuery(hql).addEntity(City.class);
         
         List results= query.list();
         System.out.println(String.valueOf(results.size()));
         cities= new City[5];
         for(int i = 0 ; i < results.size(); i++){
             //adding results into the array to be returned
             cities[i]=((City)results.get(i));
             System.out.println(((City)results.get(i)).country);
         }
         
         tx.commit();
        // sess.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return cities;
       
    
        
    }
    
    public City findCityByLocId(int locId){
         Session sess= null;
         City city= new City();
        try{
         sess = NewHibernateUtil.currentSession();
         Transaction tx = sess.beginTransaction();
        //sql query to find the row corresponding to location id
         String hql= "select * FROM Country WHERE locId="+String.valueOf(locId);
         Query query= sess.createSQLQuery(hql).addEntity(City.class);
         
         List results= query.list();
         System.out.println(String.valueOf(results.size()));
         for(int i = 0 ; i < results.size(); i++){
             city=((City)results.get(i));
             System.out.println(((City)results.get(i)).country);
         }
         
         tx.commit();
         //sess.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
       return city;
    }
    
}
