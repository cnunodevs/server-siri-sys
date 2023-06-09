package com.senatic.siri.configuration.security.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.senatic.siri.administracion.repository.UsuariosRepository;
import com.senatic.siri.configuration.security.constant.SecurityConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

    private final String SECRET_KEY = SecurityConstants.JWT_KEY;
    private final UsuariosRepository usuariosRepository;

    public JwtService(UsuariosRepository usuariosRepository) {
      this.usuariosRepository = usuariosRepository;
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails) {
        Map<String, Object> rolesClaim = new HashMap<>();
        rolesClaim.put("role", userDetails.getAuthorities().stream().findFirst().get().getAuthority());
        rolesClaim.put("id", usuariosRepository.findFirstByUsername(userDetails.getUsername()).get().getId());
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .addClaims(rolesClaim)
                .compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
      }
    
      private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
      }
    
      private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
      }
    
      private Claims extractAllClaims(String token) {
        return Jwts
            .parserBuilder()
            .setSigningKey(getSignInKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
      }
    
      private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
      }

}
