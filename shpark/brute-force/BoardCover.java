import java.io.*;

public class BoardCover {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("input.txt");
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(fr);

		int t = Integer.valueOf(br.readLine().replaceAll(" ", ""));
		for (int i = 0; i < t; i++) {
			String[] line = br.readLine().split(" ");
			int H = Integer.valueOf(line[0]);
			int W = Integer.valueOf(line[1]);
			
			int[][] arr=new int[H][W];
			int white_cnt=0;
			
			for(int j=0; j<H;j++){
				char[] c=br.readLine().toCharArray();
				for(int k=0; k<W;k++){
					if(c[k]=='#')arr[j][k]=1;
					else white_cnt++;
				}
			}
			
			if(white_cnt%3!=0 || white_cnt==0){System.out.println(0);continue;}
			else{
				BoardCover bc = new BoardCover();
				System.out.println(bc.cover(arr));
			}
	    	
		}
	}
	
	private static int[][][] cover_case={
		{{0,0},{1,0},{1,1}},
		{{0,0},{1,0},{1,-1}},
		{{0,0},{0,1},{1,0}},
		{{0,0},{0,1},{1,1}}
		};

	public boolean canCover(int[][]arr,int[][] cover,int x,int y,int cur){
		boolean status=true;
		for(int[] c:cover){
			int nextX=x+c[0],nextY=y+c[1];
			if(nextX<0 ||nextX>=arr.length || nextY<0 ||nextY>=arr[0].length)status=false;
			else if((arr[nextX][nextY]+=cur)>1)status=false;
		}
		return status;
	}
	
	public int cover(int[][] arr){
		int sum=0;
		int x=-1,y=-1;
		for(int i=0;i<arr.length;i++){
			for(int j=0; j<arr[i].length;j++){
				if(arr[i][j]==0){
					x=i;y=j;
					break;
				}
			}
			if(x!=-1)break;
		}
		
		if(x==-1)return 1; //모든 칸이 찼으면 1을 리턴 
		
		for(int i=0;i<4;i++){
			//블럭을 덮을 수 있다면 재귀호출
			if(canCover(arr,cover_case[i],x,y,1)){
				sum+=cover(arr);
			}
			//덮었던 블럭을 치운다
			canCover(arr,cover_case[i],x,y,-1);	
		}
		return sum;
	}
}
