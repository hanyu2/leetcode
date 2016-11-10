package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	// BFS
	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		char[] word = beginWord.toCharArray();
		wordList.add(endWord);
		Queue<String> q = new LinkedList<String>();
		addNextWords(word, wordList, q);
		int dist = 2;
		while (!q.isEmpty()) {
			int num = q.size();
			for (int i = 0; i < num; i++) {
				String s = q.poll();
				if (s.equals(endWord)) {
					return dist;
				}
				addNextWords(s.toCharArray(), wordList, q);
			}
			dist++;
		}
		return dist;
	}

	public void addNextWords(char[] word, Set<String> wordList, Queue<String> q) {
		wordList.remove(word);
		for (int i = 0; i < word.length; i++) {
			char c = word[i];
			for (int j = 0; j < 26; j++) {
				word[i] = (char) ('a' + j);
				String temp = String.valueOf(word);
				if (wordList.contains(temp)) {
					q.offer(temp);
					wordList.remove(temp);
				}
			}
			word[i] = c;
		}
	}

	// Two-end BFS
	/*
	 * The idea behind bidirectional search is to run two simultaneous
	 * searches—one forward from the initial state and the other backward from
	 * the goal—hoping that the two searches meet in the middle. The motivation
	 * is that b^(d/2) + b^(d/2) is much less than b^d. b is branch factor, d is
	 * depth.
	 */ 
	public int ladderLength2(String beginWord, String endWord, Set<String> wordList) {
		Set<String> beginSet = new HashSet<String>();
		Set<String> endSet = new HashSet<String>();

		int len = 1;
		int strLen = beginWord.length();
		HashSet<String> visited = new HashSet<String>();

		beginSet.add(beginWord);
		endSet.add(endWord);
		while (!beginSet.isEmpty() && !endSet.isEmpty()) {
			if (beginSet.size() > endSet.size()) {
				Set<String> set = beginSet;
				beginSet = endSet;
				endSet = set;
			}

			Set<String> temp = new HashSet<String>();
			for (String word : beginSet) {
				char[] chs = word.toCharArray();
				for (int i = 0; i < chs.length; i++) {
					char old = chs[i];
					for (char c = 'a'; c <= 'z'; c++) {
						chs[i] = c;
						String target = String.valueOf(chs);
						if (endSet.contains(target)) {
							return len + 1;
						}
						if (!visited.contains(target) && wordList.contains(target)) {
							temp.add(target);
							visited.add(target);
						}
					}
					chs[i] = old;
				}
			}
			beginSet = temp;
			len++;
		}
		return 0;
	}
}
