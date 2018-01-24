package dynamic_programming;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tiling2 {
	static final int MOD_VALUE = 1000000007;
	static int[] cache;
	public static void main(String[] args) {
		Tiling2 main = new Tiling2();
		Scanner scanner = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("src/com/algorithm/training/dynamic_programming/tiling2/test"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int cases = scanner.nextInt();
		while(cases-- > 0) {
			cache = new int[scanner.nextInt()];
			for(int i = 0; i < cache.length; i++) {
				cache[i] = -1;
			}
			System.out.println(main.getTilingCount(cache.length));
		}
	}
	public int getTilingCount(int n) {
		if(n <= 1) return 1;
		if(cache[n-1] != -1) return cache[n-1];
		int tilingCount = (getTilingCount(n-1) + getTilingCount(n-2)) % MOD_VALUE;
		cache[n-1] = tilingCount;
		return cache[n-1];
	}
}
