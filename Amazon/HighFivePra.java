package Amazon;

import java.util.*;

public class HighFivePra {
	public static Map<Integer, Double> getHighFive(Result[] results){
		Map<Integer, Double> res = new HashMap<Integer, Double>();
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(Result r : results){
			List<Integer> list = null;
			if(map.containsKey(r.id)){
				list = map.get(r.id);
				list.add(r.value);
				map.put(r.id, list);
			}else{
				list = new ArrayList<Integer>();
				list.add(r.value);
				map.put(r.id, list);
			}
		}
		for(Integer id : map.keySet()){
			List<Integer> list = map.get(id);
			Collections.sort(list);
			Collections.reverse(list);
			double sum = 0.0;
			for(int i = 0; i < 5; i++){
				sum += list.get(i);
			}
			sum /= 5;
			res.put(id, sum);
		}
		return res;
	}
	
	public static void main(String[] args) {
        Result r1 = new Result(1, 95);
        Result r2 = new Result(1, 95);
        Result r3 = new Result(1, 91);
        Result r4 = new Result(1, 91);
        Result r5 = new Result(1, 93);
        Result r6 = new Result(1, 105);

        Result r7 = new Result(2, 6);
        Result r8 = new Result(2, 6);
        Result r9 = new Result(2, 7);
        Result r10 = new Result(2, 6);
        Result r11 = new Result(2, 6);
        Result[] arr = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
        Map<Integer, Double> res = getHighFive(arr);

        System.out.println(res.get(1) + " " +res.get(2));
    }
}
