package ifrn.pi.eventos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventosController {
	
	@RequestMapping("/eventos/forms")
	public String forms() {
		return "formEvento";
	}
	
	
}
