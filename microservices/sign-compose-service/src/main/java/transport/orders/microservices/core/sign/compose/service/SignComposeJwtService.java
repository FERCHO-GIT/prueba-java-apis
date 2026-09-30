package transport.orders.microservices.core.sign.compose.service;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class SignComposeJwtService {
    private final long expirationTime;
    private final String jwtSecret = "eT3A9Smr2iJmuK0idW6Baplvh1j1zx92kJNsa57q2wGpw1vsLi";

    public SignComposeJwtService(@Value("${jwt.expiration.time}") long expirationTime) {
        this.expirationTime = expirationTime;
    }
    
    public String getJWT(String username) {
        return Jwts.builder()
            .subject(String.valueOf(username))
            .expiration(new Date(System.currentTimeMillis() + this.expirationTime))
            .signWith(this.getSigningKey(this.jwtSecret))
            .compact();
    }

    private SecretKey getSigningKey(String jwtSecret) {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
