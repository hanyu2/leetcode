package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Permutations {
	
	public static List<List<Integer>> permute(int[] nums) {
        return perm(0, nums);
    }
    
    public static List<List<Integer>> perm(int index, int[] nums){
        if(index == nums.length - 1){
            List<List<Integer>> res = new ArrayList<List<Integer>>();
            res.add(Arrays.asList(nums[index]));
            return res;
        }
        List<List<Integer>> res =  perm(index + 1, nums);
        List<List<Integer>> newList = new ArrayList<List<Integer>>();
        for(List l : res){
            for(int i = 0; i <= l.size(); i++){
                List<Integer> temp = insert(l, i, nums[index]);
                newList.add(temp);
            }
        }
        return newList;
    }
    
    public static List<Integer> insert(List<Integer> list, int index, int target){
        List<Integer> tempList = new ArrayList<Integer>();
        for(int i = 0; i < index; i++){
            tempList.add(list.get(i));
        }
        tempList.add(target);
        for(int i = index; i < list.size(); i++){
            tempList.add(list.get(i));
        }
        return tempList;
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
    
    //Swap the elements, reference for permutations2
    public static List<List<Integer>> permute4(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length == 0) {
			return res;
		}
		perm(nums, 0, res);
		return res;
	}

	public static void perm(int[] nums, int start, List<List<Integer>> res) {
		if (start == nums.length) {
			List<Integer> temp = new ArrayList<Integer>();
			for (int i : nums) 
				temp.add(i);
			
			res.add(temp);
		}
		for (int i = start; i < nums.length; i++) {
			swap(nums, i, start);
			perm(nums, start + 1, res);
			swap(nums, i, start);
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
    

    public static void main(String[] args) {
    	int [] nums = {1,2,3};
		permute2(nums);
	}
}
