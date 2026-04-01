package com.fdmgroup.RealEstateApp.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "properties_gen")
	@SequenceGenerator(name = "properties_gen", sequenceName = "PROPERTIES_SEQ", allocationSize = 1)
	private int propertyId;

	@Column(nullable = false, length = 80)
	private String propertyAddress;
	@Column(nullable = false, length = 80)
	private String propertyDescription;
	@Column(nullable = false, length = 80)
	private int numberOfRooms;
	@Column(nullable = false, length = 80)
	private double propertySize;
	@Enumerated(EnumType.STRING)
	private PropertyType propertyType;
	@Column(nullable = false, length = 80)
	private double sellingPrice;
	@Column(nullable = false, length = 80)
	private double currentBid = 0.0;

	@OneToOne(cascade = CascadeType.ALL, targetEntity = User.class)
	private User seller;

	@Enumerated(EnumType.STRING)
	private TransactionStatus transactionStatus = TransactionStatus.FOR_SALE;

	@OneToMany(cascade = CascadeType.ALL, targetEntity = Bid.class)
	private List<Bid> bids = new ArrayList<Bid>();

	
	public Property() {
		super();
	}

	public Property(String propertyAddress, String propertyDescription, int numberOfRooms, double propertySize,
			PropertyType propertyType, double sellingPrice, double currentBid) {
		super();
		this.propertyAddress = propertyAddress;
		this.propertyDescription = propertyDescription;
		this.numberOfRooms = numberOfRooms;
		this.propertySize = propertySize;
		this.propertyType = propertyType;
		this.sellingPrice = sellingPrice;
		this.transactionStatus = TransactionStatus.FOR_SALE;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public double getCurrentBid() {
		return currentBid;
	}

	public void setCurrentBid(double currentBid) {
		this.currentBid = currentBid;
	}

	public TransactionStatus getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(TransactionStatus transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public String getPropertyDescription() {
		return propertyDescription;
	}

	public void setPropertyDescription(String propertyDescription) {
		this.propertyDescription = propertyDescription;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public double getPropertySize() {
		return propertySize;
	}

	public void setPropertySize(double propertySize) {
		this.propertySize = propertySize;
	}

	public PropertyType getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(PropertyType propertyType) {
		this.propertyType = propertyType;
	}

	public double getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public List<Bid> getBids() {
		return bids;
	}

	public void addBid(Bid bid) {
		bids.add(bid);
	}

}
