package BFS;

import Tree.TreeNode;

public class Solution {
	public static String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] res = new int[m + n];
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                int mul = n1 * n2 + res[i + j + 1];
                res[i + j + 1] = mul % 10;
                res[i + j] += mul / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean zero = false;
        for(int i = 0; i < res.length; i++){
            if(res[i] != 0){
                zero = true;
                sb.append(res[i]);
            }else{
                if(zero){
                    sb.append(i);
                }
            }
        }
        return sb.length() == 0 ?  "0" : sb.toString();
    }
	public static void main(String[] args) {
		System.out.println(multiply("123", "456"));
	}
}