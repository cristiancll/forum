package br.com.alura.forum.repository;

import br.com.alura.forum.model.ThreadPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThreadRepository extends JpaRepository<ThreadPost, Long> {

    List<ThreadPost> findByCourse_Name(String courseName);
}
