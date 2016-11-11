package UnionFind;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {
	public static int longestConsecutive(int[] num) {
		int res = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int n : num) {
			if (!map.containsKey(n)) {
				int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
				int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
				// sum: length of the sequence n is in
				int sum = left + right + 1;
				map.put(n, sum);

				// keep track of the max length
				res = Math.max(res, sum);

				// extend the length to the boundary(s)
				// of the sequence
				// will do nothing if n has no neighbors
				map.put(n - left, sum);
				map.put(n + right, sum);
			}
		}
		return res;
	}

	public int longestConsecutive3(int[] nums) {
		int max = 0;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		for (int i = 0; i < nums.length; i++) {
			int count = 1;
			// look left
			int num = nums[i];
			while (set.contains(--num)) {
				count++;
				set.remove(num);
			}
			// look right
			num = nums[i];
			while (set.contains(++num)) {
				count++;
				set.remove(num);
			}
			max = Math.max(max, count);
		}
		return max;
	}

	// Union Find
	public int longestConsecutive2(int[] nums) {
		UF uf = new UF(nums.length);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // <value,index>
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				continue;
			}
			map.put(nums[i], i);
			if (map.containsKey(nums[i] + 1)) {
				uf.union(i, map.get(nums[i] + 1));
			}
			if (map.containsKey(nums[i] - 1)) {
				uf.union(i, map.get(nums[i] - 1));
			}
		}
		return uf.maxUnion();
	}

	public static void main(String[] args) {
		int num[] = { 100, 4, 200, 1, 3, 2 };
		longestConsecutive(num);
	}
}

class UF {
	private int[] list;

	public UF(int n) {
		list = new int[n];
		for (int i = 0; i < n; i++) {
			list[i] = i;
		}
	}

	private int root(int i) {
		while (i != list[i]) {
			list[i] = list[list[i]];
			i = list[i];
		}
		return i;
	}

	public boolean connected(int i, int j) {
		return root(i) == root(j);
	}

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		list[i] = j;
	}

	// returns the maxium size of union
	public int maxUnion() { // O(n)
		int[] count = new int[list.length];
		int max = 0;
		for (int i = 0; i < list.length; i++) {
			count[root(i)]++;
			max = Math.max(max, count[root(i)]);
		}
		return max;
	}
}
