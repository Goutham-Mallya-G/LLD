import java.util.Scanner;

public class App {
    char[][] board;
    Scanner sc= new Scanner(System.in);
    public void initializeBoard(int size){
        board = new char[size][size];
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++){
                board[i][j] = '_';
            }
        }
        printBoard();
    }
    char player = 'X';
    public void startGame(){
        int moves = 0;
        int size = board.length;
        while(moves < size * size) {
            System.out.print("Enter player " + player + " move [Row and Col] : ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            if(isValid(row , col)) {
                board[row][col] = player;
                if (isWin(player, row, col)) {
                    printBoard();
                    System.out.println(player + " Wins the game !");
                    return;
                }
                player = (player == 'X') ? 'O' : 'X';
                moves++;
            }else{
                System.out.println("Invalid move please try again");
            }
            printBoard();
        }
        System.out.println("Match draw");
    }

    private boolean isValid(int row , int col){
        if(row >= 0 && row < board.length && col >= 0 && col < board.length){
            if(board[row][col] == '_'){
                return true;
            }
        }
        return false;
    }

    private void printBoard() {
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board.length ; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private boolean isWin(char player , int row , int col){
        if(checkrow(player , row , col) || checkCol(player , row , col) || checkDiag(player , row , col)){
            return true;
        }
        return false;
    }

    private boolean checkDiag(char player , int row , int col) {
        boolean left = true;
        boolean right = true;
        for(int i = 0 ; i < board.length ; i++){
            if(board[i][i] != player){
                left = false;
            }
            if(board[i][board.length-i-1] != player){
                right = false;
            }
        }
        return left || right;
    }

    private boolean checkCol(char player , int row , int col) {
        for(int i = 0 ; i <  board.length ; i++){
            if(board[i][col] != player){
                return false;
            }
        }
        return true;
    }

    private boolean checkrow(char player, int row , int col) {
        for(int i = 0 ; i <  board.length ; i++){
            if(board[row][i] != player){
                return false;
            }
        }
        return true;
    }


}
