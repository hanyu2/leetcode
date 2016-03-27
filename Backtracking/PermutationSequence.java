package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
	public static String getPermutation(int n, int k) {
        int[] factorial = new int [n + 1];
        factorial[0] = 1;
        for(int i = 1; i <= n; i++){
            factorial[i] = i * factorial[i - 1];
        }
        
        List<Integer> array = new ArrayList<Integer>(n);
        for(int i = 1; i <= n; i++){
            array.add(i);
        }
        
        k--;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            int index = k / factorial[n - i];
            sb.append(array.get(index));
            array.remove(index);
            k %= factorial[n - i];
        }
        return sb.toString();
    }
	public static void main(String[] args) {
		System.out.println(getPermutation(4, 14));
	}
}
