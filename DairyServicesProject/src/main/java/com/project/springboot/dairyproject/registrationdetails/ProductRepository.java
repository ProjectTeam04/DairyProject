package com.project.springboot.dairyproject.registrationdetails;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductDetails, Integer> {

	public ProductDetails findProductDetailsByName(String name);

}
