package com.fdmgroup.RealEstateApp.controller;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.fdmgroup.RealEstateApp.model.Bid;
import com.fdmgroup.RealEstateApp.model.BidStatus;
import com.fdmgroup.RealEstateApp.model.Property;
import com.fdmgroup.RealEstateApp.model.TransactionStatus;
import com.fdmgroup.RealEstateApp.model.User;
import com.fdmgroup.RealEstateApp.repository.BidDao;
import com.fdmgroup.RealEstateApp.repository.PropertyDao;
import com.fdmgroup.RealEstateApp.repository.UserDao;

@Controller
public class BidController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private BidDao bidDao;

	@Autowired
	private PropertyDao propertyDao;

	@ModelAttribute("Bids")
	public Bid construct() {
		return new Bid();
	}

	@GetMapping("AcceptOffer")
	public ModelAndView AcceptOffer(@RequestParam("id") int id) {
		ModelAndView modelAndView = new ModelAndView();
		Optional<Property> property = propertyDao.findById(id);
		if (property.get().getCurrentBid() == 0.0) {
			modelAndView.addObject("errorMessage", "There are no bids on your property yet!");
			modelAndView.setViewName("WEB-INF/allPropertiesSeller.jsp");
			return modelAndView;
		}
		property.get().setTransactionStatus(TransactionStatus.SOLD);
		propertyDao.save(property.get());
		List<Bid> bidList = property.get().getBids();
		Bid propertyBid = bidList.get(0);
		propertyBid.setBidStatus(BidStatus.BID_ACCEPTED);
		bidDao.save(propertyBid);
		modelAndView.setViewName("WEB-INF/propertySold.jsp");

		return modelAndView;
	}

	@RequestMapping("AllBidsBuyer")
	public ModelAndView AllBidsBuyer(HttpSession session) {
		int userId = (int) session.getAttribute(LoginController.USER_ID);
		Optional<User> user = userDao.findById(userId);
		return new ModelAndView("WEB-INF/allBidsBuyer.jsp", "bids", bidDao.getMyBid(user.get()));
	}

	@RequestMapping("SignPaperworkBuyer")
	public ModelAndView SignPaperworkBuyer(@RequestParam("id") int id, HttpSession session) {
		int userId = (int) session.getAttribute(LoginController.USER_ID);
		Optional<User> user = userDao.findById(userId);
		ModelAndView modelAndView = new ModelAndView();
		Optional<Bid> bid = bidDao.findById(id);
		modelAndView.addObject("bid", bid.get());
		if (bid.get().getBidStatus().equals(BidStatus.BID_PLACED)) {
			modelAndView.addObject("errorMessage", "Your bid has not been accepted yet!");
			modelAndView.addObject("bids", bidDao.getMyBid(user.get()));
			modelAndView.setViewName("WEB-INF/allBidsBuyer.jsp");
			return modelAndView;
		} else {
			modelAndView.setViewName("WEB-INF/signPaperworkBuyer.jsp");
			return modelAndView;
		}
	}

	@RequestMapping("AddBid")
	public String addBid(@ModelAttribute("bid") Bid bid, Model model, @RequestParam("id") int id) {
		model.addAttribute("allPropertiesBuyer", propertyDao.findAll());
		model.addAttribute("property", propertyDao.findById(id).get());
		return "WEB-INF/addBid.jsp";
	}

	@PostMapping("AddBidSubmit")
	public ModelAndView addBidSubmit(@ModelAttribute("bid") Bid bid, HttpSession session, @RequestParam("id") int id) {
		int userId = (int) session.getAttribute(LoginController.USER_ID);
		Optional<User> user = userDao.findById(userId);
		if (user.isEmpty()) {
			ModelAndView modelAndView = new ModelAndView("WEB-INF/addBid.jsp");
			modelAndView.addObject("allPropertiesBuyer", propertyDao.findAll());
			modelAndView.addObject("property", propertyDao.findById(id));
			modelAndView.addObject("errorMessage", "User not found");
			return modelAndView;
		}
		Optional<Property> property = propertyDao.findById(id);
		if (property.get().getTransactionStatus() == TransactionStatus.SOLD) {
			ModelAndView modelAndView = new ModelAndView("WEB-INF/addBid.jsp");
			modelAndView.addObject("allPropertiesBuyer", propertyDao.findAll());
			modelAndView.addObject("property", propertyDao.findById(id).get());
			modelAndView.addObject("errorMessage", "Sorry, this property is no longer available!");
			return modelAndView;
		} else if (bid.getBidAmount() <= property.get().getCurrentBid()
				|| bid.getBidAmount() <= property.get().getSellingPrice()) {

			ModelAndView modelAndView = new ModelAndView("WEB-INF/addBid.jsp");
			modelAndView.addObject("allPropertiesBuyer", propertyDao.findAll());
			modelAndView.addObject("property", propertyDao.findById(id).get());
			modelAndView.addObject("errorMessage", "Please enter a higher bid!");
			return modelAndView;
		}
		bid.setPropertyId(id);
		bid.setUser(user.get());
		bidDao.save(bid);
		property.get().addBid(bid);
		property.get().setCurrentBid(bid.getBidAmount());
		propertyDao.save(property.get());
		return new ModelAndView("WEB-INF/allPropertiesBuyer.jsp", "properties", propertyDao.findAll());
	}
}