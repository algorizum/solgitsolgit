import java.io.*;
import java.util.StringTokenizer;

public class FENCE {
	public static void main(String[] args) throws IOException {
		InputStreamReader fr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(fr);

		StringTokenizer tokenizer = new StringTokenizer(br.readLine());

		int t = Integer.valueOf(tokenizer.nextToken());

		for (int i = 0; i < t; i++) {
			tokenizer=new StringTokenizer(br.readLine());
			int n=Integer.valueOf(tokenizer.nextToken());
			tokenizer=new StringTokenizer(br.readLine());
			int[] fences=new int[n];
			for(int j=0; j<n; j++)fences[j]=Integer.valueOf(tokenizer.nextToken());
			System.out.println(getMaxReuse(fences,0,n-1));
		}
	}
	
	public static int getMaxReuse(int[] fences,int l, int r){
		if(l==r)return fences[l];
		int mid=(l+r)/2;
		int newL=mid,newR=mid+1;
		int result=Math.max(getMaxReuse(fences,l,newL), getMaxReuse(fences,newR,r));
		int min=Math.min(fences[newL],fences[newR]);
		result=Math.max(result, min*2);
		
		while(l<newL||newR<r){
			if(newR<r && (newL==l ||fences[newL-1]<fences[newR+1])){
				min=Math.min(min, fences[++newR]);
			}else{
				min=Math.min(min, fences[--newL]);
			}
			result=Math.max(result, min*(newR-newL+1));
		}
		return result;
	}
}
