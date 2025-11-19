package Process;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Train train = new Train();
        while(true){
            System.out.println("1.Book Ticket");
            System.out.println("2.Cancel Ticket");
            System.out.println("3.Print Chart");
            System.out.println("4.Exit");
            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Enter the source point : ");
                    char source = sc.next().toUpperCase().charAt(0);
                    System.out.print("Enter the destination point : ");
                    char destination = sc.next().toUpperCase().charAt(0);
                    System.out.print("Enter the total passenger : ");
                    int passenger = sc.nextInt();
                    Ticket t = new Ticket(source , destination , passenger);
                    train.book(t);
                    break;
                case 2 :
                    System.out.print("Enter the ticket id to cancel");
                    int id = sc.nextInt();
                    System.out.print("Number of passenger to cancel : ");
                    int noOfPassenger = sc.nextInt();
                    train.cancel(id , noOfPassenger);
                    break;
                case 3 :
                    train.printChart();
                    break;
                case 4 :
                    return;
                default :
                    System.out.println("Enter the correct option");
            }
        }
    }
}
