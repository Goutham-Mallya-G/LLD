package Process;

import java.util.*;

public class Train {
    private int[] seat = new int[6];
    private int waiting = 2;
    private List<Ticket> bookings = new ArrayList<>();
    private List<Ticket> waitingList = new ArrayList<>();
    private List<Ticket> cancelled = new ArrayList<>();

    public Train(){
        for(int i = 0 ; i < seat.length ; i++){
            seat[i] = 8;
        }
    }

    public boolean checkAvailability(Ticket t){
        for(int i = t.getSource() - 'A' ; i < t.getDestination() - 'A' ; i++){
            if(t.getPassenger() > seat[i]){
                return false;
            }
        }
        return true;
    }

    public void allotBooking(Ticket t){
        for(int i = t.getSource() - 'A' ; i < t.getDestination() - 'A' ; i++) {
            seat[i] -= t.getPassenger();
        }
    }

    public void book(Ticket t){
        if(checkAvailability(t)) {
            bookings.add(t);
            allotBooking(t);
            System.out.println("Ticket has been confirmed, Ticket id = " + t.getId());
        }else if(t.getPassenger() <= waiting){
            waitingList.add(t);
            waiting -= t.getPassenger();
            System.out.println("Ticket has been added to waiting list, Ticket id = " + t.getId());
        }else{
            System.out.println("Train is full, please see the chart");
        }
    }

    public void revokeBooking(Ticket t , int noOfPassenger){
        for(int i = t.getSource() - 'A' ; i < t.getDestination() - 'A' ; i++) {
            seat[i] += noOfPassenger;
        }
    }

    public void cancel(int id , int noOfPassenger){
        for(Ticket t : bookings){
            if(t.getId() == id){
                t.setPassenger(t.getPassenger() - noOfPassenger);
                revokeBooking(t , noOfPassenger);
                if(t.getPassenger() <= 0){
                    cancelled.add(t);
                    bookings.remove(t);
                    revokeBooking(t , noOfPassenger);
                    System.out.println("Ticket have been cancelled");
                    return;
                }
                System.out.println("Ticket have been partially cancelled");
                for(Ticket tw : waitingList){
                    if(tw != null) {
                        if (checkAvailability(tw)) {
                            bookings.add(tw);
                            allotBooking(tw);
                            waitingList.remove(tw);
                            waiting += noOfPassenger;
                            return;
                        }
                    }
                }
            }
        }
        for(Ticket t : waitingList){
            if(t.getId() == id){
                t.setPassenger(t.getPassenger() - noOfPassenger);
                if(t.getPassenger() <= 0){
                    cancelled.add(t);
                    waitingList.remove(t);
                    waiting += noOfPassenger;
                    System.out.println("Ticket have been cancelled");
                }
                System.out.println("Ticket have been partially cancelled");
            }
        }
    }

    private void printseat(int ind){
        System.out.print(" ");
        for(int i = 0 ; i < 8 - seat[ind] ; i++){
            System.out.print("\t*");
        }
        System.out.println();
    }

    public void printChart(){
        System.out.println("Confirmed Tickets");
        for(Ticket t : bookings){
            System.out.println("TicketId : " + t.getId() + ", Ticket source : " + t.getSource() + ", Ticket destination : " + t.getDestination() + ", Passenger count : " + t.getPassenger());
        }
        System.out.println("Cancelled Tickets");
        for(Ticket t : cancelled){
            System.out.println("TicketId : " + t.getId() + ", Ticket source : " + t.getSource() + ", Ticket destination : " + t.getDestination() + ", Total passenger : " + t.getIntitialBook());
        }

        System.out.print("Tickets : ");
        System.out.println(Arrays.toString(seat));

        System.out.println("\t1\t2\t3\t4\t5\t6\t7\t8");
        System.out.print("A");
        printseat(0);
        System.out.print("B");
        printseat(1);
        System.out.print("C");
        printseat(2);
        System.out.print("D");
        printseat(3);
        System.out.print("E");
        printseat(4);
        System.out.print("F");
        printseat(5);
    }
}
