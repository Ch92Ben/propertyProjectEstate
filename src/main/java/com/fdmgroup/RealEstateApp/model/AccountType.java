package com.fdmgroup.RealEstateApp.model;

public enum AccountType {

	ADMIN("Admin"), BUYER("Buyer"), SELLER("Seller"), ESTATEAGENT("Estate Agent");

	private String name;

	private AccountType(String type) {
		name = type;
	}

	public String getName() {
		return name;
	}
}
