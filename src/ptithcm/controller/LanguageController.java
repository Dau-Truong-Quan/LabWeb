package ptithcm.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

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
@RequestMapping("lab8")
public class LanguageController {
	@RequestMapping("index")
	public String index(ModelMap model,  @ModelAttribute("user") UserModel user) {
		model.addAttribute("user", new UserModel());
		return "lab8/index";
	}
	
	@RequestMapping(value="validate2", method= RequestMethod.POST)
	public String index2(ModelMap model,
			@Validated  @ModelAttribute("user")  UserModel user, 
		HttpServletRequest request,
			BindingResult error,
			HttpSession session) throws IOException {
		
		String captcha = session.getAttribute("captcha_security").toString();
		String verifyCaptcha = request.getParameter("captcha");

		boolean verify = false;

		if (captcha.equals(verifyCaptcha)) {

			verify = true;
		} else {
			verify = false;
		}

		if (!verify) {

			model.addAttribute("reCaptra", "Vui lòng nhập đúng Captra");
			return "lab8/index";
		} 
		System.out.println(user.getPassword());
		System.out.println(user.getUsername() );
		if(error.hasErrors()) {
			
		
			return "lab8/index";
		}else if(user.getPassword().equalsIgnoreCase("123456") && user.getUsername().equalsIgnoreCase("master")) {
			
			return "lab8/success";
		}else {
			model.addAttribute("user", new UserModel());
			model.addAttribute("messenge", "tên đăng nhập hoặc mật khẩu sai");
			return "lab8/index";
		}
		
		
		
	}
}
