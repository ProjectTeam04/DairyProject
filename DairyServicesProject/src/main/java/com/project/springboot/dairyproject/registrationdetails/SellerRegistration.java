package com.project.springboot.dairyproject.registrationdetails;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.Constraint;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern.Flag;

import org.hibernate.annotations.Check;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.pattern.PatternParseException.PatternMessage;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
@Table
public class SellerRegistration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sellerId;
	@NotNull(message = "Please provide your first name")
	@Pattern(regexp = "^[a-zA-Z]{3,14}", message = "Last Name must be of min 3 and max 14 characters")
	private String firstName;
	@Pattern(regexp = "^[a-zA-Z]{3,14}", message = "Last Name must be of min 3 and max 14 characters")
	private String lastName;
	@Range(min = 18, max = 60, message = "Age should be in between 18 to 60 years")
	private int age;
	@NotNull(message = "Please select your gender")
	@Check(constraints = "Male, Female, Other")
	private String gender;
	@NotNull(message = "Email address required for registration")
	@Email(message = "Please provide valid email address.")
	private String emailId;
	@NotNull(message = "Username is required")
	// @Pattern(regexp = "^[a-zA-Z0-9]{4,16}", message = "Username must be in
	// between 4 to 16 characters")
	private String userName;
	@NotNull(message = "Password is required")
	@Size(min = 4, max = 12, message = "Password can be of minimum length 4")
	private String passWord;
	@NotNull(message = "Phone Number required")
	@Size(min = 10, max = 13, message = "Please enter complete phone number")
	@Pattern(regexp = "^[0-9]{10}", message = "Please provide your correct phone number")
	private String phoneNumber;
	@Size(min = 0, max = 40, message = "Street cannot be more than 40 characters")
	private String street;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AID")
	private Address address;

	public int getSellerId() {
		return sellerId;
	}

	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
