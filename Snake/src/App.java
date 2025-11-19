import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class App {
    private Queue<Node> snake = new LinkedList<>();
    private Queue<Node> food = new LinkedList<>();
    static char[][] board = null;
    Scanner sc = new Scanner(System.in);
    static boolean valid = true;

    public void makeBoard(int row , int col){
        board = new char[row][col];
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                board[i][j] = ' ';
            }
        }
        snake.add(new Node(0,0));
        board[0][0] = '.';
        Node nextFood = food.poll();
        if(nextFood != null) {
            int r = nextFood.getRow();
            int c = nextFood.getCol();
            board[r][c] = 'X';
        }
    }

    public void createFood() {
        food.add(new Node(1,0));
        food.add(new Node(2,2));
        food.add(new Node(3,4));
        food.add(new Node(5,2));
        food.add(new Node(4,5));
        food.add(new Node(1,0));
        food.add(new Node(2,2));
        food.add(new Node(3,4));
        food.add(new Node(5,2));
        food.add(new Node(4,5));
    }

    public void initiateGame(){

        int row = 0;
        int col = 0;
        while(valid){
            System.out.print("Enter the position : ");
            char pos = sc.next().toUpperCase().charAt(0);

            switch (pos){
                case 'W':
                    snakeMove(--row , col);
                    break;
                case 'S':
                    snakeMove(++row , col);
                    break;
                case 'A':
                    snakeMove(row , --col);
                    break;
                case 'D':
                    snakeMove(row , ++col);
                    break;
            }
            printBoard();
        }
    }
    public void snakeMove(int row, int col){
        if(row >= 0 && row < board.length && col >= 0 && col < board[0].length){
            snake.add(new Node(row , col));


            if(board[row][col] == ' '){
                Node node = snake.poll();
                int c = node.getCol();
                int r = node.getRow();
                board[r][c] = ' ';
                board[row][col] = '.';
            }

            else if(board[row][col] == 'X'){
                board[row][col] = '.';
                Node nextFood = food.poll();
                if(food.isEmpty()){
                    System.out.println("Food is over");
                    valid = false;
                    return;
                }
                if(nextFood != null) {
                    int r = nextFood.getRow();
                    int c = nextFood.getCol();
                    board[r][c] = 'X';
                }
            }

            else if(board[row][col] == '.'){
                System.out.println(" You ate yourself");
                valid = false;
                return;
            }
        }else{
            System.out.println("You are out the boundary");
            valid = false;
        }
    }

    public void printBoard(){
        System.out.println("--------------");
        for(int i = 0 ; i < board.length ; i++){
            System.out.print("|");
           for(int j = 0 ; j < board[0].length ; j++){
               System.out.print(board[i][j] + " ");
           }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("--------------");
    }
}