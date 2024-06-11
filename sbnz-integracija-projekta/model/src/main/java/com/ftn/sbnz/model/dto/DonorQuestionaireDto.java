package com.ftn.sbnz.model.dto;

public class DonorQuestionaireDto {

    private int donorId;
    private boolean vaccinatedRecently;
    private boolean takingMedicine;
    private boolean hadAspirin;
    private boolean hasDrunkAlcohol;
    private boolean hadTickLymeDisease;
    private boolean hadFever;
    private boolean didTattoosOrPiercing;
    private boolean recievedBloodorOperated;
    private boolean hasHepatitis;
    private boolean hasHIV;
    private boolean hasTakenDrugs;
    public DonorQuestionaireDto() {
    }
    public DonorQuestionaireDto(int donorId, boolean isVaccinatedRecently, boolean takingMedicine, boolean hadAspirin,
            boolean hasDrunkAlcohol, boolean hadTickLymeDisease, boolean hadFever, boolean didTattoosOrPiercing,
            boolean recievedBloodorOperated, boolean hasHepatitis, boolean hasHIV, boolean hasTakenDrugs) {
        this.donorId = donorId;
        this.vaccinatedRecently = isVaccinatedRecently;
        this.takingMedicine = takingMedicine;
        this.hadAspirin = hadAspirin;
        this.hasDrunkAlcohol = hasDrunkAlcohol;
        this.hadTickLymeDisease = hadTickLymeDisease;
        this.hadFever = hadFever;
        this.didTattoosOrPiercing = didTattoosOrPiercing;
        this.recievedBloodorOperated = recievedBloodorOperated;
        this.hasHepatitis = hasHepatitis;
        this.hasHIV = hasHIV;
        this.hasTakenDrugs = hasTakenDrugs;
    }
    public int getDonorId() {
        return donorId;
    }
    public void setDonorId(int donorId) {
        this.donorId = donorId;
    }
    public boolean isVaccinatedRecently() {
        return vaccinatedRecently;
    }
    public void setVaccinatedRecently(boolean isVaccinatedRecently) {
        this.vaccinatedRecently = isVaccinatedRecently;
    }
    public boolean isTakingMedicine() {
        return takingMedicine;
    }
    public void setTakingMedicine(boolean takingMedicine) {
        this.takingMedicine = takingMedicine;
    }
    public boolean isHadAspirin() {
        return hadAspirin;
    }
    public void setHadAspirin(boolean hadAspirin) {
        this.hadAspirin = hadAspirin;
    }
    public boolean isHasDrunkAlcohol() {
        return hasDrunkAlcohol;
    }
    public void setHasDrunkAlcohol(boolean hasDrunkAlcohol) {
        this.hasDrunkAlcohol = hasDrunkAlcohol;
    }
    public boolean isHadTickLymeDisease() {
        return hadTickLymeDisease;
    }
    public void setHadTickLymeDisease(boolean hadTickLymeDisease) {
        this.hadTickLymeDisease = hadTickLymeDisease;
    }
    public boolean isHadFever() {
        return hadFever;
    }
    public void setHadFever(boolean hadFever) {
        this.hadFever = hadFever;
    }
    public boolean isDidTattoosOrPiercing() {
        return didTattoosOrPiercing;
    }
    public void setDidTattoosOrPiercing(boolean didTattoosOrPiercing) {
        this.didTattoosOrPiercing = didTattoosOrPiercing;
    }
    public boolean isRecievedBloodorOperated() {
        return recievedBloodorOperated;
    }
    public void setRecievedBloodorOperated(boolean recievedBloodorOperated) {
        this.recievedBloodorOperated = recievedBloodorOperated;
    }
    public boolean isHasHepatitis() {
        return hasHepatitis;
    }
    public void setHasHepatitis(boolean hasHepatitis) {
        this.hasHepatitis = hasHepatitis;
    }
    public boolean isHasHIV() {
        return hasHIV;
    }
    public void setHasHIV(boolean hasHIV) {
        this.hasHIV = hasHIV;
    }
    public boolean isHasTakenDrugs() {
        return hasTakenDrugs;
    }
    public void setHasTakenDrugs(boolean hasTakenDrugs) {
        this.hasTakenDrugs = hasTakenDrugs;
    }

    
}
