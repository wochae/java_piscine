package com.example.demo.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findFirstByEmail(String email);

    @Query(value = "select u from User u where u.userName = ?1")
    List<User> findUserByUserName(@RequestParam String name);
}
