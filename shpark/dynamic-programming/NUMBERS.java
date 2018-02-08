import java.io.*;
import java.util.*;

public class NUMBERS {
	private static double[] hidingPro;
	public static void main(String[] args) throws IOException {
		InputStreamReader fr = new InputStreamReader(System.in);
		//FileReader fr = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());

		int c = Integer.valueOf(tokenizer.nextToken());

		for (int i = 0; i < c; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(tokenizer.nextToken());
			int d = Integer.valueOf(tokenizer.nextToken());
			int p = Integer.valueOf(tokenizer.nextToken());
			int[][] linked = new int[n][n];
			hidingPro = new double[n];
			double[] linkcnt = new double[n];

			for (int j = 0; j < n; j++) {
				tokenizer = new StringTokenizer(br.readLine());
				int cnt = 0;
				for (int k = 0; k < n; k++) {
					int val = Integer.valueOf(tokenizer.nextToken());
					linked[j][k] = val;
					cnt += val;
				}
				linkcnt[j] = cnt;
			}

			hidingPro[p] = 1;

			getHidingProbability(linked, linkcnt, d);

			tokenizer = new StringTokenizer(br.readLine());
			int t = Integer.valueOf(tokenizer.nextToken());
			tokenizer = new StringTokenizer(br.readLine());
			while (tokenizer.hasMoreTokens()) {
				int idx = Integer.valueOf(tokenizer.nextToken());
				System.out.print(hidingPro[idx] + " ");
			}
			System.out.println();

		}
	}

	private static void getHidingProbability(int[][] linked, double[] linkCnt, int d) {

		for (int i = 0; i < d; i++) {
			double[] tmp = new double[hidingPro.length];
			for (int j = 0; j < hidingPro.length; j++) {
				if (hidingPro[j] != 0) {
					for (int k = 0; k < hidingPro.length; k++) {
						if (linked[j][k] == 1) {
							tmp[k] += ((double) 1 / linkCnt[j]) * (hidingPro[j]);
						}
					}
				}
			}
			hidingPro = tmp;
		}
	}

}