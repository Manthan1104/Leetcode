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
        public static ListNode reverseLinkedList(ListNode head){
        ListNode prev=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode newHead=curr.next;
            curr.next=prev;
            prev=curr;
            curr=newHead;
        }
        return prev;
    }


    public static ListNode getKNode(ListNode temp,int k){
        k -=1;
        while(temp !=null && k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        // Write your code here.
        ListNode temp=head;
        ListNode nextNode=null;
        ListNode prevNode=null;
        while(temp !=null){
            ListNode KthNode=getKNode(temp,k);
            if(KthNode==null){
                if(prevNode!=null)prevNode.next=temp;
                break;
            }
            nextNode=KthNode.next;
            KthNode.next=null;
            reverseLinkedList(temp);
            if(temp==head)head=KthNode;
            else prevNode.next=KthNode;
            prevNode=temp;
            temp=nextNode;
        }
        return head;
    }
}