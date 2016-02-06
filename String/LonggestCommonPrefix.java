package String;

public class LonggestCommonPrefix {
	public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        String s = strs[0];
        for(int i = 1; i < strs.length; i++){
            int j = 0;
            while(j < strs[i].length() && j < s.length() && strs[i].charAt(j) == s.charAt(j)){
                j++;
            }
            if(j == 0){
                return "";
            }
            s = s.substring(0, j);
        }
        return s;
    }
	public static void main(String[] args) {
		String [] strings = {"abcd", "abddf","abcfg"};
		System.out.println(longestCommonPrefix(strings));
	}
}
