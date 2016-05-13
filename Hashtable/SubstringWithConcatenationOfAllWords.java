package Hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SubstringWithConcatenationOfAllWords {
	public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if(words.length==0||words[0].length()==0) return res;
        Map<String,Integer> wordDict = new HashMap<String,Integer>();
        for(String word : words) {
            if(!wordDict.containsKey(word)) wordDict.put(word,1);
            else wordDict.put(word,wordDict.get(word) + 1);
        }
        Map<String,Integer> currWords = new HashMap<String,Integer>();
        int len = words[0].length();
        for(int i = 0; i < len; i++) {
            int k = i, j = i; //k is at the head of the window and j is the last.
            int addedCount = 0; //to indicate whether we add index to res.
            while(k<= s.length()-len*words.length&&j + len <= s.length()) { //make sure the remaining length is enough.
                String subWord = s.substring(j,j+len);
                if(!wordDict.containsKey(subWord)) { //the substring is not in words, head jumps to the right of this substring.
                    addedCount = 0;
                    currWords.clear();
                    j += len;
                    k = j;
                    continue;
                }
                if(!currWords.containsKey(subWord)||currWords.get(subWord)!=wordDict.get(subWord)) {
                    if(!currWords.containsKey(subWord)) currWords.put(subWord,1);
                    else currWords.put(subWord,currWords.get(subWord) + 1); //update the current words we used.
                    addedCount++;
                    if(addedCount == words.length) { //if get a index, add it to res. And we need to continue checking
                        res.add(k);
                        addedCount--; //remove the head and check new substring, so count-- and move head to new position.
                        String preHead = s.substring(k,k+len);
                        if(currWords.get(preHead)==1) currWords.remove(preHead); //update the currWords map.
                        else currWords.put(preHead,currWords.get(preHead)-1);
                        k += len;
                    }
                    j += len;
                }
                else { //the current substring was used out before. Move head len steps right.
                    String preHead = s.substring(k,k+len);
                    addedCount--;
                    if(currWords.get(preHead)==1) currWords.remove(preHead); //update the currWords map.
                    else currWords.put(preHead,currWords.get(preHead)-1);
                    k += len; //don't move j this case.
                }
            }
            currWords.clear();
        }
        return res;
    }
	

	public static void main(String[] args) {
		/*
		 * String s = "barfoothefoobarman"; String words[] = {"foo", "bar"};
		 */

		String s = "wordgoodgoodgoodbestword";
		String words[] = { "word", "good", "best", "good" };
		findSubstring(s, words);
	}
}
