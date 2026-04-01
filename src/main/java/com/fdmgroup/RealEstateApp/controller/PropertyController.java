package com.fdmgroup.RealEstateApp.controller;

import java.util.EnumSet;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fdmgroup.RealEstateApp.model.AccountStatus;
import com.fdmgroup.RealEstateApp.model.AccountType;
import com.fdmgroup.RealEstateApp.model.Property;
import com.fdmgroup.RealEstateApp.model.PropertyType;
import com.fdmgroup.RealEstateApp.model.User;
import com.fdmgroup.RealEstateApp.repository.PropertyDao;
import com.fdmgroup.RealEstateApp.repository.UserDao;

@Controller
public class PropertyController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private PropertyDao propertyDao;

	@RequestMapping("AllProperties")
	public ModelAndView AllProperties() {

		return new ModelAndView("WEB-INF/allProperties.jsp", "properties", propertyDao.findAll());
	}

	@RequestMapping("AllPropertiesAgent")
	public ModelAndView AllPropertiesAgent() {

		return new ModelAndView("WEB-INF/allPropertiesAgent.jsp", "properties", propertyDao.findAll());
	}

	@RequestMapping("AllPropertiesBuyer")
	public ModelAndView AllPropertiesBuyer() {

		return new ModelAndView("WEB-INF/allPropertiesBuyer.jsp", "properties", propertyDao.findAll());
	}

	@RequestMapping("AllPropertiesSeller")
	public ModelAndView AllPropertiesSeller(HttpSession session) {
		int userId = (int) session.getAttribute(LoginController.USER_ID);
		Optional<User> user = userDao.findById(userId);
		return new ModelAndView("WEB-INF/allPropertiesSeller.jsp", "propertyDetails",
				propertyDao.getMyProperties(user.get()));
	}

	@RequestMapping("AddProperty")
	public String addProperty(Model model) {
		model.addAttribute("propertyTypes", EnumSet.allOf(PropertyType.class));
		model.addAttribute("property", new Property());
		model.addAttribute("allPropertiesAgent", propertyDao.findAll());
		model.addAttribute("user", new User());
		model.addAttribute("allUsers", userDao.findAll());
		model.addAttribute("allSellers", userDao.getAllSellers());
		return "WEB-INF/addProperty.jsp";

	}

	@GetMapping("EditProperty")
	public ModelAndView EditProperty(@RequestParam("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		Optional<Property> property = propertyDao.findById(id);

			modelAndView.addAllObjects(getMapDataForAddAndEditProperty());
			modelAndView.addObject("property", property.get());
			modelAndView.setViewName("WEB-INF/editProperty.jsp");

		return modelAndView;
	}

	@PostMapping("AddPropertySubmit")
	public ModelAndView addPropertySubmit(@ModelAttribute("property") Property property) {
		
		propertyDao.save(property);

		return new ModelAndView("WEB-INF/allPropertiesAgent.jsp", "properties", propertyDao.findAll());
	}

	@GetMapping("DeleteProperty")
	public ModelAndView DeleteProperty(@RequestParam("id") int id) {

		
			propertyDao.deleteById(id);


		return new ModelAndView("WEB-INF/allPropertiesAgent.jsp", "properties", propertyDao.findAll());
	}

	@PostMapping("EditPropertySubmit")
	public ModelAndView editPropertySubmit(@ModelAttribute("property") Property property) {

		propertyDao.save(property);

		return new ModelAndView("WEB-INF/allPropertiesAgent.jsp", "properties", propertyDao.findAll());
	}

	private ModelMap getMapDataForAddAndEditProperty() {
		ModelMap map = new ModelMap();
		map.addAttribute("propertyTypes", EnumSet.allOf(PropertyType.class));
		map.addAttribute("allPropertiesAgent", propertyDao.findAll());
		return map;
	}

}
