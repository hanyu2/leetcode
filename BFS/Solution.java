package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length == 0){
            return res;
        }
        List<Integer> num = new ArrayList<Integer>();
        Arrays.sort(nums);
        for(int i : nums){
            num.add(i);
        }
        permute(num, 0, res);
        return res;
    }
    
    public static void permute(List<Integer> nums, int index, List<List<Integer>> res){
        if(index == nums.size() - 1){
            res.add(new ArrayList<Integer>(nums));
            return;
        }
        for(int i = index; i < nums.size(); i++){
            if(i > index && nums.get(i) == nums.get(i - 1)){
                continue;
            }
            nums.add(index, nums.get(i));
            nums.remove(i + 1);
            permute(nums, i + 1, res);
            nums.add(i + 1, nums.get(index));
            nums.remove(index);
        }
    }

	public static void main(String[] args) {
		System.out.println(permuteUnique(new int[]{1, 1, 2}));
	}
}
