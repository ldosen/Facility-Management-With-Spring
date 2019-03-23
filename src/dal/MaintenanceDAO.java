package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import domain.facility.Apartment;
import domain.maintenance.*;

import javax.sound.midi.SysexMessage;

public class MaintenanceDAO {

    public MaintenanceDAO(){}

    public void makeFacilityMaintenanceRequest(MaintenanceRequest maintenanceRequest, int apartmentId){
        Connection con = DBHelper.getConnection();
        PreparedStatement mrPst = null;

        try{
            String mrStm = "INSERT INTO MaintenanceRequest(RequestID, MaintenanceDescription, ApartmentID) VALIUES(?, ?, ?)";
            mrPst = con.prepareStatement(mrStm);
            mrPst.setInt(1, maintenanceRequest.getRequestId());
            mrPst.setString(2, maintenanceRequest.getMaintenanceDescription());
            mrPst.setInt(3, apartmentId);

            mrPst.close();
            con.close();
        } catch (SQLException e){
            System.err.println("Maintenance DAO: Threw an exception while making new maintenance request");
            System.err.println(e.getMessage());
        }
    }

    public void scheduleMaintenance(MaintenanceVisit maintenanceVisit, int apartmentId, int problemId){
        Connection con = DBHelper.getConnection();
        PreparedStatement mvPst = null;

        try{
            String mvStm = "INSERT INTO MaintenanceVisit(VisitID, ApartmentID, ProblemID) VALUES(?, ?, ?)";
            mvPst = con.prepareStatement(mvStm);
            mvPst.setInt(1, maintenanceVisit.getVisitId());
            mvPst.setInt(2, apartmentId);
            mvPst.setInt(3, problemId);

            mvPst.close();
            con.close();

        }catch (SQLException e){
            System.err.println("MaintenanceDAO: Threw an exception while scheduling a new maintenance visit");
            System.err.println(e.getMessage());
        }
    }

    public List<Float> calcMaintenanceCostForFacility(int apartmentId){
        try{
            Statement st = DBHelper.getConnection().createStatement();
            String selectProblemsQuery = "SELECT CostToFix FROM Problem WHERE ApartmentID ='" + apartmentId + "'";
            ResultSet problemsResult = st.executeQuery(selectProblemsQuery);

            // add costs to list to return to the serviceworker
            List<Float> problemsCosts = new ArrayList<>();
            while(problemsResult.next()){
                problemsCosts.add(problemsResult.getFloat("CostToFix"));
            }

            st.close();
            problemsResult.close();
            return problemsCosts;

        }catch (SQLException e){
            System.err.println("Maintenance DAO: Threw an exception while calculating facility maintenance cost");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public List<String> listFacilityProblems(int apartmentId){
        try{
            Statement st = DBHelper.getConnection().createStatement();
            String selectProblemsQuery = "SELECT ProblemDescription FROM Problem WHERE ApartmentID ='" + apartmentId + "'";
            ResultSet problemsResult = st.executeQuery(selectProblemsQuery);

            // add problem descriptions to list which will be returned to the serviceworker
            List<String> problemsList = new ArrayList<>();
            while(problemsResult.next()){
                problemsList.add(problemsResult.getString("ProblemDescription"));
            }

            st.close();
            problemsResult.close();
            return problemsList;
        }catch (SQLException e){
            System.err.println("Maintenance DAO: Threw an exception while listing facility problems");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public List<Float> calcDownTimeForFacility(int apartmentId){
        try{
            Statement st = DBHelper.getConnection().createStatement();
            String selectFixTimeQuery = "SELECT TimeToFix FROM Problem WHERE ApartmentID ='" + apartmentId + "'";
            ResultSet fixTimeResult = st.executeQuery(selectFixTimeQuery);

            // add times to list to return to the serviceworker
            List<Float> problemsFixTimes = new ArrayList<>();
            while(fixTimeResult.next()){
                problemsFixTimes.add(fixTimeResult.getFloat("TimeToFix"));
            }

            st.close();
            fixTimeResult.close();
            return problemsFixTimes;

        }catch (SQLException e){
            System.err.println("Maintenance DAO: Threw an exception while calculating facility maintenance cost");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public List<Integer> listMaintenanceRequests(int apartmentId){
        try{
            Statement st = DBHelper.getConnection().createStatement();
            String selectMaintenanceReqsQuery = "SELECT RequestID FROM MaintenanceRequest WHERE ApartmentID ='" + apartmentId + "'";
            ResultSet maintenanceReqsResult = st.executeQuery(selectMaintenanceReqsQuery);

            // add maintenance requests to return to the service worker
            List<Integer> maintenanceRequests = new ArrayList<>();
            while (maintenanceReqsResult.next()){
                maintenanceRequests.add(maintenanceReqsResult.getInt("RequestID"));
            }

            st.close();
            maintenanceReqsResult.close();
            return maintenanceRequests;
        }catch (SQLException e){
            System.err.println("Maintenance DAO: Threw exception while trying to list maintenance requests");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public List<Integer> listMaintenance(int apartmentId){
        try{
            Statement st = DBHelper.getConnection().createStatement();
            String selectMaintenancePerformedQuery = "SELECT VisitID FROM MaintenanceVisit WHERE ApartmentID ='" + apartmentId + "'";
            ResultSet maintenancePerformedResult = st.executeQuery(selectMaintenancePerformedQuery);

            // add maintenance requests to return to the service worker
            List<Integer> maintenancePerformed = new ArrayList<>();
            while (maintenancePerformedResult.next()){
                maintenancePerformed.add(maintenancePerformedResult.getInt("VisitID"));
            }

            st.close();
            maintenancePerformedResult.close();
            return maintenancePerformed;
        }catch (SQLException e){
            System.err.println("Maintenance DAO: Threw exception while trying to list maintenance performed");
            System.err.println(e.getMessage());
        }
        return null;
    }
}