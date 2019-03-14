package domain.renter;

public class Renter implements IRenter {
    private int renterId;
    private String lastName;
    private String firstName;
    private Address rentingAddress;

    public int getRenterId() {
        return renterId;
    }

    public void setRenterId(int renterId){
        this.renterId = renterId;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public Address getRentingAddress(){
        return rentingAddress;
    }

    public void setRentingAddress(Address rentingAddress){
        this.rentingAddress = rentingAddress;
    }
}
