package fudan.se.hardchair.controller;

import fudan.se.hardchair.service.AuthService;
import fudan.se.hardchair.service.JwtUserDetailsService;
import fudan.se.hardchair.controller.request.LoginRequest;
import fudan.se.hardchair.controller.request.RegisterRequest;
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
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        logger.debug("RegistrationForm: " + request.toString());

        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        logger.debug("LoginForm: " + request.toString());

        String token = authService.login(request.getUsername(), request.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
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



