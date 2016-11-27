package Amazon;
import java.util.*;
class Result{
    int id;
    int value;
    public Result(int id, int value){
        this.id = id;
        this.value = value;
    }
}
public class HighFive {
	public static Map<Integer, Double> getHighFive(Result[] results){
		Map<Integer, Double> res = new HashMap<Integer, Double>();
		Map<Integer, List<Integer>> values = new HashMap<Integer, List<Integer>>();
		for(Result r : results){
			List<Integer> list;
			if(values.containsKey(r.id)){
				list = values.get(r.id);
				list.add(r.value);
				values.put(r.id, list);
			}else{
				list = new ArrayList<Integer>();
				list.add(r.value);
				values.put(r.id, list);
			}
		}
		for(Integer id : values.keySet()){
			List<Integer> list = values.get(id);
			Collections.sort(list);
			Collections.reverse(list);
			int sum = 0;
			for(int i = 0; i < 5; i++){
				sum += list.get(i);
			}
			res.put(id, (double)(sum / 5));
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
