package com.project.dairyproject.MainController;

import javax.validation.Valid;

import org.hibernate.boot.cfgxml.spi.CfgXmlAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.dairyproject.Entities.ConsumerDetails;
import com.project.dairyproject.MiscClasses.Login;
import com.project.dairyproject.Services.ConsumerServices;
import com.project.dairyproject.UserDefinedExceptions.EmailAddressFoundException;
import com.project.dairyproject.UserDefinedExceptions.PhoneNumberFoundException;
import com.project.dairyproject.UserDefinedExceptions.UsernameFoundException;

@RestController
@CrossOrigin
public class MainController {

	@Autowired
	private ConsumerServices conServ;

	@PostMapping("/consumer/registerdetails")
	public ConsumerDetails registerNewConsumer(@Valid @RequestBody ConsumerDetails consumerDetails)
			throws EmailAddressFoundException, UsernameFoundException, PhoneNumberFoundException {
		return conServ.registerNewConsumer(consumerDetails);
	}

	@PostMapping("/consumer/fetchdetails")
	public ConsumerDetails getConsumerDetailsByEmailIdandPassword(@RequestBody Login login) {
		return conServ.getConsumerDetailsByEmailAndPassword(login.getEmailId(), login.getPassword());
	}

}
