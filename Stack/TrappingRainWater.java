package Stack;

import java.util.Stack;

public class TrappingRainWater {
	//Two pointer
	public static int trap(int[] height) {
		int secHight = 0;
		int left = 0;
		int right = height.length - 1;
		int area = 0;
		while (left < right) {
			if (height[left] < height[right]) {
				secHight = Math.max(height[left], secHight);
				area += secHight - height[left];
				left++;
			} else {
				secHight = Math.max(height[right], secHight);
				area += secHight - height[right];
				right--;
			}
		}
		return area;
	}
	
	public static int trap2(int[] height) {
        if (height==null) return 0;
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, maxWater = 0, maxBotWater = 0;
        while (i < height.length){
            if (s.isEmpty() || height[i]<=height[s.peek()]){
                s.push(i++);
            }
            else {
                int bot = s.pop();
                maxBotWater = s.isEmpty()? // empty means no il
                0:(Math.min(height[s.peek()],height[i])-height[bot])*(i-s.peek()-1);
                maxWater += maxBotWater;
            }
        }
        return maxWater;
    }

	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		trap2(height);
	}
}
