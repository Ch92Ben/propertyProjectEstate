package com.fdmgroup.RealEstateApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fdmgroup.RealEstateApp.model.Bid;
import com.fdmgroup.RealEstateApp.model.User;

@Repository
public interface BidDao extends JpaRepository<Bid, Integer> {

	@Query("SELECT b FROM Bids b WHERE user = :user")
	List<Bid> getMyBid(@Param("user") User user);

	Bid findByBidAmount(@Param("bidAmount") double bidAmount);

	Bid findByBidId(@Param("bidId") int bidId);

}