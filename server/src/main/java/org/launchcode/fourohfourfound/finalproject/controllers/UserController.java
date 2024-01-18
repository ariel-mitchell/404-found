package org.launchcode.fourohfourfound.finalproject.controllers;

import jakarta.validation.Valid;
import org.launchcode.fourohfourfound.finalproject.models.Character;
import org.launchcode.fourohfourfound.finalproject.models.User;
import org.launchcode.fourohfourfound.finalproject.repositories.CharacterRepository;
import org.launchcode.fourohfourfound.finalproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CharacterRepository characterRepository;

    private static final String userSessionKey = "user";

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll();
        return  ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable int id,@RequestBody @Valid User updatedUser, BindingResult result) {
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                errors.put(error.getField(), error.getDefaultMessage());
            }
            return ResponseEntity.unprocessableEntity().body(errors);
        }

        Optional<User> existingUser = userRepository.findById(id);
        if (existingUser.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        User existingUserToUpdate = existingUser.get();
        existingUserToUpdate.setUsername(updatedUser.getUserName());
        existingUserToUpdate.setEmail(updatedUser.getEmail());
        if (!updatedUser.isPasswordEmpty()) {
            existingUserToUpdate.setPassword(User.getEncoder().encode(updatedUser.getPassword()));
        }

        userRepository.save(existingUserToUpdate);
        return ResponseEntity.ok(existingUserToUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") int id) {
        userRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
