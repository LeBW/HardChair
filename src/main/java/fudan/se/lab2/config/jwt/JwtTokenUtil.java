package fudan.se.lab2.config.jwt;

import fudan.se.lab2.config.SecurityConstant;
import fudan.se.lab2.domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author LBW
 */
@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -3839549913040578986L;

    public static final long JWT_TOKEN_VALIDITY = SecurityConstant.EXPIRATION_TIME;
    private String secret = SecurityConstant.SECRET;
    private SignatureAlgorithm signatureAlgorithm = SecurityConstant.SIGNATURE_ALGORITHM;

    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.builder().addClaims(claims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY))
                .signWith(signatureAlgorithm, secret).compact();
    }
}
