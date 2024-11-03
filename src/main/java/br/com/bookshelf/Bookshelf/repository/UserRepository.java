package br.com.bookshelf.Bookshelf.repository;

import br.com.bookshelf.Bookshelf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
