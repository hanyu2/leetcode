package String;

public class LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
		if(s == null || s.length() == 0 || s.trim().length() == 0){
            return 0;
		}
        String [] strings = s.split(" ");
        return strings[strings.length - 1].length();
		
	}

	 public int lengthOfLastWord2(String s) {
	       int length = 0;
	        char[] chars = s.toCharArray();
	        for (int i = s.length() - 1; i >= 0; i--) {
	            if (length == 0) {
	                if (chars[i] == ' ') {
	                    continue;
	                } else {
	                    length++;
	                }
	            } else {
	                if (chars[i] == ' ') {
	                    break;
	                } else {
	                    length++;
	                }
	            }
	        }

	        return length;
	    }
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("  "));
	}
}
