package fudan.se.hardchair.controller.request;

import fudan.se.hardchair.domain.Authority;
import fudan.se.hardchair.domain.User;
import fudan.se.hardchair.repository.AuthorityRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author LBW
 */
public class RegisterRequest {
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String organization;
    private Set<String> authorities;

    public RegisterRequest() {}

    public User toUser(PasswordEncoder encoder, AuthorityRepository authorityRepository) {
        // map Set<String> to Set<Authority>. (save authority if not exists)
        Set<Authority> userAuthorities = authorities
                .stream().map(
                        authorityText -> getOrCreateAuthority(authorityText, authorityRepository))
                .collect(Collectors.toSet());
        //encrypt password
        return new User(username, encoder.encode(password), fullname, email, organization, userAuthorities);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "RegistrationForm{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", authorities=" + authorities +
                '}';
    }

    private Authority getOrCreateAuthority(String authorityText, AuthorityRepository authorityRepository) {
        Authority authority = authorityRepository.findByAuthority(authorityText);
        if (authority == null) {
            authority = new Authority(authorityText);
            authorityRepository.save(authority);
        }
        return authority;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}

