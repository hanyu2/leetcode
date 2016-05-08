package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class FourSum {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length - 3; i++){
        	if(i > 0 && nums[i] == nums[i - 1] ){//put i > 0 first
        		continue;
        	}
            for(int j = i + 1; j < nums.length - 2; j++){
            	if(j > i + 1 && nums[j] == nums[j - 1]){
            		continue;
            	}
                int left = j + 1; 
                int right = nums.length - 1;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        List<Integer> list = new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        Collections.sort(list);
                        res.add(list);
                    }
                    if(sum < target){// in case  {0,0,0,0}
                         while(left<right && nums[left] == nums[left+1]){
                            left++;
                        }
                        left++;
                    }else{
                         while(left<right && nums[right] == nums[right-1]){
                            right--;
                        }
                        right--;
                    }
                }
            }
        }
        return  res;
    }
	
	
	public static List<List<Integer>> fourSum2(int[] nums, int target) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (nums == null || len < 4)
            return res;

        Arrays.sort(nums);

        int max = nums[len - 1];
        if (4 * nums[0] > target || 4 * max < target)
            return res;

        int i, z;
        for (i = 0; i < len; i++) {
            z = nums[i];
            if (i > 0 && z == nums[i - 1])// avoid duplicate
                continue;
            if (z + 3 * max < target) // z is too small
                continue;
            if (4 * z > target) // z is too large
                break;
            if (4 * z == target) { // z is the boundary
                if (i + 3 < len && nums[i + 3] == z)
                    res.add(Arrays.asList(z, z, z, z));
                break;
            }

            threeSumForFourSum(nums, target - z, i + 1, len - 1, res, z);
        }

        return res;
    }

    /*
     * Find all possible distinguished three numbers adding up to the target
     * in sorted array nums[] between indices low and high. If there are,
     * add all of them into the ArrayList fourSumList, using
     * fourSumList.add(Arrays.asList(z1, the three numbers))
     */
    public static void threeSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
            int z1) {
        if (low + 1 >= high)
            return;

        int max = nums[high];
        if (3 * nums[low] > target || 3 * max < target)
            return;

        int i, z;
        for (i = low; i < high - 1; i++) {
            z = nums[i];
            if (i > low && z == nums[i - 1]) // avoid duplicate
                continue;
            if (z + 2 * max < target) // z is too small
                continue;

            if (3 * z > target) // z is too large
                break;

            if (3 * z == target) { // z is the boundary
                if (i + 1 < high && nums[i + 2] == z)
                    fourSumList.add(Arrays.asList(z1, z, z, z));
                break;
            }

            twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
        }

    }

    /*
     * Find all possible distinguished two numbers adding up to the target
     * in sorted array nums[] between indices low and high. If there are,
     * add all of them into the ArrayList fourSumList, using
     * fourSumList.add(Arrays.asList(z1, z2, the two numbers))
     */
    public static void twoSumForFourSum(int[] nums, int target, int low, int high, ArrayList<List<Integer>> fourSumList,
            int z1, int z2) {

        if (low >= high)
            return;

        if (2 * nums[low] > target || 2 * nums[high] < target)
            return;

        int i = low, j = high, sum, x;
        while (i < j) {
            sum = nums[i] + nums[j];
            if (sum == target) {
                fourSumList.add(Arrays.asList(z1, z2, nums[i], nums[j]));

                x = nums[i];
                while (++i < j && x == nums[i]) // avoid duplicate
                    ;
                x = nums[j];
                while (i < --j && x == nums[j]) // avoid duplicate
                    ;
            }
            if (sum < target)
                i++;
            if (sum > target)
                j--;
        }
        return;
    }
    
    /*To avoid duplicate list items, I skip unnecessary indices at two locations:

    	one at the end of the outer loop (i-loop)
    	the other at the end of the inner loop (j-loop).
    	To avoid useless computations, the following is kind of critical:

    	the function return immediately when nums[i]*4 > target
    	the inner loop break immediately when nums[j]*4 < target.*/
    public List<List<Integer>> fourSum3(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
       Arrays.sort(nums);
       for(int i=0, L=nums.length; i<L-3; i++) {
           if(nums[i] * 4 > target) return list; // return immediately or nums[i] << 2
           for(int j=L-1; j>i+2; j--) {
               if(nums[j] * 4 < target) break; // break immediately
               int rem = target-nums[i]-nums[j];
               int lo = i+1, hi=j-1;
               while(lo<hi) {
                   int sum = nums[lo] + nums[hi];
                   if(sum>rem) --hi;
                   else if(sum<rem) ++lo;
                   else {
                       list.add(Arrays.asList(nums[i],nums[lo],nums[hi],nums[j]));
                       while(++lo<=hi && nums[lo-1]==nums[lo]) continue; // avoid duplicate results
                       while(--hi>=lo && nums[hi]==nums[hi+1]) continue; // avoid duplicate results
                   }
               }
               while(j>=1 && nums[j]==nums[j-1]) --j; // skip inner loop
           }
           while(i<L-1 && nums[i]==nums[i+1]) ++i; // skip outer loop
       }
       return list;
   }
    //Generates to N sum
    //https://leetcode.com/discuss/77704/java-backtracking-solution-for-k-sum-beat-94%25
    public static List<List<Integer>> fourSum4(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        kSum(result, new ArrayList<Integer>(), nums, target, 4, 0, nums.length-1);
        return result;
    }

    private static void kSum(List<List<Integer>> result,List<Integer> cur,int[] nums, int target,int k,int start, int end){
        if(k == 0 || nums.length==0 || start>end) return;
        if(k == 1){
            for (int i = start; i <= end ; i++) {
                if(nums[i] == target){
                    cur.add(nums[i]);
                    result.add(new ArrayList<Integer>(cur));
                    cur.remove(cur.size()-1);
                }
            }
            return;
        }

        if(k == 2){ // 2 sum
            int sum;
            while (start < end){
                sum = nums[start]+nums[end];

                if(sum == target){
                    cur.add(nums[start]);
                    cur.add(nums[end]);
                    result.add(new ArrayList<Integer>(cur));
                    cur.remove(cur.size()-1);
                    cur.remove(cur.size()-1);

                    //avoid duplicate
                    while(start < end && nums[start] == nums[start+1]) ++start;
                    ++start;
                    while(start < end && nums[end] == nums[end-1]) --end;
                    --end;
                }else if(sum < target){
                    //avoid duplicate
                    while(start < end && nums[start] == nums[start+1]) ++start;
                    ++start;
                }else{
                    while(start < end && nums[end] == nums[end-1]) --end;
                    --end;
                }
            }
            return;
        }

        //避免一些不必要case
        if(k*nums[start] > target || k*nums[end]<target) return;

        // k > 2 : choose nums[i] and do k-1 sum on the rest at right
        for (int i = start; i <= (end-k+1) ; i++) {
            // avoid duplicate
            if(i>start && nums[i]==nums[i-1]) continue;
            // 重点
            if(k*nums[i] <= target) { //避免掉一些不必要case
                cur.add(nums[i]);
                kSum(result, cur, nums, target - nums[i], k - 1, i + 1, end);
                cur.remove(cur.size() - 1);
            }
        }

    }
  //https://leetcode.com/discuss/9141/any-better-solution-than-o-n-3
    //static class: http://stackoverflow.com/questions/9560600/java-no-enclosing-instance-of-type-foo-is-accessible
    static class Pair {
        int a;
        int ai;
        int b;
        int bi;

        public Pair(int a, int ai, int b, int bi){
            this.a = a;
            this.ai = ai;
            this.b = b;
            this.bi = bi;
        }

        boolean same(Pair p){
            return p != null && p.a == a && p.b == b;
        }
    }

    public static List<List<Integer>> fourSum5(int[] num, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(num.length < 4){
            return res;
        }
        Arrays.sort(num);
        TreeMap<Integer, List<Pair>> map = new TreeMap<>();
        for(int i = 0; i < num.length; i++){
            for(int j = i + 1; j < num.length; j++){
                Pair pair = new Pair(num[i], i, num[j], j);
                int sum = num[i] + num[j];
                List<Pair> list;
                if(map.containsKey(sum)){
                    list = map.get(sum);
                }
                else{
                    list = new ArrayList<>();
                    map.put(sum, list);
                }
                list.add(pair);
            }
        }
        Integer first = map.firstKey();
        Integer last = map.lastKey();
        while(first != null && last != null && first <= last){
            if(first + last > target){
                last = map.lowerKey(last);
            }
            else if(first + last < target){
                first = map.higherKey(first);
            }
            else if(first == last){
                List<Pair> list = map.get(first);
                for(int i = 0; i < list.size(); i++){
                    Pair a = list.get(i);
                    if(a.a == a.b){
                        for(int j = i + 1; j < list.size(); j++){
                            Pair b = list.get(j);
                            if(b.a == b.b){
                                if(a.bi < b.ai){
                                    res.add(Arrays.asList(new Integer[]{a.a, a.b, b.a, b.b}));
                                    break;
                                }
                            }
                            else{
                                break;
                            }
                        }
                        break;
                    }
                }
                last = map.lowerKey(last);
                first = map.higherKey(first);
            }
            else{
                Pair lastA = null;
                for(Pair a : map.get(first)){
                    if(a.same(lastA)){
                        continue;
                    }
                    lastA = a;
                    Pair lastB = null;
                    for(Pair b: map.get(last)){
                        if(a.bi < b.ai){
                            if(b.same(lastB)){
                                continue;
                            }
                            lastB = b;
                            res.add(Arrays.asList(new Integer[]{a.a, a.b, b.a, b.b}));
                        }
                    }
                }
                last = map.lowerKey(last);
                first = map.higherKey(first);
            }
        }
        return res;
    }
    
	public static void main(String[] args) {
		//int[] nums = {0, 0, 0, 0};
		int[] nums = {-3,-2,-1,0,0,1,2,3};
		List<List<Integer>> res = fourSum5(nums, 0);
		int i = 1;
	}
}
