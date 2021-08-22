package br.com.alura.forum.repository;

import br.com.alura.forum.model.ForumUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ForumUserRepository extends JpaRepository<ForumUser, Long> {
    Optional<ForumUser> findByEmail(String email);
}
