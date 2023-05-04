package model;


import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;

@Entity
public class CD extends Item{
    private String isbn;
    @ElementCollection
    private Map<Integer, String> tracks = new HashMap<>();

    public Map<Integer, String> getTracks(){
        return tracks;
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
