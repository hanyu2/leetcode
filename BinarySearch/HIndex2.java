package BinarySearch;

public class HIndex2 {
	public static int hIndex(int[] citations) {
		int start = 0;
		int end = citations.length - 1;
		int n = citations.length;
		while (start <= end) {
			int middle = (start + end) / 2;
			if (citations[middle] == n - middle) {
				return n - middle;
			}
			if (citations[middle] > n - middle) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}
		}
		return n - start;
	}

	public static void main(String[] args) {
		// int citations[] = {0};
		int citations[] = { 1, 2, 3, 8, 9 };
		System.out.println(hIndex(citations));
	}
}
