package LinkedList;

public class Solution {
	public static void printReverse(ListNode head){
		int len = 0;
		ListNode node = head;
		while(node != null){
			node = node.next;
			len++;
		}
		print(head, len);
	}
	
	public static void print(ListNode head, int len){
		if(head == null){
			return;
		}
		if(len == 1){
			System.out.println(head.val);
			return;
		}
		ListNode node = head;
		int count = 0;
		while(node != null && count < len / 2){
			node = node.next;
			count++;
		}
		print(node, len - count);
		print(head, count);
	}
	public static void main(String[] args){
		ListNode n1 = new ListNode(1);
		
		
		printReverse(n1);
	}
}
