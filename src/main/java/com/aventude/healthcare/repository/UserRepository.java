package com.aventude.healthcare.repository;

import com.aventude.healthcare.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    Optional<User> findByUserId(Long userId);
    Optional<User> findByUsername(String username);
}
