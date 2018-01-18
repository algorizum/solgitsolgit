package dynamic_programming;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Wildcard {
	static char[] wildCard, fileName;
	static int[][] cache;
	public static void main(String[] args) {
		Wildcard main = new Wildcard();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			List<String> matchedFileList = new ArrayList<>();
			wildCard = scanner.next().toCharArray();
			int fileNumber = scanner.nextInt();
			for(int i = 0; i < fileNumber; i++) {
				String fileNameStr = scanner.next();
				fileName = fileNameStr.toCharArray();
				cache = new int[wildCard.length][fileName.length];
				if(main.isMatched(0, 0)) matchedFileList.add(fileNameStr);
			}
			Collections.sort(matchedFileList);
			for(String matchedFileName : matchedFileList) {
				System.out.println(matchedFileName);
			}
		}
	}
	
	public boolean isMatched(int wildCardIndex, int fileNameIndex) {
		if(wildCardIndex == wildCard.length && fileNameIndex == fileName.length) return true;
		if(wildCardIndex == wildCard.length) return false;
		if(fileNameIndex == fileName.length) {
			return wildCard[wildCardIndex] == '*' ? isMatched(wildCardIndex+1, fileNameIndex) : false;
		}
		if(cache[wildCardIndex][fileNameIndex] != 0) return cache[wildCardIndex][fileNameIndex] == 1;
		
		boolean isMatched = false;
		switch(wildCard[wildCardIndex]) {
		case '*':
			isMatched = isMatched(wildCardIndex+1, fileNameIndex) 
				|| isMatched(wildCardIndex, fileNameIndex+1);
			break;
		case '?':
			isMatched = isMatched(wildCardIndex+1, fileNameIndex+1);
			break;
		default:
			if(wildCard[wildCardIndex] == fileName[fileNameIndex]) {
				isMatched = isMatched(wildCardIndex+1, fileNameIndex+1);
			}
			break;
		}
		cache[wildCardIndex][fileNameIndex] = isMatched ? 1 : 2;
		return isMatched;
	}
}
