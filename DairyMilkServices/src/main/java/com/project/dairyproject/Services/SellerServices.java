package com.project.dairyproject.Services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.dairyproject.Entities.AddressDetails;
import com.project.dairyproject.Entities.ConsumerDetails;
import com.project.dairyproject.Entities.DeletedSellerRecords;
import com.project.dairyproject.Entities.SellerDetails;
import com.project.dairyproject.LoginEntities.ChangePassword;
import com.project.dairyproject.LoginEntities.Login;
import com.project.dairyproject.Repository.AddressRepository;
import com.project.dairyproject.Repository.ConsumerRepository;
import com.project.dairyproject.Repository.DeletedSellerRepository;
import com.project.dairyproject.Repository.SellerRepository;
import com.project.dairyproject.UserDefinedExceptions.EmailAddressFoundException;
import com.project.dairyproject.UserDefinedExceptions.IncorrectPasswordException;
import com.project.dairyproject.UserDefinedExceptions.PhoneNumberFoundException;
import com.project.dairyproject.UserDefinedExceptions.UnmatchedPasswordException;
import com.project.dairyproject.UserDefinedExceptions.UsernameFoundException;

@Service
@Transactional
public class SellerServices {

	@Autowired
	private AddressDetails addressDetails;

	@Autowired
	private AddressRepository addRepo;

	@Autowired
	private SellerRepository sellRepo;

	@Autowired
	private ConsumerDetails consumerDetails;

	@Autowired
	private SellerDetails sellDetails;

	@Autowired
	private ConsumerRepository conRepo;

	@Autowired
	private DeletedSellerRepository delRepo;

	@Autowired
	private DeletedSellerRecords delSelRecord;

	public SellerDetails registerNewSeller(SellerDetails sellerDetails)
			throws EmailAddressFoundException, UsernameFoundException, PhoneNumberFoundException {
		int email = sellRepo.findSellerDetailsByEmailId(sellerDetails.getEmailId());
		int username = sellRepo.findSellerDetailsByUsername(sellerDetails.getUsername());
		int phoneNumber = sellRepo.findSellerDetailsByPhoneNumber(sellerDetails.getPhoneNumber());

		addressDetails = addRepo.findAddressDetailsByPincode(sellerDetails.getAddress().getPincode());

		if (email == 1) {
			throw new EmailAddressFoundException("Email address already registered");
		} else if (username == 1) {
			throw new UsernameFoundException("Username already taken, please try with another one");
		} else if (phoneNumber == 1) {
			throw new PhoneNumberFoundException("Phone Number already registered");
		} else if (addressDetails != null) {
			sellerDetails.setAddress(addressDetails);
			sellRepo.save(sellerDetails);
			addressDetails = null;
			return sellRepo.findSellerDetailsByEmailAndPassword(sellerDetails.getEmailId(),
					sellerDetails.getPassword());
		} else {
			sellRepo.save(sellerDetails);
			return sellRepo.findSellerDetailsByEmailAndPassword(sellerDetails.getEmailId(),
					sellerDetails.getPassword());
		}
	}

	public SellerDetails getSellerDetailsByEmailAndPassword(String emailId, String password) {
		return sellRepo.findSellerDetailsByEmailAndPassword(emailId, password);
	}

	public SellerDetails getSellerDetailsByUsernameAndPassword(String username, String password) {
		return sellRepo.findSellerDetailsByUsernameAndPassword(username, password);
	}

	public SellerDetails getSellerDetailsByPhoneNumberAndPassword(String phoneNumber, String password) {
		return sellRepo.findSellerDetailsByPhoneNumberAndPassword(phoneNumber, password);
	}

	public SellerDetails getSellerDetailsByEmailId(String emailId) {
		return sellRepo.findSellerDetailsByEmailIdOnly(emailId);
	}

	public SellerDetails getSellerDetailsByUsername(String username) {
		return sellRepo.findSellerDetailsByUsernameOnly(username);
	}

	public SellerDetails getSellerDetailsByPhoneNumer(String phoneNumber) {
		return sellRepo.findSellerDetailsByPhoneNumberOnly(phoneNumber);
	}

	public String deleteSellerDetailsByEmailId(Login login) {
		sellDetails = sellRepo.findSellerDetailsByEmailAndPassword(login.getEmailId(), login.getPassword());
		if (sellDetails != null && sellRepo.deleteSellerDetailsByEmailId(sellDetails.getEmailId()) == 1) {
			delSelRecord.setAddress(sellDetails.getAddress());
			delSelRecord.setAge(sellDetails.getAge());
			delSelRecord.setEmailId(sellDetails.getEmailId());
			delSelRecord.setFirstName(sellDetails.getFirstName());
			delSelRecord.setLastName(sellDetails.getLastName());
			delSelRecord.setGender(sellDetails.getGender());
			delSelRecord.setPhoneNumber(sellDetails.getPhoneNumber());
			delSelRecord.setSellerId(sellDetails.getSellerId());
			delSelRecord.setStreet(sellDetails.getStreet());
			delSelRecord.setUsername(sellDetails.getUsername());
			delRepo.save(delSelRecord);
			sellDetails = null;
			delSelRecord = null;
			return "Seller account removed !";
		}

		return "Account not found !";
	}

	public String deleteSellerDetailsBySellerId(Integer sellerId) {
		sellDetails = sellRepo.findSellerDetailsBySellerId(sellerId);
		if (sellRepo.deleteSellerDetailsBySellerId(sellerId) == 1) {
			delSelRecord.setAddress(sellDetails.getAddress());
			delSelRecord.setAge(sellDetails.getAge());
			delSelRecord.setEmailId(sellDetails.getEmailId());
			delSelRecord.setFirstName(sellDetails.getFirstName());
			delSelRecord.setLastName(sellDetails.getLastName());
			delSelRecord.setGender(sellDetails.getGender());
			delSelRecord.setPhoneNumber(sellDetails.getPhoneNumber());
			delSelRecord.setSellerId(sellDetails.getSellerId());
			delSelRecord.setStreet(sellDetails.getStreet());
			delSelRecord.setUsername(sellDetails.getUsername());
			delRepo.save(delSelRecord);
			sellDetails = null;
			delSelRecord = null;
			return "Seller account removed !";
		}
		return "Account not found !";
	}

	public List<SellerDetails> getAllSellerList() {
		return sellRepo.findAllSellerDetails();
	}

	public List<SellerDetails> getSellerDetailsByFirstName(String firstName) {
		return sellRepo.findSellerByName(firstName);
	}

	public List<SellerDetails> getSellerListByPincode(String pincode) {
		return sellRepo.findSellersByPincode(pincode);
	}

	public List<SellerDetails> getSellerListByDistrict(String district) {
		return sellRepo.findSellersByDistrict(district);
	}

	public List<SellerDetails> getSellerListByTown(String town) {
		return sellRepo.findSellersByTown(town);
	}

	public Set<SellerDetails> getSellerListByLocality(String emailId) {

		consumerDetails = conRepo.findConsumerDetailsByEmailIdOnly(emailId);
		List<SellerDetails> sellersByPincode = sellRepo.findSellersByPincode(consumerDetails.getAddress().getPincode());
		List<SellerDetails> sellersByTown = sellRepo.findSellersByTown(consumerDetails.getAddress().getTown());
		List<SellerDetails> sellersByDistrict = sellRepo
				.findSellersByDistrict(consumerDetails.getAddress().getDistrict());

		Set<SellerDetails> concatinatedSellerSet = new HashSet<>();
		concatinatedSellerSet.addAll(sellersByPincode);
		concatinatedSellerSet.addAll(sellersByTown);
		concatinatedSellerSet.addAll(sellersByDistrict);

		return concatinatedSellerSet;

	}

	public SellerDetails updateSellerDetails(SellerDetails sellerDetails) {
		sellDetails = sellRepo.findSellerDetailsByEmailAndPassword(sellerDetails.getEmailId(),
				sellerDetails.getPassword());

		addressDetails = addRepo.findAddressDetailsByPincode(sellerDetails.getAddress().getPincode());
		if (addressDetails != null) {
			sellDetails.setAddress(addressDetails);
		} else {
			addRepo.save(sellerDetails.getAddress());
			addressDetails = addRepo.findAddressDetailsByPincode(sellerDetails.getAddress().getPincode());
			sellDetails.setAddress(addressDetails);
		}

		sellDetails.setStreet(sellerDetails.getStreet());
		sellDetails.setFirstName(sellerDetails.getFirstName());
		sellDetails.setLastName(sellerDetails.getLastName());
		sellDetails.setPhoneNumber(sellerDetails.getPhoneNumber());
		sellDetails.setUsername(sellerDetails.getUsername());
		sellRepo.save(sellDetails);

		return sellRepo.findSellerDetailsByEmailAndPassword(sellerDetails.getEmailId(), sellerDetails.getPassword());

	}

	public String changeSellerPassword(ChangePassword changePassword) {
		if (changePassword.getNewPassword().equals(changePassword.getConfirmPassword())) {
			sellDetails = sellRepo.findSellerDetailsByEmailAndPassword(changePassword.getEmailId(),
					changePassword.getOldPassword());
			if (sellDetails != null) {
				sellDetails.setPassword(changePassword.getNewPassword());
				sellRepo.save(sellDetails);
				return "Password changed successfully.";
			} else {
				throw new IncorrectPasswordException("Incorrect old password !");
			}

		} else {
			throw new UnmatchedPasswordException("Password does not match. Please enter correct password !");
		}

	}

}
