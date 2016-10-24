package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int i = 0; i < nums.length - k; i++){
            for(int j = 1; j <= k; j++){
                if(nums[i] == nums[i + j]){
                    return true;
                }
            }
        }
        return false;
    }

	public static void main(String[] args) {
		int[] nums = {99, 99};
		System.out.println(containsNearbyDuplicate(nums, 2));
	}
}
