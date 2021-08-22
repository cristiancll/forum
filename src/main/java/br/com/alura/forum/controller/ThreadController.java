package br.com.alura.forum.controller;

import br.com.alura.forum.model.ThreadPost;
import br.com.alura.forum.model.dto.ThreadPostDTO;
import br.com.alura.forum.model.form.ThreadForm;
import br.com.alura.forum.repository.CourseRepository;
import br.com.alura.forum.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/threads")
public class ThreadController {
    
    @Autowired
    private ThreadRepository threadRepository;
    
    @Autowired
    private CourseRepository courseRepository;
    
    @GetMapping
    public List<ThreadPostDTO> list(String courseName){
        List<ThreadPost> threads;
        if(courseName == null) threads = threadRepository.findAll();
        else threads = threadRepository.findByCourse_Name(courseName);
        return ThreadPostDTO.convert(threads);
    }
    
    @PostMapping
    public ResponseEntity<ThreadPostDTO> register(@RequestBody @Valid ThreadForm threadForm, UriComponentsBuilder uriBuilder){
        ThreadPost threadPost = threadForm.convert(courseRepository);
        threadRepository.save(threadPost);
        URI uri = uriBuilder.path("/threads/{id}").buildAndExpand(threadPost.getId()).toUri();
        return ResponseEntity.created(uri).body(new ThreadPostDTO(threadPost));
    } 
    
}
