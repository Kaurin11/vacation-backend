package com.example.vacation.repository;

import com.example.vacation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    User findUserById (Long id);

    User findUserByUsername (String username);
}
