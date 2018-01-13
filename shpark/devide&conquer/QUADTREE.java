import java.io.*;
import java.util.StringTokenizer;

public class QUADTREE {
	public static void main(String[] args) throws IOException {
		InputStreamReader fr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(fr);

		StringTokenizer tokenizer = new StringTokenizer(br.readLine());

		int t = Integer.valueOf(tokenizer.nextToken());

		for (int i = 0; i < t; i++) {
			String quadTree=br.readLine().replaceAll(" ", "");
			System.out.println(reverse(quadTree));
		}
	}
	
	public static String reverse(String tree){
		String first=String.valueOf(tree.charAt(0));
		tree=tree.substring(1);
		if(first.equals("b")||first.equals("w"))
			return first;
		
		String leftUp=reverse(tree);
		tree=tree.substring(leftUp.length());
		String rightUp=reverse(tree);
		tree=tree.substring(rightUp.length());
		String leftDown=reverse(tree);
		tree=tree.substring(leftDown.length());
		String rightDown=reverse(tree);
		return "x"+leftDown+rightDown+leftUp+rightUp;
	}
	
}
