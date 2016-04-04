package Sort;

public class HeapSort {
	 //Heap sort
    private static int L;
    public static int findKthLargest3(int[] nums, int k){
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

    public static void swap(int [] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    
    
    
    
    public static void heapSort2(int[] arr) {
        if(arr == null || arr.length == 0)
            return ; 
        //建立大顶堆
        for(int i=arr.length/2; i>=0; i--) {
            heapAdjust(arr, i, arr.length-1);
        }    
        for(int i=arr.length-1; i>=0; i--) {
            swap(arr, 0, i);
            heapAdjust(arr, 0, i-1);
        }   
    }
    
    public static void heapAdjust(int[] arr, int start, int end) {
        int temp = arr[start];      
        for(int i=2*start+1; i<=end; i*=2) {
            //左右孩子的节点分别为2*i+1,2*i+2 
            //选择出左右孩子较小的下标
            if(i < end && arr[i] < arr[i+1]) {
                i ++; 
            }
            if(temp >= arr[i]) {
                break; //已经为大顶堆，=保持稳定性。
            }
            arr[start] = arr[i]; //将子节点上移
            start = i; //下一轮筛选
        }
        arr[start] = temp; //插入正确的位置
    }
    
	public static void main(String[] args) {
		int [] nums = {4, 1, 2, 5, 9, 6, 3, 8, 7};
		System.out.println(findKthLargest3(nums, 3));
	}
}
