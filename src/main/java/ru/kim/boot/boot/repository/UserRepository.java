package ru.kim.boot.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kim.boot.boot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
