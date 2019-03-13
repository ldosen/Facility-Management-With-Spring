package domain.service;

import domain.renter.*;
import dal.RenterDAO;

public class RenterService {

    RenterDAO renterDAO = new RenterDAO();

    public void addAddress(Address address){
        try{
            renterDAO.addAddress(address);
        } catch (Exception e){
            System.err.println("RenterService: Error adding address object");
            System.err.println(e.getMessage());
        }
    }

    public Address getAddress(String addressId){
        try{
            Address address = renterDAO.getAddress(addressId);
            return address;
        } catch (Exception e){
            System.err.println("RenterService: Error in retrieving address");
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void removeAddress(String addressId){
        try{
            renterDAO.removeAddress(addressId);
        } catch (Exception e){
            System.err.println("RenterService: Error in removing address");
            System.err.println(e.getMessage());
        }
    }
}
