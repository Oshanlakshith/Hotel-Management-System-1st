package Model;

public class Park {
    private String slot;
    private String CustomerId;
    private String CustomerName;
    private String VehicleName;

    public Park() {
    }

    public Park(String slot, String customerId, String customerName, String vehicleName) {
        this.slot = slot;
        CustomerId = customerId;
        CustomerName = customerName;
        VehicleName = vehicleName;
    }

    public Park(String customerId, String customerName) {
        CustomerId = customerId;
        CustomerName = customerName;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getVehicleName() {
        return VehicleName;
    }

    public void setVehicleName(String vehicleName) {
        VehicleName = vehicleName;
    }

    @Override
    public String toString() {
        return "park{" +
                "slot='" + slot + '\'' +
                ", CustomerId='" + CustomerId + '\'' +
                ", CustomerName='" + CustomerName + '\'' +
                ", VehicleName='" + VehicleName + '\'' +
                '}';
    }
}
