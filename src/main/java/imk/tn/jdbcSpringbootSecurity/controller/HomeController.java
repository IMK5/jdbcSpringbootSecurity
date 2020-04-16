package imk.tn.jdbcSpringbootSecurity.controller;

import java.security.Principal;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/")
	public Principal retrievePrincipal(Principal principal) {
		return principal;
	}


	@GetMapping("/user")
	public String welcomeUser() {

		return "<h1> welcome User <h1>";
	}

	
	@GetMapping("/admin")
	public String welcomeAdmin() {

		return "<h1> welcome Admin <h1>";
	}

}
