package com.ftn.sbnz.model.dto;

public class BloodStatusDto {

    private int amount;
    private String status;
    public BloodStatusDto() {
    }
    public BloodStatusDto(int amount, String status) {
        this.amount = amount;
        this.status = status;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

}
