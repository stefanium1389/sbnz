package com.ftn.sbnz.model.models;

import java.time.LocalDateTime;

public class BloodDonor {

    private int id;
    private int numberOfDonations;
    private boolean canDonate;
    private LocalDateTime lastDonated;
    private LocalDateTime bannedUntil;
    public BloodDonor() {
    }
    public BloodDonor(int id, int numberOfDonations, boolean canDonate, LocalDateTime lastDonated,
            LocalDateTime bannedUntil) {
        this.id = id;
        this.numberOfDonations = numberOfDonations;
        this.canDonate = canDonate;
        this.lastDonated = lastDonated;
        this.bannedUntil = bannedUntil;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getNumberOfDonations() {
        return numberOfDonations;
    }
    public void setNumberOfDonations(int numberOfDonations) {
        this.numberOfDonations = numberOfDonations;
    }
    public boolean isCanDonate() {
        return canDonate;
    }
    public void setCanDonate(boolean canDonate) {
        this.canDonate = canDonate;
    }
    public LocalDateTime getLastDonated() {
        return lastDonated;
    }
    public void setLastDonated(LocalDateTime lastDonated) {
        this.lastDonated = lastDonated;
    }
    public LocalDateTime getBannedUntil() {
        return bannedUntil;
    }
    public void setBannedUntil(LocalDateTime bannedUntil) {
        this.bannedUntil = bannedUntil;
    }
    @Override
    public String toString() {
        return "BloodDonor [id=" + id + ", numberOfDonations=" + numberOfDonations + ", canDonate=" + canDonate
                + ", lastDonated=" + lastDonated + ", bannedUntil=" + bannedUntil + "]";
    }

    

}
