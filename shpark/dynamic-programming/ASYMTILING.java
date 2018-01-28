import java.io.*;
import java.util.StringTokenizer;

public class ASYMTILING {
	private static final int mod=1000000007;
	private static int[] tile=new int[101];
	public static void main(String[] args) throws IOException {
		InputStreamReader fr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(fr);
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		
		tile[0]=1;
		tile[1]=1;
		
		int C = Integer.valueOf(tokenizer.nextToken());
		for (int i = 0; i < C; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(tokenizer.nextToken());
			
			System.out.println(getAsymTile(n));
		}
	}

	private static int getAsymTile(int n) {
		int val=tiling(n);

		val=(val-tiling(n/2)+mod)%mod;
		if(n%2==0)val=(val-tiling(n/2-1)+mod)%mod;
		return val;
	}

	private static int tiling(int i) {
		if(tile[i]>0)return tile[i];
		return (tile[i]=(tiling(i-1)+tiling(i-2))%mod);
	}
}