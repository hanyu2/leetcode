package Array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public static List<List<Integer>> generate(int numRows) {
		 List<List<Integer>> rst = new ArrayList<List<Integer>>();
		 if (numRows == 0) {
	            return rst;
	        }

	        ArrayList<Integer> first = new ArrayList<Integer>();
	        first.add(0, 1);
	        rst.add(first);

	        for (int i = 1; i < numRows; i++) {
	            ArrayList<Integer> tmp = new ArrayList<Integer>(i + 1);
	            for (int j = 0; j < i + 1; j++){
	                tmp.add(-1);
	            }
	            ArrayList<Integer> prev = (ArrayList<Integer>) rst.get(i - 1);
	            tmp.set(0, prev.get(0));
	            tmp.set(i, prev.get(i - 1));
	            for (int j = 1; j < i; j++){
	                tmp.set(j, prev.get(j - 1)+prev.get(j));
	            }
	            rst.add(tmp);
	        }
	        return rst;
	}
	
	public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows < 1) {
            return res;
        }
        for (int i = 1; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            for (int j = 1; j < i; j++) {
                int left = res.get(i - 2).get(j - 1);
                int right = j <= (i - 2) ? res.get(i - 2).get(j) : 0;
                temp.add(left + right);   
            }
            res.add(temp);
        }

        return res; 
    }
	
	public static void main(String[] args) {
		List<List<Integer>> lists = generate(6);
	}
}
