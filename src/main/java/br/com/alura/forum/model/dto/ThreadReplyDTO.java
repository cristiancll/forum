package br.com.alura.forum.model.dto;

import br.com.alura.forum.model.ThreadReply;

import java.time.LocalDateTime;

public class ThreadReplyDTO {
    
    private Long id;
    private String message;
    private LocalDateTime creationDate;
    private String originalPosterName;
    
    public ThreadReplyDTO(ThreadReply reply){
        this.id = reply.getId();
        this.message = reply.getMessage();
        this.creationDate = reply.getCreationDate();
        this.originalPosterName = reply.getOriginalPoster().getName();
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public Long getId() {
        return id;
    }

    public String getOriginalPosterName() {
        return originalPosterName;
    }
}
