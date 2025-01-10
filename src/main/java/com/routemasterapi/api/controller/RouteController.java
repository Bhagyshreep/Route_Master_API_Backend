package com.routemasterapi.api.controller;

import com.routemasterapi.api.entity.RouteEntity;
import com.routemasterapi.api.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping
    public List<RouteEntity> getAllRoutes() {
        return routeService.getAllRoutes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RouteEntity> getRouteById(@PathVariable Long id) {
        return routeService.getRouteById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RouteEntity createRoute(@RequestBody RouteEntity route) {
        return routeService.saveRoute(route);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RouteEntity> updateRoute(@PathVariable Long id, @RequestBody RouteEntity updatedRoute) {
        return routeService.getRouteById(id).map(existingRoute -> {
            existingRoute.setRouteName(updatedRoute.getRouteName());
            existingRoute.setDescription(updatedRoute.getDescription());
            existingRoute.setOriginPincode(updatedRoute.getOriginPincode());
            existingRoute.setDestinationPincode(updatedRoute.getDestinationPincode());
            existingRoute.setTotalDistance(updatedRoute.getTotalDistance());
            return ResponseEntity.ok(routeService.saveRoute(existingRoute));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoute(@PathVariable Long id) {
        if (routeService.getRouteById(id).isPresent()) {
            routeService.deleteRoute(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
