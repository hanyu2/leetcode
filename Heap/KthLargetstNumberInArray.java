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
        k = nums.length - k;
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int j = partition(nums, left, right);
            if(j == k){
                return nums[j];
            }else if(j < k){
                left = j + 1;
            }else{
                right = j - 1;
            }
        }
        return nums[k];
    }
    
    private static int partition(int[] nums, int i, int j) {
        int x = nums[i];
        int m = i;
        int n = i+1;
        
        while(n<=j){
            if(nums[n]<x) {
                swap(nums, ++m, n);
            }
            ++n;
        }
        swap(nums,i, m);
        return m;
    }
    
    private static void swap(int[] nums, int i, int j) {
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
		int [] nums = {2, 1};
		System.out.println(findKthLargest2(nums, 1));
	}
}
