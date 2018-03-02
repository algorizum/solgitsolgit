import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
		int res=0;
		Map<Character,Integer> appear=new HashMap<>();
		for(char t:tasks){
			int v=appear.getOrDefault(t, 0);
			appear.put(t, v+1);
		}
		
		PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
		
		for(char k:appear.keySet())pq.add(appear.get(k));
		
		while(!pq.isEmpty()){
			Queue<Integer>tmp=new LinkedList<>();
			for(int i=n;i>=0 && (!pq.isEmpty() ||!tmp.isEmpty());i--){
				res++;
				if(!pq.isEmpty()){
					int v=pq.poll();
					if(v-1>0)tmp.add(v-1);
				}
			}
			pq.addAll(tmp);
		}
		
		return res;
	}
	@Test
	public void test(){
		assertEquals(leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'},2),16);
	}
}
