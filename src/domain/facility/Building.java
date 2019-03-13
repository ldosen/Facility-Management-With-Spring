package domain.facility;

import domain.inspection.Inspection;
import domain.renter.Address;
import java.util.List;
import java.util.ArrayList;

public class Building {
    private int buildingId;
    private Address address;
    private List<Inspection> inspections = new ArrayList<>();

    public Building(){}

    public Building(int buildingId){
        this.buildingId = buildingId;
    }

    public int getFacilityId() {
        return buildingId;
    }

    public void setFacilityId(int buildingId) {
        this.buildingId = buildingId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address){
        this.address = address;
    }

    public void setInspections(List<Inspection> inspections){
        this.inspections = inspections;
    }

    public void addInspection(Inspection inspection){
        inspections.add(inspection);
    }
}
