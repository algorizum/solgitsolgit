import java.io.*;
import java.util.*;

public class PACKING {
	public static void main(String[] args) throws IOException {
		InputStreamReader fr = new InputStreamReader(System.in);
		//FileReader fr = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());

		int T = Integer.valueOf(tokenizer.nextToken());

		for (int i = 0; i < T; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(tokenizer.nextToken());
			int w=Integer.valueOf(tokenizer.nextToken());
			
			Map<Integer,List<String>> things=new HashMap<>();
			
			int[] maxWeight=new int[w+1];
			
			int maxIdx=0;
			
			for (int j = 0; j < n; j++) {
				tokenizer = new StringTokenizer(br.readLine());
				String thing=tokenizer.nextToken();
				int key=Integer.valueOf(tokenizer.nextToken());
				int val=Integer.valueOf(tokenizer.nextToken());
				for(int k=w; k>0;k--) {
					if(maxWeight[k]>0 && key+k<=w) {
						int max=Math.max(maxWeight[key+k], maxWeight[k]+val);
						maxIdx=maxWeight[maxIdx]<max?key+k:maxIdx;
						
						if(maxWeight[key+k]<= maxWeight[k]+val) {
							List<String>tmp=new ArrayList<>(things.get(k));
							tmp.add(thing);
							things.put(key+k, tmp);
							maxWeight[key+k]=max;
						}
					}
				}
				if(maxWeight[key]<val) {
					maxWeight[key]=val;
					things.put(key, new ArrayList<>());
					things.get(key).add(thing);
				}
			}
			System.out.println(maxWeight[maxIdx]+" "+things.get(maxIdx).size());
			for(String s:things.get(maxIdx)) {
				System.out.println(s);
			}
		}
	}

}
