package com.javadevjournal.user.jpa.repository;

import com.javadevjournal.user.jpa.data.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long > {
    UserEntity findByEmail(String email);
}
