package fudan.se.hardchair.service;

import fudan.se.hardchair.domain.User;
import fudan.se.hardchair.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * @author LBW
 */
@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).get();
    }

    public Iterable<User> findAllUsers() {
        return  userRepository.findAll();
    }
}
