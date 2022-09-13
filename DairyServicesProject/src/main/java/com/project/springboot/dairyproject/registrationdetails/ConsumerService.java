package com.project.springboot.dairyproject.registrationdetails;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.springboot.dairyproject.AddressRepository.AddressRepository;

@Service
@Transactional
public class ConsumerService {

	@Autowired
	private Address address;

	@Autowired
	private SellerRegistrationRepository sellReg;

	@Autowired
	private RegistrationRepository conreg;

	@Autowired
	private AddressRepository addRepo;

	@Autowired
	private ProductRepository prorepo;

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

	public List<ConsumerRegistration> getConsumerRegistrations() {
		return conreg.fetchConsumerRegistrations();
	}

	public String insertSellerRecords(SellerRegistration sellerDetails) {
		address = addRepo.findAddressByPincode(sellerDetails.getAddress().getPincode());
		if (address != null) {
			sellerDetails.setAddress(address);
			sellReg.save(sellerDetails);
			return "Successfully Inserted Seller Details.";
		} else {
			sellReg.save(sellerDetails);
			return "Successfully Inserted Seller Details.";
		}

	}

}
