package Design;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
	class Node{
        Node pre;
        Node next;
        int key;
        int val;
        public Node(int k){
            this.key = k;
        }
    }

	Map<Integer, Node> map;
    int size;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        head = new Node(-1);
        tail = new Node(-1);
        map = new HashMap<Integer, Node>();
        head.next = tail;
        head.pre = null;
        tail.pre = head;
        tail.next = null;
        this.size = capacity;
    }
    
    public void remove(Node n){
        n.pre.next = n.next;
        n.next.pre = n.pre;
    }
    
    public void addHead(Node n){
        n.next = head.next;
        n.next.pre = n;
        head.next = n;
        n.pre = head;
    }
    
    public Node popTail(){
        Node n = tail.pre;
        tail.pre = n.pre;
        n.pre.next = tail;
        return n;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            addHead(n);
            return n.val;
        }else{
            return -1;
        }
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            n.val = value;
            remove(n);
            addHead(n);
        }else{
            Node n = new Node(key);
            n.val = value;
            map.put(key, n);
            addHead(n);
            if(map.size() > size){
                Node t = popTail();
                map.remove(t.key);
            }
        }
    }
}
