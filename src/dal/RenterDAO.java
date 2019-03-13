package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import domain.facility.*;
import domain.renter.*;

public class RenterDAO {

    public RenterDAO(){}

    public Address getAddress(String addressId) {

        try {
            //Get Address From DB
            Statement st = DBHelper.getConnection().createStatement();
            String selectAddressQuery = "SELECT AddressID, StreetName, ApartmentNumber, City, State, Zip FROM Address WHERE AddressID = '" + addressId + "'";

            ResultSet addrRS = st.executeQuery(selectAddressQuery);
            System.out.println("RenterDAO: *************** Query " + selectAddressQuery);

            //Create new address object
            Address address = new Address();
            while ( addrRS.next() ) {
                address.setAddressID(addrRS.getString("AddressID"));
                address.setStreetName(addrRS.getString("StreetName"));
                address.setApartmentNumber(addrRS.getString("ApartmentNumber"));
                address.setCity(addrRS.getString("City"));
                address.setState(addrRS.getString("State"));
                address.setZip(addrRS.getString("Zip"));
            }
            //close to manage resources
            addrRS.close();

            return address;
        }
        catch (SQLException se) {
            System.err.println("RenterDAO: Threw a SQLException retrieving the address object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return null;
    }

    public void addAddress(Address address){
        Connection con = DBHelper.getConnection();
        PreparedStatement adrPst = null;
        PreparedStatement addPst = null;

        try{
            String bldStm = "INSERT INTO Address(AddressID, StreetName, ApartmentNumber, City, State, Zip) VALUES(?, ?, ?, ?, ?, ?)";
            adrPst = con.prepareStatement(bldStm);
            adrPst.setString(1, address.getAddressID());
            adrPst.setString(2, address.getStreetName());
            adrPst.setString(3, address.getApartmentNumber());
            adrPst.setString(4, address.getCity());
            adrPst.setString(5, address.getState());
            adrPst.setString(6, address.getZip());
            adrPst.executeUpdate();
        } catch (SQLException ex){

        } finally {
            try{
                if(addPst != null){
                    addPst.close();
                    adrPst.close();
                }
                if(con != null){
                    con.close();
                }
            } catch (SQLException ex){
                System.err.println("CustomerDAO: Threw a SQLException saving the customer object");
                System.err.println(ex.getMessage());
            }
        }
    }

    public void removeAddress(String addressId){
        // remove entries that references addresses in other tables before removing from the address table
        // remove from building
        try{
            Statement st = DBHelper.getConnection().createStatement();
            String buildingRemovalQuery = "delete from Building where AddressID = '" + addressId + "'";
            st.execute(buildingRemovalQuery);
            st.close();
        } catch (SQLException e){
            System.err.println("RenterDAO: error removing address primary key references");
            System.err.println(e.getMessage());
        }
        // remove address from Renter
        try{
            Statement st = DBHelper.getConnection().createStatement();
            String renterRemovalQuery = "delete from Renter where AddressID = '" + addressId + "'";
            st.execute(renterRemovalQuery);
            st.close();
        } catch (SQLException e){
            System.err.println("RenterDAO: error removing address primary key references");
            System.err.println(e.getMessage());
        }
        // finally, remove address from address table
        try{
            Statement st = DBHelper.getConnection().createStatement();
            String facilityRemovalQuery = "delete from Address where AddressID = '" + addressId + "'";
            st.execute(facilityRemovalQuery);
            st.close();
        } catch (SQLException e){
            System.err.println("RenterDAO: Threw and SQLException while trying to delete address");
            System.err.println(e.getMessage());
        }
    }

    public Renter getRenter(int renterId){
        try {
            //Get renter id From DB
            Statement st = DBHelper.getConnection().createStatement();
            String selectRenterQuery = "SELECT RenterID, LastName, FirstName, AddressID FROM Renter WHERE RenterID = '" + renterId + "'";

            ResultSet renterRS = st.executeQuery(selectRenterQuery);
            System.out.println("RenterDAO: *************** Query " + selectRenterQuery);

            //Create new address object
            Renter renter = new Renter();
            while ( renterRS.next() ) {
                renter.setRenterId(renterRS.getInt("RenterID"));
                renter.setLastName(renterRS.getString("LastName"));
                renter.setFirstName(renterRS.getString("FirstName"));
                renter.setRentingAddress(getAddress(renterRS.getString("AddressID")));
            }

            //close to manage resources
            renterRS.close();
            st.close();

            return renter;
        } catch (SQLException se) {
            System.err.println("RenterDAO: Threw a SQLException retrieving the address object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return null;
    }
}