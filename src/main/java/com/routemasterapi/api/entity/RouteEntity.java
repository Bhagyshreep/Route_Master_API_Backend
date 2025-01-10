package com.routemasterapi.api.entity;

import javax.persistence.*;

@Entity
public class RouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long routeId;
    private String routeName;
    private String description;
    private String originPincode;
    private String destinationPincode;
    private Double totalDistance;

    // Getters and Setters
    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public String getRouteName() {
        return routeName;
    }

    public void setRouteName(String routeName) {
        this.routeName = routeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOriginPincode() {
        return originPincode;
    }

    public void setOriginPincode(String originPincode) {
        this.originPincode = originPincode;
    }

    public String getDestinationPincode() {
        return destinationPincode;
    }

    public void setDestinationPincode(String destinationPincode) {
        this.destinationPincode = destinationPincode;
    }

    public Double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(Double totalDistance) {
        this.totalDistance = totalDistance;
    }
}
