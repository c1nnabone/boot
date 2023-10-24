package ru.kim.boot.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kim.boot.boot.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
