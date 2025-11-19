public class Customer {
    private static int idGenerator = 1;
    private int customerID;
    private char pickupPoint;
    private char dropPoint;
    private int pickupTime;

    public Customer(char pickupPoint, char dropPoint, int pickupTime) {
        this.pickupPoint = pickupPoint;
        this.dropPoint = dropPoint;
        this.pickupTime = pickupTime;
        this.customerID = idGenerator++;
    }

    public int getCustomerID() {
        return customerID;
    }

    public char getPickupPoint() {
        return pickupPoint;
    }

    public char getDropPoint() {
        return dropPoint;
    }

    public int getPickupTime() {
        return pickupTime;
    }
}
