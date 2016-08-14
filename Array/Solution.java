package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static void permute(List<Integer> nums, List<String> res,String s, int n) {
       if(s.length() == n){
    	   res.add(s);
    	   return;
       }
       for(int i = 0; i < nums.size(); i++){
    	   int temp = nums.get(i);
    	   nums.remove(i);
    	   permute(nums, res, s + String.valueOf(temp), n);
    	   nums.add(i, temp);
       }
    }

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		List<String> res = new ArrayList<String>();
		permute(nums, res, "", 5);
		System.out.println(res);
	}
}
