import java.io.*;
import java.util.*;

public class LUNCHBOX {
	public static void main(String[] args) throws IOException {
		InputStreamReader fr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());

		int T = Integer.valueOf(tokenizer.nextToken());

		for (int i = 0; i < T; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(tokenizer.nextToken());
			
			List<int[]> lunchs=new ArrayList<>();
			tokenizer = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				lunchs.add(new int[2]);
				lunchs.get(j)[0]=Integer.valueOf(tokenizer.nextToken());
			}
			
			tokenizer = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				lunchs.get(j)[1]=Integer.valueOf(tokenizer.nextToken());
			}
			Collections.sort(lunchs,new Comparator<int[]>(){
				@Override
				public int compare(int[] a0, int[] a1) {
					if(a0[1]>a1[1])return -1;
					else if(a0[1]<a1[1])return 1;
					else return 0;
				}
				
			});
			int max=0,result=0;
			for(int j=0; j<n; j++) {
				result+=lunchs.get(j)[0];
				max=Math.max(max, result+lunchs.get(j)[1]);
			}
			System.out.println(max);
		}
	}
}
