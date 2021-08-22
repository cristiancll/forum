package br.com.alura.forum.model.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthForm {
    
    private String email;
    private String password;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public UsernamePasswordAuthenticationToken convert() {
        return new UsernamePasswordAuthenticationToken(this.email, this.password);
    }
}
