package ptithcm.controller;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import ptithcm.entity.UserModel;

@Transactional
@Controller
@RequestMapping("lab7")
public class ValidationController {
	@RequestMapping("validate")
	public String index(ModelMap model,  @ModelAttribute("user") UserModel user) {
		model.addAttribute("user", new UserModel());
		return "lab7/Login";
	}
	
	@RequestMapping(value="validate2", method= RequestMethod.POST)
	public String index2(ModelMap model,
			@Validated  @ModelAttribute("user")  UserModel user, 
		HttpServletRequest request,
			BindingResult error,
			HttpServletResponse session) throws IOException {
		
//		String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
//		boolean verify = RecaptchaVerification.verify(gRecaptchaResponse);
		
//		if(user.getUsername() == null) {
//			error.rejectValue("username", "user", "username null!");
//		}
//		if(user.getPassword() == null) {
//			error.rejectValue("password", "student", "password null!");
//		}
		System.out.println(user.getPassword());
		System.out.println(user.getUsername() );
		if(error.hasErrors()) {
			
		
			return "lab7/Login";
		}else if(user.getPassword().equalsIgnoreCase("123456") && user.getUsername().equalsIgnoreCase("master")) {
			
			return "lab7/success";
		}else {
			model.addAttribute("user", new UserModel());
			model.addAttribute("messenge", "tên đăng nhập hoặc mật khẩu sai");
			return "lab7/Login";
		}
		
		
		
	}
}
