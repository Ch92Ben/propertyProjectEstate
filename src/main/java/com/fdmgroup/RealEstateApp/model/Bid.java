package com.fdmgroup.RealEstateApp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity(name = "Bids")
public class Bid {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bids_gen")
	@SequenceGenerator(name = "bids_gen", sequenceName = "BIDS_SEQ", allocationSize = 1)
	private int bidId;
	@Column(nullable = false, unique = false, length = 80)
	private double bidAmount;
	@Column(nullable = false, unique = false, length = 80)
	private Date bidDate = new Date();
	@Enumerated(EnumType.STRING)
	private BidStatus bidStatus = BidStatus.BID_PLACED;
	@Column(nullable = false, unique = false, length = 80)
	private int propertyId;

	@OneToOne
	private User user;

	public Bid() {
		super();
	}

	public Bid(double bidAmount, Date bidDate, BidStatus bidStatus, User user) {
		super();
		this.bidAmount = bidAmount;
		this.bidDate = bidDate;
		this.bidStatus = bidStatus;
		this.user = user;
	}

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public int getBidId() {
		return bidId;
	}

	public double getBidAmount() {
		return bidAmount;
	}

	public void setBidAmount(double bidAmount) {
		this.bidAmount = bidAmount;
	}

	public Date getBidDate() {
		return bidDate;
	}

	public void setBidDate(Date bidDate) {
		this.bidDate = bidDate;
	}

	public BidStatus getBidStatus() {
		return bidStatus;
	}

	public void setBidStatus(BidStatus bidStatus) {
		this.bidStatus = bidStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
