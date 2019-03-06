package com.arefin.sunshinefarm.repo;

import com.arefin.sunshinefarm.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesignationRepo extends JpaRepository<Designation, Long> {
    Designation findByDesignationName(String designationName);
}
