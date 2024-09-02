package now2.greenery.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/ch05")
public class Ch05Controller {
	
	@GetMapping("/header")
	public String header(
			@RequestHeader("User-Agent") String userAgent,
			HttpServletRequest request,
			Model model
			){
		log.info("userAgent: " + userAgent);
		
		userAgent = request.getHeader("User-Agent");
		
		String browser = null;
		if(userAgent.contains("Edg")){
			browser = "Edg";
		} else if (userAgent.contains("Chrome")){
			browser = "Chrome";
		}
		
		model.addAttribute("browser", browser);
		
		String clientIp = request.getRemoteAddr();
		log.info("clientIp: " + clientIp);
		model.addAttribute("clientIp", clientIp);
		model.addAttribute("chNum", "ch05");

		return "ch05/header";
	}
	
	@GetMapping("/createCookie")
	public String createCookie(HttpServletResponse response){
		Cookie cookie1 = new Cookie("mid", "user1");
		
		Cookie cookie2 = new Cookie("memail", "user1@mycompany.com");
		
		response.addCookie(cookie1);
		response.addCookie(cookie2);

		return "redirect:/";
	}
	
	@GetMapping("/readCookie")
	public String readCookie(
			@CookieValue("mid") String mid,
			@CookieValue("memail") String memail,
			Model model
			){
		
		log.info("mid: " + mid);
		log.info("memail: " + memail);
		
		model.addAttribute("mid", mid);
		model.addAttribute("memail", memail);
		model.addAttribute("chNum", "ch05");

 		return "ch05/readCookie";
	}
	
}