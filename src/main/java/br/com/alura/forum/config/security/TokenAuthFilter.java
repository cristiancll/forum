package br.com.alura.forum.config.security;

import br.com.alura.forum.model.ForumUser;
import br.com.alura.forum.repository.ForumUserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class TokenAuthFilter extends OncePerRequestFilter {
    
    private TokenService tokenService;
    private ForumUserRepository repository;
    
    public TokenAuthFilter(TokenService tokenService, ForumUserRepository repository){
        this.tokenService = tokenService;
        this.repository = repository;
    }
    
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = retrieveToken(request);
        boolean validToken = tokenService.isValidToken(token);
        if(validToken){
            authenticateClient(token);
        }
        filterChain.doFilter(request, response);
    }

    private String retrieveToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) return null;
        return token.substring(7, token.length());
    }
    
    private void authenticateClient(String token){
        Long userId = tokenService.getIdFromToken(token);
        Optional<ForumUser> user = repository.findById(userId);
        if(user.isPresent()){
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user.get(), null, user.get().getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
    }
}
