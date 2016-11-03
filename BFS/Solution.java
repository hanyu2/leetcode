package BFS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

import Tree.TreeNode;

public class Solution {
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        sub(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    
    public static void sub(int[] nums, int index, List<Integer> list, List<List<Integer>> res){
        res.add(list);
        for(int i = index; i < nums.length; i++){
            if(i > index && nums[i] == nums[i - 1]){
                continue;
            }
            List<Integer> temp = new ArrayList<Integer>(list);
            temp.add(nums[i]);
            sub(nums, i + 1, temp, res);
        }
    }
	public static void main(String[] args){
		int[] nums = {1, 2, 2};
		subsetsWithDup(nums);
	}
}
