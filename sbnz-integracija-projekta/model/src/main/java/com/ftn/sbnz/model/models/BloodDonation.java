package com.ftn.sbnz.model.models;

import java.time.LocalDateTime;

public class BloodDonation {

    private int id;
    private int donorId;
    private LocalDateTime date;
    private boolean useEritrocitesOnly;
    private String bloodType;
    private String rhPhenotype;

    public BloodDonation() {
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getDonorId() {
        return donorId;
    }
    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public boolean isUseEritrocitesOnly() {
        return useEritrocitesOnly;
    }
    public void setUseEritrocitesOnly(boolean useEritrocitesOnly) {
        this.useEritrocitesOnly = useEritrocitesOnly;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getRhPhenotype() {
        return rhPhenotype;
    }

    public void setRhPhenotype(String rhPhenotype) {
        this.rhPhenotype = rhPhenotype;
    }

}
