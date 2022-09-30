package ifrn.pi.eventos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ifrn.pi.eventos.models.Evento;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EventosController {
	
	@RequestMapping("/eventos/forms")
	public String forms() {
		return "formEvento";
	}
	
	@PostMapping ("/eventos")
	public String Salvar(Evento evento) {
		
		System.out.println(evento);
		
		return "evento-salvado";
	}
	
}
