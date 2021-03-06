package com.eObrazovanje.studentServices.security;

import com.eObrazovanje.studentServices.entity.AuthUser;
import com.eObrazovanje.studentServices.helper.TimeProvider;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@SuppressWarnings("unused")
@Component
public class TokenHelper {

    @Value("eObrazovanje")
    private String APP_NAME;

    @Value("g=B!~dQ`-d%hF{5}")
    public String SECRET;

    @Value("300")
    private int EXPIRES_IN;

    @Value("Authorization")
    private String AUTH_HEADER;

    private final TimeProvider timeProvider;

    public TokenHelper(TimeProvider timeProvider) {
        this.timeProvider = timeProvider;
    }

    private final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS512;

    public String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    public Date getIssuedAtDateFromToken(String token) {
        Date issueAt;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            issueAt = claims.getIssuedAt();
        } catch (Exception e) {
            issueAt = null;
        }
        return issueAt;
    }

    public String getAudienceFromToken(String token) {
        String audience;
        try {
            final Claims claims = this.getAllClaimsFromToken(token);
            audience = claims.getAudience();
        } catch (Exception e) {
            audience = null;
        }
        return audience;
    }

    public String generateToken(String username) {
        return Jwts.builder().setIssuer(APP_NAME).setSubject(username)
                .setIssuedAt(timeProvider.now()).setExpiration(generateExpirationDate())
                .signWith(SIGNATURE_ALGORITHM, SECRET).compact();
    }

    private Claims getAllClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    private Date generateExpirationDate() {
        return new Date(timeProvider.now().getTime() + EXPIRES_IN * 1000);
    }

    public int getExpiredIn() {
        return EXPIRES_IN;
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        AuthUser authUser = (AuthUser) userDetails;
        final String username = getUsernameFromToken(token);
        return (username != null && username.equals(userDetails.getUsername()));
    }

    public String getToken(HttpServletRequest request) {
        String authHeader = getAuthHeaderFromHeader(request);
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }

        return null;
    }

    public String getAuthHeaderFromHeader(HttpServletRequest request) {
        return request.getHeader(AUTH_HEADER);
    }
}