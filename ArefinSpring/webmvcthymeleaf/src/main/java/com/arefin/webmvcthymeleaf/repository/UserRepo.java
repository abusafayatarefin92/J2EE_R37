package com.arefin.webmvcthymeleaf.repository;

import com.arefin.webmvcthymeleaf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
