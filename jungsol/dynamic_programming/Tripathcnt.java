package dynamic_programming;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tripathcnt {
	static int[][] triangle;
	static int[][] maxPath;
	static int[][] cache;
	public static void main(String[] args) {
		Tripathcnt main = new Tripathcnt();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/tripathcnt/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			triangle = new int[scanner.nextInt()][];
			maxPath = new int[triangle.length][];
			cache = new int[triangle.length][];
			for(int i = 0; i < triangle.length; i++) {
				triangle[i] = new int[i+1];
				maxPath[i] = new int[i+1];
				cache[i] = new int[i+1];
				for(int j = 0; j < triangle[i].length; j++) {
					triangle[i][j] = scanner.nextInt();
					maxPath[i][j] = -1;
					cache[i][j] = -1;
				}
			}
			main.setMaxPath(0, 0);
			System.out.println(main.getMaxPathCount(0, 0));
		}
	}
	
	public int getMaxPathCount(int startX, int startY) {
		if(startX >= triangle.length-1) return 1;
		if(cache[startX][startY] != -1) return cache[startX][startY];
		int maxPathCount = 0;
		if(maxPath[startX+1][startY] >= maxPath[startX+1][startY+1]) maxPathCount += getMaxPathCount(startX+1, startY);
		if(maxPath[startX+1][startY] <= maxPath[startX+1][startY+1]) maxPathCount += getMaxPathCount(startX+1, startY+1);
		cache[startX][startY] = maxPathCount;
		return cache[startX][startY];
	}
	
	public int setMaxPath(int startX, int startY) {
		if(startX >= triangle.length || startY >= triangle[startX].length) return 0;
		if(maxPath[startX][startY] != -1) return maxPath[startX][startY];
		maxPath[startX][startY] = triangle[startX][startY] + Math.max(setMaxPath(startX+1, startY), setMaxPath(startX+1, startY+1));
		return maxPath[startX][startY];
	}
}
