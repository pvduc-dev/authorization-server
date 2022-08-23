package pvduc.dev.authorization.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pvduc.dev.authorization.entity.User;
import pvduc.dev.authorization.repository.UserRepository;

import java.util.*;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
	private final UserRepository userRepository;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(11);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email)
			.orElseThrow(() -> new UsernameNotFoundException("Invalid certificates"));

		return new org.springframework.security.core.userdetails.User(
			user.getEmail(),
			user.getPassword(),
			user.getIsEnable(),
			true,
			true,
			true,
			new ArrayList<>()
		);
	}
}
