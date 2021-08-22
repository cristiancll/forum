package br.com.alura.forum.model.dto;

import br.com.alura.forum.model.ThreadPost;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

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

    public static Page<ThreadPostDTO> convert(Page<ThreadPost> threads) {
//      return threads.stream().map(ThreadPostDTO::new).collect(Collectors.toList());
        return threads.map(ThreadPostDTO::new);
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
