package codes;

import FastIO.InputReader;
import java.io.PrintWriter;

public class Fence {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] fence = new int[n];
        for (int i = 0; i < n; i++) {
            fence[i] = in.nextInt();
        }
        out.println(solution(fence, 0, n - 1));
    }

    public int solution(int[] fences, int left, int right) {
        if (left == right) {
            return fences[left];
        }
        int mid = (left + right) / 2;
        int max = Math.max(solution(fences, left, mid), solution(fences, mid + 1, right));
        int lp = mid, rp = mid + 1, height = Math.min(fences[lp], fences[rp]);
        max = Math.max(max, height * 2);
        while (left < lp || rp < right) {
            if (lp == left) {
                rp++;
                height = Math.min(height, fences[rp]);
            } else if (rp == right) {
                lp--;
                height = Math.min(height, fences[lp]);
            } else if (lp > left && rp < right && fences[lp - 1] > fences[rp + 1]) {
                lp--;
                height = Math.min(height, fences[lp]);
            } else if (lp > left && rp < right && fences[lp - 1] <= fences[rp + 1]) {
                rp++;
                height = Math.min(height, fences[rp]);
            }
            max = Math.max(max, (rp - lp + 1) * height);
        }
        return max;
    }
}
