package solutions.mundovirtual.usuario.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import solutions.mundovirtual.usuario.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
