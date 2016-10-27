package BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	public static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : nums1){
            if(map.containsKey(i)){
                map.put(i, map.get(i) + 1);
            }else{
                map.put(i, 1);
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i : nums2){
            if(map.containsKey(i)){
                list.add(i);
                int time = map.get(i);
                if(time == 0){
                    map.remove(i);
                }else{
                    map.put(i, time - 1);
                }
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }
	public static void main(String[] args){
		int[] nums = {1};
		int[] nums2 = {1, 1};
		System.out.println(intersection(nums, nums2));
	}
}
