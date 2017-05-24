package Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
	public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        int[] res = new int[findNums.length];
        for(int i = 0; i < nums.length; i++){
            while(!stack.isEmpty() && stack.peek() < nums[i]){
                map.put(stack.pop(), nums[i]);
            }
            stack.push(nums[i]);
        }
        for(int i = 0; i < findNums.length; i++){
            if(!map.containsKey(findNums[i])){
                res[i] = -1;
            }else{
                res[i] = map.get(findNums[i]);
            }
        }
        return res;
    }
}
