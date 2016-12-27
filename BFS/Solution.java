package BFS;

public class Solution {
	public static String longestPalindrome(String s) {
        if(s.length() <= 1){
            return s;
        }
        int start = -1;
        int longest = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = find(i, i, s);
            int len2 = find(i, i + 1, s);
            int len = Math.max(len1, len2);
            if(len > longest){
            		start = i - (len - 1) / 2;
                longest = len;
            }
        }
        return s.substring(start, start + longest);
    }
    
    public static int find(int start, int end, String s){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--;
            end++;
        }
        return end - start - 1;
    }
    
    public static void main(String[] args) {
		System.out.println(longestPalindrome("bb"));
	}
}