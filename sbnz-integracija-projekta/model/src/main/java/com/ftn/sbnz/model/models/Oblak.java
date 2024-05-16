package com.ftn.sbnz.model.models;

import org.kie.api.definition.type.Position;

public class Oblak {

    @Position(0)
    private String naziv;

    @Position(1)
    private String vrsta;

    public Oblak(String naziv, String vrsta) {
        this.naziv = naziv;
        this.vrsta = vrsta;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String item) {
        this.naziv = item;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String location) {
        this.vrsta = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        if (o == null || getClass() != o.getClass()) { return false; }

        Oblak location1 = (Oblak) o;

        if (naziv != null ? !naziv.equals(location1.naziv) : location1.naziv != null) { return false; }
        if (vrsta != null ? !vrsta.equals(location1.vrsta) : location1.vrsta != null) { return false; }

        return true;
    }

    @Override
    public int hashCode() {
        int result = naziv != null ? naziv.hashCode() : 0;
        result = 31 * result + (vrsta != null ? vrsta.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Location{" +
               "item='" + naziv + '\'' +
               ", location='" + vrsta + '\'' +
               '}';
    }
}
