package br.com.alura.forum.model.dto;

public class FormErrorDTO {
    
    private String field;
    private String message;

    public FormErrorDTO(String field, String message){
        this.field = field;
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }

    public String getField() {
        return field;
    }
}
