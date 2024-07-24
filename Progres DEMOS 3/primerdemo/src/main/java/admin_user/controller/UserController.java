package admin_user.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import admin_user.dto.UserDto;
import admin_user.model.ReCaptchaResponse;
import admin_user.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
		return "register";
	}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model, @RequestParam(name="g-recaptcha-response") String captchaResponse) {
		
		String url = "https://www.google.com/recaptcha/api/siteverify";
		String params = "?secret=6LcWieQpAAAAALydVaFlqoaRTnIX5SN2o_7VV9Mr&response="+captchaResponse;
		
		ReCaptchaResponse reCaptchaResponse = restTemplate.exchange(url+params, HttpMethod.POST, null, ReCaptchaResponse.class).getBody();
		if(reCaptchaResponse.isSuccess()) {
			userService.save(userDto);
			model.addAttribute("message", "Registered Successfuly");
			return "register";
		} else {
			model.addAttribute("message", "Please verify captcha");
			return "register";

		}
		

	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("admin-page")
	public String adminPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "admin";
	}
	
	@GetMapping("user-page")
	public String userPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "user";
	}
	
}
