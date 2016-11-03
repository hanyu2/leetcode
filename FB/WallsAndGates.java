package FB;

import java.util.LinkedList;
import java.util.Queue;

import com.sun.swing.internal.plaf.metal.resources.metal;

public class WallsAndGates {
	public static void wallsAndGates(int[][] rooms) {
	    for (int i = 0; i < rooms.length; i++)
	        for (int j = 0; j < rooms[0].length; j++)
	            if (rooms[i][j] == 0) dfs(rooms, i, j, 0);
	}

	private static void dfs(int[][] rooms, int i, int j, int d) {
	    if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] < d) return;
	    rooms[i][j] = d;
	    dfs(rooms, i - 1, j, d + 1);
	    dfs(rooms, i + 1, j, d + 1);
	    dfs(rooms, i, j - 1, d + 1);
	    dfs(rooms, i, j + 1, d + 1);
	}
	
	//BFS
	public static void wallsAndGates2(int[][] rooms) {
		int t = 0;
        if (rooms.length == 0 || rooms[0].length == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0)
                	queue.add(new int[]{i, j});
            }
        }
        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int row = top[0], col = top[1];
            if (row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE) {
                rooms[row - 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row - 1, col});
            }
            if (row < rooms.length - 1 && rooms[row + 1][col] == Integer.MAX_VALUE) {
                rooms[row + 1][col] = rooms[row][col] + 1;
                queue.add(new int[]{row + 1, col});
            }
            if (col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE) {
                rooms[row][col - 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col - 1});
            }
            if (col < rooms[0].length - 1 && rooms[row][col + 1] == Integer.MAX_VALUE) {
                rooms[row][col + 1] = rooms[row][col] + 1;
                queue.add(new int[]{row, col + 1});
            }
        }
    }
	public static void main(String[] args) {
		int[][] rooms = { { 2147483647, -1, 0, 2147483647 }, { 2147483647, 2147483647, 2147483647, -1 },
				{ 2147483647, -1, 2147483647, -1 }, { 0, -1, 2147483647, 2147483647 } };
		wallsAndGates2(rooms);
		for(int i = 0; i < rooms.length; i++){
			for(int j = 0; j < rooms[0].length; j++){
				System.out.print(rooms[i][j] + " ");
			}
			System.out.println();
		}
	}
}
