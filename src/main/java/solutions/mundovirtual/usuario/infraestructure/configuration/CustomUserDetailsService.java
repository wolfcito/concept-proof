package solutions.mundovirtual.usuario.infraestructure.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import solutions.mundovirtual.usuario.domain.Usuario;
import solutions.mundovirtual.usuario.infraestructure.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario customUser = usuarioRepository.findByNombre(username);
		if (customUser == null) {
			throw new UsernameNotFoundException("username " + username + " is not found");
		}

		return User.builder()
				.username(customUser.getNombre())
				.password(customUser.getClave())
				.roles("ADMIN")
				.build();

	}
}
