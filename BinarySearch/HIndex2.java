package BinarySearch;

public class HIndex2 {
	public static int hIndex(int[] citations) {
        int start = 0;
        int end = citations.length - 1;
        int n = citations.length;
        while(start <= end){
            int middle = (start + end) / 2;
            if(citations[middle] >= n - middle){
                end  = middle - 1;
            }else{
            	start = start + 1;
            }
        }
        return n - start;
    }
	public static void main(String[] args) {
		int citations[] = {0};
		System.out.println(hIndex(citations));
	}
}
