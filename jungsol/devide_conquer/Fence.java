package devide_conquer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Fence {
	static int[] boardHeights;
	public static void main(String[] args) {
		Fence main = new Fence();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("input"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			boardHeights = new int[scanner.nextInt()];
			for(int i = 0; i < boardHeights.length; i++) {
				boardHeights[i] = scanner.nextInt();
			}
			System.out.println(main.getMaxWeight(0, boardHeights.length-1));
		}
	}
	
	public int getMaxWeight(int head, int tail) {
		int maxWeight = -1, mid = (head+tail)/2, left = mid, right = mid, minHeight = boardHeights[mid];
		if(head == tail) return boardHeights[left];
		maxWeight = Math.max(getMaxWeight(head, mid), getMaxWeight(mid+1, tail));
		while(left > head || right < tail) {
			if(left <= head || (right < tail && boardHeights[left-1] <= boardHeights[right+1])) {
				minHeight = Math.min(minHeight, boardHeights[++right]);
			} else {
				minHeight = Math.min(minHeight, boardHeights[--left]);
			}
			maxWeight = Math.max(maxWeight, (right-left+1) * minHeight);
		}
		return maxWeight;
	}
}
