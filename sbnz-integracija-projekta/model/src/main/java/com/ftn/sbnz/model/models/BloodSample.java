package com.ftn.sbnz.model.models;

import org.kie.api.definition.type.Position;

public class BloodSample {

    @Position(0)
    private int id;

    @Position(1)
    private BloodType bloodType;

    @Position(2)
    private boolean RhD;

    @Position(3)
    private RhPhenotype rhPhenotype;

    @Position(4)
    private boolean irregularEritrociteAntibodies;

    @Position(5)
    private boolean irregularEritrociteAntibodiesPresent;

    @Position(6)
    private boolean irregularEritrociteAntibodiesSpecific;

    @Position(7)
    private boolean useEritrocitesOnly;

    @Position(8)
    private boolean hivPositive;

    @Position(9)
    private boolean hepatitisBPositive;

    @Position(10)
    private boolean hepatitisCPositive;

    @Position(11)
    private boolean syphilisPositive;

    public BloodSample(int id, BloodType bloodType, boolean rhD, RhPhenotype rhPhenotype, boolean irregularEritrociteAntibodies,
            boolean irregularEritrociteAntibodiesPresent, boolean irregularEritrociteAntibodiesSpecific,
            boolean useEritrocitesOnly, boolean hivPositive, boolean hepatitisBPositive, boolean hepatitisCPositive,
            boolean syphilisPositive) {
        this.id = id;
        this.bloodType = bloodType;
        this.RhD = rhD;
        this.rhPhenotype = rhPhenotype;
        this.irregularEritrociteAntibodies = irregularEritrociteAntibodies;
        this.irregularEritrociteAntibodiesPresent = irregularEritrociteAntibodiesPresent;
        this.irregularEritrociteAntibodiesSpecific = irregularEritrociteAntibodiesSpecific;
        this.useEritrocitesOnly = useEritrocitesOnly;
        this.hivPositive = hivPositive;
        this.hepatitisBPositive = hepatitisBPositive;
        this.hepatitisCPositive = hepatitisCPositive;
        this.syphilisPositive = syphilisPositive;
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
    
}
