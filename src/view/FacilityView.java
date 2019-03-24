package view;

import domain.maintenance.MaintenanceRequest;
import domain.service.MaintenanceService;
import domain.service.UsageService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import domain.facility.*;
import domain.service.FacilityService;
import domain.service.RenterService;
import domain.renter.*;
import java.util.List;
import java.util.ArrayList;

public class FacilityView {

    public static void main(String args[]) throws Exception{

        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");

        // instantiate the necessary services
        FacilityService facilityService = new FacilityService();
        RenterService renterService = new RenterService();
        MaintenanceService maintenanceService = new MaintenanceService();
        UsageService usageService = new UsageService();

        // test addFacility
        Building building = (Building) context.getBean("building");
        building.setFacilityId(1000);
        Address address = (Address) context.getBean("buildingaddress");
        building.setAddress(address);
        facilityService.addFacility(building);

        // test remove facility
        // facilityService.removeFacility(1000);

        // test list facilities
        List<Integer> facilities = facilityService.listFacilities();
        System.out.println("Facilities:");
        for(Integer element : facilities){
            System.out.println(element);
        }

        // test getApartmentInformation
        Apartment apartment = facilityService.getApartmentInformation(1000);
        System.out.println(apartment.toString());

        //test requestCapacity
        int apartmentNo = 1;
        int capacity = facilityService.requestCapacity(apartmentNo);
        System.out.println("Apartment " + apartmentNo + " capaity:" + capacity);

        // test addApartment
        Apartment apartmentToAdd = (Apartment) context.getBean("apartment");
        System.out.println("Apartment added successfully!");

        /***************************Maintenance Service*****************************/

        //test makeFacilityMaintenanceRequest
        MaintenanceRequest maintenanceRequest = (MaintenanceRequest) context.getBean("maintenancerequest");
        maintenanceService.makeFacilityMaintenanceRequest(maintenanceRequest, 1);
        System.out.println("Maintenance request filed");

        //test listMaintenanceRequests
        List maintenanceRequests = maintenanceService.listMaintenanceRequests(1);


        //test listMaintenance
        List maintenancePerformed = maintenanceService.listMaintenance(1);

        //test listFacilityProblems
        List facilityProblems = maintenanceService.listFacilityProblems(1);

        //test calcMaintenanceCost
        float cost = maintenanceService.calcMaintenanceCostForFacility(1);
        System.out.println("Apartment maintenance cost: " + cost);

        //test calcProblemRateForFacility
        float problemRate = maintenanceService.calcProblemRateForFacility(1, 30);
        System.out.println("Problem rate for given apartment: " + problemRate);

        // test calcDownTimeForFacility
        float downTime = maintenanceService.calcDownTimeForFacility(1);
        System.out.println("Given the facility problems and the time to fix each, the expected downtime to fix the problems is: " + downTime);

        /***************************Usage Service*****************************/

        // test isInUseDuringInterval
        if(usageService.isInUseDuringInterval()){
            System.out.println("Facility was in use during this interval");
        } else {
            System.out.println("System was not in use during this interval");
        }

        //test calcUsageRate
        float usageRate = usageService.calcUsageRate(1);
        System.out.println("Usage rate for given apartment: " + usageRate);

        //test listInspections
        List inspections = usageService.listInspections(1000);
        System.out.println(inspections);

        // test vacateFacility
        usageService.vacateFacility();
        System.out.println("Facility successfully vacated");
    }
}
