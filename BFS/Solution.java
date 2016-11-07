package BFS;

import java.util.Stack;

import Tree.TreeNode;

public class Solution {
	public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            int x = n % 26;
            if(x == 0){
                sb.insert(0, "Z");
                n = n / 26 - 1;
            }else{
                sb.insert(0, (char)('A' + x - 1));
                n = x / 26;
            }
        }
        return sb.toString();
    }
	public static void main(String[] args){
		System.out.println(convertToTitle(27));
	}
}
