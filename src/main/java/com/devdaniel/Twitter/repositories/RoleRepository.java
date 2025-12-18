package com.devdaniel.Twitter.repositories;

import com.devdaniel.Twitter.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> { }