package com.stssecuritycrud.repository;

import com.stssecuritycrud.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {
    Role findByRolename(String rolename);
}
