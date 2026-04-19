import java.io.*;
import java.util.*;

public class SudokuBoard {
   private char[][] board;

   public SudokuBoard(String fileName) {
      board = new char[9][9];

      try {
         Scanner input = new Scanner(new File(fileName));
         int row = 0;                                  // FIX: declare row
         while (input.hasNextLine() && row < 9) {
            String line = input.nextLine();
            for (int col = 0; col < 9 && col < line.length(); col++) {
               board[row][col] = line.charAt(col);
            }
            row++;
         }
      } catch (FileNotFoundException e) {              // FIX: removed stray {
         System.out.println("Error file not found " + fileName);
      }
   }

   public String toString() {
      String divider = "+-------+-------+-------+\n"; 
      String result = divider;

      for (int row = 0; row < 9; row++) {
         result += "| ";
         for (int col = 0; col < 9; col++) {      
            char c = board[row][col];
            if (c == '.') {
               result += ". ";
            } else {
               result += c + " ";
            }                                         
            if (col % 3 == 2) {
               result += "| ";
            }
         }
         result += "\n";
         if (row == 2 || row == 5) {
            result += divider;
         }
      }
      result += divider;
      return result;
   }
}

/*
# PROGRAM OUTPUT
 +-------+-------+-------+
 | 2 . . | 1 . 5 | . . 3 | 
 | . 5 4 | . . . | 7 1 . | 
 | . 1 . | 2 . 3 | . 8 . | 
 +-------+-------+-------+
 | 6 . 2 | 8 . 7 | 3 . 4 | 
 | . . . | . . . | . . . | 
 | 1 . 5 | 3 . 9 | 8 . 6 | 
 +-------+-------+-------+
 | . 2 . | 7 . 1 | . 6 . | 
 | . 8 1 | . . . | 2 4 . | 
 | 7 . . | 4 . 2 | . . 1 | 
 +-------+-------+-------+
 
 
*/