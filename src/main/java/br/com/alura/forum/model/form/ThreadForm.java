package br.com.alura.forum.model.form;


import br.com.alura.forum.model.Course;
import br.com.alura.forum.model.ThreadPost;
import br.com.alura.forum.repository.CourseRepository;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ThreadForm {
    
    
    @NotNull @NotBlank @Min(5)
    private String title;
    @NotNull @NotBlank @Min(10)
    private String body;
    @NotNull @NotBlank
    private String courseName;


    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ThreadPost convert(CourseRepository repository) {
        Course course = repository.findByName(this.courseName);
        ThreadPost thread = new ThreadPost(this.title, this.body, course);
        return thread;
    }
}
