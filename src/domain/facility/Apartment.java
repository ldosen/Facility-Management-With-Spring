package domain.facility;

import domain.maintenance.MaintenanceRequest;

import java.util.List;
import java.util.ArrayList;

public class Apartment {

    private int apartmentId;
    private int numberOfRooms;
    private int monthlyRent;
    private int renterId;
    private String occupationStatus;
    private int capacity;
    private int buildingId;
    private int daysInhabited;
    private List<MaintenanceRequest> maintenanceRequests = new ArrayList<>();

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

    public int getApartmentId(){
        return apartmentId;
    }

    public void setApartmentId(int apartmentId){
        this.apartmentId = apartmentId;
    }

    public int getNumberOfRooms(){
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms){
        this.numberOfRooms = numberOfRooms;
    }

    public int getMonthlyRent(){
        return monthlyRent;
    }

    public void setMonthlyRent(int monthlyRent){
        this.monthlyRent = monthlyRent;
    }

    public int getRenterId(){
        return renterId;
    }

    public void setRenterId(int renterId){
        this.renterId = renterId;
    }

    public String getOccupationStatus(){
        return occupationStatus;
    }

    public void setOccupationStatus(String occupationStatus){
        this.occupationStatus = occupationStatus;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public int getCapacity(){
        return capacity;
    }

    public int getBuildingId(){
        return buildingId;
    }

    public void setBuildingId(int buildingId){
        this.buildingId = buildingId;
    }

    public int getDaysInhabited() {
        return daysInhabited;
    }

    public void setDaysInhabited(int daysInhabited) {
        this.daysInhabited = daysInhabited;
    }

    public void setMaintenanceRequests(List<MaintenanceRequest> maintenanceRequests){
        this.maintenanceRequests = maintenanceRequests;
    }

    public void addMaintenanceRequest(MaintenanceRequest maintenanceRequest){
        maintenanceRequests.add(maintenanceRequest);
    }

    @Override
    public String toString(){
        String aptattributes = "Apartment ID:" + Integer.toString(apartmentId) + "\nNumber of Rooms:" +
                Integer.toString(numberOfRooms) + "\nMonthly Rent:" + Integer.toString(monthlyRent) + "\nCurrent Tenant:" + renterId +
                "\nStatus:" + occupationStatus + "\nCapacity:" + capacity + "\nBuildingID:" + buildingId;
        return aptattributes;
    }
}
