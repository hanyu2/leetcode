package Hashtable;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
	public int singleNumber(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();
		int result = 0;
		for(Integer i : nums){
			if(set.contains(i)){
				result -= i;
				set.remove(i);
			}else{
				result += i;
				set.add(i);
			}
		}
		return result;
	}
	public int singleNumber2(int[] nums){
		int result = 0;
		for(Integer i : nums){
			result ^= i;
		}
		return result;
	}
}
