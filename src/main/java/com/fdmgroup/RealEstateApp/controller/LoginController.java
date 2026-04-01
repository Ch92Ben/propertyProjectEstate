package com.fdmgroup.RealEstateApp.controller;

import java.time.ZonedDateTime;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.fdmgroup.RealEstateApp.model.AccountStatus;
import com.fdmgroup.RealEstateApp.model.AccountType;
import com.fdmgroup.RealEstateApp.model.User;
import com.fdmgroup.RealEstateApp.repository.UserDao;

@Controller
public class LoginController {

	public static final String USER_ID = "USER_ID";
	private static Logger logger = LogManager.getLogger(LoginController.class);

	@Autowired
	private UserDao userDao;

	@RequestMapping("Login")
	public ModelAndView login() {
		return new ModelAndView("login.jsp", "user", new User());
	}

	@PostMapping("LoginSubmit")
	public String loginSubmit(@ModelAttribute("user") User user, Model model, HttpSession session) {

		User userFromDatabase = userDao.findByUserNameAndPassword(user.getUserName(), user.getPassword());
		if (userFromDatabase == null) {
			model.addAttribute("message", "Incorrect user name or password");
			return "login.jsp";
		}
		session.setAttribute(USER_ID, userFromDatabase.getUserId());
		model.addAttribute("user", userFromDatabase);

		if (userFromDatabase.getAccountStatus().getName() == AccountStatus.INACTIVE.getName()) {
			return "WEB-INF/inactiveAccount.jsp";
		} else {
			if (userFromDatabase.getAccountType().getName() == AccountType.SELLER.getName()) {
				return "WEB-INF/seller.jsp";
			} else if (userFromDatabase.getAccountType().getName() == AccountType.BUYER.getName()) {
				return "WEB-INF/buyer.jsp";
			} else if (userFromDatabase.getAccountType().getName() == AccountType.ESTATEAGENT.getName()) {
				return "WEB-INF/estateAgent.jsp";
			} else if (userFromDatabase.getAccountType().getName() == AccountType.ADMIN.getName()) {
				return "WEB-INF/admin.jsp";
			}
		}
		return "WEB-INF/index.jsp";
	}

	@RequestMapping("/Logout")
	public ModelAndView logout(HttpSession session) {
		Object idFromSession = session.getAttribute(LoginController.USER_ID);
		if (idFromSession != null) {
			int userId = (int) session.getAttribute(LoginController.USER_ID);
			logger.warn("User {} logged out at {}", userDao.findById(userId).get().getUserName(), ZonedDateTime.now());
		}
		session.invalidate();
		return new ModelAndView("login.jsp", "user", new User());
	}
}
