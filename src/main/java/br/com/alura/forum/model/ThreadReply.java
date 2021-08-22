package br.com.alura.forum.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class ThreadReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    @ManyToOne
    private ThreadPost thread;
    private LocalDateTime creationDate;
    @ManyToOne
    private ForumUser originalPoster;
    private Boolean solved = false;

    public ThreadReply(){}
    

    @Override
    public String toString() {
        return "Answer{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", thread=" + thread +
                ", creationDate=" + creationDate +
                ", originalPoster=" + originalPoster +
                ", solved=" + solved +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThreadReply forumThreadReply = (ThreadReply) o;
        return Objects.equals(id, forumThreadReply.id) && Objects.equals(message, forumThreadReply.message) && Objects.equals(thread, forumThreadReply.thread) && Objects.equals(creationDate, forumThreadReply.creationDate) && Objects.equals(originalPoster, forumThreadReply.originalPoster) && Objects.equals(solved, forumThreadReply.solved);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, thread, creationDate, originalPoster, solved);
    }

    public Long getId() {
        return id;
    }

    public Boolean getSolved() {
        return solved;
    }

    public ThreadPost getThread() {
        return thread;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getMessage() {
        return message;
    }

    public ForumUser getOriginalPoster() {
        return originalPoster;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setOriginalPoster(ForumUser originalPoster) {
        this.originalPoster = originalPoster;
    }

    public void setSolved(Boolean solved) {
        this.solved = solved;
    }

    public void setThread(ThreadPost thread) {
        this.thread = thread;
    }
}
