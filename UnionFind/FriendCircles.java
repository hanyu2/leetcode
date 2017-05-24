package UnionFind;

public class FriendCircles {
//	public static int findCircleNum(int[][] M) {
//        boolean[] all = new boolean[M.length];
//        int[] count = new int[1];
//        count[0] = M.length;
//        for(int i = 0; i < M.length; i++){
//            for(int j = 0; j < M.length; j++){
//                if(i != j && M[i][j] == 1 && !all[i]){
//                    all[i] = true;
//                    count[0]--;
//                    search(M, j, all, count);
//                }
//            }
//        }
//        return count[0];
//    }
//    public static void search(int[][] M, int start, boolean[] all, int[] count){
//        all[start] = true;
//        for(int j = 0; j < M[0].length; j++){
//            if(start != j && !all[j] && M[start][j] == 1){
//            	count[0]--;
//                search(M, j, all, count);
//            }
//        }
//    }
	public static void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public static int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
	public static void main(String[] args) {
		int[][] M = { { 1, 0, 0, 1 }, { 0, 1, 1, 0 }, { 0, 1, 1, 1}, {1, 0, 1, 1} };
		System.out.println(findCircleNum(M));
	}
}
