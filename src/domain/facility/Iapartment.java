package domain.facility;

import domain.maintenance.MaintenanceRequest;

import java.util.List;

public interface Iapartment {

    public int getApartmentId();
    public void setApartmentId(int apartmentId);
    public int getMonthlyRent();
    public void setMonthlyRent(int monthlyRent);
    public int getRenterId();
    public void setRenterId(int renterId);
    public String getOccupationStatus();
    public void setOccupationStatus(String occupationStatus);
    public int getCapacity();
    public void setCapacity(int capacity);
    public int getBuildingId();
    public  void setBuildingId(int buildingId);
    public int getDaysInhabited();
    public void setDaysInhabited(int daysInhabited);
    public List<MaintenanceRequest> getMaintenanceRequests();
    public void setMaintenanceRequests(List<MaintenanceRequest> maintenanceRequests);
    public void addMaintenanceRequest(MaintenanceRequest maintenanceRequest);
    public int getNumberOfRooms();
    public void setNumberOfRooms(int numberOfRooms);
}
