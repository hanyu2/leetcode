package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle2 {
	public static List<Integer> getRow(int rowIndex){
		List<Integer> list = new ArrayList<Integer>();
		int index = rowIndex + 1;
		if(rowIndex == 0){
			return list;
		}
		list.add(1);
		for(int i = 1; i < index; i++){
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for(int j = 0; j < i + 1; j++){
				temp.add(-1);
			}
			temp.set(0, 1);
			temp.set(i, list.get(i - 1));
			for(int j = 1; j < i; j++){
				temp.set(j, list.get(j - 1) + list.get(j));
			}
			list = temp;
		}
		return list;
	}
	//better
	public static List<Integer> getRow2(int rowIndex) {
        Integer[] arr = new Integer[rowIndex + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;

        for (int i = 1; i <= rowIndex; i++) 
            for (int j = i; j > 0; j--) 
                arr[j] = arr[j] + arr[j - 1];

        return Arrays.asList(arr);
    }
	//not efficient
	public List<Integer> getRow3(int rowIndex) {
	    List<Integer> list = new ArrayList<Integer>();
	    if (rowIndex < 0)
	        return list;

	    for (int i = 0; i < rowIndex + 1; i++) {
	        list.add(0, 1);//not effiecient
	        for (int j = 1; j < list.size() - 1; j++) {
	            list.set(j, list.get(j) + list.get(j + 1));
	        }
	    }
	    return list;
	}
	
	public static void main(String[] args) {
		List<Integer> list = getRow2(3);
		for(int i : list){
			System.out.print(i + " ");
		}
	}
}
