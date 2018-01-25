import java.io.*;
import java.util.StringTokenizer;

public class TRIANGLEPATH {
	public static void main(String[] args) throws IOException {
		InputStreamReader fr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(fr);

		StringTokenizer tokenizer = new StringTokenizer(br.readLine());

		int t = Integer.valueOf(tokenizer.nextToken());

		for (int i = 0; i < t; i++) {
			
			tokenizer = new StringTokenizer(br.readLine());
			int size=Integer.valueOf(tokenizer.nextToken());
			
			int result=Integer.MIN_VALUE;
			
			int[] line=new int[size];
			
			for(int j=1;j<=size;j++){
				tokenizer = new StringTokenizer(br.readLine());
				
				int[] tmp=line;
				line=new int[j];
				
				for(int k=0;k<j;k++){
					int token=Integer.valueOf(tokenizer.nextToken());
					
					if(k>0 && k<j-1)token=Math.max(token+tmp[k-1], token+tmp[k]);
					else if(k==0)token+=tmp[k];
					else if(k==j-1)token+=tmp[k-1];
					
					result=Math.max(result, token);
					line[k]=token;
				}
			}
			System.out.println(result);
		}
	}
}
