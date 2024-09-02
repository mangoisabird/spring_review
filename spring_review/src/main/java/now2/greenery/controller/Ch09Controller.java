package now2.greenery.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import now2.greenery.dto.Ch08LoginForm;
import now2.greenery.dto.Ch08Member;

@Controller
@Slf4j
@RequestMapping("/ch09")
public class Ch09Controller {

	@GetMapping("fileUploadForm")
	public String fileUploadForm(Model model){
		model.addAttribute("chNum", "ch09");
		return "ch09/fileUploadForm";
	}
		
	
	@GetMapping("downloadFileList")
	public String downloadFileList(Model model){
		model.addAttribute("chNum", "ch09");
		return "ch09/downloadFileList";
	}
}