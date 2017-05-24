package DFS;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
	private int n;
	private int m;

	public int numIslands(char[][] grid) {
		int count = 0;
		n = grid.length;
		if (n == 0)
			return 0;
		m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				if (grid[i][j] == '1') {
					DFSMarking(grid, i, j);
					++count;
				}
		}
		return count;
	}

	private void DFSMarking(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1')
			return;
		grid[i][j] = '0';
		DFSMarking(grid, i + 1, j);
		DFSMarking(grid, i - 1, j);
		DFSMarking(grid, i, j + 1);
		DFSMarking(grid, i, j - 1);
	}

	// BFS
	int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int numIslands2(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int islands = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					islands++;
					BFS(grid, i, j);
				}
			}
		}
		return islands;
	}

	private void BFS(char[][] grid, int x, int y) {
		grid[x][y] = '0';
		Queue<Point> q = new LinkedList<Point>();
		q.offer(new Point(x, y));
		while (q.size() > 0) {
			int size = q.size();
			Point p = q.poll();
			for (int i = 0; i < size; i++) {
				for (int[] dir : dirs) {
					int x1 = p.x + dir[0];
					int y1 = p.y + dir[1];
					if (x1 >= 0 && y1 >= 0 && x1 < grid.length && y1 < grid[0].length && grid[x1][y1] == '1') {
						grid[x1][y1] = '0';
						q.offer(new Point(x1, y1));
					}
				}
			}
		}
	}

	static int[][] distance = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static int numIslands3(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		UnionFind uf = new UnionFind(grid);
		int rows = grid.length;
		int cols = grid[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == '1') {
					for (int[] d : distance) {
						int x = i + d[0];
						int y = j + d[1];
						if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {
							int id1 = i * cols + j;
							int id2 = x * cols + y;
							uf.union(id1, id2);
						}
					}
				}
			}
		}
		return uf.count;
	}

	public static void main(String[] args) {
		char[][] grid = { { '0', '1', '0' }, { '1', '1', '0' }, { '0', '0', '1' } };
		numIslands3(grid);
	}
}

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

// Union find
class UnionFind {
	int[] father;
	int m, n;
	int count = 0;

	UnionFind(char[][] grid) {
		m = grid.length;
		n = grid[0].length;
		father = new int[m * n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					int id = i * n + j;
					father[id] = id;
					count++;
				}
			}
		}
	}

	public void union(int node1, int node2) {
		int find1 = find(node1);
		int find2 = find(node2);
		if (find1 != find2) {
			father[find1] = find2;
			count--;
		}
	}

	public int find(int node) {
		while(father[node] != node) {
			node = father[node];
		}
		return father[node];
	}
}
