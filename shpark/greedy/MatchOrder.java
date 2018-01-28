import java.io.*;
import java.util.*;

public class MatchOrder {
	public static void main(String[] args) throws IOException {
		InputStreamReader fr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());

		int C = Integer.valueOf(tokenizer.nextToken());

		for (int i = 0; i < C; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(tokenizer.nextToken());
			
			int[] r=new int[n];
			tokenizer = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++)r[j]=Integer.valueOf(tokenizer.nextToken());
					
			int[] k=new int[n];
			tokenizer = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++)k[j]=Integer.valueOf(tokenizer.nextToken());
			
			System.out.println(getMaxWin(r,k));
		}
	}

	private static int getMaxWin(int[] r, int[] k) {
		int result=0;
		
		Arrays.sort(r);
		Arrays.sort(k);
		
		for(int i=0,j=0; i<r.length &&j<k.length;j++) {
			if(r[i]<=k[j]) {
				result++;
				i++;
			}
		}
		return result;
	}
}
