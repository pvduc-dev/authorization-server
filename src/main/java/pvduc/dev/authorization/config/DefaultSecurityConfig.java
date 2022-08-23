package pvduc.dev.authorization.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import pvduc.dev.authorization.service.AuthenticationProvider;

@EnableWebSecurity
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DefaultSecurityConfig {
	private final AuthenticationProvider authenticationProvider;

	@Bean
	SecurityFilterChain defaultSecurityChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests(authorizeRequests ->
			authorizeRequests.anyRequest().authenticated()).formLogin(Customizer.withDefaults());
		return httpSecurity.build();
	}

	@Autowired
	public void bindAuthenticationProvider(AuthenticationManagerBuilder authenticationManagerBuilder) {
		authenticationManagerBuilder.authenticationProvider(this.authenticationProvider);
	}
}
