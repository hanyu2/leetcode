package BFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

	static String[] simpleWords(String[] words) {
        Set<String> wordDict = new HashSet<String>();
        for(String word : words){
            wordDict.add(word);
        }    
        List<String> res = new ArrayList<String>();
        for(String word : words){
            if(!compound(word, wordDict)){
                res.add(word);
            }
        }
        String[] simWords = new String[res.size()];
        for(int i = 0; i < res.size(); i++){
            simWords[i] = res.get(i);
        }
        return simWords;
    }

    static boolean compound(String word, Set<String> wordDict){
        boolean wordInDict = false;
        if(wordDict.contains(word)){
            wordDict.remove(word);
            wordInDict = true;
        }
        boolean[] check = new boolean[word.length()];
        for(int i = 0; i < word.length(); i++){
            String sub = word.substring(0, i + 1);
            checkContain(sub, wordDict, check);
        }
        if(wordInDict){
            wordDict.add(word);
        }
        return check[word.length() - 1];
    }

    static void checkContain(String word, Set<String> wordDict, boolean[] check){
       if(wordDict.contains(word)){
           check[word.length() - 1] = true;
           return;
       }
       for(int i = 0; i < word.length(); i++){
    	   if(check[i]){
               String sub = word.substring(i + 1, word.length());
               if(wordDict.contains(sub)){
                   check[sub.length() - 1] = true;
                   return;
               }
           }
       }
    }
	
	public static void main(String[] args) {
		String[] words = {"chat", "ever", "snapchat", "snap", "salesperson", "per", "person", "sales", "son", "whatsoever", "what", "so"};
		String[] re = simpleWords(words);
		for(String string : re){
			System.out.println(string);
		}
	}

}