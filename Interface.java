import java.util.Scanner;

public class Interface {

  public static String choice(String numOne, String numTwo) {
    String num = "";
    Scanner input = new Scanner(System.in);


    while (!(String.valueOf(num).equalsIgnoreCase(numOne)) 
        || !(String.valueOf(num).equalsIgnoreCase(numTwo))) {
      
      num = input.next();
      if (String.valueOf(num).equalsIgnoreCase(numOne) 
          || String.valueOf(num).equalsIgnoreCase(numTwo)) {
        return num;
      } else {
        System.out.println("Wrong input.");
      }
    }
    return num;
  }
  

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);    
    
    System.out.println("Welcome to TicTacToe World!");
    System.out.println("\n          1. 1p");
    System.out.println("          2. 2p\n");
    System.out.println("Press 1 to play 1p and 2 to play 2p");
    
    String num = "";
    
    num = choice("1", "2");
    
    String ending ="";
    while(!String.valueOf(ending).equalsIgnoreCase("N")) {
      if(num.equals("1")) {
        computer.c2p();       
    }
      if(num.equals("2")) {
        BasicTicTacToe.p2p();
      }
      
      System.out.println("Would you like to play again?");
      System.out.println("\n\n          Y  /  N\n");
      ending = choice("y", "n");
      
      if(ending.equalsIgnoreCase("y")) {
      System.out.println("Welcome to TicTacToe World!");
      System.out.println("\n         1. 1p");
      System.out.println("         2. 2p\n");
      System.out.println("Press 1 to play 1p and 2 to play 2p");
      num = choice("1", "2");
      }
    }
    
    System.out.println("   Thank you for playing!");
    }
  }
