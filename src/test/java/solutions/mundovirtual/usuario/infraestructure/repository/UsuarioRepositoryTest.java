package solutions.mundovirtual.usuario.infraestructure.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import solutions.mundovirtual.usuario.domain.Usuario;

@SpringBootTest
final class UsuarioRepositoryTest {
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Test
	void userCreation() {
		Usuario usuario = new Usuario();
		usuario.setId(2);
		usuario.setClave(bCryptPasswordEncoder.encode("1234"));
		usuario.setNombre("AdminWolf");

		Usuario usuarioReturned = usuarioRepository.save(usuario);

		Assertions.assertEquals(usuarioReturned.getClave(), usuario.getClave());
	}

}