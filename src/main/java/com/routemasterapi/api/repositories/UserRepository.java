package com.routemasterapi.api.repositories;

import com.routemasterapi.api.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    // Additional query methods (if needed)
}
