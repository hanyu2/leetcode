package Array;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int k, int v){
            this.key = k;
            this.value = v;
        }
    }
    Map<Integer, Node> map;
    int size;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.size = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        head.pre = null;
        tail.pre = head;
        tail.next = null;
        map = new HashMap<Integer, Node>();
    }
    
    public void addToHead(Node n){
        n.next = head.next;
        head.next.pre = n;
        head.next = n;
        n.pre = head;
    }
    
    public Node removeTail(){
        Node n = tail.pre;
        tail.pre = n.pre;
        n.pre.next = tail;
        return n;
    }
    
    public void remove(Node n){
        n.next.pre = n.pre;
        n.pre.next = n.next;
    }
    
    public int get(int key) {
        Node n = map.get(key);
        if(n == null){
            return -1;
        }else{
            remove(n);
            addToHead(n);
            return n.value;
        }
    }
    
    public void set(int key, int value) {
        Node n = map.get(key);
        if(n == null){
            Node temp = new Node(key, value);
            map.put(key, temp);
            addToHead(temp);
            if(map.size() > size){
                Node t = removeTail();
                map.remove(t.key);
                remove(t);
            }
        }else{
            n.value = value;
            remove(n);
            addToHead(n);
        }
    }
    
    public static void main(String[] args){
    	LRUCache lru = new LRUCache(2);
    	lru.set(2, 1);
    	lru.set(1, 1);
    	lru.set(2, 3);
    	lru.set(4, 1);
    	lru.get(1);
    	lru.get(2);
    }
}
