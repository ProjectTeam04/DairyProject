package com.project.springboot.dairyproject.registrationdetails;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ConsumerService {

	@Autowired
	private RegistrationRepository conreg;

	public ConsumerRegistration addConsumerDetails(ConsumerRegistration condetails) {
		conreg.save(condetails);
		return condetails;
	}

	public ConsumerRegistration getConsumerDetailsByEmailId(String emailId) {
		return conreg.findConsumerRegistrationByEmailId(emailId);
	}

	public ConsumerRegistration getDetailsbyID(int userId) {
		return conreg.findConsumerRegistrationByConsumerId(userId);
	}

	public ConsumerRegistration getDetailsByEmailIdPassword(Login userDetails) {
		return conreg.findConsumerRegistrationByEmailIdPassWord(userDetails.getEmailId(), userDetails.getPassword());
	}
	
	public String deleteDetails(int userId) {
		conreg.deleteById(userId);
		return "Consumer Deleted from Record..!";
	}

}
