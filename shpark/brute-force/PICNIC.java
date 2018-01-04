import java.io.*;
import java.util.*;

public class PICNIC {
	
	public static void main(String[] args) throws IOException{
		FileReader fr = new FileReader("input.txt");
		BufferedReader br=new BufferedReader(fr);
		
		int t=Integer.valueOf(br.readLine().replaceAll(" ", ""));
		for(int i=0; i<t;i++){
			String[] line=br.readLine().split(" ");
			int n=Integer.valueOf(line[0]);
			int m=Integer.valueOf(line[1]);
			
			line=br.readLine().split(" ");
			//System.out.println("n="+n+" ,m="+m);
			PICNIC p=new PICNIC();
			System.out.println(p.picnic(n, m, line));
		}
	}
	
	public int picnic(int n, int m, String[]friends){
		if(n%2!=0)return 0;
		
		int [][] isFriend=new int[n][n];
		
		for(int i=0; i<m;i++){
			int x=Integer.valueOf(friends[i*2]);
			int y=Integer.valueOf(friends[i*2+1]);
			isFriend[x][y]=1;
			isFriend[y][x]=1;
		}
		
		LinkedList<Integer> students=new LinkedList<>();
		for(int i=0; i<n; i++)students.add(i);
		
		return getPossibleCase(students,isFriend);
	}
	
	public int getPossibleCase(LinkedList<Integer> students,int[][] isFriend){
		if(students.size()<2)return 1;
		int sum=0;
		int x=students.poll();
		int size=students.size();
		for(int i=0; i<size;i++){
			int y=students.poll();
			if(isFriend[x][y]==1)sum+=getPossibleCase(students,isFriend);
			students.offer(y);
		}
		students.addFirst(x);
		return sum;
	}
}