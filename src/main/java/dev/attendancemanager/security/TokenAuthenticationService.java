package dev.attendancemanager.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import static java.util.Collections.emptyList;

public class TokenAuthenticationService {
	static final long EXPIRATIONTIME = 8_640_000; // 1 day
	  static final String SECRET = "ThisIsASecret";
	  static final String TOKEN_PREFIX = "Bearer";
	  static final String HEADER_STRING = "Authorization";

	  static void addAuthentication(HttpServletResponse res, String matricule, String role) {
		Map<String, Object> payloadJson = new HashMap<>();
		role = role.replace("[", "");
		role = role.replace("]", "");
		payloadJson.put("matricule", matricule);
		payloadJson.put("role", role);
		  
	    String JWT = Jwts.builder()
	        .setSubject(matricule)
	        .setClaims(payloadJson)
	        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
	        .signWith(SignatureAlgorithm.HS512, SECRET)
	        .compact();
	    res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
	  }

	  static Authentication getAuthentication(HttpServletRequest request) {
	    String token = request.getHeader(HEADER_STRING);
	    if (token != null) {
	      String user = Jwts.parser()
	          .setSigningKey(SECRET)
	          .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
	          .getBody()
	          .getSubject();

	      return user != null ?
	          new UsernamePasswordAuthenticationToken(user, null, emptyList()) :
	          null;
	    }
	    return null;
	  }
}
