import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the row : ");
        int row = sc.nextInt();
        System.out.print("Enter the column : ");
        int col = sc.nextInt();
        app.createFood();
        app.makeBoard(row , col);
        app.printBoard();
        app.initiateGame();
    }
}
