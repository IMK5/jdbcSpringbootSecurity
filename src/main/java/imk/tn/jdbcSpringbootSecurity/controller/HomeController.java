package imk.tn.jdbcSpringbootSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	@GetMapping("/")
	public String welcome() {
		
		return "<h1> welcome all <h1>";
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
