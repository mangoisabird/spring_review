package now2.greenery.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import now2.greenery.dto.Ch04LoginForm;
import now2.greenery.dto.Ch04LoginFormValidator;

@Controller
@Slf4j
@RequestMapping("/ch04")
public class Ch04Controller {
	
	@GetMapping("/loginForm")
	public String loginForm(Model model){
		model.addAttribute("chNum", "ch04");

		return "ch04/loginForm";
	}
	
	@InitBinder("ch04LoginForm")
	public void Ch04LoginFormValidator(WebDataBinder binder){
		binder.setValidator(new Ch04LoginFormValidator());
	}
	
	@PostMapping("/login")
	public String login(@Valid Ch04LoginForm loginForm, Errors errors){
		if(errors.hasErrors()) {
			log.info("유효성 검사 실패");
			return "ch04/loginForm";
		}
		
		log.info("유효성 검사 성공");
		log.info("mid: " + loginForm.getMid());
		log.info("mpassword: " + loginForm.getMpassword());
		return "redirect:/";
	}
	
	
}