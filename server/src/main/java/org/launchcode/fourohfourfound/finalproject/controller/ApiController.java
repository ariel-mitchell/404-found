package org.launchcode.fourohfourfound.finalproject.controller;




import jakarta.validation.Valid;
import org.launchcode.fourohfourfound.finalproject.dto.UserDTO;
import org.launchcode.fourohfourfound.finalproject.model.User;
import org.launchcode.fourohfourfound.finalproject.repository.CharacterRepository;
import org.launchcode.fourohfourfound.finalproject.repository.UserRepository;
import org.launchcode.fourohfourfound.finalproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.launchcode.fourohfourfound.finalproject.model.Character;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class ApiController {

    private final CharacterRepository characterRepository;
    private final UserRepository userRepository;
    private final UserService userService;



    @Autowired
    public ApiController(CharacterRepository characterRepository, UserRepository userRepository,
                         UserService userService) {
        this.characterRepository = characterRepository;
        this.userRepository = userRepository;
        this.userService = userService;

    }

    @GetMapping("/character")
    public Character getCharacter(@RequestParam int id) {
        Character character = characterRepository.findById(id).orElse(null);
        if (character != null) {
            return character;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Character not found");
        }
    }
    @PostMapping("/characters")
    public Character createCharacter(@RequestBody @Valid Character character, BindingResult bindingResult,
                                     @AuthenticationPrincipal User user) {
        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Invalid input");
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = " ";
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
            System.out.println(currentUserName);
        }
        character.setOwner(userRepository.findByUserName(currentUserName));
        try {
            return characterRepository.save(character);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Character could not be created", e);
        }
    }

    @GetMapping("/user")
    public User getUser(@RequestParam int id) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            return user;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "USER NOT FOUND, SORRY!");
        }
    }


    @PostMapping("/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO userDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE,"Invalid input");
        }
           User newUser = userService.registerNewUserAccount(userDto);
            return ResponseEntity.ok(new UserDTO(newUser.getUserName(),
                           newUser.getFirstName(), newUser.getLastName(),
                           newUser.getEmail(), newUser.getPassword()));
    }


}
