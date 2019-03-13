package domain.service;

import dal.FacilityDAO;
import domain.facility.*;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import domain.renter.Address;

import java.util.List;

public class FacilityService {

    private FacilityDAO facilityDAO = new FacilityDAO();

    public void addFacility(Building building){
        try{
            facilityDAO.addFacility(building);
        } catch (Exception e){
            System.err.println("FacilityService: threw and exception adding a new facility");
            System.err .println(e.getMessage());
        }
    }

    public void removeFacility(int buildingId){
        try{
            facilityDAO.removeFacility(buildingId);
        } catch (Exception e){
            System.err.println("FacilityService: error removing facility");
            System.err.println(e.getMessage());
        }
    }

    public List<Integer> listFacilities(){
        try{
            List<Integer> facilities = facilityDAO.listFacilities();
            return facilities;
        } catch (Exception e){
            System.err.println("FacilityService: error retrieving facilities list");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public Apartment getApartmentInformation(int buildingId){
        try{
            Apartment apartment = facilityDAO.getApartmentInformation(buildingId);
            return apartment;
        } catch (Exception e){
            System.err.println("FacilityService: error retrieving apartment");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public int requestCapacity(int apartmentId){
        try{
            int capacity = facilityDAO.getApartmentCapacity(apartmentId);
            return capacity;
        } catch (Exception e){
            System.err.println("FacilityService: Error when getting capacity");
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public void addApartment(Apartment apartment){
        try{
            facilityDAO.addApartment(apartment);
        } catch(Exception e){
            System.err.println("FacilityService: error when trying to add Apartment object");
            System.err.println(e.getMessage());
        }
    }
}
