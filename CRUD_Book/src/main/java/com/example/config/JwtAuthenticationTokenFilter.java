//package com.example.config;
//
//import java.io.IOException;
//import java.security.SignatureException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.example.constant.SystemConstant;
//
//import io.jsonwebtoken.ExpiredJwtException;
//
//
//
//public class JwtAuthenticationTokenFilter extends OncePerRequestFilter{
////	
////	@Autowired
////    private CustomUserDetailsService userDetailsService;
//	
//	@Autowired
//	private TokenProvider jwtTokenUtil;
//
//
//	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		String header = req.getHeader(SystemConstant.HEADER_STRING);
//        String username = null;
//        String authToken = null;
//        if (header != null && header.startsWith(SystemConstant.TOKEN_PREFIX)) {
//            authToken = header.replace(SystemConstant.TOKEN_PREFIX,"");
//            try {
//                username = jwtTokenUtil.getUsernameFromToken(authToken);
//            } catch (IllegalArgumentException e) {
//                logger.error("an error occured during getting username from token", e);
//            } catch (ExpiredJwtException e) {
//                logger.warn("the token is expired and not valid anymore", e);
//            } catch(SignatureException e){
//                logger.error("Authentication Failed. Username or Password not valid.");
//            }
//        } else {
//            logger.warn("couldn't find bearer string, will ignore the header");
//        }
//        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//
//            UserDetails userDetails = UserDetailsService.loadUserByUsername(username);
//
//            if (jwtTokenUtil.validateToken(authToken, userDetails)) {
//                UsernamePasswordAuthenticationToken authentication = jwtTokenUtil.getAuthentication(authToken, SecurityContextHolder.getContext().getAuthentication(), userDetails);
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
//                logger.info("authenticated user " + username + ", setting security context");
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }
//
//        chain.doFilter(req, res);
//		
//	}
//
//}
