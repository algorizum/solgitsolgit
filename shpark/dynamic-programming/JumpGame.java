import java.io.*;
import java.util.StringTokenizer;

public class JumpGame {
	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("input.txt");
		BufferedReader br=new BufferedReader(fr);
		
		StringTokenizer tokenizer=new StringTokenizer(br.readLine());
		
		int t=Integer.valueOf(tokenizer.nextToken());
	
		for(int i=0; i<t;i++){
			tokenizer=new StringTokenizer(br.readLine());
			int n=Integer.valueOf(tokenizer.nextToken());
			int[][] grid=new int[n][n];
			for(int j=0; j<n;j++){
				tokenizer=new StringTokenizer(br.readLine());
				for(int k=0; k<n;k++)
					grid[j][k]=Integer.valueOf(tokenizer.nextToken());
			}
			System.out.println(jump(grid,n)?"YES":"NO");
		}
	}
	
	public static boolean jump(int[][]grid, int n){
		int[][] can=new int[n][n];
		can[0][0]=1;
		for(int i=0;i<n;i++){
			for(int j=0; j<n;j++){
				if(can[i][j]==1){
					if(i+grid[i][j]<grid.length)can[i+grid[i][j]][j]=1;
					if(j+grid[i][j]<grid.length)can[i][j+grid[i][j]]=1;
				}
			}
		}
		return can[n-1][n-1]==1?true:false;
	}
}
