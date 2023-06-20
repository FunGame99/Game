import java.util.InputMismatchException;
import java.util.Scanner;

public class computer implements base {
  

  Scanner input = new Scanner(System.in);
  String winner = null;
  final static int lowImportance = 1;
  final static int midImportance = 2;
  final static int highImportance = 3;
  final static int priorityImportance = 4;
  final static int zeroImportance = 0;
  public static int currentImportance;
  public static gameboard[] gBoard = new gameboard[9];
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
  
 
  public static void setting() {
    gameboard board0 = new gameboard(midImportance);
    gameboard board1 = new gameboard(lowImportance);
    gameboard board2 = new gameboard(midImportance);
    gameboard board3 = new gameboard(lowImportance);
    gameboard board4 = new gameboard(highImportance);
    gameboard board5 = new gameboard(lowImportance);
    gameboard board6 = new gameboard(midImportance);
    gameboard board7 = new gameboard(lowImportance);
    gameboard board8 = new gameboard(midImportance);


    gBoard[0] = board0;
    gBoard[1] = board1;
    gBoard[2] = board2;
    gBoard[3] = board3;
    gBoard[4] = board4; 
    gBoard[5] = board5;
    gBoard[6] = board6;
    gBoard[7] = board7;
    gBoard[8] = board8;
  }
  
  
  
  
  
  public static void modifyImportance() {
    int xCounter;
    int oCounter;
    
    if(gBoard[0].getContents().equalsIgnoreCase("o")) {
      gBoard[8].setImportance(lowImportance);
    }
    
    if(gBoard[2].getContents().equalsIgnoreCase("o")) {
      gBoard[6].setImportance(lowImportance);
    }
    
    if(gBoard[8].getContents().equalsIgnoreCase("o")) {
      gBoard[0].setImportance(lowImportance);
    }
    
    if(gBoard[6].getContents().equalsIgnoreCase("o")) {
      gBoard[2].setImportance(lowImportance);
    }

    for (int n = 0; n < 8; n++) {
      switch (n) {
        case 0:
          xCounter = 0;
          oCounter = 0;
          if (gBoard[0].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[0].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }
          if (gBoard[1].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[1].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }
          if (gBoard[2].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[2].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }

          if (xCounter == 2 || oCounter == 2) {
            gBoard[0].setImportance(priorityImportance);
            gBoard[1].setImportance(priorityImportance);
            gBoard[2].setImportance(priorityImportance);
          }
          break;

        case 1:
          xCounter = 0;
          oCounter = 0;
          if (gBoard[3].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[3].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }
          if (gBoard[4].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[4].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }
          if (gBoard[5].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[5].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }
          if (xCounter == 2 || oCounter == 2) {
            gBoard[3].setImportance(priorityImportance);
            gBoard[4].setImportance(priorityImportance);
            gBoard[5].setImportance(priorityImportance);
          }
          break;


        case 2:
          xCounter = 0;
          oCounter = 0;
          if (gBoard[6].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[6].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }
          if (gBoard[7].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[7].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }
          if (gBoard[8].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[8].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }
          if (xCounter == 2 || oCounter == 2) {
            gBoard[6].setImportance(priorityImportance);
            gBoard[7].setImportance(priorityImportance);
            gBoard[8].setImportance(priorityImportance);
          }
          break;


        case 3:
          xCounter = 0;
          oCounter = 0;
          if (gBoard[0].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[0].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }
          if (gBoard[3].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[3].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }
          if (gBoard[6].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[6].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }
          if (xCounter == 2 || oCounter == 2) {
            gBoard[0].setImportance(priorityImportance);
            gBoard[3].setImportance(priorityImportance);
            gBoard[6].setImportance(priorityImportance);
          }
          break;


        case 4:
          xCounter = 0;
          oCounter = 0;
          if (gBoard[1].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[1].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }
          if (gBoard[4].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[4].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }
          if (gBoard[7].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[7].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }
          if (xCounter == 2 || oCounter == 2) {
            gBoard[1].setImportance(priorityImportance);
            gBoard[4].setImportance(priorityImportance);
            gBoard[7].setImportance(priorityImportance);
          }
          break;
          
          
        case 5: 
          xCounter = 0;
          oCounter = 0;
          if (gBoard[2].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[2].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }
          if (gBoard[5].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[5].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }
          if (gBoard[8].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[8].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }
          if (xCounter == 2 || oCounter == 2) {
            gBoard[2].setImportance(priorityImportance);
            gBoard[5].setImportance(priorityImportance);
            gBoard[8].setImportance(priorityImportance);
          }
          break;
          
          
        case 6: 
          xCounter = 0;
          oCounter = 0;
          if (gBoard[0].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[0].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }
          if (gBoard[4].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[4].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }
          if (gBoard[8].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[8].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }
          if (xCounter == 2 || oCounter == 2) {
            gBoard[0].setImportance(priorityImportance);
            gBoard[4].setImportance(priorityImportance);
            gBoard[8].setImportance(priorityImportance);
          }
          break;
          
          
        case 7: 
          xCounter = 0;
          oCounter = 0;
          if (gBoard[2].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[2].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }
          if (gBoard[4].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[4].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }
          if (gBoard[6].getContents().equalsIgnoreCase("X")) {
            xCounter++;
          }
          if (gBoard[6].getContents().equalsIgnoreCase("O")) {
            oCounter++;
          }
          if (xCounter == 2 || oCounter == 2) {
            gBoard[2].setImportance(priorityImportance);
            gBoard[4].setImportance(priorityImportance);
            gBoard[6].setImportance(priorityImportance);
          }
          break;
      }
    }
    
    for(int i = 0; i < 9; i++) {
      if(!(gBoard[i].isEmpty())) {
        gBoard[i].setImportance(zeroImportance);
      }
    }
  }

  
  
  
  
  public static void lay() {       
    int current = 0;
    for (int i = 1; i < 9; i++) {   
      if (gBoard[current].compareTo(gBoard[i].getImportance()) >= 0) {
        continue;
      } else if (gBoard[current].compareTo(gBoard[i].getImportance()) < 0) {
        current = i;
      } 
    }
    
    gBoard[current].setContents("X");
    board[current] = "X";
    printBoard();
  }
    
  
  
  
  
  public static void c2p() {
    
    setting();
    Scanner input = new Scanner(System.in);
    turn = "O";
    board = new String[9];
    String winner = null;

    for (int i = 1; i < 10; i++) {
      board[i - 1] = String.valueOf(i);
    }

    System.out.println("       1p TicTacToe\n\n");
    System.out.println("Woud you like to play first?");
    System.out.println("\n\n         Y  /  N\n");
    
    String newInput = "";
    
    while(!(newInput.equalsIgnoreCase("Y")) || !(newInput.equalsIgnoreCase("N"))) {
      newInput = input.next();
    
      if(newInput.equalsIgnoreCase("Y") || newInput.equalsIgnoreCase("N")) {
        break;
      }
      System.out.println("Press Y to play first, or N to play later.");
      }
    
    
      if(newInput.equalsIgnoreCase("Y")) {
        printBoard();
        System.out.println("You First. Enter a number between 1 and 9:");

        
      
        while(winner == null) {
          int numInput;
        
          try {
            numInput = input.nextInt();
            if(!(numInput > 0 && numInput <= 9)) {
              System.out.println("Invalid number. Please re-enter a number between 0 and 9");
              continue;
            }
          }catch (InputMismatchException e) {
            input = new Scanner(System.in);
            System.out.println("Invalid Input. Please enter a number between 0 and 9");
            continue;
          }
        
          if (board[numInput - 1].equals(String.valueOf(numInput))) {
            board[numInput - 1] = turn;
            gBoard[numInput - 1].setContents(turn);
            printBoard();
            System.out.println("----------------------------------\n");
            modifyImportance();
            lay();
          } 
          else {
            System.out.println("Slot already taken; re-enter a number:");
            continue;
          }
          
          modifyImportance();
          winner = checkWinner();
      }
    }
    else {
      System.out.println("          Me First");
      while(winner == null) {
        int numInput;
        
        lay();
        modifyImportance();
        winner = checkWinner();
        
        if(winner != null) {
          break;
        }
        do {
        try {
          numInput = input.nextInt();
          if(!(numInput > 0 && numInput <= 9) ) {
            System.out.println("Invalid number. Please re-enter a number between 0 and 9");
            continue;
          }
        }catch (InputMismatchException e) {
          input = new Scanner(System.in);
          System.out.println("Invalid Input. Please enter a number between 0 and 9");
          break;
        }
        
        if(board[numInput - 1].equals(String.valueOf(numInput))) {
          board[numInput - 1] = turn;
          gBoard[numInput - 1].setContents(turn);
          modifyImportance();
          printBoard();
          System.out.println("----------------------------------\n");
          break;
        } 
        else {
          System.out.println("Slot already taken; re-enter a number:");
          }
        } while(gBoard[numInput].isEmpty());
        }
      }
    
    
    
    if(winner.equalsIgnoreCase("draw")) {
      System.out.println("The game is a draw. Good Game! \n\n");
    }
    else if(winner.equalsIgnoreCase("X")) {
      System.out.println("     I WIN, YOU LOSE! \n\n");
    }
    else {
      System.out.println("     The winner is " + winner + ".\n\n");
    }
    
  }
  
}

