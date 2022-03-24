package cl.desafio.sitio.protegido.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@GetMapping("/index")
	public ModelAndView indexPage() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

}
