package executable;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import model.Adress2;
import model.Book;
import model.BookCategory;
import model.CD;
import model.Customer;
import model.OrderLine;
import model.PurchaseOrder;

public class JPAMain {

	public static void main(String[] args) {

		EntityManager em = JPAUtils.getInstance().getEntityManager();
		
		Book livre = new Book();
		livre.setTitle("PATATE");
		livre.setDescription("hihi");
		livre.setPrice(25F);
		livre.setIllustrations(Boolean.TRUE);
		livre.setNbOfPages(200);
		livre.setCategory(BookCategory.ADVENTURE);

		livre.getTags().add("Bouhouhouhou");
        livre.getTags().add("Oink oink");
        livre.getTags().add("null");
        livre.getTags().remove("null");

////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////
		
		// Customer customer = new Customer("A", "B");
        // Adress adress = new Adress();
        // adress.setStreetName("rue abc");
        // adress.setCity("Paris");
        // adress.setStreetNumber(15);
        // customer.setAdress(adress);
        // customer.setAdress(new Adress(12, "rue abc", "MTP"));

        Customer customer = new Customer("A", "B");
        Adress2 adr2 = new Adress2();
        adr2.setStreetName("rue abc");
        adr2.setCity("Paris");
        adr2.setStreetNumber(15);
        adr2.setZipCode(91000);
        customer.setAdress2(adr2);

        Customer customer2 = new Customer("pouet", "pat");
        Adress2 adr3 = new Adress2();
        adr3.setStreetName("rue abc");
        adr3.setCity("pit");
        adr3.setStreetNumber(15);
        adr3.setZipCode(35000);
        customer2.setAdress2(adr3);

        Customer customer3 = new Customer("tata", "toto");
        Adress2 adr4 = new Adress2();
        adr4.setStreetName("rue abc");
        adr4.setCity("pat");
        adr4.setStreetNumber(15);
        adr4.setZipCode(45000);
        customer3.setAdress2(adr4);

////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////

        OrderLine l1 = new OrderLine();
        l1.setPrice(100d);
        l1.setQuantity(10);
        l1.setDescription("Desc1");
        PurchaseOrder order = new PurchaseOrder();
        order.setAmount(50);
        order.getOrderLines().add(l1);

////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////

		CD c = new CD();
        c.setTitle("This is a good title for a CD");
        c.getTitle();
        c.setDescription("This is a good CD");
        c.setPrice(12f);
        c.getTracks().put(1, "première musique");
        c.getTracks().put(2, "deuxième musique");
        c.getTracks().put(3, "troisième musique");

        // order.setAmount(50);
        // order.setDate(new Date(01, 10, 1995));
        // OrderLine line1 = new OrderLine();
        // line1.setPrice(100d);
        // line1.setQuantity(10);
        // line1.setDescription("Desc1");
        // order.getOrderLines().add(line1);
        // order.getOrderLines().add(new OrderLine( 30, 300, "Description 2"));
        // order.getOrderLines().add(new OrderLine(70, 700, "Description 3"));		

////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////

		em.getTransaction().begin();
		em.persist(livre);
		em.persist(customer);
		em.persist(adr2);
		em.persist(customer2);
		em.persist(adr3);
		em.persist(customer3);
		em.persist(adr4);
		em.persist(l1);
		em.persist(order);
		em.persist(c);
		em.getTransaction().commit();

		TypedQuery <Customer> typedQuery = em.createQuery("SELECT a FROM Customer a WHERE a.address2.city='pat'", Customer.class);
		List<Customer> listCustomers = typedQuery.getResultList();
		
		for(Customer client : listCustomers) {
			System.out.println(client.getFirstName() + " " + client.getName());
		}

		// TypedQuery<Customer> namedQuery = em.createNamedQuery("Customer.findByCity", Customer.class);
		// namedQuery.setParameter("city", "pat");
		// List<Customer> listCustomers2 = typedQuery.getResultList();

		// for(Customer client : listCustomers2) {
		// 	System.out.println(client.getFirstName() + " " + client.getName());
		// }

		TypedQuery<Customer> namedQuery = em.createNamedQuery("Customer.findByZipcode", Customer.class);
		namedQuery.setParameter("zipCode", 35000);
		List<Customer> listCustomers2 = typedQuery.getResultList();

		for(Customer client : listCustomers2) {
			System.out.println(client.getFirstName() + " " + client.getName());
		}

		// Book livre2 = em.find(Book.class, 4);

		// if (livre2 == null) {
		// 	System.out.println("ppouet");
		// }

		// livre2 = em.find(Book.class, 1);

		// if (livre2 != null) {
		// 	System.out.println(livre2);
		// }

		em.close();
	}

}
