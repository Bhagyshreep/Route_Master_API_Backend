package com.routemasterapi.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.routemasterapi.api.entity.RouteEntity;

public interface RouteRepository extends JpaRepository<RouteEntity, Long> {
    // Additional query methods (if needed) can be declared here
}
