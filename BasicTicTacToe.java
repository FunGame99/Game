import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BasicTicTacToe implements base{

  static String[] board;
  static String turn;
  public static String checkWinner() {
    for (int i = 0; i < 8; i++) {
      String line = null;

      switch (i) {
        case 0:
          line = board[0] + board[1] + board[2];
          break;

        case 1:
          line = board[3] + board[4] + board[5];
          break;

        case 2:
          line = board[6] + board[7] + board[8];
          break;

        case 3:
          line = board[0] + board[3] + board[6];
          break;

        case 4:
          line = board[1] + board[4] + board[7];
          break;

        case 5:
          line = board[2] + board[5] + board[8];
          break;

        case 6:
          line = board[0] + board[4] + board[8];
          break;

        case 7:
          line = board[2] + board[4] + board[6];
          break;
      }

      if (line.equals("XXX")) {
        return "X";
      }

      if (line.equals("OOO")) {
        return "O";
      }
    }

    for (int a = 0; a < 9; a++) {
      if (board[a].contains(String.valueOf(a + 1))) {
        break;
      } 
      
      else if (a == 8) {
        return "draw";
      }
    }

    // To enter the X Or O at the exact place on board.
    System.out.println(turn + "'s turn; enter a slot number to place " + turn + " in:");
    return null;
  }

  /**
   * PrintBoard that looks like below
   * 
   * |-----|-----|-----| | 1 | 2 | 3 | |-----|-----|-----| | 4 | 5 | 6 | |-----|-----|-----| | 7 | 8
   * | 9 | |-----|-----|-----|
   */

  public static void printBoard() {
    System.out.println("   |-----|-----|-----|");
    System.out.println("   |  " + board[0] + "  |  " + board[1] + "  |  " + board[2] + "  |");
    System.out.println("   |-----|-----|-----|");
    System.out.println("   |  " + board[3] + "  |  " + board[4] + "  |  " + board[5] + "  |");
    System.out.println("   |-----|-----|-----|");
    System.out.println("   |  " + board[6] + "  |  " + board[7] + "  |  " + board[8] + "  |");
    System.out.println("   |-----|-----|-----|\n");
  }
  
  public static void p2p() {
    Scanner input = new Scanner(System.in);
    turn = "X";
    board = new String[9];
    String winner = null;



    for (int i = 1; i < 10; i++) {
      board[i - 1] = String.valueOf(i);
    }

    System.out.println("       2p TicTacToe\n");
    printBoard();
    System.out.println("X will play first. Enter a number to place " + turn + " in \n");


    while (winner == null) {
      int numInput;

      try {
        numInput = input.nextInt();
        if (!(numInput > 0 && numInput <= 9)) {
          System.out.println("Invalid number. Please re-enter a number between 0 and 9");
          continue;
        }
      } catch (InputMismatchException e) {
          input = new Scanner(System.in);
          System.out.println("Invalid Input. Please enter a number between 0 and 9");
          continue;
      }


      // turn X and O

      if (board[numInput - 1].equals(String.valueOf(numInput))) {
        board[numInput - 1] = turn;

        if (turn.equals("X")) {
          turn = "O";
        } 
        else {
          turn = "X";
        }

        printBoard();
        winner = checkWinner();
      } 
      
      else {
        System.out.println("Slot already taken; re-enter a number:");
      }
    }
    
    if(winner.equalsIgnoreCase("draw")) {
      System.out.println("The game is a draw. Good Game! \n\n");
    }
    else {
      System.out.println("     The winner is " + winner + ".\n\n");
    }
  }
}
