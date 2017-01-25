package BinarySearch;

public class MedianOfTwoSortedArrays {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		
		if (m > n) {
			return findMedianSortedArrays(nums2, nums1);
		}
		
		int i = 0, j = 0, imin = 0, imax = m, half = (m + n + 1) / 2;
		double maxLeft = 0, minRight = 0;
		while(imin <= imax){
			i = (imin + imax) / 2;
			j = half - i;
			if(j > 0 && i < m && nums2[j - 1] > nums1[i]){
				imin = i + 1;
			}else if(i > 0 && j < n && nums1[i - 1] > nums2[j]){
				imax = i - 1;
			}else{
				if(i == 0){
					maxLeft = (double)nums2[j - 1];
				}else if(j == 0){
					maxLeft = (double)nums1[i - 1];
				}else{
					maxLeft = (double)Math.max(nums1[i - 1], nums2[j - 1]);	
				}
				break;
			}
		}
		if((m + n) % 2 == 1){
			return maxLeft;
		}
		if(i == m){
			minRight = (double)nums2[j];
		}else if(j == n){
			minRight = (double)nums1[i];
		}else{
			minRight = (double)Math.min(nums1[i], nums2[j]);
		}
		
		return (double)(maxLeft + minRight) / 2;
	}
	
	//O(log k) nine chapter
	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if(length % 2 == 0){
            return (findKthLargest(nums1, 0, nums2, 0, length / 2) + findKthLargest(nums1, 0, nums2, 0, length / 2 + 1)) / 2.0;
        }else{
            return findKthLargest(nums1, 0, nums2, 0, length / 2 + 1);
        }
    }
    
    public int findKthLargest(int[] nums1, int start1, int[] nums2, int start2, int k){
        if(start1 >= nums1.length){
            return nums2[start2 + k - 1];
        }
        if(start2 >= nums2.length){
            return nums1[start1 + k - 1];
        }
        if(k == 1){
            return Math.min(nums1[start1], nums2[start2]);
        }
        int keyOfNums1 = start1 + k / 2 - 1 < nums1.length ? nums1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
        int keyOfNums2 = start2 + k / 2 - 1 < nums2.length ? nums2[start2 + k / 2 - 1] : Integer.MAX_VALUE;
        if(keyOfNums1 < keyOfNums2){
            return findKthLargest(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        }else{
            return findKthLargest(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }
	
	public static void main(String[] args) {
		int []nums1 = {2};
		int []nums2 = {};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}
}
