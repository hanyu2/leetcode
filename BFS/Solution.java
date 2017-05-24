package BFS;

public class Solution {
    public static int minCut(String s) {
        if(isPalindrome(s)){
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = -1;
        for(int i = 1 ;i <= s.length() ;i++){
            int min = i;
            for(int j = i - 1; j >= 0; j--){
                String sub = s.substring(j, i);
                if(isPalindrome(sub)){
                    int sum = dp[j] + 1;
                    min = Math.min(sum, min);
                }
            }
            dp[i] = min;
        }
        return dp[s.length()];
    }
    
    public static boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            char l = s.charAt(left);
            char r = s.charAt(right);
            if(l != r){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
	public static void main(String[] args) {
		System.out.println(minCut("leet"));
	}
}