/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gul
 */
public class City {
    public int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getId() {
        return id;
    }

    public String getCountryName() {
        return countryName;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
    public String countryName;
    public double lat;
    public double lng;
    
    public City(){}
    public City(int id , String countryName, double lat, double lng){
        this.id=id;
        this.countryName=countryName;
        this.lat=lat;
        this.lng=lng;
    }
    
}
