package com.fdmgroup.RealEstateApp;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fdmgroup.RealEstateApp.controller.BidController;
import com.fdmgroup.RealEstateApp.controller.HomeController;
import com.fdmgroup.RealEstateApp.controller.LoginController;
import com.fdmgroup.RealEstateApp.controller.PropertyController;
import com.fdmgroup.RealEstateApp.controller.RegisterController;
import com.fdmgroup.RealEstateApp.controller.UserController;

@SpringBootTest
public class ControllerTests {

	@Autowired
	private HomeController homeController;

	@Autowired
	private BidController bidController;

	@Autowired
	private LoginController loginController;

	@Autowired
	private PropertyController propertyController;

	@Autowired
	private RegisterController registerController;

	@Autowired
	private UserController userController;

	@Test
	public void HomeControllercontextLoads() throws Exception {
		assertThat(homeController).isNotNull();
	}

	@Test
	public void BidControllercontextLoads() throws Exception {
		assertThat(bidController).isNotNull();
	}

	@Test
	public void LoginControllercontextLoads() throws Exception {
		assertThat(loginController).isNotNull();
	}

	@Test
	public void PropertyControllercontextLoads() throws Exception {
		assertThat(propertyController).isNotNull();
	}

	@Test
	public void RegisterControllercontextLoads() throws Exception {
		assertThat(registerController).isNotNull();
	}

	@Test
	public void UserControllercontextLoads() throws Exception {
		assertThat(userController).isNotNull();
	}

}
