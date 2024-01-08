package DDCreatorApp;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import models.User;
import models.Data.UserRepository;
import models.dto.LoginFormDTO;
import models.dto.RegisterFormDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class AuthenticationController {
    @Autowired
    private UserRepository userRepository;
    private static final String userSessionKey = "user";
    public static String getUserSessionKey() {
        return userSessionKey;
    }
    public static String setUserSessionKey() {
        return userSessionKey;
    }
    public static void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getId());
    }


    @GetMapping("/register")
    public String displayRegistrationForm(Model model, HttpSession session) {
        model.addAttribute(new RegisterFormDTO());
        return "register";
    }
    @PostMapping("/register")
    public String processRegistrationForm(@ModelAttribute @Valid RegisterFormDTO registerFormDTO,
                                          Errors errors,
                                          Model model, HttpServletRequest request) {
        if(errors.hasErrors()) {
            return "register";
        }
        if (!registerFormDTO.getPassword().equals(registerFormDTO.getVerifyPassword())) {
            model.addAttribute("verifyError", "Passwords do not match");
            return "register";
        }
        if (userRepository.findByUsername(registerFormDTO.getUsername()) != null) {
            model.addAttribute("usernameError", "Username already exists");
            return "register";
        }
        //create and save a User
        User newUser = new User(registerFormDTO.getUsername(), registerFormDTO.getPassword());
        userRepository.save(newUser);
        //save the user's id into session
        setUserInSession(request.getSession(), newUser);

        return "redirect:";
    }
    @GetMapping("/login")
    public String displayLoginForm(Model model, HttpSession session){
        model.addAttribute(new LoginFormDTO());
        return "login";
    }
    @PostMapping("/login")
    public String processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO,
                                   Errors errors,
                                   Model model, HttpServletRequest request){
        if(errors.hasErrors()) {
            return "login";
        }
        User theUser = userRepository.findByUsername(loginFormDTO.getUsername());
        if (theUser == null) {
            model.addAttribute("usernameError", "Username does not exist");
            return "login";
        }
        if (!theUser.isMatchingPassword(loginFormDTO.getPassword())) {
            model.addAttribute("passwordError", "Invalid password");
            return "login";
        }
        setUserInSession(request.getSession(), theUser);
        return "redirect:";
    }
}
