package com.fdmgroup.RealEstateApp.controller;

import java.util.EnumSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fdmgroup.RealEstateApp.model.AccountStatus;
import com.fdmgroup.RealEstateApp.model.AccountType;
import com.fdmgroup.RealEstateApp.model.User;
import com.fdmgroup.RealEstateApp.repository.UserDao;

@Controller

public class RegisterController {

	@Autowired
	private UserDao userDao;

	@RequestMapping("Register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("allUsers", userDao.findAll());
		model.addAttribute("accountTypes", EnumSet.allOf(AccountType.class));
		model.addAttribute("accountStatuses", EnumSet.allOf(AccountStatus.class));
		return "register.jsp";
	}

	@PostMapping("RegisterSubmit")
	public String registerSubmit(@ModelAttribute("user") User user, Model model) {

		User userFromDatabase = userDao.findByUserName(user.getUserName());
		if (userFromDatabase != null) {
			model.addAttribute("message", "This user name already exists");
			return "register.jsp";
		}
		userDao.save(user);

		return "login.jsp";
	}
}
