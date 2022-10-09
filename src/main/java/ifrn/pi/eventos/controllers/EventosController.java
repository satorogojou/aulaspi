package ifrn.pi.eventos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ifrn.pi.eventos.models.Evento;
import ifrn.pi.eventos.repositories.EventoRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/eventos")
public class EventosController {

	@Autowired
	private EventoRepository er;

	@GetMapping("/forms")
	public String forms() {
		return "eventos/formEvento";
	}

	@PostMapping
	public String Salvar(Evento evento) {

		System.out.println(evento);
		er.save(evento);

		return "eventos/evento-salvado";
	}

	@GetMapping
	public ModelAndView listar() {

		List<Evento> eventos = er.findAll();
		ModelAndView mv = new ModelAndView("eventos/lista");
		mv.addObject("eventos", eventos);
		return mv;

	}

	@GetMapping("/{id}")
	public ModelAndView detalhar(@PathVariable Long id) {
		ModelAndView md = new ModelAndView();
		Optional<Evento> Opt = er.findById(id);

		if (Opt.isEmpty()) {
			md.setViewName("/redirect:/eventos");
			return md;
		}

		md.setViewName("eventos/detalhes");
		Evento evento = Opt.get();
		md.addObject("evento", evento);

		return md;
	}

}
