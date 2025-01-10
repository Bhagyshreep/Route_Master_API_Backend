package com.routemasterapi.api.entity;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "yourname_trackparcel")
public class TrackParcelEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trackParcelId;

    private Long parcelId;

    @Column(length = 25)
    private String parcelStatus;

    private Long employeeId;

    @Column(length = 10)
    private String approveReject;

    @Temporal(TemporalType.DATE)
    private Date timestamp;

    // Getters and Setters
    public Long getTrackParcelId() {
        return trackParcelId;
    }

    public void setTrackParcelId(Long trackParcelId) {
        this.trackParcelId = trackParcelId;
    }

    public Long getParcelId() {
        return parcelId;
    }

    public void setParcelId(Long parcelId) {
        this.parcelId = parcelId;
    }

    public String getParcelStatus() {
        return parcelStatus;
    }

    public void setParcelStatus(String parcelStatus) {
        this.parcelStatus = parcelStatus;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getApproveReject() {
        return approveReject;
    }

    public void setApproveReject(String approveReject) {
        this.approveReject = approveReject;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
