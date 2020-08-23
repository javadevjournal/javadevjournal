package com.javadevjournal.core.user.jpa.repository;

import com.javadevjournal.core.user.jpa.data.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long > {
    UserEntity findByEmail(String email);
}
