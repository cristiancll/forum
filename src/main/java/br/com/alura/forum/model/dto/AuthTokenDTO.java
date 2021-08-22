package br.com.alura.forum.model.dto;

public class AuthTokenDTO {
    
    private String token;
    private String authType;

    public AuthTokenDTO(String token, String authType){
        this.token = token;
        this.authType = authType;
    }

    public String getAuthType() {
        return authType;
    }

    public String getToken() {
        return token;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
