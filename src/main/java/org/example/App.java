package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        //Building the grid from user input

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter row length: ");
        int row = scanner.nextInt();

        System.out.print( "Enter column length: ");
        int col = scanner.nextInt();

        int grid[][] = new int[row][col];

        System.out.println("Enter numbers for the grid");

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                grid[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Your grid: ");
        System.out.println(Arrays.deepToString(grid));
        System.out.print("Minimum path sum: ");

        minPathSum(grid);

    }


    public static void minPathSum(int[][] grid) {
        //add all numbers in first column
        for(int i = 1; i < grid.length; i++){
            grid[i][0] = grid[i-1][0] + grid[i][0];
        }

        //add all numbers in first row
        for(int j = 1; j < grid[0].length; j++){
            grid[0][j] = grid[0][j-1] + grid[0][j];
        }

        //starting at grid[1][1],check the path above or to the left and add the smaller one to the grid
        //the bottom left grid will have the min path as its new path
        for(int i = 1; i < grid.length; i++){
            for(int j = 1 ; j < grid[0].length; j++){
                grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
            }

        }
        
        System.out.print(grid[grid.length-1][grid[0].length-1]);
    }
}
