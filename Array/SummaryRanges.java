package Array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	public static List<String> summaryRanges(int[] nums) {
		List<String> list = new ArrayList<String>();
		
		int start = 0;
		for (int i = 0; i < nums.length; i++) {
			if((i + 1) == nums.length){
				String s;
				if(i - start == 0){
					s = nums[i] + "";
				}else{
					s = nums[start] + "->" + nums[i];
				}
				list.add(s);
				break;
			}
			if(!(nums[i] + 1 == nums[i + 1])){
				String s;
				if((i - start) == 0){
					s = nums[start] + "";
					start = i + 1;
				}else{
					s = nums[start] + "->" + nums[i];
					start = i + 1;
				}
				list.add(s);
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		int [] nums = {0,1,2,4,5,7};
		List<String> l = summaryRanges(nums);
		for(String s : l){
			System.out.print(s + " ");
		}
	}
}
