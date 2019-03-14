package domain.renter;

public interface IRenter {
    public int getRenterId();
    public void setRenterId(int renterId);
    public String getLastName();
    public void setLastName(String lastName);
    public String getFirstName();
    public void setFirstName(String firstName);
    public Address getRentingAddress();
    public void setRentingAddress(Address rentingAddress);
}
