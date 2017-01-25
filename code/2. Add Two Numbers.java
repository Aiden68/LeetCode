/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
			return l2;
		}
		else if(l2 == null){
			return l1;
		}
		int carry = 0;
		ListNode head = null;
		ListNode listNode = new ListNode(0);		
		while(l1 != null && l2 != null){
			ListNode temp = new ListNode(l1.val + l2.val + carry);
			if(temp.val >= 10){
				temp.val -= 10;
				carry = 1;
			}
			else{
				carry = 0;
			}
			if(head == null){
				head = temp;
				listNode = head;
			}
			else {
				listNode.next = temp;
				listNode = temp;
			}			
			l1 = l1.next;
			l2 = l2.next;
		}
		while(l1 != null){
			ListNode temp = new ListNode(l1.val + carry);
			if(temp.val >= 10){
				temp.val -= 10;
				carry = 1;
			}
			else{
				carry = 0;
			}
			listNode.next = temp;
			listNode = temp;
			l1 = l1.next;
		}
		while(l2 != null){
			ListNode temp = new ListNode(l2.val + carry);
			if(temp.val >= 10){
				temp.val -= 10;
				carry = 1;
			}
			else{
				carry = 0;
			}
			listNode.next = temp;
			listNode = temp;
			l2 = l2.next;
		}
		if(carry != 0){
			ListNode temp = new ListNode(carry);
			listNode.next = temp;
			listNode = temp;
		}
		return head;
    }
}