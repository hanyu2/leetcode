package Heap;

import java.util.PriorityQueue;
import java.util.Random;

public class KthLargetstNumberInArray {
	//O(N lg K) running time + O(K) memory
	public static int findKthLargest(int[] nums, int k) {
		final PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int val : nums) {
			pq.offer(val);
			if (pq.size() > k) {
				pq.poll();
			}
		}
		return pq.peek();
	}
	//similar idea with quick sort
	public static int findKthLargest2(int[] nums, int k) {
		//shuffle(nums);
        k = nums.length - k;
        int start = 0;
        int end = nums.length - 1;
        while(start < end){
            int j = partition(nums, start, end);
            if(j < k){
                start = j + 1;
            }else if(j > k){
                end = j - 1;
            }else{
                break;
            }
        }
        return nums[k];
    }
    public static int partition(int [] nums, int start, int end){
        int i = start;
        int j = end + 1;
        while(true){
            while(i < end && (nums[++i] < nums[start]));
               
            while(j > start && (nums[start] < nums[--j]));
            if(i >= j){
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, start, j);
        return j;
    }
    public static void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    private static void shuffle(int a[]) {

        Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            swap(a, ind, r);
        }
    }
    
    //Heap sort
    private static int L;
    public static int findKthLargest3(int[] nums, int k) {
        heapSort(nums);
        return nums[nums.length - k];
    }

    private static void heapSort(int[] nums){
       buildHeap(nums);
       for(int i = L;i >=1; i--)
       {
           swap(nums, 0, i);
           L = L - 1;
          heapify(nums, 0);
       }
    }

    private static void buildHeap(int[] nums){
        L = nums.length-1;
        for(int i = L/2; i >=0; i--)
            heapify(nums, i);
    }

    //max-heap
    private static void heapify(int[] nums, int i){
        int l = 2 * i;
        int r = l + 1;
        int largest = i;
        if((l <= L) && (nums[l] > nums[largest]))
            largest = l;
        if((r <= L) && (nums[r] > nums[largest]))
            largest = r;
        if(largest != i)
        {
            swap(nums, i, largest);
            heapify(nums, largest);
        }
    }

	public static void main(String[] args) {
		int [] nums = {4, 1, 2, 5, 9, 6, 3, 8, 7};
		System.out.println(findKthLargest3(nums, 3));
	}
}
