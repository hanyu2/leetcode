package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return lists;
        }
        return permuteList(nums);
    }
    
    public static List<List<Integer>> permuteList(int [] nums){
        if(nums.length == 1){
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            result.add(Arrays.asList(nums[0]));
            return result;
        }
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        int c = nums[0];
        int [] newNum = new int [nums.length - 1];
        for(int i = 1; i < nums.length; i++){
            newNum[i - 1] = nums[i];
        }
        List<List<Integer>> result = permuteList(newNum);
        for(List<Integer> list : result){
            for(int i = 0; i <= list.size(); i++){
                List<Integer> newList = insert(list, c, i);
                lists.add(newList);
            }
        }
        return lists;
    }
    public static List<Integer> insert(List<Integer> list, int c, int j){
    	List<Integer> newList = new ArrayList<Integer>();
        for(int i = 0; i < j; i++){
        	newList.add(list.get(i));
        }
        newList.add(c);
        for(int i = j; i < list.size(); i++){
        	newList.add(list.get(i));
        }
        return newList;
    }
    
    public static void main(String[] args) {
    	int [] nums = {1,2,3};
		permute(nums);
	}
}
