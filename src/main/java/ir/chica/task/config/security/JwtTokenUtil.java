package ir.chica.task.config.security;

import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.security.SignatureException;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtTokenUtil {
    private final String jwtSecret = "zdtlD3JK56m6wTTgsNFhqzjqP";

    public String generateAccessToken(User user) {
        var jwtIssuer = "example.io";
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuer(jwtIssuer)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000)) // 1 week
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String getUsername(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public Date getExpirationDate(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getExpiration();
    }

    public boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
            // todo log Invalid JWT token
        }
        catch (ExpiredJwtException ex) {
            // todo log Expired JWT tokenUtil
        }
        catch (UnsupportedJwtException ex) {
            // todo log Unsupported JWT token
        } catch (IllegalArgumentException ex) {
            // todo log JWT claims string is empty
        }
        return false;
    }
}
