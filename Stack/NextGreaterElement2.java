package Stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class NextGreaterElement2 {
	public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Queue<Integer> q = new LinkedList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                List<Integer> list = map.get(nums[i]);
                list.add(i);
            }else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(nums[i], list);
            }
            while(!stack.isEmpty() && stack.peek() < nums[i]){
                List<Integer> list = map.get(stack.pop());
                res[list.remove(list.size() - 1)] = nums[i];
            }
            stack.push(nums[i]);
            if(q.isEmpty()){
                q.offer(nums[i]);
            }else if(nums[i] > q.peek()){
                q.offer(nums[i]);
            }
        }
        while(!stack.isEmpty() && !q.isEmpty()){
            while(!q.isEmpty() && q.peek() > stack.peek()){
                List<Integer> list = map.get(stack.pop());
                res[list.remove(list.size() - 1)] = q.peek();
            }
            q.poll();
        }
        return res;
    }
	
	public static int[] nextGreaterElements2(int[] nums) {
        int[] res = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * nums.length - 1; i >= 0; --i) {
            while (!stack.empty() && nums[stack.peek()] <= nums[i % nums.length]) {
                stack.pop();
            }
            res[i % nums.length] = stack.empty() ? -1 : nums[stack.peek()];
            stack.push(i % nums.length);
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums = {3, 8, 4, 1, 2};
		nextGreaterElements2(nums);
	}
}
