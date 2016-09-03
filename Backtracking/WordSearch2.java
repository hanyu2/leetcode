package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JViewport;
import javax.swing.JWindow;

import sun.net.www.content.text.plain;

public class WordSearch2 {
	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		TrieNode root = buildTrie(words);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, i, j, root, res);
			}
		}
		return res;
	}

	public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
		char c = board[i][j];
		if (c == '#' || p.next[c - 'a'] == null)
			return;
		p = p.next[c - 'a'];
		if (p.word != null) { // found one
			res.add(p.word);
			p.word = null; // de-duplicate
		}

		board[i][j] = '#';
		if (i > 0)
			dfs(board, i - 1, j, p, res);
		if (j > 0)
			dfs(board, i, j - 1, p, res);
		if (i < board.length - 1)
			dfs(board, i + 1, j, p, res);
		if (j < board[0].length - 1)
			dfs(board, i, j + 1, p, res);
		board[i][j] = c;
	}

	public TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for (String w : words) {
			TrieNode p = root;
			for (char c : w.toCharArray()) {
				int i = c - 'a';
				if (p.next[i] == null)
					p.next[i] = new TrieNode();
				p = p.next[i];
			}
			p.word = w;
		}
		return root;
	}

	class TrieNode {
		TrieNode[] next = new TrieNode[26];
		String word;
	}
	
	public static List<String> findWords2(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        if(board.length == 0){
            return res;
        }
        Map<Character, ArrayList<String>> map = new HashMap<Character, ArrayList<String>>();
        for(String s : words){
            if(s.length() == 0){
                continue;
            }
            if(map.containsKey(s.charAt(0))){
                map.get(s.charAt(0)).add(s);
            }else{
                map.put(s.charAt(0), new ArrayList<String>(Arrays.asList(s)));
            }
        }
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(map.containsKey(board[i][j])){
                    for(String s : map.get(board[i][j])){
                        if(search(i, j, board, s, 0)){
                            res.add(s);
                        }
                    }
                }
            }
        }
        return res;
    }
    
    public static boolean search(int i, int j, char[][] board, String s, int index){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length){
            return false;
        }
        if(index >= s.length()){
            return false;
        }
        if((index == s.length() - 1) && (s.charAt(index) == board[i][j])){
            return true;
        }
        char temp = board[i][j];
        
        if(board[i][j] == s.charAt(index)){
        	board[i][j] = '*';
            boolean left =  search(i, j - 1, board, s, index + 1);
            boolean right =  search(i, j + 1, board, s, index + 1);
            boolean up =  search(i - 1, j, board, s, index + 1);
            boolean down =  search(i + 1, j, board, s, index + 1);
            board[i][j] = temp;
            return left || right || up || down;
        }else{
            return false;
        }
    }
    public static void main(String[] args){
    char[][] board = {
    		  {'o','a','a','n'},
    		  {'e','t','a','e'},
    		  {'i','h','k','r'},
    		  {'i','f','l','v'}
    		};
    String[] words = {"oath","pea","eat","rain"};
    	
    	/*char[][] board = {{'a', 'a'}};
      String[] words = {"aaa"};*/
    System.out.println(findWords2(board, words));
    }
}
