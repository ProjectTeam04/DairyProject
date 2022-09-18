package com.project.dairyproject.Services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.project.dairyproject.Entities.AddressDetails;
import com.project.dairyproject.Entities.ConsumerDetails;
import com.project.dairyproject.Repository.AddressRepository;
import com.project.dairyproject.Repository.ConsumerRepository;
import com.project.dairyproject.UserDefinedExceptions.EmailAddressFoundException;
import com.project.dairyproject.UserDefinedExceptions.PhoneNumberFoundException;
import com.project.dairyproject.UserDefinedExceptions.UsernameFoundException;

@Service
@Transactional
@Component
public class ConsumerServices {

	@Autowired
	private ConsumerRepository conRepo;

	@Autowired
	private AddressDetails addressDetails;

	@Autowired
	private AddressRepository addRepo;

	public ConsumerDetails registerNewConsumer(ConsumerDetails consumerDetails)
			throws EmailAddressFoundException, UsernameFoundException, PhoneNumberFoundException {
		int email = conRepo.findConsumerDetailsByEmailId(consumerDetails.getEmailId());
		int username = conRepo.findConsumerDetailsByUsername(consumerDetails.getUsername());
		int phoneNumber = conRepo.findConsumerDetailsByPhoneNumber(consumerDetails.getPhoneNumber());

		addressDetails = addRepo.findAddressDetailsByPincode(consumerDetails.getAddress().getPincode());

		if (email == 1) {
			throw new EmailAddressFoundException("Email address already registered");
		} else if (username == 1) {
			throw new UsernameFoundException("Username already taken, please try with another one");
		} else if (phoneNumber == 1) {
			throw new PhoneNumberFoundException("Phone Number already registered");
		} else if (addressDetails != null) {
			consumerDetails.setAddress(addressDetails);
			conRepo.save(consumerDetails);
			return conRepo.findConsumerDetailsByEmailAndPassword(consumerDetails.getEmailId(),
					consumerDetails.getPassword());
		} else {
			conRepo.save(consumerDetails);
			return conRepo.findConsumerDetailsByEmailAndPassword(consumerDetails.getEmailId(),
					consumerDetails.getPassword());
		}
	}

	public ConsumerDetails getConsumerDetailsByEmailAndPassword(String emailId, String password) {
		return conRepo.findConsumerDetailsByEmailAndPassword(emailId, password);
	}

	public ConsumerDetails getConsumerDetailsByUsernameAndPassword(String username, String password) {
		return conRepo.findConsumerDetailsByUsernameAndPassword(username, password);
	}

	public ConsumerDetails getConsumerDetailsByPhoneNumber(String phoneNumber, String password) {
		return conRepo.findConsumerDetailsByPhoneNumberAndPassword(phoneNumber, password);
	}

	public ConsumerDetails getConsumerDetailsByEmailId(String emailId) {
		return conRepo.findConsumerDetailsByEmailIdOnly(emailId);
	}

	public ConsumerDetails getConsumerDetailsByUsername(String username) {
		return conRepo.findConsumerDetailsByUsernameOnly(username);
	}

	public ConsumerDetails getConsumerDetailsByPhoneNumer(String phoneNumber) {
		return conRepo.findConsumerDetailsByPhoneNumberOnly(phoneNumber);
	}

	public String deleteConsumerDetailsByEmailId(String emailId) {
		if (conRepo.deleteConsumerDetailsByEmailId(emailId) == 1) {
			return "Consumer account removed from database...";
		}

		return "Account not found !";
	}

	public String deleteConsumerDetailsByConsumerId(Integer consumerId) {
		if (conRepo.deleteConsumerDetailsByConsumerId(consumerId) == 1) {
			return "Consumer account removed from database...";
		}
		return "Account not found !";
	}

	public List<ConsumerDetails> getAllConsumerList() {
		return conRepo.findAllConsumerDetails();
	}

	public List<ConsumerDetails> getConsumerDetailsByFirstName(String firstName) {
		return conRepo.findConsumerByName(firstName);
	}

	public List<ConsumerDetails> getConsumerListByPincode(String pincode) {
		return conRepo.findConsumersByPincode(pincode);
	}

	public List<ConsumerDetails> getConsumerListByDistrict(String district) {
		return conRepo.findConsumersByDistrict(district);
	}

	public List<ConsumerDetails> getConsumerListByTown(String town) {
		return conRepo.findConsumersByTown(town);
	}

	public List<ConsumerDetails> getConsumerByAid(Integer aid) {
		return conRepo.findConsumerDetailsByAid(aid);
	}

}
