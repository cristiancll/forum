package br.com.alura.forum.controller;

import br.com.alura.forum.config.security.TokenService;
import br.com.alura.forum.model.dto.AuthTokenDTO;
import br.com.alura.forum.model.form.AuthForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Profile({"prod", "test"})
public class AuthController {
    
    @Autowired private AuthenticationManager authManager;
    @Autowired private TokenService tokenService;
    
    @PostMapping
    public ResponseEntity<AuthTokenDTO> authenticate(
            @RequestBody @Valid AuthForm form){
        UsernamePasswordAuthenticationToken loginData = form.convert();
        try{
            Authentication authentication = authManager.authenticate(loginData);
            String token = tokenService.generateToken(authentication);
            return ResponseEntity.ok(new AuthTokenDTO(token, "Bearer"));
        }catch(AuthenticationException e){
            return ResponseEntity.badRequest().build();
        }
    }
}
