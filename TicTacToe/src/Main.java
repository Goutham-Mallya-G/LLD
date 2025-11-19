import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        App app = new App();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the board size : ");
        int size = sc.nextInt();
        app.initializeBoard(size);
        app.startGame();
    }
}
