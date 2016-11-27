package Amazon;

import java.util.HashMap;
import java.util.Map;

class ArbitraryListNode{
    int val;
    ArbitraryListNode next;
    ArbitraryListNode arbitrary;
    public ArbitraryListNode(int val){
        this.val = val;
        next = null;
        arbitrary = null;
    }
}
public class DeepCopyList {
	public static ArbitraryListNode deepCopy(ArbitraryListNode head){
		Map<ArbitraryListNode, ArbitraryListNode> map = new HashMap<ArbitraryListNode, ArbitraryListNode>();
		ArbitraryListNode cur = head;
		while(cur != null){
			map.put(cur, new ArbitraryListNode(cur.val));
			cur = cur.next;
		}
		cur = head;
		while(cur != null){
			map.get(cur).next = map.get(cur.next);
			if(cur.arbitrary != null){
				map.get(cur).arbitrary = map.get(cur.arbitrary);
			}
			cur = cur.next;
		}
		return map.get(head);
	}
}
