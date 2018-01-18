package brust_force;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BoardCover {
	static char[][] board;
	static int[][][] settingCase = { {{0,1},{1,0},{0,0}}, {{0,1},{1,1},{0,0}}, {{1,0},{1,1},{0,0}}, {{1,-1},{1,0},{0,0}} };
	public static void main(String[] args) {
		BoardCover main = new BoardCover();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			board  = new char[scanner.nextInt()][scanner.nextInt()];
			for(int i = 0;  i < board.length; i++) {
				board[i] = scanner.next().toCharArray();
			}
			System.out.println(main.countCover());
		}
	}
	
	public int countCover() {
		if(allCovered()) return 1;
		int count = 0;
		boolean cover = false;
		for(int i = 0; i < board.length && !cover; i++) {
			for(int j = 0; j < board[i].length && !cover; j++) {
				if(board[i][j] == '.') {
					cover = true;
					for(int[][] settings : settingCase) {
						if(canSet(settings, i, j)) {
							setBlock(settings, i, j, '#');
							count += countCover();
							setBlock(settings, i, j, '.');
						}
					}
				}
			}
		}
		return count;
	}
	
	private boolean allCovered() {
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == '.') return false;
			}
		}
		return true;
	}
	
	private boolean canSet(int[][] settings, int cX, int cY) {
		boolean canSet = true;
		for(int i = 0; i < settings.length-1; i++) {
			int x = settings[i][0];
			int y = settings[i][1];
			canSet = canSet && cX+x >= 0 && cX+x < board.length 
					&& cY+y >= 0 && cY+y < board[0].length
					&& board[cX+x][cY+y] == '.';
		}
		
		return canSet;
	}
	
	private void setBlock(int[][] settings, int cX, int cY, char setChar) {
		for(int[] set : settings) {
			board[cX+set[0]][cY+set[1]] = setChar;
		}
	}
}
