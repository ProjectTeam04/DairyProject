package com.project.dairyproject.MainController;

import javax.validation.Valid;

import org.hibernate.boot.cfgxml.spi.CfgXmlAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.dairyproject.Entities.ConsumerDetails;
import com.project.dairyproject.Services.ConsumerServices;

@RestController
@CrossOrigin
public class MainController {

	@Autowired
	private ConsumerServices conServ;

	@PostMapping("/consumer/registerdetails")
	public String registerNewConsumer(@Valid @RequestBody ConsumerDetails consumerDetails) {
		return conServ.registerNewConsumer(consumerDetails);
	}

	@GetMapping("/consumer/fetchdetails")
	public ConsumerDetails getConsumerDetailsByEmailIdandPassword(@RequestParam String emailid,
			@RequestParam String password) {
		return null;
	}

	/*
	 * public ConsumerDetails getConsumerDetailsByEmailIdAndPassword(@RequestBody
	 * Login login) { return null; }
	 * 
	 */

}
