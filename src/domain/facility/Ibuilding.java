package domain.facility;

import domain.renter.Address;
import domain.inspection.Inspection;
import java.util.List;

public interface Ibuilding {

    public int getFacilityId();
    public void setFacilityId(int facilityId);
    public Address getAddress();
    public void setAddress(Address address);
    public List<Inspection> getInspections();
    public void setInspections(List<Inspection> inspections);
    public void addInspection(Inspection inspection);
}
