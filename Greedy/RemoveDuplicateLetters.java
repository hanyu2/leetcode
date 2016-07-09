package Greedy;

import java.util.Stack;

public class RemoveDuplicateLetters {
	public static String removeDuplicateLetters(String s) {

		int[] res = new int[26]; // will contain number of occurences of
									// character (i+'a')
		boolean[] visited = new boolean[26]; // will contain if character
												// (i+'a') is present in current
												// result Stack
		char[] ch = s.toCharArray();
		for (char c : ch) { // count number of occurences of character
			res[c - 'a']++;
		}
		Stack<Character> stack = new Stack<>(); // answer stack
		int index;
		for (char c : ch) {
			index = c - 'a';
			res[index]--; // decrement number of characters remaining in the
							// string to be analysed
			if (visited[index]) // if character is already present in stack,
								// dont bother
				continue;
			// if current character is smaller than last character in stack
			// which occurs later in the string again
			// it can be removed and added later e.g stack = bc remaining string
			// abc then a can pop b and then c
			while (!stack.isEmpty() && c < stack.peek() && res[stack.peek() - 'a'] != 0) {
				visited[stack.pop() - 'a'] = false;
			}
			stack.push(c); // add current character and mark it as visited
			visited[index] = true;
		}

		StringBuilder sb = new StringBuilder();
		// pop character from stack and build answer string from back
		while (!stack.isEmpty()) {
			sb.insert(0, stack.pop());
		}
		return sb.toString();
	}
	
	//greedy
	public static String removeDuplicateLetters2(String s) {
        int[] cnt = new int[26];
        int pos = 0; // the position for the smallest s[i]
        for (int i = 0; i < s.length(); i++) cnt[s.charAt(i) - 'a']++;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < s.charAt(pos)) pos = i;
            if (--cnt[s.charAt(i) - 'a'] == 0) break;
        }
        return s.length() == 0 ? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
    }
	
	public static void main(String[] args) {
		System.out.println(removeDuplicateLetters2("bbcaac"));
	}
}
