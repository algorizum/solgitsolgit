package brust_force;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClockSync {
	static int[] clocks;
	static int[][] switches = { {0,1,2}, {3,7,9,11}, {4,10,14,15}, {0,4,5,6,7}, {6,7,8,10,12}, 
			{0,2,14,15}, {3,14,15}, {4,5,7,14,15}, {1,2,3,4,5}, {3,4,5,9,13} };
	public static void main(String[] args) {
		ClockSync main = new ClockSync();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			clocks = new int[16];
			for(int i = 0; i < clocks.length; i++) {
				clocks[i] = scanner.nextInt();
			}
			int ret = main.getMinSwitchCount(0, 0);
			System.out.println(ret == Integer.MAX_VALUE ? -1 : ret);
		}
	}
	
	public int getMinSwitchCount(int switchNumber, int currentCount) {
		int minSwitchCount = Integer.MAX_VALUE;
		if(isMatchedAllClocks()) return currentCount;
		if(switchNumber == switches.length) return minSwitchCount;
		for(int i = 1; i <= 4; i++) {
			rotate(switchNumber, +3);
			minSwitchCount = Math.min(minSwitchCount, getMinSwitchCount(switchNumber+1, currentCount+(i%4)));
		}
		return minSwitchCount;
	}
	
	private boolean isMatchedAllClocks() {
		for(int clock : clocks) {
			if(clock != 12) return false;
		}
		return true;
	}
	
	private void rotate(int switchNumber, int time) {
		for(int button : switches[switchNumber]) {
			clocks[button] += time;
			if(clocks[button] <= 0) clocks[button] += 12;
			if(clocks[button] > 12) clocks[button] -= 12;
		}
	}
}
