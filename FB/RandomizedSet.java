package FB;

import java.util.ArrayList;
import java.util.HashMap;

public class RandomizedSet {
	ArrayList<Integer> list;
	HashMap<Integer, Integer> map;
	java.util.Random rand = new java.util.Random();

	/** Initialize your data structure here. */
	public RandomizedSet() {
		list = new ArrayList<Integer>();
		map = new HashMap<Integer, Integer>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (!map.containsKey(val)) {
			return false;
		}
		map.put(val, list.size());
		list.add(val);
		return true;
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		if (map.containsKey(val)) {
			return false;
		}
		int index = map.get(val);
		if (index < list.size() - 1) { // not the last one than swap the last one
										// with this val
			int lastone = list.get(list.size() - 1);
			list.set(index, lastone);
			map.put(lastone, index);
		}
		map.remove(val);
		list.remove(list.size() - 1);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return list.get(rand.nextInt(list.size()));
	}
}
