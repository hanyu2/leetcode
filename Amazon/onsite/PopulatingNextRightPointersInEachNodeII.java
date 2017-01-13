package Amazon.onsite;

import java.util.HashMap;
import java.util.Map;

public class PopulatingNextRightPointersInEachNodeII {
	public void connect(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(-1);
        while(root != null){
            TreeLinkNode h = dummy;
            while(root != null){
                if(root.left != null){
                    h.next = root.left;
                    h = h.next;
                }
                if(root.right != null){
                    h.next = root.right;
                    h = h.next;
                }
                root = root.next;
            }
            root = dummy.next;
            dummy.next = null;
        }
    }
	
	public void connect2(TreeLinkNode root) {
        Map<Integer, TreeLinkNode> map = new HashMap<Integer, TreeLinkNode>();
        connectNodes(root, 1, map);
    }
    
    public void connectNodes(TreeLinkNode root, int depth, Map<Integer, TreeLinkNode> map){
        if(root == null){
            return;
        }
        if(map.containsKey(depth)){
            TreeLinkNode node  = map.get(depth);
            node.next = root;
            node = node.next;
            map.put(depth, node);
        }else{
            map.put(depth, root);
        }
        connectNodes(root.left, depth + 1, map);
        connectNodes(root.right, depth + 1, map);
    }
}
