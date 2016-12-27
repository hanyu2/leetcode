package Amazon;
import java.util.*;

class NodePra { //这个是题目给好的
    int val;
    ArrayList<NodePra> children;
    public NodePra(int val){
        this.val = val;
        children = new ArrayList<NodePra>();
    }
}

class SumCountPra{
	int sum;
    int count;
    public SumCountPra(int sum, int count){
        this.sum = sum;
        this.count = count;
    }
}
public class CompanyTreePractice {
	public static NodePra getHighest(NodePra root){
		if(root == null){
			return null;
		}
		NodePra[] nodes = new NodePra[1];
		nodes[0] = new NodePra(0);
		double[] min = new double[]{Double.MIN_VALUE};
		dfs(root, nodes, min);
		return nodes[0];
	}
	
	public static SumCountPra dfs(NodePra root, NodePra[] nodes, double[] min){
		if(root.children == null || root.children.size() == 0){
			return new SumCountPra(root.val, 1);
		}
		int curSum = root.val;
		int curCount = 1;
		for(NodePra child : root.children){
			SumCountPra last = dfs(child, nodes, min);
			 curSum += last.sum;
			 curCount += last.count;
		}
		double curAvg = (double)curSum / curCount;
		if(curAvg > min[0]){
			nodes[0] = root;
			min[0] = curAvg;
		}
		return new SumCountPra(curSum, curCount);
	}
	
	public static void main(String[] args) {
        NodePra root = new NodePra(1);
        NodePra l21 = new NodePra(2);
        NodePra l22 = new NodePra(3);
        NodePra l23 = new NodePra(4);
        NodePra l31 = new NodePra(5);
        NodePra l32 = new NodePra(5);
        NodePra l33 = new NodePra(5);
        NodePra l34 = new NodePra(5);
        NodePra l35 = new NodePra(5);
        NodePra l36 = new NodePra(5);

        l21.children.add(l31);
        l21.children.add(l32);

        l22.children.add(l33);
        l22.children.add(l34);

        l23.children.add(l35);
        l23.children.add(l36);

        root.children.add(l21);
        root.children.add(l22);
        root.children.add(l23);

        NodePra res = getHighest(root);
        System.out.println(res.val + " ");
    }
}
