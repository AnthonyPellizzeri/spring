package org.miage.Bundary;

import org.miage.Entity.User;
import org.miage.controllers.UsersRessource;
import org.miage.payload.response.JwtResponse;
import org.miage.payload.response.MessageResponse;
import org.miage.repository.UserRepository;
import org.miage.security.jwt.JwtUtils;
import org.miage.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	private org.miage.controllers.UsersRessource UsersRessource;

	//  GET all
	@GetMapping
	public ResponseEntity<List<User>> getAllIntervenants() {
		List<User> userIterable = UsersRessource.findAll();
		return ResponseEntity.ok().body(userIterable);
	}

	// GET one
	@GetMapping(value = "/{userMail}")
	public ResponseEntity<User> getOneUser(@PathVariable("userMail") String mail) {
		return Optional.of(UsersRessource.findById(mail))
				.filter(Optional::isPresent)
				.map(intervenant -> ResponseEntity.ok().body(intervenant.get()))
				.orElse(ResponseEntity.notFound().build());
	}

}
