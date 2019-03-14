package domain.renter;

public interface IAddress {
    public String getAddressID();
    public void setAddressID(String addressID);
    public String getStreetName();
    public void setStreetName(String streetName);
    public String getApartmentNumber();
    public void setApartmentNumber(String apartmentNumber);
    public String getCity();
    public void setCity(String city);
    public String getState();
    public void setState(String state);
    public String getZip();
    public void  setZip(String zip);
}
