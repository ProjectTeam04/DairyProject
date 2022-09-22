package com.project.dairyproject.Services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dairyproject.Entities.ConsumerDetails;
import com.project.dairyproject.Entities.ConsumerQuery;
import com.project.dairyproject.Entities.SellerDetails;
import com.project.dairyproject.Entities.SellerQuery;
import com.project.dairyproject.Repository.ConsumerQueryRepository;
import com.project.dairyproject.Repository.ConsumerRepository;
import com.project.dairyproject.Repository.SellerQueryRepository;
import com.project.dairyproject.Repository.SellerRepository;

@Service
@Transactional
public class QueryServices {

	@Autowired
	private ConsumerQueryRepository conQueryRepo;

	@Autowired
	private SellerQueryRepository sellQueryRepo;

	@Autowired
	private ConsumerRepository conRepo;

	@Autowired
	private SellerRepository sellRepo;

	@Autowired
	private ConsumerDetails conDetails;

	@Autowired
	private SellerDetails sellDetails;

	// Consumer Query

	public String insertNewConsumerQuery(ConsumerQuery consumerQuery) {
		conDetails = conRepo.findConsumerDetailsByEmailIdOnly(consumerQuery.getConsumerDetails().getEmailId());
		if (conDetails != null) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");
			String dateTime = dtf.format(LocalDateTime.now());
			System.out.println(dateTime);
			consumerQuery.setConsumerDetails(conDetails);
			consumerQuery.setDateTime(dateTime);
			conQueryRepo.save(consumerQuery);
			conDetails = null;
			return "Thank you for your valuable time. We will soon get back to you with proper solution !";
		}

		return "Query insertion failed ! Please try after some time. Sorry for the inconvenience...";
	}

	public List<ConsumerQuery> getAllConsumerQueries() {
		return conQueryRepo.findAllConsumerQueries();
	}

	public List<ConsumerQuery> getConsumerQueriesByDateTime(String dateTime) {
		return conQueryRepo.findConsumerQueriesByDateTime(dateTime);
	}

	public List<ConsumerQuery> getConsumerQueriesByConsumerEmailId(String emailId) {
		return conQueryRepo.findConsumerQueriesByConsumerEmailId(emailId);
	}

	// Seller Query

	public String insertNewSellerQuery(SellerQuery sellerQuery) {
		sellDetails = sellRepo.findSellerDetailsByEmailIdOnly(sellerQuery.getSellerDetails().getEmailId());
		if (sellDetails != null) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm a");
			String dateTime = dtf.format(LocalDateTime.now());
			sellerQuery.setSellerDetails(sellDetails);
			sellerQuery.setDateTime(dateTime);
			sellQueryRepo.save(sellerQuery);
			sellDetails = null;
			return "Thank you for your valuable time. We will soon get back to you with proper solution !";
		}

		return "Query insertion failed ! Please try after some time. Sorry for the inconvenience...";
	}

	public List<SellerQuery> getAllSellerQueries() {
		return sellQueryRepo.findAllSellerQueries();
	}

	public List<SellerQuery> getSellerQueriesByDateTime(String dateTime) {
		return sellQueryRepo.findSellerQueriesByDateTime(dateTime);
	}

	public List<SellerQuery> getSellerQueriesBySellerEmailId(String emailId) {
		return sellQueryRepo.findSellerQueriesBySellerEmailId(emailId);
	}

}
