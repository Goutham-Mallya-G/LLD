import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option = 1;
        App booking = new App(5);
        while(option != 3) {
            System.out.println("1.Book a Taxi.Taxi");
            System.out.println("2.Taxi.Taxi details");
            System.out.println("3.Exit the application");
            System.out.println();
            System.out.print("Enter your option : ");
            option = sc.nextInt();
            if (option == 1) {
                System.out.print("Enter the Pickup point : ");
                char pickupPoint = sc.next().toUpperCase().charAt(0);
                System.out.print("Enter the Drop point : ");
                char dropPoint = sc.next().toUpperCase().charAt(0);
                System.out.print("Enter the Pickup time (24 hours) : ");
                int pickupTime = sc.nextInt();
                Customer customer = new Customer(pickupPoint , dropPoint , pickupTime);
                booking.bookTaxi(customer);
            }else if(option == 2) {
                System.out.print("Enter the taxi id : ");
                int taxiId = sc.nextInt();
                booking.Taxidetails(taxiId);
            }else if(option == 3){
                System.out.println("Thank you for using our app");
                return;
            }else{
                System.out.println("Enter the correct option");
            }
        }
    }
}