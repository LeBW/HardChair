package fudan.se.lab2.security;

import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author LBW
 */
public class SecurityConstant {
    public static final String SECRET = "FdseFdse2020";
    public static final long EXPIRATION_TIME = 5 * 60 * 60 * 1000; // 5 hours.
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;
}
