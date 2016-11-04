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
	
	public int[][] multiply3(int[][] A, int[][] B) {
        if (A == null || A[0] == null || B == null || B[0] == null) return null;
        int m = A.length, n = A[0].length, l = B[0].length;
        int[][] C = new int[m][l];
        Map<Integer, HashMap<Integer, Integer>> tableB = new HashMap<>();
        
        for(int k = 0; k < n; k++) {
            tableB.put(k, new HashMap<Integer, Integer>());
            for(int j = 0; j < l; j++) {
                if (B[k][j] != 0){
                    tableB.get(k).put(j, B[k][j]);
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int k = 0; k < n; k++) {
                if (A[i][k] != 0){
                    for (Integer j: tableB.get(k).keySet()) {
                        C[i][j] += A[i][k] * tableB.get(k).get(j);
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
	
	//use map to store nonzeroes
    public int[][] multiply2(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];
        Map<Integer, Map<Integer, Integer>> arows = map(A);
        Map<Integer, Map<Integer, Integer>> brows = map(B);
        for(int i: arows.keySet()) {
            Map<Integer, Integer> acol = arows.get(i);
            for(int j: acol.keySet()) {
                Map<Integer, Integer> bcol = brows.get(j);
                if (bcol == null) continue;
                int a = acol.get(j);
                for(int l: bcol.keySet()) {
                    C[i][l] += a * bcol.get(l);
                }
            }
        }
        return C;
    }
    
    private Map<Integer, Map<Integer, Integer>> map(int[][] m) {
        Map<Integer, Map<Integer, Integer>> rows = new HashMap<>();
        for(int i=0; i<m.length; i++) {
            for(int j=0; j<m[i].length; j++) {
                if (m[i][j]==0) continue;
                Map<Integer, Integer> cols = rows.get(i);
                if (cols == null) {
                    cols = new HashMap<>();
                    rows.put(i, cols);
                }
                cols.put(j, m[i][j]);
            }
        }
        return rows;
    }

}
