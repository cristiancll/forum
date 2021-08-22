package br.com.alura.forum.model.form;

import br.com.alura.forum.model.ThreadPost;
import br.com.alura.forum.repository.ThreadRepository;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UpdateThreadForm {
    
    @NotNull @NotEmpty @Min(5)
    private String title;
    @NotNull @NotEmpty @Min(10)
    private String body;

    public String getBody() {
        return body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ThreadPost update(Long id, ThreadRepository threadRepository) {
        ThreadPost thread = threadRepository.getById(id);
        thread.setTitle(this.title);
        thread.setBody(this.body);
        return thread;
    }
}
