package com.fdmgroup.RealEstateApp;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.fdmgroup.RealEstateApp.model.AccountType;
import com.fdmgroup.RealEstateApp.model.Bid;
import com.fdmgroup.RealEstateApp.model.BidStatus;
import com.fdmgroup.RealEstateApp.model.User;
import com.fdmgroup.RealEstateApp.repository.BidDao;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BidTests {

	@Autowired
	private BidDao bidDao;

	private Date date = new Date();

	private User user;

	@Test
	void testCreateNewBid() {
		Bid bid = new Bid(250000, date, BidStatus.BID_PLACED, user);
		bidDao.save(bid);
		assertTrue(bid.getBidId() > 0);
	}

	@Test
	void testBidFindById() {
		Optional<Bid> bid = bidDao.findById(1);
		assertTrue(bid.get().getBidAmount() == 250000);
	}

	@Test
	void testSetBidStatus() {
		Optional<Bid> bid = bidDao.findById(1);
		bid.get().setBidStatus(BidStatus.BID_ACCEPTED);
		assertTrue(bid.get().getBidStatus().equals(BidStatus.BID_ACCEPTED));
	}

	@Test
	void testSetPropertyId() {
		Optional<Bid> bid = bidDao.findById(1);
		bid.get().setPropertyId(1);
		assertTrue(bid.get().getPropertyId() == 1);
	}

	@Test
	void testSetBidDate() {
		Optional<Bid> bid = bidDao.findById(1);
		bid.get().setBidDate(date);
		assertTrue(bid.get().getBidDate().equals(date));
	}

	@Test
	void testFindBidByBidAmount() {
		Bid bid = bidDao.findByBidAmount(250000);
		assertEquals(true, bid.getBidStatus().equals(BidStatus.BID_PLACED));
	}

	@Test
	void testAddUserForABid() {
		User user = new User("cojican", "zalau", "manitou", "mail", "pass", 1234, AccountType.ADMIN);
		Bid bid = new Bid();
		bid.setUser(user);
		assertEquals(true, bid.getUser().getUserName().equals("manitou"));
	}

	@Test
	void testFindAllBids() {
		assertTrue(bidDao.findAll().size() > 0);
	}

	@Test
	void testUpdateBid() {
		Optional<Bid> bid = bidDao.findById(1);
		bid.get().setBidAmount(180000);
		bidDao.save(bid.get());
		assertTrue(bid.get().getBidAmount() == 180000);
	}

	@Test
	void testBidDelete() {
		Bid bid = bidDao.findByBidId(1);
		bidDao.delete(bid);
		assertNull(bidDao.findByBidId(1));
	}

}
