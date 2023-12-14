package InsuranceManagementSystem.Address;

public class BusinessAddress implements IAddress{
    private String addressName;
    private String address;

    public BusinessAddress(String addressName, String address) {
        this.addressName = addressName;
        this.address = address;
    }

    @Override
    public String getName() {
        return addressName;
    }

    @Override
    public String toString() {
        return addressName + "(Business Address)\n" + address;
    }
}
