package Array;

public class UniquePaths {
	public static int uniquePaths(int m, int n) {
		return factorial(m + n)/factorial(m)/factorial(n);
	}
	public static int factorial(int n){
		int count = 1;
		while(n > 0){
			count *= n;
			n--;
		}
		return count;
	}
	public static void main(String[] args) {
		System.out.println(factorial(6));
	}
}
