/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head==null||head.next==null)return null;
        ListNode temp=head;
        int n=0;
        while(temp!=null){
            n++;
            temp=temp.next;
        }
        int res=n/2;
        temp=head;
        while(temp!=null){
            res--;
            if(res==0){
                ListNode middle=temp.next;
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
        }
        return head;
    }
}