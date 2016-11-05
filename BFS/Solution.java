package BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution {
	public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >= 0 && j >= 0){
            int sum = carry;
            if(i >= 0){
                sum += a.charAt(i) - '0';
                i--;
            }
            if(j >= 0){
                sum += b.charAt(j) - '0';
                j--;
            }
            sb.insert(0, sum % 2);
            carry = sum / 2;
        }
        if(carry == 1){
            sb.insert(0, 1);
        }
        return sb.toString();
    }
	public static void main(String[] args){
		int[][] graph = {{0,1},{0,2},{2,3},{2,4}};
		System.out.println(addBinary("11", "1"));
	}
}
