package solutions.mundovirtual;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	public static final String PERSONAS_ENDPOINT = "/personas/**";
	public static final String ADMIN_ROLE = "ADMIN";

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorizeHttpRequests ->
						authorizeHttpRequests
								.requestMatchers(HttpMethod.GET, PERSONAS_ENDPOINT).permitAll()
								.requestMatchers(HttpMethod.POST, PERSONAS_ENDPOINT).hasRole(ADMIN_ROLE)
								.requestMatchers(HttpMethod.DELETE, PERSONAS_ENDPOINT).hasRole(ADMIN_ROLE)
								.anyRequest().authenticated()
				).httpBasic(Customizer.withDefaults())
				.csrf(AbstractHttpConfigurer::disable)
				.cors(Customizer.withDefaults());
		return http.build();
	}


}
