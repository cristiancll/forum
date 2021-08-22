package br.com.alura.forum.controller;

import br.com.alura.forum.model.ThreadPost;
import br.com.alura.forum.model.dto.DetailedThreadPostDTO;
import br.com.alura.forum.model.dto.ThreadPostDTO;
import br.com.alura.forum.model.form.ThreadForm;
import br.com.alura.forum.model.form.UpdateThreadForm;
import br.com.alura.forum.repository.CourseRepository;
import br.com.alura.forum.repository.ThreadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/threads")
public class ThreadController {
    
    @Autowired
    private ThreadRepository threadRepository;
    
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/{id}")
    public ResponseEntity<DetailedThreadPostDTO> get(@PathVariable Long id){
        Optional<ThreadPost> thread = threadRepository.findById(id);
        if(thread.isPresent()){
            return ResponseEntity.ok(new DetailedThreadPostDTO(thread.get()));    
        }
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping
    public Page<ThreadPostDTO> list(
            @RequestParam(required = false) String courseName, 
            @PageableDefault(sort="id", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable pagination){
        Page<ThreadPost> threads;
        if(courseName == null) threads = threadRepository.findAll(pagination);
        else threads = threadRepository.findByCourse_Name(courseName, pagination);
        return ThreadPostDTO.convert(threads);
    }
    
    @PostMapping
    @Transactional
    public ResponseEntity<ThreadPostDTO> register(@RequestBody @Valid ThreadForm threadForm, UriComponentsBuilder uriBuilder){
        ThreadPost threadPost = threadForm.convert(courseRepository);
        threadRepository.save(threadPost);
        URI uri = uriBuilder.path("/threads/{id}").buildAndExpand(threadPost.getId()).toUri();
        return ResponseEntity.created(uri).body(new ThreadPostDTO(threadPost));
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ThreadPostDTO> update(@PathVariable Long id, @RequestBody @Valid UpdateThreadForm form){
        Optional<ThreadPost> thread = threadRepository.findById(id);
        if(thread.isPresent()){
            return ResponseEntity.ok(new ThreadPostDTO(form.update(id, threadRepository)));
        }
        return ResponseEntity.notFound().build();
    } 

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<ThreadPost> thread = threadRepository.findById(id);
        if(thread.isPresent()){
            threadRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    
}
