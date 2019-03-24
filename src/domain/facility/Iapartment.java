package domain.facility;

import domain.maintenance.MaintenanceRequest;
import domain.maintenance.MaintenanceVisit;
import domain.maintenance.Problem;

import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

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
    public List<MaintenanceVisit> getMaintenanceVisits();
    public void setMaintenanceVisits(List<MaintenanceVisit> maintenanceVisits);
    public void addMaintenanceVisit(MaintenanceVisit maintenanceVisit);
    public List<Problem> getProblems();
    public void setProblems(List<Problem> problems);
    public void addProblem(Problem problem);

}
