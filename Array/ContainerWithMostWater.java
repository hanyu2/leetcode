package Array;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int left = 0, right = height.length - 1;
		int maxArea = 0;

		while (left < right) {
			maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
			if (height[left] < height[right])
				left++;
			else
				right--;
		}

		return maxArea;
	}
	//This is wrong !!! 
	public static int maxArea3(int[] height) {
		int left = 0, right = height.length - 1;
		int maxArea = 0;

		while (left < right) {
			maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
			if (height[left] < height[right])
				while (left < right && height[left] >= height[left + 1]) {//at first I revesed the condition and it will cause  
					left++; 											//OutOfBounds exception
				}
			else
				while ( right > left && height[right] >= height[right - 1]) {
					right--;
				}
		}

		return maxArea;
	}

	public int maxArea2(int[] height) {
		int L = height.length, lo = 0, hi = L - 1;
		int max = 0;
		while (lo < hi) {
			int loMax = height[lo], hiMax = height[hi];

			int candidate = (hi - lo) * (loMax < hiMax ? loMax : hiMax);
			max = candidate > max ? candidate : max;

			if (height[lo] <= height[hi])
				while (lo < hi && height[lo] <= loMax)
					++lo;
			else
				while (hi > lo && height[hi] <= hiMax)
					--hi;
		}
		return max;
	}
	public static void main(String[] args) {
		int height [] = {1, 1};
		System.out.println(maxArea3(height));
	}
}
