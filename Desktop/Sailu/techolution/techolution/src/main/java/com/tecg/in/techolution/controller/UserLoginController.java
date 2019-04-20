package com.tecg.in.techolution.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tecg.in.techolution.domain.UserEntity;
import com.tecg.in.techolution.repo.UserRepository;
 
@Controller
public class UserLoginController {

	Logger logger = LoggerFactory.getLogger(UserLoginController.class);

	@Autowired
	UserRepository userRepository;

	@GetMapping("/")
	public String loginPage(Model model) {
		logger.info(" Hi login page ");

		return "UI/loginUser/loginPage";
	}

	@PostMapping("/login")
	public String getUser(@RequestParam("userName")String userName,@RequestParam("password") String password, Model model,HttpServletRequest httpServletRequest) {
		try {
			logger.info("REST request to get userName User : {}", userName);
			logger.info("REST request to get password User : {}", password);
			/*
			 * if(bindingresult.hasErrors()) { model.addAttribute("msg",
			 * "invalid credentials"); return "UI/loginUser/loginPage"; }
			 */
			
			
			UserEntity user = userRepository.getUserByLogin(userName);
			if(user!=null && user.getId()!=null ) {
				httpServletRequest.getSession().setAttribute("userDetails", user);
				model.addAttribute("userDetails", userName);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "UI/loginUser/DashBoardPage";
	}
	
	@GetMapping("/addExpensive")
	public String addExpensive() {
		try {
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "UI/loginUser/addExpensive";
	}
	
	@PostMapping("/addExpensive")
	public String addExpensive(@RequestParam("expenive") String expenive,Model model, HttpServletRequest httpServletRequest) {
		try {
			UserEntity user= (UserEntity)httpServletRequest.getSession().getAttribute("userDetails");
			logger.info("user  =   {} ",user);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "UI/loginUser/addExpensive";
	}
	
	
}
