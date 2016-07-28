package SegmentTree;

public class NumArray {
	class SegmentTreeNode {
		int start, end;
		SegmentTreeNode left, right;
		int sum;

		public SegmentTreeNode(int start, int end) {
			this.start = start;
			this.end = end;
			this.left = null;
			this.right = null;
			this.sum = 0;
		}
	}

	SegmentTreeNode root = null;

	public NumArray(int[] nums) {
		root = buildTree(nums, 0, nums.length - 1);
	}

	private SegmentTreeNode buildTree(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		} else {
			SegmentTreeNode node = new SegmentTreeNode(start, end);
			if (start == end) {
				node.sum = nums[start];
			} else {
				int mid = start + (end - start) / 2;
				node.left = buildTree(nums, start, mid);
				node.right = buildTree(nums, mid + 1, end);
				node.sum = node.left.sum + node.right.sum;
			}
			return node;
		}
	}

	void update(int i, int val) {
		update(root, i, val);
	}

	void update(SegmentTreeNode root, int pos, int val) {
		if (root.start == root.end) {
			root.sum = val;
		} else {
			int mid = root.start + (root.end - root.start) / 2;
			if (pos <= mid) {
				update(root.left, pos, val);
			} else {
				update(root.right, pos, val);
			}
			root.sum = root.left.sum + root.right.sum;
		}
	}

	public int sumRange(int i, int j) {
		return sumRange(root, i, j);
	}

	public int sumRange(SegmentTreeNode root, int start, int end) {
		if (root.end == end && root.start == start) {
			return root.sum;
		} else {
			int mid = root.start + (root.end - root.start) / 2;
			if (mid >= end) {
				return sumRange(root.left, start, end);
			} else if (mid + 1 <= start) {
				return sumRange(root.right, start, end);
			} else {
				return sumRange(root.left, start, mid) + sumRange(root.right, mid + 1, end);
			}
		}
	}
	
	
	//Array implementation
	int[] tree;
	int n;
	/*public NumArray2(int[] nums) {
	    if (nums.length > 0) {
	        n = nums.length;
	        tree = new int[n * 2];
	        buildTree2(nums);
	    }
	}*/
	private void buildTree2(int[] nums) {
	    for (int i = n, j = 0;  i < 2 * n; i++,  j++)
	        tree[i] = nums[j];
	    for (int i = n - 1; i > 0; --i)
	        tree[i] = tree[i * 2] + tree[i * 2 + 1];
	}

	void update2(int pos, int val) {
	    pos += n;
	    tree[pos] = val;
	    while (pos > 0) {
	        int left = pos;
	        int right = pos;
	        if (pos % 2 == 0) {
	            right = pos + 1;
	        } else {
	            left = pos - 1;
	        }
	        // parent is updated after child is updated
	        tree[pos / 2] = tree[left] + tree[right];
	        pos /= 2;
	    }
	}
	public int sumRange2(int l, int r) {
	    // get leaf with value 'l'
	    l += n;
	    // get leaf with value 'r'
	    r += n;
	    int sum = 0;
	    while (l <= r) {
	        if ((l % 2) == 1) {
	           sum += tree[l];
	           l++;
	        }
	        if ((r % 2) == 0) {
	           sum += tree[r];
	           r--;
	        }
	        l /= 2;
	        r /= 2;
	    }
	    return sum;
	}
}
