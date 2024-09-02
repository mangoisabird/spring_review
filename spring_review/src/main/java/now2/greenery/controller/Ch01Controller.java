package now2.greenery.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class Ch01Controller {
	@RequestMapping("/ch01/content")
	public String content() {
		log.info("실행");
		return "ch01/content";
	}

}
