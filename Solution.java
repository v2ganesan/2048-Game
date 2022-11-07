/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.security.KeyStore.TrustedCertificateEntry;
import java.util.*;
import java.util.Random;
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
class Solution {
  
  public static int[][] buildGrid(int size)
  {
    int[][] theGrid = new int[size][size]; 
    return theGrid;
  }

  public static int[][] fillGrid(int[][] grid)
  {
    int[][] newGrid = grid;
    for(int i = 0; i < grid.length; i++)
    {
      for(int j = 0; j <  grid[0].length; j++)
      {
        newGrid[i][j] = 0;
      }
    }
    return Solution.insertNewBlock(newGrid, "new");
  }
  
  public static int[][] insertNewBlock(int[][] grid, String direction)
  {
    
    int[][] newGrid = grid;

    Random elem = new Random();

    int[] startNums = new int[2];
    startNums[0] = 2;
    startNums[1] = 4;
    
    int row = elem.nextInt(4);
    int col = elem.nextInt(4);
    int startNumIdx = elem.nextInt(2);

    while(newGrid[row][col] != 0)
    {
      row = elem.nextInt(4);
      col = elem.nextInt(4);
    }
    newGrid[row][col] = startNums[startNumIdx];

    if (direction == "new")
    {
      int row2 = elem.nextInt(4);
      int col2 = elem.nextInt(4);

      while(row == row2 && col == col2)
      {
        row2 = elem.nextInt(4);
        col2 = elem.nextInt(4);
      }
      startNumIdx = elem.nextInt(2);
      newGrid[row2][col2] = startNums[startNumIdx];
    }
    return newGrid;
  }


  public static void printGrid(int[][] originalGrid)
  {
    for(int i = 0; i < originalGrid.length; i++)
    {
      for(int j = 0; j < originalGrid[i].length; j++)
      {
        System.out.print(originalGrid[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println();
  }

  public static int[][] moveRight(int[][] grid)
  {

    int[][] newGrid = grid;
     /*
     - go through the grid
     - if the element is not 0, 
        - move it right until it hits the border or the element to the right of it is not the same value
        2 4 8 8 
        2 2 0 16
        0 2 0 16 
        0 0 4 8 
      */
    
    for(int i = 0; i < newGrid.length; i++)
    {
      for(int j = newGrid[0].length - 2; j >= 0; j--)
      {
        if(newGrid[i][j] != 0)
        {
          for(int k = j; k < newGrid[0].length - 1; k++)
          {
            if(newGrid[i][k] == newGrid[i][k+1])
            {
              newGrid[i][k+1] = newGrid[i][k] * 2;
              newGrid[i][k] = 0;
            }
            else if(newGrid[i][k + 1] == 0)
            {
              newGrid[i][k + 1] = newGrid[i][k];
              newGrid[i][k] = 0;
            }
            else continue;
          }
        }
      }
    }
    return newGrid;
    //return Solution.insertNewBlock(grid, "");
  }
  public static int[][] moveLeft(int[][] grid)
    {
  
      int[][] newGrid = grid;
  
      for(int i = 0; i < newGrid.length; i++)
      {
        for(int j = 1; j < newGrid[0].length; j++)
        {
          if(newGrid[i][j] != 0)
          {
            for(int k = j; k < newGrid[0].length; k++)
            {
              if(newGrid[i][k] == newGrid[i][k-1])
              {
                newGrid[i][k-1] = newGrid[i][k] * 2;
                newGrid[i][k] = 0;
              }
              else if(newGrid[i][k - 1] == 0)
              {
                newGrid[i][k - 1] = newGrid[i][k];
                newGrid[i][k] = 0;
              }
              else continue;
            }
          }
        }
      }
      return newGrid;
    }

  public static int[][] moveUp(int[][] grid)
      {
    
        int[][] newGrid = grid;
        for(int j = 0; j < newGrid[0].length; j++)
        {
          for(int i = newGrid.length - 1; i >= 0; i--)
            {
              if(newGrid[i][j] != 0)
              {
                for(int k = i; k < newGrid[0].length; k++)
                {
                  if(newGrid[k][j] == newGrid[k - 1][j])
                  {
                    newGrid[k - 1][j] = newGrid[k][j] * 2;
                    newGrid[k][j] = 0;
                  }
                  else if(newGrid[k - 1][j] == 0)
                  {
                    newGrid[k - 1][j] = newGrid[k][j]
                    newGrid[k][j] = 0;
                  }
                  else continue;
                }
              }
            }
        }
        return newGrid;
      }
  
  public static int[][] moveDown(int[][] grid)
      {
    
        int[][] newGrid = grid;
        for(int j = 0; j < newGrid[0].length; j++)
        {
          for(int i = 1; i < newGrid.length; i++)
            {
              if(newGrid[i][j] != 0)
              {
                for(int k = i; k < newGrid[0].length; k++)
                {
                  if(newGrid[k][j] == newGrid[k - 1][j])
                  {
                    newGrid[k - 1][j] = newGrid[k][j] * 2;
                    newGrid[k][j] = 0;
                  }
                  else if(newGrid[k - 1][j] == 0)
                  {
                    newGrid[k - 1][j] = newGrid[k][j]
                    newGrid[k][j] = 0;
                  }
                  else continue;
                }
              }
            }
        }
        return newGrid;
      }


  public static int[][] deepCopy(int[][] matrix) {
    int[][] newMatrix = new int[matrix.length][matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        newMatrix[i][j] = matrix[i][j];
      }
    }
    return newMatrix;
  }

  public static boolean isEqual(int[][] x, int[][] y) {
    for (int i = 0; i < x.length; i++){
      for (int j = 0; j < x[0].length; j++){
        //System.out.println(x[i][j] + " " + i + " " + j);
        //System.out.println(y[i][j] + " " + i + " " + j);
        if (x[i][j] != y[i][j]) return false;
      }
    }
    return true;
  }

  public static void testMoveRight() {
    int[][] filledGrid = Solution.fillGrid(Solution.buildGrid(4));

    int i = 5;

    // filled_grid -> block in memory
    // prev_grid = filled_grid
    // prev_grid -> filled_grid

    while (i != 0) {
      System.out.println("filled grid before move right");
      Solution.printGrid(filledGrid);
      
      int[][] filledGridDeepCopy = Solution.deepCopy(filledGrid);
      int[][] moveRight = Solution.moveRight(filledGrid);

      System.out.println("filled grid after move right");
      Solution.printGrid(filledGrid);

      if (Solution.isEqual(filledGridDeepCopy, moveRight)) {
        System.out.println("cant move right");
        break;
      }
      else {
        Solution.insertNewBlock(filledGrid, "");  
      }

      System.out.println("filled grid after insert new block");
      Solution.printGrid(filledGrid);
      i--;
    }
  }
  
  public static void main(String[] args) {

    Solution.testMoveRight();

    boolean same = false; 
  
  }
}





0 4 0 0 
2 4 0 0 
4 0 0 0
8 2 0 0  