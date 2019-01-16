package uk.co.datadisk.webservices.restfulwebservices.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

	static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

	static {
		inMemoryUserList.add(new JwtUserDetails(1L, "in28minutes",
				"$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
		inMemoryUserList.add(new JwtUserDetails(2L, "ranga",
				"$2a$10$IetbreuU5KihCkDB6/r1DOJO0VyU9lSiBcrMDT.biU7FOt2oqZDPm", "ROLE_USER_2"));
		inMemoryUserList.add(new JwtUserDetails(3L, "pvalle",
				"$2a$10$.6QAKfZ4s3W3152plG3.1e1bfsvMXBaNTUgVpeYElajqPNaHqvtZO", "ROLE_USER_2"));
		
		// $2a$10$.6QAKfZ4s3W3152plG3.1e1bfsvMXBaNTUgVpeYElajqPNaHqvtZO = password (pvalle)
		//	"token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwdmFsbGUiLCJleHAiOjE1NDgyNDc1MTEsImlhdCI6MTU0NzY0MjcxMX0.DjaC8xlwu5E2WmA6Q_MshRdxSxvzvT52yASvrYekizOL3W1CQ5yf1ZUFgKKnaSMmgLtzBIZtnmsg7l-7zWC9iQ"
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
				.filter(user -> user.getUsername().equals(username)).findFirst();

		if (!findFirst.isPresent()) {
			throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
		}

		return findFirst.get();
	}

}
