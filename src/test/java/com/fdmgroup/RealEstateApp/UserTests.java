package com.fdmgroup.RealEstateApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.fdmgroup.RealEstateApp.model.AccountStatus;
import com.fdmgroup.RealEstateApp.model.AccountType;
import com.fdmgroup.RealEstateApp.model.User;
import com.fdmgroup.RealEstateApp.repository.UserDao;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserTests {

	@Autowired
	private UserDao userDao;

	@Test
	void testCreateNewUser() {
		User user = new User("username", "email", "password", "firstName", "lastName", 123, AccountType.ADMIN);
		userDao.save(user);
		assertTrue(user.getUserId() > 0);
	}

	@Test
	void testGetByLastName() {
		User user = new User("cojican", "zalau", "manitou", "mail", "pass", 1234, AccountType.ADMIN);
		userDao.save(user);
		assertEquals(true, user.getLastName().equals("zalau"));
	}

	@Test
	void testCheckPhoneNumberSetCorrectly() {
		User user = new User("cojican", "zalau", "manitou", "mail", "pass", 1234, AccountType.ADMIN);
		userDao.save(user);
		assertTrue(user.getPhoneNumber() == 1234);
	}

	@Test
	void testCheckAccountTypeInitialised() {
		User user = new User("cojican", "zalau", "manitou", "mail", "pass", 1234, AccountType.ESTATEAGENT);
		userDao.save(user);
		assertEquals(true, user.getAccountType().equals(AccountType.ESTATEAGENT));
	}

	@Test
	void testUserFindById() {
		Optional<User> user = userDao.findById(1);
		assertEquals(true, user.get().getUserName().equals("david"));
	}

	@Test
	void testUserSetAccountStatus() {
		Optional<User> user = userDao.findById(1);
		user.get().setAccountStatus(AccountStatus.ACTIVE);
		assertEquals(true, user.get().getAccountStatus().equals(AccountStatus.ACTIVE));
	}

	@Test
	void testUserSetAccountType() {
		Optional<User> user = userDao.findById(1);
		user.get().setAccountType(AccountType.SELLER);
		assertEquals(true, user.get().getAccountType().equals(AccountType.SELLER));
	}

	@Test
	void testUserSetEmail() {
		Optional<User> user = userDao.findById(1);
		user.get().setEmail("ben@252.com");
		assertEquals(true, user.get().getEmail().equals("ben@252.com"));
	}

	@Test
	void testUserSetFirstName() {
		Optional<User> user = userDao.findById(1);
		user.get().setFirstName("crina");
		assertEquals(true, user.get().getFirstName().equals("crina"));
	}

	@Test
	void testUserSetLastName() {
		Optional<User> user = userDao.findById(1);
		user.get().setLastName("kina");
		assertEquals(true, user.get().getLastName().equals("kina"));
	}

	@Test
	void testUserSetPhoneNumber() {
		Optional<User> user = userDao.findById(1);
		user.get().setPhoneNumber(1234);
		assertTrue(user.get().getPhoneNumber() == 1234);
	}

	@Test
	void testFindUserByEmail() {
		User user = userDao.findByEmail("zen_9255@yahoo.com");
		assertEquals(true, user.getUserName().equals("david"));
	}

	@Test
	void testFindUserByUsername() {
		User user = userDao.findByUserName("hassan");
		assertEquals(true, user.getPassword().equals("ten"));
	}

	@Test
	void testSetUserByUsername() {
		Optional<User> user = userDao.findById(2);
		user.get().setUserName("kuna");
		assertEquals(true, user.get().getUserName().equals("kuna"));
	}

	@Test
	void testFindAllUsers() {
		assertTrue(userDao.findAll().size() > 0);
	}

	@Test
	void testFindByUsernameAndPassword() {
		User user = userDao.findByUserNameAndPassword("ben", "ten");
		assertEquals(true, user.getEmail().equals("ken_9255@yahoo.com"));
	}

	@Test
	void testCreateByUsernameAndPassword() {
		User user = new User("gina", "tina");
		assertEquals(true, user.getUserName().equals("gina"));
	}

	@Test
	void testUpdateUser() {
		User user = userDao.findByUserName("hassan");
		user.setPassword("zen");
		userDao.save(user);
		assertEquals(true, userDao.findByUserName("hassan").getPassword().equals("zen"));
	}

	@Test
	void testUserDelete() {
		User user = userDao.findByUserName("ana");
		userDao.delete(user);
		assertNull(userDao.findByUserName("ana"));
	}

}
