package com.tecg.in.techolution.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tecg.in.techolution.domain.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity getUserByLogin(String login);


}
