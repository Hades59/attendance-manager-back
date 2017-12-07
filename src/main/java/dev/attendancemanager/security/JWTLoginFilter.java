package dev.attendancemanager.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.attendancemanager.entite.Role;
import dev.attendancemanager.entite.User;

public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	public JWTLoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url, HttpMethod.POST.name()));
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException, IOException, ServletException {
		User creds = new ObjectMapper()
				.readValue(req.getInputStream(), User.class);
		
		List<Role> authorities = new ArrayList<>();
		authorities.add(Role.ROLE_MANAGER);
		authorities.add(Role.ROLE_EMPLOYE);
		authorities.add(Role.ROLE_ADMIN);
		
		return getAuthenticationManager().authenticate(
				new UsernamePasswordAuthenticationToken(
						creds.getMatricule(),
						creds.getPassword(),
						Collections.emptyList()
						)
				);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException, ServletException {
		TokenAuthenticationService
			.addAuthentication(res, auth.getName(), auth.getAuthorities().toString());
	}
}
