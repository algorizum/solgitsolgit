package dynamic_programming;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Trianglepath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            scanner = new Scanner(new File("input"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int cases = scanner.nextInt();
        while(cases-- > 0) {
            int[][] triangle = new int[scanner.nextInt()][];
            int dp[][] = new int[2][triangle.length];
            for(int i = 0; i < triangle.length; i++) {
                triangle[i] = new int[i+1];
                for(int j = 0; j < triangle[i] .length; j++) {
                    triangle[i][j] = scanner.nextInt();
                }
            }
            for(int i = 0; i < triangle[triangle.length-1].length; i++) {
                dp[(triangle.length-1)%2][i] = triangle[triangle.length-1][i];
            }
            for(int i = triangle.length-2; i >= 0; i--) {
                for(int j = 0; j < triangle[i].length; j++) {
                    dp[i%2][j] = Math.max(dp[(i+1)%2][j+1], dp[(i+1)%2][j]) + triangle[i][j];
                }
            }
            System.out.println(dp[0][0]);
        }
    }
}
