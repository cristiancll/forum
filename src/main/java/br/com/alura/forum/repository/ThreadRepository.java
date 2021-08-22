package br.com.alura.forum.repository;

import br.com.alura.forum.model.ThreadPost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ThreadRepository extends JpaRepository<ThreadPost, Long> {

    Page<ThreadPost> findByCourse_Name(String courseName, Pageable pagination);
}
