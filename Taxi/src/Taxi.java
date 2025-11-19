import java.util.ArrayList;
import java.util.List;

public class Taxi {
    private int taxiId;
    private char currentPoint;
    private int freeTime;
    private int earning;
    private List<Booking> bookings;

    public Taxi(int taxiId) {
        this.taxiId = taxiId;
        this.currentPoint = 'A';
        this.freeTime = 0;
        this.earning = 0;
        bookings = new ArrayList<>();
    }

    public boolean isfree(char pickupPoint, int pickupTime){
        int timeRequired = Math.abs(currentPoint - pickupPoint);
        return (freeTime + timeRequired <= pickupTime);
    }

    public int getTaxiId() {
        return taxiId;
    }

    public char getCurrentPoint() {
        return currentPoint;
    }

    public int getFreeTime() {
        return freeTime;
    }

    public int getEarning() {
        return earning;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void assignBooking(Booking book){
        bookings.add(book);
    }

    public void setCurrentPoint(char currentPoint) {
        this.currentPoint = currentPoint;
    }

    public void setFreeTime(int freeTime) {
        this.freeTime = freeTime;
    }

    public void setEarning(int earning) {
        this.earning = earning;
    }
}
