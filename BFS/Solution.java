package BFS;

public class Solution {
	public static int[] sortArray(int[] arr) {
		int i, max, location, j, temp, len = arr.length;
		for (i = 0; i < len; i++) {
			max = arr[i];
			location = i;
			for (j = i; j < len; j++) {
				if (max < arr[j]) {
					max = arr[j];
					location = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[location];
			arr[location] = temp;
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] arr = {3, 1, 6, 9, 4, 2, 0, 7};
		int[] temp = sortArray(arr);
		for(int i : temp){
			System.out.print(i + " ");
		}
	}
}