package domain.facility;

import domain.maintenance.MaintenanceRequest;
import domain.maintenance.MaintenanceVisit;
import domain.maintenance.Problem;

import java.util.List;
import java.util.ArrayList;

public class Apartment implements Iapartment {

    private int apartmentId;
    private int numberOfRooms;
    private int monthlyRent;
    private int renterId;
    private String occupationStatus;
    private int capacity;
    private int buildingId;
    private int daysInhabited;
    private List<MaintenanceRequest> maintenanceRequests;
    private List<MaintenanceVisit> maintenanceVisits;
    private List<Problem> problems;

    public Apartment(){}

    public Apartment(int apartmentId, int numberOfRooms, int monthlyRent, int renterId, String occupationStatus, int capacity, int buildingId){
        this.apartmentId = apartmentId;
        this.numberOfRooms = numberOfRooms;
        this.monthlyRent = monthlyRent;
        this.renterId = renterId;
        this.occupationStatus = occupationStatus;
        this.capacity = capacity;
        this.buildingId = buildingId;
    }

    @Override
    public int getApartmentId() {
        return apartmentId;
    }

    @Override
    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    @Override
    public int getMonthlyRent() {
        return monthlyRent;
    }

    @Override
    public void setMonthlyRent(int monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    @Override
    public int getRenterId() {
        return renterId;
    }

    @Override
    public void setRenterId(int renterId) {
        this.renterId = renterId;
    }

    @Override
    public String getOccupationStatus() {
        return occupationStatus;
    }

    @Override
    public void setOccupationStatus(String occupationStatus) {
        this.occupationStatus = occupationStatus;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int getBuildingId() {
        return buildingId;
    }

    @Override
    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    @Override
    public int getDaysInhabited() {
        return daysInhabited;
    }

    @Override
    public void setDaysInhabited(int daysInhabited) {
        this.daysInhabited = daysInhabited;
    }

    @Override
    public List<MaintenanceRequest> getMaintenanceRequests() {
        return maintenanceRequests;
    }

    @Override
    public void setMaintenanceRequests(List<MaintenanceRequest> maintenanceRequests) {
        this.maintenanceRequests = maintenanceRequests;
    }

    @Override
    public void addMaintenanceRequest(MaintenanceRequest maintenanceRequest) {
        maintenanceRequests.add(maintenanceRequest);
    }

    @Override
    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    @Override
    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public List<MaintenanceVisit> getMaintenanceVisits() {
        return maintenanceVisits;
    }

    @Override
    public void setMaintenanceVisits(List<MaintenanceVisit> maintenanceVisits) {
        this.maintenanceVisits = maintenanceVisits;
    }

    @Override
    public void addMaintenanceVisit(MaintenanceVisit maintenanceVisit){
        maintenanceVisits.add(maintenanceVisit);
    }

    @Override
    public List<Problem> getProblems() {
        return problems;
    }

    @Override
    public void setProblems(List<Problem> problems) {
        this.problems = problems;
    }

    @Override
    public void addProblem(Problem problem){
        problems.add(problem);
    }

    @Override
    public String toString(){
        String aptattributes = "Apartment ID:" + Integer.toString(apartmentId) + "\nNumber of Rooms:" +
                Integer.toString(numberOfRooms) + "\nMonthly Rent:" + Integer.toString(monthlyRent) + "\nCurrent Tenant:" + renterId +
                "\nStatus:" + occupationStatus + "\nCapacity:" + capacity + "\nBuildingID:" + buildingId;
        return aptattributes;
    }
}
