package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	public static String reverseWords(String s) {
        s = s.trim();
        String[] str = s.split("\\s+");
        int start = 0; int end = str.length - 1;
        while(start <= end){
            String temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length; i++){
            sb.append(str[i].trim()).append(" ");
        }
        return sb.toString().trim();
    }
	
	public static void main(String[] args) {
		System.out.print(reverseWords("   a   b "));
	}
}
