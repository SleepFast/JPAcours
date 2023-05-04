package model; 

import jakarta.persistence.Embeddable;

@Embeddable 
public class Adress {
    private int streetNumber;
    private String streetName;
    private String city;

    public Adress() {
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }
    
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    @Override
    public String toString() {
        return "Adress [streetNumber=" + streetNumber + ", streetName=" + streetName + ", city=" + city + "]";
    }
}
