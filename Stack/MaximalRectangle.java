package Stack;

import java.util.Stack;

public class MaximalRectangle {
	public static int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }
        int max = 0;
        int [] heights = new int [matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '1'){
                    heights[j] += 1;
                }else{
                    heights[j] = 0;
                }
            }
            max = Math.max(find(heights), max);
        }
        return max;
    }
    
    public static int find(int []heights){
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for(int i = 0; i <= heights.length; i++){
            int h = i == heights.length ? 0 : heights[i];
            if(stack.isEmpty() || h >= heights[stack.peek()]){
                stack.push(i);
            }else{
                int dp = stack.pop();
                int area = heights[dp] * (stack.isEmpty() ? i : i - 1 - stack.peek()) ;
                max = Math.max(max, area);
                i--;
            }
        }
        return max;
    }

	public static void main(String[] args) {
		char[][] matrix = { {'1' } };
		System.out.println(maximalRectangle(matrix));
	}
}
