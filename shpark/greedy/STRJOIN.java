import java.io.*;
import java.util.*;

public class STRJOIN {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("input.txt");
		// InputStreamReader fr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());

		int c = Integer.valueOf(tokenizer.nextToken());

		for (int i = 0; i < c; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(tokenizer.nextToken());
			tokenizer = new StringTokenizer(br.readLine());
			PriorityQueue<Integer> pq=new PriorityQueue<>();
			for (int j = 0; j < n; j++) {
				pq.add(Integer.valueOf(tokenizer.nextToken()));
			}
			System.out.println(getStrcatCost(pq));
		}
	}

	private static int getStrcatCost(PriorityQueue<Integer> pq) {
		int res=0;
		while(pq.size()>1) {
			int v1=pq.poll(),v2=pq.poll();
			int sum=v1+v2;
			res+=sum;
			pq.add(sum);
		}
		return res;
	}
}
