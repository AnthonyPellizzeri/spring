package org.miage.Bundary;

import org.miage.Entity.User;
import org.miage.Entity.request.AddCoursRequest;
import org.miage.Entity.response.MessageResponse;
import org.miage.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
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

	@PostMapping("/addCours")
	public ResponseEntity<?> addCourrs(@Valid @RequestBody AddCoursRequest AddCoursRequest) {

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

}
