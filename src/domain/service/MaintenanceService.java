package domain.service;

import dal.MaintenanceDAO;
import domain.maintenance.*;
import org.w3c.dom.events.EventException;

import java.util.ArrayList;
import java.util.List;

public class MaintenanceService {

    private MaintenanceDAO maintenanceDAO = new MaintenanceDAO();

    public void makeFacilityMaintenanceRequest(MaintenanceRequest maintenanceRequest, int apartmentId){
        try{
            maintenanceDAO.makeFacilityMaintenanceRequest(maintenanceRequest, apartmentId);
        }catch (Exception e){
            System.err.println("MaintenanceService: threw an exception while trying to make a new maintenance request");
            System.err.println(e.getMessage());
        }
    }

    public List<Integer> listMaintenanceRequests(int apartmentId){
        try{
            List<Integer> maintenanceReqs = maintenanceDAO.listMaintenanceRequests(apartmentId);
            return maintenanceReqs;
        }catch (Exception e){
            System.err.println("MaintenanceService: threw an exception while trying to list maintenance requests");
            System.err.println(e.getMessage());
        }
        return null;
    }

    // lists maintenance performed on a given Apartment
    public List<Integer> listMaintenance(int apartmentId){
        try{
            List<Integer> maintenancePerformed = maintenanceDAO.listMaintenance(apartmentId);
            return maintenancePerformed;
        }catch (Exception e){
            System.err.println("MaintenanceService: threw an exception while trying to list maintenance performed");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public List<String> listFacilityProblems(int apartmentId){
        try{
            List<String> problemsList = maintenanceDAO.listFacilityProblems(apartmentId);
            return problemsList;
        }catch (Exception e){
            System.err.println("MaintenanceService: threw an exception while trying to get facility problems");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void scheduleMaintenance(MaintenanceVisit maintenanceVisit, int apartmentId, int problemId){
        try{
            maintenanceDAO.scheduleMaintenance(maintenanceVisit, apartmentId, problemId);
        }catch (Exception e){
            System.err.println("MaintenanceService: threw an exception while trying to schedule maintenance");
            System.err.println(e.getMessage());
        }
    }

    public float calcMaintenanceCostForFacility(int apartmentId){
        try{
            List<Float> costs = maintenanceDAO.calcMaintenanceCostForFacility(apartmentId);
            // calculate the total cost from the list elements
            float cost = 0;
            for(Float f: costs){
                cost += f;
            }
            return cost;

        }catch (Exception e){
            System.err.println("MaintenanceService: threw an exception while trying to calculate facility maintenance cost");
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public float calcProblemRateForFacility(int apartmentId, int daysInhabited){
        try {
            List<String> problemList = maintenanceDAO.listFacilityProblems(apartmentId);
            float totalProblems = problemList.size();
            float problemRate = totalProblems/daysInhabited;
            return problemRate;
        } catch (Exception e){
            System.err.println("MaintenanceService: threw an exception while trying to calculate facility problem rate");
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public float calcDownTimeForFacility(int apartmentId){
        try{
            List<Float> fixTimes = maintenanceDAO.calcDownTimeForFacility(apartmentId);
            // calculate the total downtime from the list elements
            float downtime = 0;
            for(Float f: fixTimes){
                downtime += f;
            }
            return downtime;
        }catch (Exception e){
            System.err.println("MaintenanceService: threw an exception while trying to calculate maintenance downtime");
            System.err.println(e.getMessage());
        }
        return -1;
    }
}