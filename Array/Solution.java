package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        sum(res, new ArrayList<Integer>(), nums, 4, target,0, nums.length - 1);
        return res;
    }
    
    public static void sum(List<List<Integer>> res, List<Integer> list, int [] nums, int k, int target,int start, int end){
        if(k == 0 || start > end || nums.length == 0){
            return;
        }
        if(k == 1){
            for(int i = start; i <= end; i++){
                if(nums[i] == target){
                    list.add(nums[i]);
                    res.add(new ArrayList<Integer>(list));
                    list.remove(nums[i]);
                }
            }
            return;
        }
        if(k == 2){
            if(nums[start] * k > target || nums[end] * k < target) return;
            while(start < end){
                int sum = nums[start] + nums[end];
                if(sum == target){
                    list.add(nums[start]);
                    list.add(nums[end]);
                    res.add(new ArrayList(list));
                    list.remove(list.size() - 1);
                    list.remove(list.size() - 1);
                    //avoid duplicate
                    while(start < end && nums[start] == nums[start+1]) ++start;
                    ++start;
                    while(start < end && nums[end] == nums[end-1]) --end;
                    --end;
                }
                if(sum < target){
                    while(start < end && nums[start] == nums[start + 1]){
                        start++;
                    }
                    start++;
                }else{
                    while(start < end && nums[end] == nums[end - 1]){
                        end--;
                    }
                    end--;
                }
            }
            return;
        }
        
        if(nums[start] * k > target || nums[end] * k < target) return;
        for(int i = start; i < nums.length - k; i++){
            if(i > start && nums[i] == nums[i - 1]){
                continue;
            }
            if(nums[i] * k > target){
                return;
            }
            list.add(nums[i]);
            sum(res, list, nums, k - 1, target - nums[i], i + 1, end);
            list.remove(list.size() - 1);
        }
    }

	public static void main(String[] args) {
		int[] nums = {-3,-2,-1,0,0,1,2,3};
		fourSum(nums, 0);
	}
}
