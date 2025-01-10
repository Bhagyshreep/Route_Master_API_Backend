package com.routemasterapi.api.service;

import com.routemasterapi.api.entity.TrackParcelEntity;
import com.routemasterapi.api.repositories.TrackParcelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackParcelService {

    @Autowired
    private TrackParcelRepository trackParcelRepository;

    public List<TrackParcelEntity> getAllTrackParcels() {
        return trackParcelRepository.findAll();
    }

    public Optional<TrackParcelEntity> getTrackParcelById(Long id) {
        return trackParcelRepository.findById(id);
    }

    public TrackParcelEntity saveTrackParcel(TrackParcelEntity trackParcel) {
        return trackParcelRepository.save(trackParcel);
    }

    public void deleteTrackParcel(Long id) {
        trackParcelRepository.deleteById(id);
    }
    public TrackParcelEntity updateTrackParcel(Long id, TrackParcelEntity updatedParcel) {
        return trackParcelRepository.findById(id)
                .map(existingParcel -> {
                    // Update fields
                    existingParcel.setParcelId(updatedParcel.getParcelId());
                    existingParcel.setParcelStatus(updatedParcel.getParcelStatus());
                    existingParcel.setEmployeeId(updatedParcel.getEmployeeId());
                    existingParcel.setApproveReject(updatedParcel.getApproveReject());
                    existingParcel.setTimestamp(updatedParcel.getTimestamp());
                    return trackParcelRepository.save(existingParcel);
                })
                .orElseThrow(() -> new RuntimeException("Parcel with ID " + id + " not found"));
    }

}
