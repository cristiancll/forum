package br.com.alura.forum.config.security;

import br.com.alura.forum.model.ForumUser;
import br.com.alura.forum.repository.ForumUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {
    @Autowired
    private ForumUserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<ForumUser> user = repository.findByEmail(email);
        if(user.isPresent()){
            return user.get();
        }
        throw new UsernameNotFoundException("Dados inválidos");
    }
}
