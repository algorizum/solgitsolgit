
import java.util.*;
import java.io.*;

public class WILDCARD {
	public static void main(String[] args) throws IOException {
		InputStreamReader fr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(fr);

		StringTokenizer tokenizer = new StringTokenizer(br.readLine());

		int t = Integer.valueOf(tokenizer.nextToken());

		for (int i = 0; i < t; i++) {
			tokenizer = new StringTokenizer(br.readLine());
			String wildcard = tokenizer.nextToken();

			tokenizer = new StringTokenizer(br.readLine());
			int n = Integer.valueOf(tokenizer.nextToken());
			List<String> result = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				tokenizer = new StringTokenizer(br.readLine());
				String target = tokenizer.nextToken();
				if (isMatch(wildcard, target))
					result.add(target);
			}
			Collections.sort(result);
			for (String res : result)
				System.out.println(res);
		}
	}

	public static boolean isMatch(String wildcard, String target) {
		if (wildcard.length() == 0 && target.length() == 0)
			return true;

		if (wildcard.length() > 0 && target.length() > 0
				&& (target.charAt(0) == wildcard.charAt(0) || wildcard.charAt(0) == '?')) {
			return isMatch(wildcard.substring(1), target.substring(1));
		}

		if (wildcard.length() > 0 && wildcard.charAt(0) == '*') {
			if (isMatch(wildcard.substring(1), target)
					|| (target.length() > 0 && isMatch(wildcard, target.substring(1))))
				return true;
		}
		return false;
	}
}