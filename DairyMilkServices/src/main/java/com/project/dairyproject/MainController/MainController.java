package com.project.dairyproject.MainController;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.dairyproject.Entities.ConsumerDetails;
import com.project.dairyproject.Entities.SellerDetails;
import com.project.dairyproject.LoginEntities.Login;
import com.project.dairyproject.LoginEntities.LoginByPhone;
import com.project.dairyproject.LoginEntities.LoginByUsername;
import com.project.dairyproject.Services.ConsumerServices;
import com.project.dairyproject.Services.SellerServices;
import com.project.dairyproject.UserDefinedExceptions.EmailAddressFoundException;
import com.project.dairyproject.UserDefinedExceptions.PhoneNumberFoundException;
import com.project.dairyproject.UserDefinedExceptions.UsernameFoundException;

@RestController
@CrossOrigin(origins = "http://localhost:9090")
public class MainController {

	@Autowired
	private ConsumerServices conServ;

	@Autowired
	private SellerServices sellServ;

	// Consumers Controller

	@PostMapping("/consumer/registerdetails")
	public ConsumerDetails registerNewConsumer(@Valid @RequestBody ConsumerDetails consumerDetails)
			throws EmailAddressFoundException, UsernameFoundException, PhoneNumberFoundException {
		return conServ.registerNewConsumer(consumerDetails);
	}

	@PostMapping("/consumer/fetchdetailsbyemail")
	public ConsumerDetails getConsumerDetailsByEmailIdandPassword(@RequestBody Login login) {
		return conServ.getConsumerDetailsByEmailAndPassword(login.getEmailId(), login.getPassword());
	}

	@PostMapping("/consumer/fetchdetailsbyusername")
	public ConsumerDetails getConsumerDetailsByUsernameAndPassword(@RequestBody LoginByUsername loginByUsername) {
		return conServ.getConsumerDetailsByUsernameAndPassword(loginByUsername.getUsername(),
				loginByUsername.getPassword());
	}

	@PostMapping("/consumer/fetchdetailsbyphonenumber")
	public ConsumerDetails getConsumerDetailsByPhoneNumber(@RequestBody LoginByPhone loginByPhone) {
		return conServ.getConsumerDetailsByPhoneNumber(loginByPhone.getPhoneNumber(), loginByPhone.getPassword());
	}

	@GetMapping("/consumer/removeconsumeraccount")
	public String deleteConsumerByConsumerId(@RequestParam Integer consumerId) {
		return conServ.deleteConsumerDetailsByConsumerId(consumerId);
	}

	// Sellers Controller

	@PostMapping("/seller/registerdetails")
	public SellerDetails registeredNewSeller(@Valid @RequestBody SellerDetails sellerDetails)
			throws EmailAddressFoundException, UsernameFoundException, PhoneNumberFoundException {
		return sellServ.registerNewSeller(sellerDetails);
	}

	@PostMapping("/seller/fetchdetailsbyemail")
	public SellerDetails getSellerDetailsByEmailIdandPassword(@RequestBody Login login) {
		return sellServ.getSellerDetailsByEmailAndPassword(login.getEmailId(), login.getPassword());
	}

	@PostMapping("/seller/fetchdetailsbyusername")
	public SellerDetails getSellerDetailsByUsernameAndPassword(@RequestBody LoginByUsername loginByUsername) {
		return sellServ.getSellerDetailsByUsernameAndPassword(loginByUsername.getUsername(),
				loginByUsername.getPassword());
	}

	@PostMapping("/seller/fetchdetailsbyphonenumber")
	public SellerDetails getSellerDetailsByPhoneNumber(@RequestBody LoginByPhone loginByPhone) {
		return sellServ.getSellerDetailsByPhoneNumberAndPassword(loginByPhone.getPhoneNumber(),
				loginByPhone.getPassword());
	}

	@GetMapping("/seller/removeselleraccount")
	public String deleteSellerBysellerId(@RequestParam Integer sellerId) {
		return sellServ.deleteSellerDetailsBySellerId(sellerId);
	}

	// Administrator Controller

	@GetMapping("/admin/fetchconsumerbyemail")
	public ConsumerDetails getConsumerDetailsByEmailId(@RequestParam String emailId) {
		return conServ.getConsumerDetailsByEmailId(emailId);
	}

	@GetMapping("/admin/fetchconsumerbyusername")
	public ConsumerDetails getConsumerDetailsByUsername(@RequestParam String username) {
		return conServ.getConsumerDetailsByUsername(username);
	}

	@GetMapping("/admin/fetchconsumerbyphone")
	public ConsumerDetails getConsumerDetailsByPhoneNumber(@RequestParam String phoneNumber) {
		return conServ.getConsumerDetailsByPhoneNumer(phoneNumber);
	}

	@GetMapping("/admin/removeaccountbyemail")
	public String deleteConsumerByEmail(@RequestParam String emailId) {
		return conServ.deleteConsumerDetailsByEmailId(emailId);
	}

	@GetMapping("/admin/fetchallconsumers")
	public List<ConsumerDetails> getAllConsumers() {
		return conServ.getAllConsumerList();
	}

	@GetMapping("/admin/fetchconsumersbyname")
	public List<ConsumerDetails> getAllConsumersByName(String name) {
		return conServ.getConsumerDetailsByFirstName(name);
	}

	@GetMapping("/admin/fetchconsumersbypincode")
	public List<ConsumerDetails> getAllConsumersByPincode(@RequestParam String pincode) {
		return conServ.getConsumerListByPincode(pincode);
	}

	@GetMapping("/admin/fetchconsumersbydistrict")
	public List<ConsumerDetails> getAllConsumersByDistrict(String district) {
		return conServ.getConsumerListByDistrict(district);
	}

	@GetMapping("/admin/fetchconsumersbytown")
	public List<ConsumerDetails> getAllConsumersByTown(String town) {
		return conServ.getConsumerListByTown(town);
	}

}
