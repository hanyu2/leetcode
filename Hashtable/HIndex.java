package Hashtable;

import java.util.Arrays;

public class HIndex {
	public static int hIndex(int[] citations) {
        Arrays.sort(citations);
		int n = citations.length;
		for (int i = 0; i < n; i++)
			if (citations[i] >= n - i)
				return n - i;
		return 0;
    }
	//https://leetcode.com/discuss/55952/my-o-n-time-solution-use-java
	public static int hIndex2(int[] citations) {
        int length = citations.length;
        if (length == 0) {
            return 0;
        }

        int[] array2 = new int[length + 1];
        for (int i = 0; i < length; i++) {
            if (citations[i] > length) {
                array2[length] += 1;
            } else {
                array2[citations[i]] += 1;
            }
        }
        int t = 0;
        for (int i = length; i >= 0; i--) {
            t = t + array2[i];
            if (t >= i) {
                return i;
            }
        }
        return 0;
    }
	
	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		//int[] citations = {100};
		//int[] citations = {0};
		System.out.println(hIndex2(citations));
	}
}
