import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class TaskScheduler {
	/*public int leastInterval(char[] tasks, int n) {
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
	}*/
	public int leastInterval(char[] tasks, int n) {
		int[] nums=new int[26];
		for(char t:tasks)nums[t-'A']++;
		Arrays.sort(nums);
		int max=nums[25]-1;
		int idleSlotCnt=max*n;
		
		for(int i=24;i>=0 && nums[i]>0; i--){
			idleSlotCnt-=Math.min(max, nums[i]);
		}
		
		return tasks.length+(idleSlotCnt>0?idleSlotCnt:0);
	}
	@Test
	public void test(){
		assertEquals(leastInterval(new char[]{'A','A','A','B','B','B'},0),6);
		assertEquals(leastInterval(new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'},2),16);
	}
}
