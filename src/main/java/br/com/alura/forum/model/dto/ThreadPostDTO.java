package br.com.alura.forum.model.dto;

import br.com.alura.forum.model.ThreadPost;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ThreadPostDTO {
    
    private Long id;
    private String title;
    private String body;
    private LocalDateTime creationDate;

    public ThreadPostDTO(ThreadPost thread){
        this.id = thread.getId();
        this.title = thread.getTitle();
        this.body = thread.getBody();
        this.creationDate = thread.getCreationDate();
    }

    public static List<ThreadPostDTO> convert(List<ThreadPost> threads) {
        return threads.stream().map(ThreadPostDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }
}
