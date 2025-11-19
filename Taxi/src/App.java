import java.util.ArrayList;
import java.util.List;

public class App {
    private List<Taxi> taxis;
    private int bookingId = 1;

    public App(int taxiCount) {
        taxis = new ArrayList<>();
        for(int i = 1 ; i <= taxiCount ; i++){
            taxis.add(new Taxi(i));
        }
    }
    private int calculateCharges(char picupPoint , char dropPoint){
        int distance = Math.abs(picupPoint - dropPoint)*15;
        int charges = 100;
        distance -= 5;
        charges += distance * 10;
        return charges;
    }

    private Taxi selected(char pickupPoint , int pickupTime) {
        List<Taxi> freeTaxis = new ArrayList<>();
        for (Taxi t : taxis) {
            if (t.isfree(pickupPoint, pickupTime)) {
                freeTaxis.add(t);
            }
        }
        if(freeTaxis.isEmpty()){
            return null;
        }
        int minimumDistance = Integer.MAX_VALUE;
        for (Taxi t : freeTaxis) {
            int distance = Math.abs(t.getCurrentPoint() - pickupPoint);
            minimumDistance = Math.min(minimumDistance, distance);
        }
        List<Taxi> closest = new ArrayList<>();
        for (Taxi t : freeTaxis) {
            int distance = Math.abs(t.getCurrentPoint() - pickupPoint);
            if (minimumDistance == distance) {
                closest.add(t);
            }
        }
        Taxi selectedTaxi = closest.get(0);
        for (Taxi t : closest) {
            if (t.getEarning() < selectedTaxi.getEarning()) {
                selectedTaxi = t;
            }
        }
        return selectedTaxi;
    }
    public void bookTaxi(Customer customer){
        Taxi selectedTaxi = selected(customer.getPickupPoint(), customer.getPickupTime());
        if(selectedTaxi == null){
            System.out.println("No Taxi.Taxi is Available at the moment");
            return;
        }
        int travelTime = Math.abs(customer.getPickupPoint()- customer.getDropPoint());
        int dropTime = (customer.getPickupTime() + travelTime);
        int charges = calculateCharges(customer.getPickupPoint() , customer.getDropPoint());
        Booking booking = new Booking(bookingId++ , customer , dropTime , charges);

        selectedTaxi.assignBooking(booking);
        selectedTaxi.setCurrentPoint(customer.getDropPoint());
        selectedTaxi.setEarning(selectedTaxi.getEarning() + charges);
        selectedTaxi.setFreeTime(dropTime);

        System.out.println("Taxi.Taxi- " + selectedTaxi.getTaxiId() + " is allocated");
    }

    public void Taxidetails(int taxiId){
        for(Taxi t : taxis){
            if(t.getTaxiId() == taxiId){
                System.out.println("Taxi.Taxi-"+t.getTaxiId()+ " Earnings: "+t.getEarning());
                System.out.println("Taxi.Booking Id\tCustomer Id\tFrom\tTo\tPickup Time\tDrop Time\tCharges");
                for(Booking b : t.getBookings()){
                    System.out.println(b.getBookingId() + "\t\t\t" + b.getCustomerId() + "\t\t\t" + b.getPickUpPoint() + "\t\t" + b.getDropPoint() + "\t" + b.getPickUpTime() + "\t\t\t" + b.getDropTime() + "\t\t\t" + b.getCharges());
                }
                return;
            }
        }
        System.out.println("No taxi found in the id");
    }

}
