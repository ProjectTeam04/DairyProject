package com.project.dairyproject;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.project.dairyproject.Entities.AddressDetails;
import com.project.dairyproject.Entities.ConsumerDetails;
import com.project.dairyproject.Entities.ConsumerQuery;
import com.project.dairyproject.Entities.ProductDetails;
import com.project.dairyproject.Entities.SellerDetails;
import com.project.dairyproject.Entities.SellerQuery;
import com.project.dairyproject.LoginEntities.ChangePassword;
import com.project.dairyproject.Repository.AddressRepository;
import com.project.dairyproject.Repository.ConsumerRepository;
import com.project.dairyproject.Repository.ProductRepository;
import com.project.dairyproject.Repository.SellerRepository;
import com.project.dairyproject.Services.ConsumerServices;
import com.project.dairyproject.Services.ProductServices;
import com.project.dairyproject.Services.QueryServices;
import com.project.dairyproject.Services.SellerServices;

@SpringBootTest
class DairyMilkServicesApplicationTests {
	
	@Autowired 
	private SellerRepository sellRepo;
	

	@Autowired 
	private ProductRepository prodRepo;
	

	@Autowired 
	private AddressRepository addRpeo;
	
	@Autowired 
	private ConsumerRepository conRepo;
	
	
	@Autowired
	private ConsumerServices conServe;
	

	@Autowired 
	private SellerServices sellServe;
	
	@Autowired
	private QueryServices queryServ;
	 
	@Autowired
	private SellerDetails sellDetails;
	
	@Autowired
	private ProductServices proServe;
	

	// Seller Test Cases
	/* ****************************************************************** */
	@Test
	void addSeller() {
		
		SellerDetails seller = new SellerDetails();
		AddressDetails address = new AddressDetails();
		
		seller.setFirstName("Rohit");
		seller.setLastName("Kumbhar");
		seller.setGender("Male");
		seller.setAge(25);
		seller.setEmailId("RhitK@gmail.com");
		seller.setPhoneNumber("9856235458");
		seller.setStreet("Vijapur Road");
		seller.setUsername("RohitK123");
		seller.setPassword("Rhit1234");
		
		address.setDistrict("solapur");
		address.setTown("solapur");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPincode("562288");
		
		seller.setAddress(address);
		
		sellServe.registerNewSeller(seller);
		

	}
	
	@Test
    public void updateSeller(){
        SellerDetails seller = new SellerDetails();
        AddressDetails address = new AddressDetails();
        
        seller.setEmailId("RhitK@gmail.com");
        seller.setPassword("Rhit1234");
        seller.setFirstName("Rohit");
		seller.setLastName("Kumbhar");
		seller.setPhoneNumber("9856235458");
		seller.setStreet("Shivaji Road");
		seller.setUsername("RohitK1234");
		
		address.setPincode("562288");
		seller.setAddress(address);
        
        SellerDetails update_seller = sellServe.updateSellerDetails(seller);
        
        // then - verify the output
        assertThat(update_seller.getUsername()).isEqualTo("RohitK1234");
        assertThat(update_seller.getStreet()).isEqualTo("Shivaji Road");
        
    }
	
	@Test
    public void ChangeSellerPassword(){
		 SellerDetails seller = new SellerDetails();
        ChangePassword cp = new ChangePassword();
        
        
        cp.setEmailId("kubarabde@gmail.com");
        cp.setOldPassword("Kumar1234");
        cp.setNewPassword("Kumar123456");
        cp.setConfirmPassword("Kumar123456");

        sellServe.changeSellerPassword(cp);
          
         seller = sellRepo.findSellerDetailsByEmailIdOnly("kubarabde@gmail.com"); 
        // then - verify the output
        assertThat(seller.getPassword()).isEqualTo("Kumar123456");
        
    }
	
	
	
	
	// Address Test Cases
		/* ****************************************************************** */
	@Test
	void addAddress() {
		AddressDetails address = new AddressDetails();
		ConsumerDetails conDetails = new ConsumerDetails();
		
		address.setPincode("856971");
		address.setDistrict("north");
		address.setTown("Solapur");
		address.setState("Maharashtra");
		address.setCountry("India");
		
		conDetails.setAddress(address);
		
	
		
		conServe.registerNewConsumer(conDetails);
		
	}
	
	// Consumer Test Cases
		/* ****************************************************************** */
	@Test
	void addConsumer() {
		
		
		ConsumerDetails consumer = new ConsumerDetails();
		AddressDetails address = new AddressDetails();
		
		consumer.setFirstName("Jayant");
		consumer.setLastName("Patil");
		consumer.setGender("Male");
		consumer.setEmailId("jayant@gmail.com");
		consumer.setPhoneNumber("9856235458");
		consumer.setStreet("Vijapur Road");
		consumer.setUsername("JayantP123");
		consumer.setPassword("Jayant1234");
		
		address.setDistrict("karvir");
		address.setTown("Kolhapur");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPincode("416222");
		
		consumer.setAddress(address);
		
		conServe.registerNewConsumer(consumer);
		

	}
	
	@Test
	void updateConsumer() {
		
		
		ConsumerDetails consumer = new ConsumerDetails();
		 AddressDetails address = new AddressDetails();
		
		consumer.setEmailId("jayant@gmail.com");
		consumer.setPassword("Jayant1234");
		consumer.setFirstName("Jayant");
		consumer.setLastName("Patil");
		consumer.setPhoneNumber("9856235459");
		consumer.setStreet("Vijapur Road");
		consumer.setUsername("JayantP12345");
		
		address.setPincode("416222");
		consumer.setAddress(address);
		
		ConsumerDetails update_consumer = conServe.updateConsumerDetails(consumer);
		
	    assertThat(update_consumer.getUsername()).isEqualTo("JayantP12345");
        assertThat(update_consumer.getPhoneNumber()).isEqualTo("9856235459");
			
	}
	
	@Test
    public void ChangeConsumerPassword(){
		 ConsumerDetails consumer = new ConsumerDetails();
        ChangePassword cp = new ChangePassword();
        
        
        cp.setEmailId("jayant@gmail.com");
        cp.setOldPassword("Jayant1234");
        cp.setNewPassword("Jayant123456");
        cp.setConfirmPassword("Jayant123456");

        conServe.changeConsumerPassword(cp);
          
        consumer = conRepo.findConsumerDetailsByEmailIdOnly("jayant@gmail.com");
        // then - verify the output
        assertThat(consumer.getPassword()).isEqualTo("Jayant123456");
        
    }
	
	/* Query Test Cases
	 * ***************************************************************** */
	 @Test
	 public void addNewConsumerQuery() {
		 
		 ConsumerQuery cq = new ConsumerQuery();
		 ConsumerDetails consumer = new ConsumerDetails();
		 
		 
		
		
		  consumer = conRepo.findConsumerDetailsByEmailIdOnly("yogesh@gmail.com");
		 
		 
	
		 cq.setConsumerDetails(consumer); 
		 cq.setMessage("product is not satisfactory");
		 
		 queryServ.insertNewConsumerQuery(cq);
		 
		 
	 }
	 
	 @Test
	 public void addNewSellerQuery() {
		 
		 SellerQuery sq = new SellerQuery();
		 SellerDetails setseller = new SellerDetails();
		 
		 setseller.setEmailId("kubarabde@gmail.com");
		  setseller = sellRepo.findSellerDetailsByEmailIdOnly("Kiran@gmail.com");
		 
		 
	
		 
		 sq.setSellerDetails(setseller);
		 sq.setMessage("False consumer Complaints");
		 
		 queryServ.insertNewSellerQuery(sq);
		 
		 
	 }
	 
	 /* ProductService Test cases
	  * ********************************************************
	  */
	 
	 @Test
	 public void addNewProduct() {
		 
	 
		 ProductDetails setproduct = new ProductDetails();
		 
		 setproduct.setName("Lassi");
		 setproduct.setPrice(100);
		 setproduct.setUnit("L");
		
		
		 proServe.insertNewProductDetails(setproduct); 
		 
		  assertThat(setproduct.getName()).isEqualTo("Lassi");
		 
	 }
	 

	
}












