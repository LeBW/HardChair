package fudan.se.lab2.controller;

import fudan.se.lab2.domain.User;
import fudan.se.lab2.service.AuthService;
import fudan.se.lab2.service.JwtUserDetailsService;
import fudan.se.lab2.utils.LoginForm;
import fudan.se.lab2.utils.RegistrationForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author LBW
 */
@RestController
public class AuthController {

    private AuthService authService;
    private JwtUserDetailsService userDetailsService;

    Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    public AuthController(AuthService authService, JwtUserDetailsService userDetailsService) {
        this.authService = authService;
        this.userDetailsService = userDetailsService;
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegistrationForm form) {
        logger.debug("RegistrationForm: " + form.toString());

        return ResponseEntity.ok(authService.register(form));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginForm form) {
        logger.debug("LoginForm: " + form.toString());

        String token = authService.login(form.getUsername(), form.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(form.getUsername());
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("userDetails", userDetails);
        responseMap.put("token", token);

        return ResponseEntity.ok(responseMap);
    }

    @GetMapping("/login")
    public String login() {
        return "Hello World";
    }

}



