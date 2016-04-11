package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
	//http://www.cnblogs.com/yuzhangcmu/p/4121804.html
	public static List<Integer> grayCode(int n) {
		List<Integer> ret = new ArrayList<Integer>();
		if (n == 0) {
			ret.add(0);
			return ret;
		}

		ret = grayCode(n - 1);

		for (int i = ret.size() - 1; i >= 0; i--) {
			int num = ret.get(i);
			num += 1 << (n - 1);
			ret.add(num);
		}

		return ret;
	}
	public static void main(String[] args) {
		grayCode(3);
	}
}
