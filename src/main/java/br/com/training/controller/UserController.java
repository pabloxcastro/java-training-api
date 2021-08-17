package br.com.training.controller;

import javax.validation.Valid;

import br.com.training.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import br.com.training.model.User;
import br.com.training.repository.UserRepository;

@RestController
@RestControllerAdvice
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User createUser(@RequestBody @Valid User user) {
		return userService.createUser(user);
	}

	@GetMapping (value = "/{cpf}")
	@ResponseStatus(HttpStatus.OK)
    public User getUser (@PathVariable String cpf){
        return userService.getUser(cpf);
    }

	@PutMapping(value = "/{cpf}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> updateUser(@PathVariable String cpf, @RequestBody @Valid User user){
		return userService.updateUser(cpf, user);
	}

	@DeleteMapping(value = "/{cpf}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> deleteUser(@PathVariable String cpf){return userService.deleteUser(cpf); }

}
