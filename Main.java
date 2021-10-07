package PuissanceFour;

//import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {

    public static int col = 7;
    public static int ligne = 6;
    public static String player1;
    public static String player2;
    public static int player1Choose;
    public static int player2Choose;
    public static String symbol = ".";


    static String[][] board = new String[col][ligne];
    static Scanner scan = new Scanner(System.in);

    static boolean loop = true;


    public static void main(String[] args) {
        nomJoeur();
        initBoard();
        printBoard();

        
        while(loop) {
            System.out.println(player1 + " Chose one ligne (1 and 7)");
            player1Choose = scan.nextInt();
            play(player1Choose, player1);
            printBoard();
            // checkWin();

            if(checkWin() != null) {
                if(checkWin() == "R") {
                    System.out.println(player1 + " win");
                } else if(checkWin() == "Y") {
                    System.out.println(player2 + " win");
                }
                // System.out.println("Ying");
                loop = false;
            }

            System.out.println(player2 + " Chose one ligne (1 and 7)");
            player2Choose = scan.nextInt();
            play(player2Choose, player2);
            printBoard();
            // checkWin();

            if(checkWin() != null) {
                if(checkWin() == "R") {
                    System.out.println(player1 + " win");
                } else if(checkWin() == "Y") {
                    System.out.println(player2 + " win");
                    
                }
               // System.out.println("Ying");
                loop = false;
            }
            
        }
    
    }

    public static void nomJoeur() {
        System.out.println("username first player");
        player1 = scan.nextLine();

        System.out.println("username second player");
        player2 = scan.nextLine();
    }

    public static void printBoard() {
        System.out.print(1234567);
        System.out.println();
        System.out.print("-------");
        for (int i = 0; i < ligne; i++) {
            System.out.println();
            for (int j = 0; j < col; j++) {
                System.out.print(board[j][i]);
            }
        }
        System.out.println();
        System.out.println("-------");
    }

    public static void initBoard() {
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < col; j++) {
                board[j][i] = symbol;
            }
        }
    }

    public static void play(int playerChoose, String player) {
        if(playerChoose >=1 && playerChoose <= 7) {

            playerChoose = playerChoose - 1;
            for(int l = ligne -1; l >= 0; l--) {
                if(board[playerChoose][l] == symbol) {
                    if(player == player1) {
                        board[playerChoose][l] = "R";
                    } else if (player == player2) {
                        board[playerChoose][l] = "Y";
                    }
                    break;
                }
            }
        } else {
            System.out.println("Mettre un nombre entre 1 à 7");
        }
    }

    public static String checkWin() {

        // vertical
        for(int i = 0; i<ligne; i++){
            for(int j=0; j < 3; j++) {
                if((board[i][j] != symbol) 
                &&(board[i][j] == board[i][j+1])
                &&(board[i][j] == board[i][j+2]) 
                && (board[i][j] == board[i][j+3])) {
                    System.out.println(board[i][j]);
                    return board[i][j];
                }
            }
        }
        // Horizontal
        for(int i = 1; i < ligne; i++){
            for(int j=0; j < 4; j++) {
                if((board[j][i] != symbol) 
                &&(board[j][i] == board[j+1][i])
                &&(board[j][i] == board[j+2][i])
                && (board[j][i] == board[j+3][i])) {
                    System.out.println(board[j][i]);
                    
                    return board[j][i];
                }
            }
        }

        // Diagonale gauche
        for(int i = 0; i < ligne; i++){
            for(int j = 0; j < 3; j++) {
                if(j <= board.length - 2 && i <= board[j].length - 2) {
                    if((board[i][j] != symbol) 
                    &&(board[i][j] == board[i+1][j+1])
                    &&(board[i][j] == board[i+2][j+2])
                    && (board[i][j] == board[i+3][j+3])) {
                        System.out.println(board[i][j]);
                        return board[i][j];
                    }
                }
            }
        }
        // Diagonale Droite
        for(int i = 0; i < col; i++){
            for(int j = 0; j < ligne; j++) {
                if(i <= board.length - 3 && j >= board[i].length - 3) {
                    if((board[i][j] != symbol) 
                    &&(board[i][j] == board[i+1][j-1])
                    &&(board[i][j] == board[i+2][j-2])
                    && (board[i][j] == board[i+3][j-3])) {
                        System.out.println(board[i][j]);
                        return board[i][j];
                    }
                }
            }
        }
        return null;
    }
}
