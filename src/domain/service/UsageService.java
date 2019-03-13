package domain.service;
import dal.UsageDAO;
import domain.usage.*;
import domain.facility.*;

import java.util.List;

public class UsageService {
    private UsageDAO usageDAO = new UsageDAO();

    public boolean isInUseDuringInterval(){
        try{
            usageDAO.isInUseDuringInterval();
        } catch (Exception e){
            System.err.println("UsageService: threw an exception checking if the facility is in use during the interval");
            System.err.println(e.getMessage());
        }
        return true;
    }

    public float calcUsageRate(int apartmentId){
        try{
            List<Float> usageRates = usageDAO.calcUsageRate(apartmentId);
            // calculate the total downtime from the list elements
            float useRate = 0;
            for(Float f: usageRates){
                useRate += f;
            }
            return useRate;
        }catch (Exception e){
            System.err.println("UsageService: threw an exception while trying to calculate facility usage rate");
            System.err.println(e.getMessage());
        }
        return -1;
    }

    public List<String> listActualUsage(int apartmentId){
        try{
            List<String> actualUsageList = usageDAO.listActualUsage(apartmentId);
            return actualUsageList;
        } catch (Exception e){
            System.err.println("FacilityService: error retrieving actual usage list");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public List<String> listInspections(int apartmentId){
        try{
            List<String> inspections = usageDAO.listInspections(apartmentId);
            return inspections;
        } catch (Exception e){
            System.err.println("UsageService: error retrieving inspections list");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void vacateFacility(){
        try{
            usageDAO.vacateFacility();
        } catch (Exception e){
            System.err.println("UsageService: error vacating the facility");
            System.err.println(e.getMessage());
        }
    }
}