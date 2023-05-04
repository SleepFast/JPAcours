package model;

public enum BookCategory {
    FICTION("Fiction"),
    NONFICTION("Non-Fiction"),
    ADVENTURE("Adventure"),
    SCIENCE("Science"),
    HISTORY("History"),
    FANTASY("Fantasy"),
    ROMANCE("Romance"),
    MYSTERY("Mystery"),
    THRILLER("Thriller"),
    COMMEDY("Comedy");

    private String type;

    private BookCategory(String type){
        this.type = type;
    }

    public String toString(){
        return String.format("Book category: %s", type);
    }
}
