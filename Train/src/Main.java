import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        App app = new App();
        while(true) {
            System.out.println();
            System.out.println("1.Book Ticket");
            System.out.println("2.Cancel Ticket");
            System.out.println("3.List Booked Tickets");
            System.out.println("4.List Available Tickets");
            System.out.println("5.Exit");
            System.out.print("Select Your Choice : ");
            int choice = sc.nextInt();
            switch(choice){
                case 1:
                    int havechild = 2;
                    System.out.print("Enter the passenger name : ");
                    String passengerName = sc.next();
                    System.out.print("Enter the paasenger age :");
                    int passengerAge = sc.nextInt();
                    System.out.print("Enter the passenger Gender : ");
                    String passengerGender = sc.next().toUpperCase();
                    try{
                        Gender.valueOf(passengerGender);
                        if(passengerGender.equals("FEMALE")){
                            System.out.println("Do you have Children below age of 5 ?");
                            System.out.println("1.yes");
                            System.out.println("2.No");
                            havechild = sc.nextInt();
                        }
                    }catch (IllegalArgumentException e){
                        System.out.println("Gender is not valid");
                        break;
                    }
                    System.out.print("Enter the berth preference : ");
                    String passengerPreference = sc.next().toUpperCase();
                    try{
                        Berth.valueOf(passengerPreference);
                    }catch (IllegalArgumentException e){
                        System.out.println("Preference is not valid");
                        break;
                    }
                    if(passengerAge < 5){
                        System.out.println("Children below 5 cannot book tickets");
                        break;
                    }
                    Passenger p = new Passenger(passengerName,passengerAge,passengerGender,passengerPreference);
                    if (havechild == 1){
                        p.setChildren(true);
                    }
                    app.bookTicket(p);
                    break;
                case 2:
                    System.out.print("Enter ticket id to cancel: ");
                    int ticketid = sc.nextInt();
                    app.cancelTicket(ticketid);
                    break;
                case 3:
                    app.printAllConfirmed();
                    break;
                case 4:
                    app.printAllAvailable();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Enter the correct Choice");
            }
        }
    }
}