package Stack;

import java.util.Stack;

public class LargestRectangleArea {
	//http://www.cnblogs.com/boring09/p/4231906.html
	public static int largestRectangleArea(int[] height) {
		int len = height.length;
		Stack<Integer> s = new Stack<Integer>();
		int maxArea = 0;
		for (int i = 0; i <= len; i++) {
			int h = (i == len ? 0 : height[i]);
			if (s.isEmpty() || h >= height[s.peek()]) {
				s.push(i);
			} else {
				int tp = s.pop();
				maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
				i--;
			}
		}
		return maxArea;
	}
	
	//Divide and conquer
	//TLE for (1...20000) O(N log N)
	public static int largestRectangleArea2(int[] height) {
		return max(height, 0, height.length - 1);
	}
	
	public static int max(int[] height, int start, int end){
		if(start >= height.length || end < 0 || start > end){// dont forget start > end
			return 0;
		}
		int min = height[start];
		int index = start;
		for(int i = start; i <= end; i++){
			if(height[i] < min){
				min = height[i];
				index = i;
			}
		}
		int left = max(height, start, index - 1);
		int right = max(height, index + 1, end);
		int cur = min * (end - start + 1);
		return Math.max(cur, Math.max(left, right));
	}
	
	//Divide and conquer
	public static int largestRectangleArea3(int[] height) {
		return max3(height, 0, height.length - 1);
	}
	
	public static int max3(int[] height, int start, int end){
		if(start == end){
			return height[start];
		}
		int middle = (start + end) / 2;
		int area = max3(height, start, middle);
		area = Math.max(area, max3(height, middle + 1, end));
		area = Math.max(area, maxCombination(height, start, middle, end));
		return area;
	}
	
	public static int maxCombination(int[] height, int start, int middle, int end){
		int i = middle, j = middle + 1;
		int area = 0, h = Math.min(height[i], height[j]);
		while(i >= start && j <= end){
			h = Math.min(h, Math.min(height[i], height[j]));
			area = Math.max(area, (j - i + 1) * h);
			if(i == start){
				j++;
			}else if(j == end){
				i--;
			}else{
				if(height[i - 1] > height[j + 1]){
					i--;
				}else{
					j++;
				}
			}
		}
		return area;
	}

	public static void main(String[] args) {
		//int heights [] = { 2, 1, 5, 6, 2, 3 };
		int heights [] = {6, 2, 5, 4, 5, 1, 6};
		//int heights[] = {0, 0, 0};
		System.out.println(largestRectangleArea(heights));
	}
}
