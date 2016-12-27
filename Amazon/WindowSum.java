package Amazon;
import java.util.*;

public class WindowSum {
	public List<Integer> getSum(List<Integer> nums, int k) {
		List<Integer> res = new ArrayList<Integer>();
		if(nums == null || nums.size() == 0){
			return res;
		}
        int len = nums.size();
        for (int i = 0; i + k - 1 < len; ++i) {
            int sum = 0;
            for (int j = 0; j < k; ++j) {
                sum += nums.get(i+j);
            }
            res.add(i,sum);
        }
        return res;
	}
}
