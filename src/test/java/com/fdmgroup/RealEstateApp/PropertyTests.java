package com.fdmgroup.RealEstateApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.fdmgroup.RealEstateApp.model.AccountType;
import com.fdmgroup.RealEstateApp.model.Bid;
import com.fdmgroup.RealEstateApp.model.Property;
import com.fdmgroup.RealEstateApp.model.PropertyType;
import com.fdmgroup.RealEstateApp.model.TransactionStatus;
import com.fdmgroup.RealEstateApp.model.User;
import com.fdmgroup.RealEstateApp.repository.BidDao;
import com.fdmgroup.RealEstateApp.repository.PropertyDao;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class PropertyTests {

	@Autowired
	private PropertyDao propertyDao;

	@Autowired
	private BidDao bidDao;

	@Test
	void testCreateNewProperty() {
		Property property = new Property("Edinburgh", "2 Bed flat", 2, 195.5, PropertyType.FLAT, 186000, 0.0);
		propertyDao.save(property);
		assertTrue(property.getPropertyId() > 0);
	}

	@Test
	void testPropertyFindById() {
		Optional<Property> property = propertyDao.findById(1);
		assertTrue(property.get().getPropertyId() == 1);
	}

	@Test
	void testFindByPropertyAddress() {
		Property property = propertyDao.findByPropertyAddress("Edinburgh");
		assertEquals(true, property.getPropertyAddress().equals("Edinburgh"));
	}

	@Test
	void testGetPropertyType() {
		Property property = new Property("Edinburgh", "2 Bed flat", 2, 195.5, PropertyType.TERRACED_HOUSE, 186000, 0.0);
		assertEquals(true, property.getPropertyType().equals(PropertyType.TERRACED_HOUSE));
	}

	@Test
	void testGetPropertySize() {
		Property property = new Property("Edinburgh", "2 Bed flat", 2, 195.5, PropertyType.TERRACED_HOUSE, 186000, 0.0);
		assertTrue(property.getPropertySize() == 195.5);
	}

	@Test
	void testPropertyAddBids() {
		Bid bid = bidDao.findByBidId(1);
		Property property = new Property();
		property.addBid(bid);
		assertTrue(property.getBids().size() > 0);
	}

	@Test
	void testFindAllProperties() {
		assertTrue(propertyDao.findAll().size() > 0);
	}

	@Test
	void testUpdatePropertyDescription() {
		Property property = propertyDao.findByPropertyId(1);
		property.setPropertyDescription("5 Bedroom Villa");
		propertyDao.save(property);
		assertEquals(true, propertyDao.findByPropertyId(1).getPropertyDescription().equals("5 Bedroom Villa"));
	}

	@Test
	void testUpdatePropertyCurrentBid() {
		Property property = propertyDao.findByPropertyId(1);
		property.setCurrentBid(250000);
		propertyDao.save(property);
		assertTrue(property.getCurrentBid() == 250000);
	}

	@Test
	void testUpdatePropertySellingPrice() {
		Property property = propertyDao.findByPropertyId(1);
		property.setSellingPrice(185000);
		propertyDao.save(property);
		assertTrue(property.getSellingPrice() == 185000);
	}

	@Test
	void testUpdatePropertyNumberOfRooms() {
		Property property = propertyDao.findByPropertyId(1);
		property.setNumberOfRooms(5);
		propertyDao.save(property);
		assertTrue(property.getNumberOfRooms() == 5);
	}

	@Test
	void testUpdatePropertyTransactionStatus() {
		Property property = propertyDao.findByPropertyId(1);
		property.setTransactionStatus(TransactionStatus.SOLD);
		propertyDao.save(property);
		assertEquals(true, propertyDao.findByPropertyId(1).getTransactionStatus().equals(TransactionStatus.SOLD));
	}

	@Test
	void testUpdatePropertyType() {
		Property property = propertyDao.findByPropertyId(1);
		property.setPropertyType(PropertyType.FLAT);
		propertyDao.save(property);
		assertEquals(true, propertyDao.findByPropertyId(1).getPropertyType().equals(PropertyType.FLAT));
	}

	@Test
	void testUpdatePropertySeller() {
		User user = new User("cojican", "zalau", "manitou", "mail", "pass", 1234, AccountType.ADMIN);
		Property property = propertyDao.findByPropertyId(1);
		property.setSeller(user);
		propertyDao.save(property);
		assertEquals(true, propertyDao.findByPropertyId(1).getSeller().getEmail().equals("mail"));
	}

	@Test
	void testUpdatePropertySize() {
		Property property = propertyDao.findByPropertyId(1);
		property.setPropertySize(195);
		propertyDao.save(property);
		assertTrue(property.getPropertySize() == 195);
	}

	@Test
	void testUpdateProperty() {
		Property property = propertyDao.findByPropertyId(1);
		property.setPropertyAddress("Glasgow");
		propertyDao.save(property);
		assertEquals(true, propertyDao.findByPropertyId(1).getPropertyAddress().equals("Glasgow"));
	}

	@Test
	void testPropertyDelete() {
		Property property = propertyDao.findByPropertyId(1);
		propertyDao.delete(property);
		assertNull(propertyDao.findByPropertyId(1));
	}

}
