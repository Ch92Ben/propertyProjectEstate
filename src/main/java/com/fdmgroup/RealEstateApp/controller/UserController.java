package com.fdmgroup.RealEstateApp.controller;

import java.util.EnumSet;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.RealEstateApp.model.AccountStatus;
import com.fdmgroup.RealEstateApp.model.AccountType;
import com.fdmgroup.RealEstateApp.model.User;
import com.fdmgroup.RealEstateApp.repository.UserDao;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@GetMapping("AllUsers")
	public ModelAndView allUsers() {
		return new ModelAndView("WEB-INF/allUsers.jsp", "users", userDao.findAll());
	}

	@GetMapping("EditUser")
	public ModelAndView EditUser(@RequestParam("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		Optional<User> user = userDao.findById(id);

		modelAndView.addAllObjects(getMapDataForAddAndEditUser());
		modelAndView.addObject("user", user.get());
		modelAndView.setViewName("WEB-INF/editUser.jsp");

		return modelAndView;
	}

	@GetMapping("DeleteUser")
	public ModelAndView DeleteUser(@RequestParam("id") int id) {
		userDao.deleteById(id);

		return new ModelAndView("WEB-INF/allUsers.jsp", "users", userDao.findAll());
	}

	private ModelMap getMapDataForAddAndEditUser() {
		ModelMap map = new ModelMap();
		map.addAttribute("accountStatuses", EnumSet.allOf(AccountStatus.class));
		map.addAttribute("accountTypes", EnumSet.allOf(AccountType.class));
		map.addAttribute("allUsers", userDao.findAll());
		return map;
	}

	@PostMapping("EditUserSubmit")
	public ModelAndView editUserSubmit(@ModelAttribute("user") User user) {

		userDao.save(user);
		
		return new ModelAndView("WEB-INF/allUsers.jsp", "users", userDao.findAll());
	}

	@GetMapping("UserProfile")
	public ModelAndView login(HttpSession session) {
		int userId = (int) session.getAttribute(LoginController.USER_ID);
		Optional<User> currentUser = userDao.findById(userId);
		if (currentUser.isEmpty()) {
			return new ModelAndView("errorPage.jsp", "error", "The selected user does not exist");
		}

		return new ModelAndView("WEB-INF/userProfile.jsp", "user", currentUser.get());
	}

	@GetMapping("EstateAgentProfile")
	public ModelAndView loginAgent(HttpSession session) {
		int userId = (int) session.getAttribute(LoginController.USER_ID);
		Optional<User> currentUser = userDao.findById(userId);
		if (currentUser.isEmpty()) {
			return new ModelAndView("errorPage.jsp", "error", "The selected user does not exist");
		}
		return new ModelAndView("WEB-INF/estateAgentProfile.jsp", "user", currentUser.get());
	}

	@GetMapping("BuyerProfile")
	public ModelAndView loginBuyer(HttpSession session) {
		int userId = (int) session.getAttribute(LoginController.USER_ID);
		Optional<User> currentUser = userDao.findById(userId);
		if (currentUser.isEmpty()) {
			return new ModelAndView("errorPage.jsp", "error", "The selected user does not exist");
		}
		return new ModelAndView("WEB-INF/buyerProfile.jsp", "user", currentUser.get());
	}

	@GetMapping("SellerProfile")
	public ModelAndView loginSeller(HttpSession session) {
		int userId = (int) session.getAttribute(LoginController.USER_ID);
		Optional<User> currentUser = userDao.findById(userId);
		if (currentUser.isEmpty()) {
			return new ModelAndView("errorPage.jsp", "error", "The selected user does not exist");
		}
		return new ModelAndView("WEB-INF/sellerProfile.jsp", "user", currentUser.get());
	}
}
