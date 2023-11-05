package solutions.mundovirtual.persona.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solutions.mundovirtual.persona.domain.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer> {
}
