package br.com.alura.forum.model.dto;

import br.com.alura.forum.model.ThreadPost;
import br.com.alura.forum.model.ThreadStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DetailedThreadPostDTO {
    
    private Long id;
    private String title;
    private String body;
    private LocalDateTime creationDate;
    private String originalPosterName;
    private ThreadStatus status;
    private List<ThreadReplyDTO> replies;
    
    public DetailedThreadPostDTO(ThreadPost thread){
        this.id = thread.getId();
        this.title = thread.getTitle();
        this.body = thread.getBody();
        this.creationDate = thread.getCreationDate();
        this.originalPosterName = thread.getOriginalPoster().getName();
        this.status = thread.getStatus();
        this.replies = thread.getReplies().stream().map(ThreadReplyDTO::new).collect(Collectors.toList());
    }
    
}
