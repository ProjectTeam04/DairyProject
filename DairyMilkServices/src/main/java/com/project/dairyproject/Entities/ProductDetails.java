package com.project.dairyproject.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class ProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int PID;

	@NotEmpty(message = "Product Name is required")
	@Column(length = 15, unique = true)
	@Pattern(regexp = "^[a-zA-Z0-9]{4,15}$", message = "Product name must be in betweem 4 to 15 (special characters are not allowed)")
	private String name;

	@NotNull(message = "Price cannot be empty, please enter price for your product")
	@Range(min = 8, message = "Price should be more than 8 Rs.")
	private float price;

	@NotNull(message = "Enter maximum quantity available to sell")
	private float maxQuantity;

	public int getPID() {
		return PID;
	}

	public void setPID(int pID) {
		PID = pID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getMaxQuantity() {
		return maxQuantity;
	}

	public void setMaxQuantity(float maxQuantity) {
		this.maxQuantity = maxQuantity;
	}

}
