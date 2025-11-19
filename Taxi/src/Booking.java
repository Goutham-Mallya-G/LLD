public class Booking {
    private int bookingId;
    private Customer customer;
    private int dropTime;
    private int charges;

    public Booking(int bookingId, Customer customer, int dropTime, int charges) {
        this.bookingId = bookingId;
        this.customer = customer;
        this.dropTime = dropTime;
        this.charges = charges;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDropTime() {
        return dropTime;
    }

    public int getCharges() {
        return charges;
    }

    public int getCustomerId(){
        return this.customer.getCustomerID();
    }

    public char getPickUpPoint(){
        return this.customer.getPickupPoint();
    }

    public char getDropPoint(){
        return this.customer.getDropPoint();
    }

    public int getPickUpTime(){
        return this.customer.getPickupTime();
    }



}
