package org.miage.controllers;

import javax.validation.Valid;

import org.miage.Entity.User;
import org.miage.payload.request.LoginRequest;
import org.miage.payload.request.SignupRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import org.miage.payload.response.JwtResponse;
import org.miage.payload.response.MessageResponse;
import org.miage.repository.UserRepository;
import org.miage.security.jwt.JwtUtils;
import org.miage.security.services.UserDetailsImpl;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@Autowired
	private UsersRessource UsersRessource;
	private UserDetailsImpl UserDetailsImpl=null;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		UsernamePasswordAuthenticationToken credential=new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());

		Iterable<User> usersIterable = UsersRessource.findAll();
		usersIterable.forEach(elem->{
			if(elem.getEmail().equals(loginRequest.getEmail())
			&& encoder.matches(loginRequest.getPassword(), elem.getPassword()))
			{
				// utilisateur exist
				UserDetailsImpl=new UserDetailsImpl(elem.getUsername(), elem.getEmail(),elem.getPassword(),elem.isAdmin());
			}
		});

		if(UserDetailsImpl!=null){
			String jwt = jwtUtils.generateJwtToken(UserDetailsImpl);

			return ResponseEntity.ok(new JwtResponse(jwt,
					UserDetailsImpl.getId(),
					UserDetailsImpl.getUsername(),
					UserDetailsImpl.getEmail(),
					UserDetailsImpl.isAdmin()));
		}else {
			return ResponseEntity.ok(new MessageResponse("User not find!"));
		}
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(),
							 signUpRequest.getUsername(),
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()),
				signUpRequest.getAdmin());

		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
