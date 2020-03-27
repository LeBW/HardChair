package fudan.se.hardchair.service;

import fudan.se.hardchair.exception.UsernameHasBeenRegisteredException;
import fudan.se.hardchair.security.jwt.JwtTokenUtil;
import fudan.se.hardchair.domain.User;
import fudan.se.hardchair.repository.AuthorityRepository;
import fudan.se.hardchair.repository.UserRepository;
import fudan.se.hardchair.controller.request.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author LBW
 */
@Service
public class AuthService {
    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    public AuthService(UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder, AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public User register(RegisterRequest request) {
        if (userRepository.findByUsername(request.getUsername()) != null) {
            throw new UsernameHasBeenRegisteredException(request.getUsername());
        }
        User user = request.toUser(passwordEncoder, authorityRepository);
        return userRepository.save(user);
    }

    public String login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User: '" + username + "' not found.");
        }

        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);

        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtTokenUtil.generateToken(user);

    }


}
