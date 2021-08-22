package br.com.alura.forum.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class ThreadPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String body;
    private LocalDateTime creationDate;
    @Enumerated(EnumType.STRING)
    private ThreadStatus status = ThreadStatus.UNANSWERED;
    
    @ManyToOne
    private ForumUser originalPoster;
    
    @ManyToOne
    private Course course;
    @OneToMany(mappedBy = "thread")
    private List<ThreadReply> replies = new ArrayList<>();

    public ThreadPost(){}
    
    public ThreadPost(String title, String body, Course course){
        this.title = title;
        this.body = body;
        this.course = course;
    }

    @Override
    public String toString() {
        return "ThreadPost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", creationDate=" + creationDate +
                ", status=" + status +
                ", originalPoster=" + originalPoster +
                ", course=" + course +
                ", replies=" + replies +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ThreadPost that = (ThreadPost) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(body, that.body) && Objects.equals(creationDate, that.creationDate) && status == that.status && Objects.equals(originalPoster, that.originalPoster) && Objects.equals(course, that.course) && Objects.equals(replies, that.replies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, body, creationDate, status, originalPoster, course, replies);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public ThreadStatus getStatus() {
        return status;
    }

    public void setStatus(ThreadStatus status) {
        this.status = status;
    }

    public ForumUser getOriginalPoster() {
        return originalPoster;
    }

    public void setOriginalPoster(ForumUser originalPoster) {
        this.originalPoster = originalPoster;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public List<ThreadReply> getReplies() {
        return replies;
    }

    public void setReplies(List<ThreadReply> replies) {
        this.replies = replies;
    }
}
