package solutions.mundovirtual.persona.infraestructure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import solutions.mundovirtual.persona.domain.Persona;
import solutions.mundovirtual.persona.infraestructure.repository.PersonaRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/personas")
public class PersonaController {

	@Autowired
	private PersonaRepository repository;

	@GetMapping
	public Map<String, List<Persona>> findAll() {
		Map<String, List<Persona>> model = new HashMap<>();
		model.put("personas", repository.findAll());
		return model;
	}

	@PostMapping
	public void upsert(@RequestBody Persona persona) {
		repository.save(persona);
	}

	@DeleteMapping(value = "/{idPersona}")
	public void delete(@PathVariable("idPersona") Integer idPersona) {
		repository.deleteById(idPersona);
	}
}
