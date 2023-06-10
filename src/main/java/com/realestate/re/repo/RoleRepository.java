package com.realestate.re.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.realestate.re.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
    @Query("SELECT r FROM Role r WHERE r.roleId = :roleId")
    Role getRoleById(@Param("roleId") Long roleId);
}
