package fudan.se.hardchair.service;

import fudan.se.hardchair.controller.request.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author LBW
 */
@SpringBootTest
class AuthServiceTest {
    @Autowired
    private AuthService authService;

    @Test
    @Transactional
    void register() {
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setAuthorities(Collections.singleton("User"));
        registerRequest.setEmail("libw521@gmail.com");
        registerRequest.setUsername("cslibw521");
        registerRequest.setFullname("李博文");
        registerRequest.setOrganization("Fudan University");
        registerRequest.setPassword("fdse12345");
        authService.register(registerRequest);
    }

    @Test
    void login() {
    }
}