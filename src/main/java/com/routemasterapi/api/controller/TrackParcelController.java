package com.routemasterapi.api.controller;


import com.routemasterapi.api.entity.TrackParcelEntity;
import com.routemasterapi.api.service.TrackParcelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/trackparcel")
public class TrackParcelController {

    @Autowired
    private TrackParcelService trackParcelService;

    @GetMapping
    public ResponseEntity<List<TrackParcelEntity>> getAllTrackParcels() {
        List<TrackParcelEntity> parcels = trackParcelService.getAllTrackParcels();
        return ResponseEntity.ok(parcels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrackParcelEntity> getTrackParcelById(@PathVariable Long id) {
        Optional<TrackParcelEntity> trackParcel = trackParcelService.getTrackParcelById(id);
        return trackParcel.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TrackParcelEntity> createTrackParcel(@RequestBody TrackParcelEntity trackParcel) {
        TrackParcelEntity savedParcel = trackParcelService.saveTrackParcel(trackParcel);
        return ResponseEntity.ok(savedParcel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTrackParcel(@PathVariable Long id) {
        trackParcelService.deleteTrackParcel(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<TrackParcelEntity> updateTrackParcel(
            @PathVariable Long id,
            @RequestBody TrackParcelEntity updatedParcel) {
        try {
            TrackParcelEntity updatedEntity = trackParcelService.updateTrackParcel(id, updatedParcel);
            return ResponseEntity.ok(updatedEntity);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
