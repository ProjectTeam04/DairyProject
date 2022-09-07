package com.project.springboot.dairyproject.registrationdetails;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RegistrationRepository extends CrudRepository<ConsumerRegistration, Integer> {

	public ConsumerRegistration findConsumerRegistrationByEmailId(String emailId);

	public ConsumerRegistration findConsumerRegistrationByConsumerId(int userId);

	@Query("select c from ConsumerRegistration c where c.emailId = ?1 and c.passWord = ?2")
	public ConsumerRegistration findConsumerRegistrationByEmailIdPassWord(String emailId, String passWord);

}
