package com.project.dairyproject.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.dairyproject.Entities.AddressDetails;

@Repository
public interface AddressRepository extends CrudRepository<AddressDetails, Integer> {

	public AddressDetails findAddressDetailsByPincode(String pincode);

	public List<AddressDetails> findAddressDetailsByDistrict(String district);

	public AddressDetails findAddressDetailsByTown(String town);

}
