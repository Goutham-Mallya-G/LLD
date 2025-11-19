import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Flight indigo = new Flight("Indigo" , 50 , 5000);
        Flight spiceJet = new Flight("SpiceJet" , 50 , 5000);
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("1.Book Ticket");
            System.out.println("2.Cancel Ticket");
            System.out.println("3.Print details");
            System.out.println("4.Exit");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("1.Indigo");
                    System.out.println("2.SpiceJet");
                    System.out.print("Enter the flight number : ");
                    int flightId = sc.nextInt();
                    if(flightId == 1){
                        indigo.printDetails();
                    }else if(flightId == 2){
                        spiceJet.printDetails();
                    }
                    System.out.print("Enter the passenger name : ");
                    String name = sc.next();
                    System.out.print("Enter the passenger Age : ");
                    int age = sc.nextInt();
                    System.out.print("Enter the number of Tickets : ");
                    int ticketCount = sc.nextInt();
                    Passenger p = new Passenger(name , age , ticketCount);
                    if(flightId == 1){
                        indigo.book(p);
                    }else if(flightId == 2){
                        spiceJet.book(p);
                    }else{
                        System.out.println("Flight id is not available ! Please try again !");
                    }
                    break;
                case 2:
                    System.out.println("Enter the passenger Id : ");
                    int passengerId = sc.nextInt();
                    if(indigo.hasPassenger(passengerId)){
                        indigo.cancel(passengerId);
                    }else if(spiceJet.hasPassenger(passengerId)){
                        spiceJet.cancel(passengerId);
                    }else{
                        System.out.println("There is no booking with that Id");
                    }
                    break;
                case 3:
                    System.out.println("Indigo details");
                    indigo.printBookings();
                    System.out.println("SpiceJet details");
                    spiceJet.printBookings();
                    break;
                case 4:
                    return;
            }
        }
    }
}