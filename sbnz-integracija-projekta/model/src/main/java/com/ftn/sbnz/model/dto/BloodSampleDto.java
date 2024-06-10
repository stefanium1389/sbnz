package com.ftn.sbnz.model.dto;

public class BloodSampleDto {
    private int id;
    private int donorId;
    private String bloodType;
    private boolean RhD;
    private String rhPhenotype;
    private boolean hivPositive;
    private boolean hepatitisBPositive;
    private boolean hepatitisCPositive;
    private boolean syphilisPositive;
    private boolean useEritrocitesOnly;
    
    public BloodSampleDto(int id, int donorId, String bloodType, boolean rhD, String rhPhenotype, boolean hivPositive,
            boolean hepatitisBPositive, boolean hepatitisCPositive, boolean syphilisPositive,
            boolean useEritrocitesOnly) {
        this.id = id;
        this.donorId = donorId;
        this.bloodType = bloodType;
        RhD = rhD;
        this.rhPhenotype = rhPhenotype;
        this.hivPositive = hivPositive;
        this.hepatitisBPositive = hepatitisBPositive;
        this.hepatitisCPositive = hepatitisCPositive;
        this.syphilisPositive = syphilisPositive;
        this.useEritrocitesOnly = useEritrocitesOnly;
    }
    public BloodSampleDto() {
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
    public String getBloodType() {
        return bloodType;
    }
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
    public boolean isRhD() {
        return RhD;
    }
    public void setRhD(boolean rhD) {
        RhD = rhD;
    }
    public String getRhPhenotype() {
        return rhPhenotype;
    }
    public void setRhPhenotype(String rhPhenotype) {
        this.rhPhenotype = rhPhenotype;
    }
    public boolean isHivPositive() {
        return hivPositive;
    }
    public void setHivPositive(boolean hivPositive) {
        this.hivPositive = hivPositive;
    }
    public boolean isHepatitisBPositive() {
        return hepatitisBPositive;
    }
    public void setHepatitisBPositive(boolean hepatitisBPositive) {
        this.hepatitisBPositive = hepatitisBPositive;
    }
    public boolean isHepatitisCPositive() {
        return hepatitisCPositive;
    }
    public void setHepatitisCPositive(boolean hepatitisCPositive) {
        this.hepatitisCPositive = hepatitisCPositive;
    }
    public boolean isSyphilisPositive() {
        return syphilisPositive;
    }
    public void setSyphilisPositive(boolean syphilisPositive) {
        this.syphilisPositive = syphilisPositive;
    }
    public boolean isUseEritrocitesOnly() {
        return useEritrocitesOnly;
    }
    public void setUseEritrocitesOnly(boolean useEritrocitesOnly) {
        this.useEritrocitesOnly = useEritrocitesOnly;
    }
}
