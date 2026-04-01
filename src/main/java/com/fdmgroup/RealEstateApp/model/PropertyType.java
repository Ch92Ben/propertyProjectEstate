package com.fdmgroup.RealEstateApp.model;

public enum PropertyType {
	FLAT("Flat"), TERRACED_HOUSE("Terraced house"), DETACHED_HOUSE("Detached house"),
	SEMI_DETACHED_HOUSE("Semi detached house");

	private String name;

	private PropertyType(String type) {
		name = type;
	}

	public String getName() {
		return name;
	}
}
