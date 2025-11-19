import java.util.ArrayList;
import java.util.List;

public class Flight {
    private String name;
    private int seats;
    private int amount;
    private List<Passenger> bookings = new ArrayList<>();

    public Flight(String name, int seats, int amount) {
        this.name = name;
        this.seats = seats;
        this.amount = amount;
    }

    public  void printDetails(){
        System.out.println("Flight name : " + name);
        System.out.println("Available Seats : " + seats);
        System.out.println("Booking Price : "+ amount);
    }

    public  void book(Passenger p){
        if(p.getTicketCount() <= seats) {
            bookings.add(p);
            amount += p.getTicketCount() * 200;
            seats -= p.getTicketCount();
            System.out.println("Ticket Confirmed");
        }else{
            System.out.println("Flight has no capacity of " + p.getTicketCount() + " seats available");
        }
    }
     Passenger passengerToBeDeleted;
    public boolean hasPassenger(int id){
        for(Passenger p : bookings){
            if(p.getId() == id){
                passengerToBeDeleted = p;
                return true;
            }
        }
        return false;
    }

    public void cancel(int id){
        if(passengerToBeDeleted.getId() == id){
            amount -= passengerToBeDeleted.getTicketCount() * 200;
            seats += passengerToBeDeleted.getTicketCount();
            bookings.remove(passengerToBeDeleted);
            System.out.println("Ticket has been cancelled for passenger id " + passengerToBeDeleted.getId() + " Amount is refunded");
        }else{
            System.out.println("Internel Error");
        }
    }

    public void printBookings(){
        for(Passenger p : bookings){
            System.out.println(" Passenger Id : " + p.getId() + " Passenger Name : " + p.getName() + " Passenger Age : " + p.getAge() + " Passenger Total ticket : " + p.getTicketCount());
        }
    }


}
