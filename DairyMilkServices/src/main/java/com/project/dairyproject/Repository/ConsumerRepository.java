package com.project.dairyproject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.dairyproject.Entities.ConsumerDetails;

@Repository
public interface ConsumerRepository extends CrudRepository<ConsumerDetails, Integer> {

	@Query("select c from ConsumerDetails c where c.username = ?1 and c.password = ?2")
	public ConsumerDetails findConsumerDetailsByUsernameAndPassword(String username, String password);

	@Query("select c from ConsumerDetails c where c.emailId = ?1 and c.password = ?2")
	public ConsumerDetails findConsumerDetailsByEmailAndPassword(String emailId, String password);

	public int findConsumerDetailsByEmailId(String emailId);

	public int findConsumerDetailsByUsername(String username);

	public int findConsumerDetailsByPhoneNumber(String phoneNumber);

	@Query("select c from ConsumerDetails c where c.emailId = ?1")
	public ConsumerDetails findConsumerDetailsByEmailIdOnly(String emailId);

	@Query("select c from ConsumerDetails c where c.username = ?1")
	public ConsumerDetails findConsumerDetailsByUsernameOnly(String username);

	@Query("select c from ConsumerDetails c where c.phoneNumber = ?1")
	public ConsumerDetails findConsumerDetailsByPhoneNumberOnly(String phoneNumber);

	public int deleteConsumerDetailsByConsumerId(int consumerid);

	public int deleteConsumerDetailsByEmailId(String emailId);

	@Query("select c from ConsumerDetails c")
	public List<ConsumerDetails> findAllConsumerDetails();

	@Query("select c from ConsumerDetails c where firstName = ?1")
	public List<ConsumerDetails> findConsumerByName(String name);

	@Query("select c from ConsumerDetails c inner join AddressDetails a on a.AID = c.consumerId where a.pincode = ?1")
	public List<ConsumerDetails> findConsumerByPincode(String pincode);

	@Query("select c from ConsumerDetails c inner join AddressDetails a on a.AID = c.consumerId where a.district = ?1")
	public List<ConsumerDetails> findConsumerByDistrict(String district);

	@Query("select c from ConsumerDetails c inner join AddressDetails a on a.AID = c.consumerId where a.town = ?1")
	public List<ConsumerDetails> findConsumerByTown(String town);

}
