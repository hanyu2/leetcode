package FB;

import java.util.HashMap;
import java.util.Map;


/*这道题我当时并没有准备到，但是正因为如此，我认为我跟面试官的交流给我加分了不少。
 * 面试官首先问我每个vector很大，并不能在内存中存下，该怎么办，
 * 我说只需要存下非零的元素和他们的下标就行，
 * 然后询问面试官是否可以用预处理后的这两个vector非零元素的index和value作为输入，
 * 面试官同意后快速写完O(M*N)的代码，M和N分别是两个vector的长度。
 * 面试官说这两个输入如果是根据下标排序好的话应该怎么办，
 * 我说可以遍历长度较短的那一个，然后用二分搜索的方法在另一个vector中找index相同的元素，
 * 相乘加入到结果中，这样的话复杂度就是O(M*logN)。
 * 这时，面试官又问是否可以同时利用两个输入都是排序好这一个特性，我在这个地方有点卡住，但是在白板上写出一个test case，
 * 试着用可视化的方法帮助我来进行思考，同时面试官给了一些提醒，最后写出了O(M + N)的双指针方法
	然后问如果有一个向量比另一个长很多怎么办，遍历短的，对长的二分查找。
	两个vector相乘*/
public class SparseMatrixMultiplication {
	
	public int[][] multiply2(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int k = B[0].length;
        int[][] T = new int[m][k];
        Map<Integer, Map<Integer, Integer>> mapA = mapify(A);
        Map<Integer, Map<Integer, Integer>> mapB = mapify(B);
        for(int i : mapA.keySet()){
            Map<Integer, Integer> arow = mapA.get(i);
            for(int j : arow.keySet()){
                Map<Integer, Integer> bcol = mapB.get(j);
                if(bcol != null){
                    for(int t : mapB.get(j).keySet()){
                        T[i][t] += arow.get(j) * mapB.get(j).get(t);
                    }
                }
            }
        }
        return T;
    }
	
	public Map<Integer, Map<Integer, Integer>> mapify(int[][] matrix){
        Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] != 0){
                    if(!map.containsKey(i)){
                        map.put(i, new HashMap<Integer, Integer>());
                    }
                    Map<Integer, Integer> row = map.get(i);
                    row.put(j, matrix[i][j]);
                }
            }
        }
        return map;
    }
	
	public int[][] multiply3(int[][] A, int[][] B) {
		int[][] C = new int[A.length][B[0].length];
        Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
        for(int j = 0; j < B.length; j++){
            map.put(j, new HashMap<Integer, Integer>());
            for(int k = 0; k < B[0].length; k++){
                if(B[j][k] != 0){
                    map.get(j).put(k, B[j][k]);
                }
            }
        }
        
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                if(A[i][j] != 0){
                    for(int k : map.get(j).keySet()){
                        C[i][k] += A[i][j] * map.get(j).get(k);
                    }
                }
            }
        }
        return C;   
    }
	
	// regular way
	public int[][] multiply(int[][] A, int[][] B) {
		int[][] C = new int[A.length][B[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				if (A[i][j] == 0)
					continue;
				for (int k = 0; k < B[0].length; k++) {
					if (B[j][k] == 0)
						continue;
					C[i][k] += A[i][j] * B[j][k];
				}
			}
		}
		return C;
	}
	

}
