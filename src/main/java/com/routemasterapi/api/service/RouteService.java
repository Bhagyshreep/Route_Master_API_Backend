package com.routemasterapi.api.service;

import com.routemasterapi.api.entity.RouteEntity;
import com.routemasterapi.api.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public List<RouteEntity> getAllRoutes() {
        return routeRepository.findAll();
    }

    public Optional<RouteEntity> getRouteById(Long routeId) {
        return routeRepository.findById(routeId);
    }

    public RouteEntity saveRoute(RouteEntity route) {
        return routeRepository.save(route);
    }

    public void deleteRoute(Long routeId) {
        routeRepository.deleteById(routeId);
    }
}
