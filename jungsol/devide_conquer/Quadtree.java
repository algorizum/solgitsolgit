package devide_conquer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Quadtree {
	static char[] originPicture;
	static int index;
	public static void main(String[] args) {
		Quadtree main = new Quadtree();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			originPicture = scanner.next().toCharArray();
			index = 0;
			System.out.println(main.zipPicture());
		}
	}
	
	private String zipPicture() {
		switch (originPicture[index++]) {
		case 'w':
		case 'b':
			return String.valueOf(originPicture[index-1]);
		default:
			String s1 = zipPicture();
			String s2 = zipPicture();
			String s3 = zipPicture();
			String s4 = zipPicture();
			return "x" + s3 + s4 + s1 + s2;
		}
	}
}
