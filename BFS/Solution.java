package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public static int lengthOfLIS(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        List<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > list.get(list.size() - 1)){
                list.add(nums[i]);
            }else{
                int index = find(list, nums[i]);
                list.set(index, nums[i]);
            }
        }
        return list.size();
    }
    
    public static int find(List<Integer> list, int target){
        int start = 0;
        int end = list.size() - 1;
        while(start < end){
            int mid = (start + end) >> 1;
            if(list.get(mid) > target){
                end = mid - 1;
            }else{
                start = mid;
            }
        }
        return start;
    }
	public static void main(String[] args){
		int[] nums = {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLIS(nums));
	}
}
