package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
    
    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length == 0 || nums == null){
            return res;
        }
        List<Integer> list = new ArrayList<Integer>();
        list.add(nums[0]);
        res.add(list);
        for(int i = 1; i < nums.length; i++){
            List<List<Integer>> newList = new ArrayList<List<Integer>>();
            for(int j = 0; j <= i; j++){
                for(List l : res){
                    List<Integer> temp = new ArrayList<Integer>(l);
                    temp.add(j, nums[i]);
                    newList.add(temp);
                }
            }
            res = newList;
        }
        return res;
    }
    
    //Same idea with the last one
    public static List<List<Integer>> permute3(int[] num) {
        LinkedList<List<Integer>> res = new LinkedList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (int n : num) {
            int size = res.size();
            for (; size > 0; size--) {
                List<Integer> r = res.pollFirst();
                for (int i = 0; i <= r.size(); i++) {
                    List<Integer> t = new ArrayList<Integer>(r);
                    t.add(i, n);
                    res.add(t);
                }
            }
        }
        return res;
    }

    
    public static void main(String[] args) {
    	int [] nums = {1,2,3};
		permute3(nums);
	}
}
