package Array;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length == 0) return res;
        sub(0, nums, res, new ArrayList<Integer>());
        return res;
    }
    
    public static void sub(int index, int[] nums, List<List<Integer>> res, List<Integer> list){
        if(index <= nums.length){
            res.add(new ArrayList<Integer>(list));
        }
        while(index < nums.length){
            list.add(nums[index]);
            sub(index + 1, nums, res, list);
            list.remove(list.size() - 1);
            index++;
            if(index < nums.length && nums[index] == nums[index - 1]){
                index++;
            }
        }
        return;
    }
    
    public static void main(String[] args){
    	int[] nums = {3, 3, 3};
    	subsetsWithDup(nums);
    }
}
