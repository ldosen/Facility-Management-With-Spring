package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.facility.Apartment;
import domain.usage.*;
import domain.inspection.*;

public class UsageDAO {

    public UsageDAO(){}

    public boolean isInUseDuringInterval(){
        try{
            Statement state = DBHelper.getConnection().createStatement();
            String selectIsInUseQuery = "SELECT NumOfPeople FROM Use WHERE NumOfPeople = NULL ";
            ResultSet isInUseResult = state.executeQuery(selectIsInUseQuery);

            boolean empty = true;
            while(isInUseResult.next()){
                if(selectIsInUseQuery.equals(null)){
                    empty = false;
                }
            }

            state.close();
            isInUseResult.close();
            return empty;

        }catch (SQLException e){
            System.err.println("UsageDAO: Threw an exception while calculating the facility usage rate");
            System.err.println(e.getMessage());
        }
        return true;

    }

    public  List<Float> calcUsageRate(int apartmentId){
        try{
            Statement state = DBHelper.getConnection().createStatement();
            String selectUseQuery = "SELECT UseCost FROM Use WHERE ApartmentID ='" + apartmentId + "'";
            ResultSet useResult = state.executeQuery(selectUseQuery);

            List<Float> usageCosts = new ArrayList<>();
            while(useResult.next()){
                usageCosts.add(useResult.getFloat("UsageCost"));
            }

            state.close();
            useResult.close();
            return usageCosts;

        }catch (SQLException e){
            System.err.println("UsageDAO: Threw an exception while calculating the facility usage rate");
            System.err.println(e.getMessage());
        }
        return null;

    }

    public List<String> listActualUsage(int apartmentId){
        try{
            Statement state = DBHelper.getConnection().createStatement();
            String selectActualUsageQuery = "SELECT NumOfPeople FROM Use WHERE ApartmentID ='" + apartmentId + "'";
            ResultSet actualUsageResult = state.executeQuery(selectActualUsageQuery);

            List<String> actualUsageList = new ArrayList<>();
            while(actualUsageResult.next()){
                actualUsageList.add(actualUsageResult.getString("ActualUsage"));
            }

            state.close();
            actualUsageResult.close();
            return actualUsageList;
        }catch (SQLException e){
            System.err.println("Usage DAO: Threw an exception while listing actual usage");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public List<String> listInspections(int apartmentId){
        try{
            Statement state = DBHelper.getConnection().createStatement();
            String selectInspectionsQuery = "SELECT InspectionDetail FROM Inspection WHERE ApartmentID ='" + apartmentId + "'";
            ResultSet inspectionsResult = state.executeQuery(selectInspectionsQuery);

            List<String> inspections = new ArrayList<>();
            while (inspectionsResult.next()){
                inspections.add(inspectionsResult.getString("InspectionID"));
            }

            state.close();
            inspectionsResult.close();
            return inspections;
        }catch (SQLException e){
            System.err.println("UsageDAO: Threw exception while trying to list inspections");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void vacateFacility(){

        try {
            Statement state = DBHelper.getConnection().createStatement();
            String vacateFacilityQuery = "UPDATE Use SET NumOfPeople = NULL";
            state.execute(vacateFacilityQuery);
            state.close();
        } catch ( SQLException e){
            System.err.println("UsageDAO: Error vacating facility");
            System.err.println(e.getMessage());
        }
    }

}
