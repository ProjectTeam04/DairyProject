package com.project.dairyproject.Entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Check;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.bytebuddy.utility.nullability.UnknownNull;

@Entity
@Table
@Component
public class ConsumerDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int consumerId;
	@NotEmpty(message = "First Name is required")
	@Length(min = 3, max = 18, message = "First name can be in between 3 to 18 characters only")
	@Pattern(regexp = "^[a-zA-Z]{3,18}$", message = "Please enter your correct name")
	private String firstName;
	@Length(min = 3, max = 18, message = "First name can be in between 3 to 18 characters only")
	@Pattern(regexp = "^[a-zA-Z]{3,18}$", message = "Please enter your correct last name ")
	private String lastName;
	@NotEmpty(message = "Select your gender")
	@Check(constraints = "Male, Female, Other")
	private String gender;
	@NotEmpty(message = "Email address is required for registration")
	@Column(unique = true)
	/*
	 * @Email(regexp =
	 * "^[\\\\w!#$%&'*+/=?`{|}~^-]+(?:\\\\.[\\\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,6}$",
	 * message = "Please enter your valid email address")
	 */
	private String emailId;
	@NotEmpty(message = "Please enter your phone number")
	@Column(length = 14, unique = true)
	@Length(min = 10, max = 13, message = "Please enter correct phone number")
	@Pattern(regexp = "^(?:(?:\\+|0{0,2})91(\\s*[\\ -]\\s*)?|[0]?)?[789]\\d{9}|(\\d[ -]?){10}\\d$", message = "Please enter your correct phone number")
	private String phoneNumber;
	@Length(max = 40, message = "Street cannot be more than 40 characters")
	private String street;
	@NotEmpty(message = "Username must be required for registration and login")
	@Length(min = 5, max = 15, message = "Username must be in between 5 to 15 characters")
	@Column(unique = true)
	@Pattern(regexp = "^[a-zA-Z0-9_-]{5,15}$", message = "Please enter correct username")
	private String username;
	@NotEmpty(message = "Password is required")
	@Length(min = 4, max = 12, message = "Password must be in between 4 to 12 characters")
	/*
	 * @Pattern(regexp =
	 * "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){4,12}$", message =
	 * "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit "
	 * )
	 */
	private String password;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "AID")
	private AddressDetails address;

	public int getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(int consumerId) {
		this.consumerId = consumerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AddressDetails getAddress() {
		return address;
	}

	public void setAddress(AddressDetails address) {
		this.address = address;
	}

}
