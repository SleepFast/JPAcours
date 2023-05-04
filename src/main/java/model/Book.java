package model;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Book extends Item{

    private String isbn;
    private Integer nbOfPages;
    private Boolean illustrations;
    private Instant instant = Instant.now();
    @Enumerated(EnumType.STRING)
    private BookCategory category;
    @ElementCollection
    private List<String> tags = new ArrayList<>();
    
    public BookCategory getCategory() {
        return category;
    }
    public void setCategory(BookCategory category) {
        this.category = category;
    }
    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public Integer getNbOfPages() {
        return nbOfPages;
    }
    public void setNbOfPages(Integer nbOfPages) {
        this.nbOfPages = nbOfPages;
    }
    public Instant getInstant() {
        return instant;
    }
    public void setInstant(Instant instant) {
        this.instant = instant;
    }
    public Boolean getIllustrations() {
        return illustrations;
    }
    public void setIllustrations(Boolean illustrations) {
        this.illustrations = illustrations;
    }
}
