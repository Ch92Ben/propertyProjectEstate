package com.fdmgroup.RealEstateApp.model;

public enum AccountStatus {
	ACTIVE("Active"), INACTIVE("Inactive");

	private String name;

	private AccountStatus(String type) {
		name = type;
	}

	public String getName() {
		return name;
	}
}
