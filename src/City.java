/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gul
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Country")

public class City {
    @Id
    @Column(name="locId")
    public int locId;
    @Column(name="country")
    public String country;
    @Column(name="lat")
    public double lat;
    @Column(name="lng")
    public double lng;

    public City(){
        
    }
    
    public City(int locId, String country, double lat, double lng){
        this.locId=locId;
        this.country=country;
        this.lat=lat;
        this.lng=lng;
    }
    public void setLocId(int locId) {
        this.locId = locId;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public int getLocId() {
        return locId;
    }

    public String getCountry() {
        return country;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
    
    
}
