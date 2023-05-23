package com.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reservation.entity.User;
import com.reservation.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepo;
	@RequestMapping("/showRegistration")
    public String showReg() {
		return"showReg";
	}
	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("user") User user) {
		userRepo.save(user);
		return"login_id";
	}
	@RequestMapping("/showLoginPage")
		public String showLoginPageDetails() {
		return"login_id";
	}
	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("emailId") String emailId,@RequestParam("password") String password, ModelMap modelMap) {
		User user=userRepo.findByEmail(emailId);
		if(user!=null) {
			if(user.getEmail().equals(emailId)&&user.getPassword().equals(password)) {
				return "findflights";
			}else {
				modelMap.addAttribute("error", "invalid username/password");
				return"login_id";
			}
		}else {
			modelMap.addAttribute("error", "invalid username/password");
			return"login_id";
			
		}
	}
}
