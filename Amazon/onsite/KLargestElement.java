package Amazon.onsite;

import java.util.PriorityQueue;

public class KLargestElement {
	public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int n : nums){
            if(pq.size() < k){
                pq.offer(n);
            }else{
                if(n > pq.peek()){
                    pq.poll();
                    pq.offer(n);
                }
            }
        }
        return pq.peek();
    }
}
