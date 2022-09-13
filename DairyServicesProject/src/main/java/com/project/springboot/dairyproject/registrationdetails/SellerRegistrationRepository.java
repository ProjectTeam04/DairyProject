package com.project.springboot.dairyproject.registrationdetails;

import org.springframework.data.repository.CrudRepository;

public interface SellerRegistrationRepository extends CrudRepository<SellerRegistration, Integer> {

	public SellerRegistration findSellerRegistrationByEmailId(String emailId);

}
