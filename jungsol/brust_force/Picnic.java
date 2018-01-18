package brust_force;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Picnic {
	static Set<String> friendSet;
	static boolean[] isMatched;
	public static void main(String[] args) {
		Picnic main = new Picnic();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			isMatched = new boolean[scanner.nextInt()];
			int friendNumber = scanner.nextInt();
			friendSet = new HashSet<>();
			for(int i = 0; i < friendNumber; i ++) {
				int friend1 = scanner.nextInt();
				int friend2 = scanner.nextInt();
				friendSet.add(Math.min(friend1, friend2) + "," + Math.max(friend1, friend2));
			}
			System.out.println(main.getPairNumber());
		}
	}
	public int getPairNumber() {
		int pairNumber = 0;
		int student1 = -1;
		for(int i = 0; i < isMatched.length; i++) {
			if(!isMatched[i]) {
				student1 = i;
				break;
			}
		}
		if(student1 == -1) return 1;
		for(int i = student1+1; i < isMatched.length; i++) {
			if(!isMatched[i] && friendSet.contains(student1 + "," + i)) {
				isMatched[student1] = isMatched[i] = true;
				pairNumber += getPairNumber();
				isMatched[student1] = isMatched[i] = false;
			}
		}
 		return pairNumber;
	}
}
