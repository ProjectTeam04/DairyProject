package com.project.springboot.dairyproject.AddressRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.springboot.dairyproject.registrationdetails.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	public Address findAddressByPincode(int pincode);

}
