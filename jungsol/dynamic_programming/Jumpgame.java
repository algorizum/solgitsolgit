package dynamic_programming;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Jumpgame {
	static int board[][];
	static int cache[][];
	public static void main(String[] args) {
		Jumpgame main = new Jumpgame();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			int boardSize = scanner.nextInt();
			board = new int[boardSize][boardSize];
			cache = new int[boardSize][boardSize];
			cache[boardSize-1][boardSize-1] = 1;
			for(int i = 0; i < boardSize; i++) {
				for (int j = 0; j < boardSize; j++) {
					board[i][j] = scanner.nextInt();
				}
			}
			System.out.println(main.isPossibleArrival(0, 0) ? "YES" : "NO" );
		}
	}
	
	public boolean isPossibleArrival(int startX, int startY) {
		if(startX > board.length-1 || startY > board.length-1) return false;
		if(cache[startX][startY] != 0) return cache[startX][startY] == 1; 
		int moveDistance = board[startX][startY];
		boolean isPossible = isPossibleArrival(startX + moveDistance, startY) || isPossibleArrival(startX, startY + moveDistance);
		cache[startX][startY] = isPossible ? 1 : 2;
		return isPossible;
	}
}
