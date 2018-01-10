package codes;

import FastIO.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CLOCKSYNC {
    int[][] idxList=new int[][]{{0,1,2}
    ,{3,7,9,11}
    ,{4,10,14,15}
    ,{0,4,5,6,7}
    ,{6,7,8,10,12}
    ,{0,2,14,15}
    ,{3,14,15}
    ,{4,5,7,14,15}
    ,{1,2,3,4,5}
    ,{3,4,5,9,13}};
    final static int MAX = 99999999;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int[] input = new int[16];
        for(int i=0;i<16;i++){
            input[i]=in.readInt();
        }
        int ans=sync(input,0);
        if(ans>=MAX){
            out.println(-1);
        }else out.println(ans);
    }

    public boolean isFinish(int[] now){
        for(int v:now)if(v!=12)return false;
        return true;
    }

    public int sync(int[] now, int swch){
        if(swch==10)return isFinish(now)?0:MAX;

        int res=MAX;

        for(int i=0;i<4;i++){
            res=Math.min(res,i+sync(now,swch+1));
            for(int idx:idxList[swch]){
                now[idx]+=3;
                if(now[idx]==15)now[idx]=3;
            }
        }
        return res;
    }
}

