package com.project.springboot.dairyproject.MainController;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.springboot.dairyproject.registrationdetails.ConsumerRegistration;
import com.project.springboot.dairyproject.registrationdetails.ConsumerService;
import com.project.springboot.dairyproject.registrationdetails.Login;
import com.project.springboot.dairyproject.registrationdetails.SellerRegistration;

@RestController
public class MainController {

	@Autowired
	private ConsumerService conserv;

	@PostMapping("/pushDetails.com")
	public String saveDetails(@RequestBody ConsumerRegistration consumerInfo) {
		conserv.addConsumerDetails(consumerInfo);
		return "Details Inserted..!";
	}

	@GetMapping("/getDetails.com")
	public ConsumerRegistration getDetailsConsumer(@RequestParam String emailId) {
		return conserv.getConsumerDetailsByEmailId(emailId);
	}

	@GetMapping("/getDetailsbyId.com")
	public ConsumerRegistration getDetailsByUserId(@RequestParam int userId) {
		return conserv.getDetailsbyID(userId);
	}

	@PostMapping("/getDetailsbymailidnpassword.com")
	public ConsumerRegistration getDetailsByEmailnPassword(@RequestBody Login userDetails) {
		return conserv.getDetailsByEmailIdPassword(userDetails);
	}

	@GetMapping("/deleteDetailsbyId.com")
	public String deleteDetailsById(@RequestParam int userId) {
		return conserv.deleteDetails(userId);
	}

	@GetMapping("/getall/list/consumerregistration")
	public List<ConsumerRegistration> getAllDetailsConsumerRegistrations() {
		return conserv.getConsumerRegistrations();
	}

	@PostMapping("/insertrecords/seller")
	public String insertSellerRecords(@RequestBody SellerRegistration sellerRegistration) {
		return conserv.insertSellerRecords(sellerRegistration);
	}

}
