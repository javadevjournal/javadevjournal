package com.javadevjournal.customlogout.core.repository;

import com.javadevjournal.customlogout.core.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long > {
	UserEntity findByEmailOrUserName(String email, String username);
}
