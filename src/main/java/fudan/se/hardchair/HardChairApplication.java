package fudan.se.hardchair;

import fudan.se.hardchair.domain.Authority;
import fudan.se.hardchair.domain.User;
import fudan.se.hardchair.repository.AuthorityRepository;
import fudan.se.hardchair.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.HashSet;

@SpringBootApplication
public class HardChairApplication {

    public static void main(String[] args) {
        SpringApplication.run(HardChairApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(UserRepository userRepository, AuthorityRepository authorityRepository, PasswordEncoder passwordEncoder) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // Create authorities if not exist.
                Authority adminAuthority = getOrCreateAuthority("Admin", authorityRepository);
                Authority chairAuthority = getOrCreateAuthority("User", authorityRepository);

                // Create a admin if not exists.
                if (userRepository.findByUsername("admin") == null) {
                    User admin = new User(
                            "admin",
                            passwordEncoder.encode("password"),
                            "李博文",
                            "libw521@qq.com",
                            "Fudan University",
                            new HashSet<>(Collections.singletonList(adminAuthority))
                    );
                    adminAuthority.addUser(admin);
                    userRepository.save(admin);
                }
                //System.out.println(adminAuthority.getUsers());

            }

            private Authority getOrCreateAuthority(String authorityText, AuthorityRepository authorityRepository) {
                Authority authority = authorityRepository.findByAuthority(authorityText);
                if (authority == null) {
                    authority = new Authority(authorityText);
                    authorityRepository.save(authority);
                }
                return authority;
            }
        };
    }
}

