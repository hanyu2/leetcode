package FB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
	/** Initialize your data structure here. */
	List<Integer> list;
	Map<Integer, Integer> map;
	Random r = new Random();

	public RandomizedSet() {
		list = new ArrayList<Integer>();
		map = new HashMap<Integer, Integer>();
	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (map.containsKey(val)) {
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
		if (!map.containsKey(val)) {
			return false;
		}
		int index = map.get(val);
		if (index < list.size() - 1) {
			int last = list.get(list.size() - 1);
			list.set(index, last);
			map.put(last, index);
		}
		map.remove(val);
		list.remove(list.size() - 1);
		return true;
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return list.get(r.nextInt(list.size()));
	}
}
