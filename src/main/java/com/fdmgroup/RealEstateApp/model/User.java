package com.fdmgroup.RealEstateApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_gen")
	@SequenceGenerator(name = "users_gen", sequenceName = "USERS_SEQ", allocationSize = 1)
	private int userId;

	@Column(nullable = false, length = 80)
	private String firstName;
	@Column(nullable = false, length = 80)
	private String lastName;
	@Column(nullable = false, unique = true, length = 80)
	private String userName;
	@Column(nullable = false, length = 80)
	private String email;
	@Column(nullable = false, length = 80)
	private String password;
	@Column(nullable = false, length = 80)
	private int phoneNumber;
	@Enumerated(EnumType.STRING)
	private AccountType accountType;
	@Enumerated(EnumType.STRING)
	private AccountStatus accountStatus = AccountStatus.INACTIVE;

	/*---Constructors---*/

	public User() {
		super();
	}

	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public User(String firstName, String lastName, String userName, String email, String password, int phoneNumber,
			AccountType accountType) {

		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.accountType = accountType;
		this.accountStatus = AccountStatus.INACTIVE;
	}

	/*---Getters and setters---*/

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

	public AccountStatus getAccountStatus() {
		return this.accountStatus;
	}

}
