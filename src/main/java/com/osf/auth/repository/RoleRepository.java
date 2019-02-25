package com.osf.auth.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.osf.auth.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

    @Override
    void delete(Role role);

}