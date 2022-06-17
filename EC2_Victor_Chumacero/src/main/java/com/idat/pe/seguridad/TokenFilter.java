package com.idat.pe.seguridad;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class TokenFilter extends OncePerRequestFilter{

	@Autowired
	private JwUtil util;
	
	@Autowired
	private UserDetailService service;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String requestHeader = request.getHeader("Authorization");
		
		String token = null;
		String userName =  null;
		
		if(requestHeader != null && requestHeader.startsWith("Bearer ")) {
			token = requestHeader.substring(7);
			
			try {
				
				userName = util.getUsernameFromToken(token);
				
			} catch (IllegalArgumentException e) {
				System.out.println("Argumento del token inválido");
				
			} catch(ExpiredJwtException e) {
				System.out.println("JW expirado");
			}
		}else {
			logger.warn("JWT no contiene la palabra Bearer");
		}
		
		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails details =this.service.loadUserByUsername(userName);
			
			if(util.validateToken(token, details)) {
				UsernamePasswordAuthenticationToken usernametoken = new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
				usernametoken.setDetails(new WebAuthenticationDetails(request));
				SecurityContextHolder.getContext().setAuthentication(usernametoken);
			}
		}
		filterChain.doFilter(request, response);
	}

}
