package domain.facility;

import domain.inspection.Inspection;
import domain.renter.Address;
import domain.usage.Use;

import java.util.List;
import java.util.ArrayList;

public class Building implements Ibuilding {
    private int buildingId;
    private Address address;
    private Use use;
    private List<Inspection> inspections;

    public Building(){}

    public Building(int buildingId){
        this.buildingId = buildingId;
    }

    @Override
    public int getFacilityId() {
        return buildingId;
    }

    @Override
    public void setFacilityId(int buildingId) {
        this.buildingId = buildingId;
    }

    @Override
    public Address getAddress() {
        return address;
    }

    @Override
    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public List<Inspection> getInspections() {
        return inspections;
    }

    @Override
    public void setInspections(List<Inspection> inspections) {
        this.inspections = inspections;
    }

    @Override
    public void addInspection(Inspection inspection) {
        inspections.add(inspection);
    }

    @Override
    public void setUse(Use use) {
        this.use = use;
    }

    @Override
    public Use getUse() {
        return use;
    }

}
