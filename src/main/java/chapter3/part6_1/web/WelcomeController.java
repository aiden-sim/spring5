package chapter3.part6_1.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
@RequestMapping("/")
public class WelcomeController {

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Model model) {
		Date today = new Date();
		model.addAttribute("today", today);

		return "welcome";
	}

	@RequestMapping(value = "/welcomeRedirect", method = RequestMethod.GET)
	public String welcomeRedirect(Model model) {
		return "welcomeRedirect";
	}
}