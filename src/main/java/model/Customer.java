package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;

@Entity
@NamedQueries({
    @NamedQuery(name = "Customer.findByCity", query = "SELECT c FROM Customer c WHERE c.address2.city = :city"),
    @NamedQuery(name = "Customer.findByZipcode", query = "SELECT c FROM Customer c WHERE c.address2.zipCode = :zipCode")
})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String firstName;
    // private PurchaseOrder order;

    // @Embedded
    // private Adress address;

    @OneToOne
    private Adress2 address2;

    public Customer(String name, String firstName){
        this.name = name;
        this.firstName = firstName;

        //this.address = new Adress(12, "rue abc", "MTP");
    
    }

    public String getFirstName() {
        return firstName;
    }

    public String getName() {
        return name;
    }

    // public void setAdress(Adress address) {
    //     this.address = address;
    // }
    
    public void setAdress2(Adress2 address) {
        this.address2 = address;
    }
}