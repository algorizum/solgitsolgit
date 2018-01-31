import java.util.*;
import java.io.*;

public class POLY {
	public static int[][] monoPoly=new int[101][101];
	public static int MOD=10*1000*1000;
	public static void main(String[] args) throws IOException{
		InputStreamReader fr = new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(fr);
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		
		int C = Integer.valueOf(tokenizer.nextToken());
		
		for(int i=0; i<C;i++){
			tokenizer = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(tokenizer.nextToken());
			
			System.out.println(getMonoPoly(n));
		}
	}

	private static int getMonoPoly(int n) {
		int result=0;
		for(int i=1; i<=n; i++)
			result+=monopoly(n,i);
		return result%MOD;
	}
	
	private static int monopoly(int n,int first){
		if(n==first)
			return 1;
		
		if(monoPoly[n][first]>0)
			return monoPoly[n][first];
		
		for(int second=1; second<=n-first;second++){
			monoPoly[n][first]+=((first+second-1)*monopoly(n-first,second)%MOD);
			monoPoly[n][first]%=MOD;
		}
		return monoPoly[n][first];
	}
}