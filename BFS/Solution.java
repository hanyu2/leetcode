package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Tree.TreeNode;

public class Solution {
	public static int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int i = 0;
        int j = 0;
        while(i < str1.length || j < str2.length){
            int num1 = i < str1.length ? Integer.parseInt(str1[i]) : 0;
            int num2 = j < str2.length ? Integer.parseInt(str2[j]) : 0;
            if(num1 > num2){
                return 1;
            }else if(num1 < num2){
                return -1;
            }else{
                i++;
                j++;
            }
        }
        return 0;
    }

	public static void main(String[] args) {
		compareVersion("1.0", "1.1");
	}
}
