package com.ftn.sbnz.model.models;

import java.util.Random;

public class BloodSample {

    private int id;
    private int donorId;
    private BloodType bloodType;
    private boolean RhD;
    private RhPhenotype rhPhenotype;
    private boolean irregularEritrociteAntibodies;
    private boolean irregularEritrociteAntibodiesPresent;
    private boolean irregularEritrociteAntibodiesSpecific;
    private boolean useEritrocitesOnly;
    private boolean additionalTesting;
    private boolean additionalTestingDone;
    private boolean hivPositive;
    private boolean hepatitisBPositive;
    private boolean hepatitisCPositive;
    private boolean syphilisPositive;

    public BloodSample(int id, int donorId, BloodType bloodType, boolean rhD, RhPhenotype rhPhenotype,
            boolean irregularEritrociteAntibodies, boolean irregularEritrociteAntibodiesPresent,
            boolean irregularEritrociteAntibodiesSpecific, boolean useEritrocitesOnly, boolean hivPositive,
            boolean hepatitisBPositive, boolean hepatitisCPositive, boolean syphilisPositive) {
        this.id = id;
        this.donorId = donorId;
        this.bloodType = bloodType;
        RhD = rhD;
        this.rhPhenotype = rhPhenotype;
        this.irregularEritrociteAntibodies = irregularEritrociteAntibodies;
        this.irregularEritrociteAntibodiesPresent = irregularEritrociteAntibodiesPresent;
        this.irregularEritrociteAntibodiesSpecific = irregularEritrociteAntibodiesSpecific;
        this.useEritrocitesOnly = useEritrocitesOnly;
        this.hivPositive = hivPositive;
        this.hepatitisBPositive = hepatitisBPositive;
        this.hepatitisCPositive = hepatitisCPositive;
        this.syphilisPositive = syphilisPositive;
        this.additionalTesting = false;
        this.additionalTestingDone = false;
    }

    public BloodSample() {
    }

    public int getId() {
        return id;
    }

    public void setId(int item) {
        this.id = item;
    }

    public BloodType getBloodType() {
        return this.bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
    }
    
    public boolean isRhD() {
        return RhD;
    }

    public void setRhD(boolean rhD) {
        this.RhD = rhD;
    }

    public RhPhenotype getRhPhenotype() {
        return rhPhenotype;
    }

    public void setRhPhenotype(RhPhenotype rhPhenotype) {
        this.rhPhenotype = rhPhenotype;
    }

    public boolean isIrregularEritrociteAntibodies() {
        return irregularEritrociteAntibodies;
    }

    public void setIrregularEritrociteAntibodies(boolean irregularEritrociteAntibodies) {
        this.irregularEritrociteAntibodies = irregularEritrociteAntibodies;
    }

    public boolean isIrregularEritrociteAntibodiesPresent() {
        return irregularEritrociteAntibodiesPresent;
    }

    public void setIrregularEritrociteAntibodiesPresent(boolean irregularEritrociteAntibodiesPresent) {
        this.irregularEritrociteAntibodiesPresent = irregularEritrociteAntibodiesPresent;
    }

    public boolean isIrregularEritrociteAntibodiesSpecific() {
        return irregularEritrociteAntibodiesSpecific;
    }

    public void setIrregularEritrociteAntibodiesSpecific(boolean irregularEritrociteAntibodiesSpecific) {
        this.irregularEritrociteAntibodiesSpecific = irregularEritrociteAntibodiesSpecific;
    }

    public boolean isUseEritrocitesOnly() {
        return useEritrocitesOnly;
    }

    public void setUseEritrocitesOnly(boolean useEritrocitesOnly) {
        this.useEritrocitesOnly = useEritrocitesOnly;
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

    @Override
    public boolean equals(Object obj) {
        BloodSample other = (BloodSample) obj;
        if(this.getId() != other.getId()) { return false; }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    @Override
    public String toString() {
        return "BloodSample [id=" + id + ", bloodType=" + bloodType + ", RhD=" + RhD + ", rhPhenotype=" + rhPhenotype
                + ", irregularEritrociteAntibodies=" + irregularEritrociteAntibodies
                + ", irregularEritrociteAntibodiesPresent=" + irregularEritrociteAntibodiesPresent
                + ", irregularEritrociteAntibodiesSpecific=" + irregularEritrociteAntibodiesSpecific
                + ", useEritrocitesOnly=" + useEritrocitesOnly + ", hivPositive=" + hivPositive
                + ", hepatitisBPositive=" + hepatitisBPositive + ", hepatitisCPositive=" + hepatitisCPositive
                + ", syphilisPositive=" + syphilisPositive + "]";
    }

    public int getDonorId() {
        return donorId;
    }

    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }

    public boolean isAdditionalTesting() {
        return additionalTesting;
    }

    public void setAdditionalTesting(boolean additionalTesting) {
        this.additionalTesting = additionalTesting;
    }

    public boolean isAdditionalTestingDone() {
        return additionalTestingDone;
    }

    public void setAdditionalTestingDone(boolean additionalTestingDone) {
        this.additionalTestingDone = additionalTestingDone;
    }
    public void redoHepatitisCTest(){
        Random r = new Random();
        double x = r.nextDouble();
        if(x<=0.1){
            this.hepatitisCPositive = !this.hepatitisCPositive;
        }
    }
    public void redoHepatitisBTest(){
        Random r = new Random();
        double x = r.nextDouble();
        if(x<=0.1){
            this.hepatitisBPositive = !this.hepatitisBPositive;
        }
    }
    public void redoHIVTest(){
        Random r = new Random();
        double x = r.nextDouble();
        if(x<=0.1){
            this.hivPositive = !this.hivPositive;
        }
    }
    public void redoSyphilisTest(){
        Random r = new Random();
        double x = r.nextDouble();
        if(x<=0.1){
            this.syphilisPositive = !this.syphilisPositive;
        }
    }
}   
