package InsuranceManagementSystem.Address;

public class HomeAddress implements IAddress{
    private String addressName;
    private String address;

    public HomeAddress(String addressName, String address) {
        this.addressName = addressName;
        this.address = address;
    }

    @Override
    public String getName() {
        return addressName;
    }

    @Override
    public String toString() {
        return addressName + "(Home Address)\n" + "\t" + address;
    }
}
