package cl.desafio.sitio.protegido.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController {

	@GetMapping("/client")
	public ModelAndView homeClient() {
		ModelAndView modelAndView = new ModelAndView("client/client");
		return modelAndView;
	}
}
