package Array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {
	public static List<Integer> getRow(int rowIndex){
		List<Integer> list = new ArrayList<Integer>();
		int index = rowIndex + 1;
		if(rowIndex == 0){
			return list;
		}
		list.add(1);
		for(int i = 1; i < index - 1; i++){
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
	
	public static void main(String[] args) {
		List<Integer> list = getRow(5);
		for(int i : list){
			System.out.print(i + " ");
		}
	}
}
