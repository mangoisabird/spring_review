package now2.greenery.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import now2.greenery.dto.Ch06Member;

@Controller
@Slf4j
@RequestMapping("/ch06")
public class Ch06Controller {
	
	@GetMapping("/forward")
	public String forward(Model model, HttpServletRequest request){
		Ch06Member member = new Ch06Member();
		
		member.setMid("user1");
		member.setMname("사용자1");
		member.setMemail("user1@mycompanycom");
		
		model.addAttribute("member1", member);
		request.setAttribute("member2", member);
		model.addAttribute("chNum", "ch06");

		return "ch06/forward";
	}

/*	
	@GetMapping("/redirect")
	public String redirect(Model model, HttpServletRequest request){
		Ch06Member member = new Ch06Member();
		
		member.setMid("user1");
		member.setMname("사용자1");
		member.setMemail("user1@mycompany.com");
		
		model.addAttribute("member1", member);
		request.setAttribute("member2", member);
		
		return "redirect:/ch06/sessionData";
	}
*/
	
	@GetMapping("/redirect")
	public String redirect(HttpSession session){
		Ch06Member member = new Ch06Member();
		
		member.setMid("user1");
		member.setMname("사용자1");
		member.setMemail("user1@mycompany.com");
		
		session.setAttribute("member", member);
		
		return "redirect:/ch06/sessionData";
	}	
	
	
	@GetMapping("/sessionData")
	public String sessionData(HttpSession session, Model model){
		Ch06Member member = (Ch06Member)session.getAttribute("member");
		log.info(member.toString());
		
		log.info("mid: " + member.getMid());
		log.info("mname: " + member.getMname());
		log.info("memail: " + member.getMemail());
		model.addAttribute("chNum", "ch06");

		return "ch06/sessionData";
	}
	
}