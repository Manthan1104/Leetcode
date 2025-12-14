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

    public ListNode getNthNode(ListNode temp,int k){
        int cnt=1;
        while(temp!=null){
            if(cnt==k)return temp;
            cnt++;
            temp=temp.next;
        }
        return temp;
    }

    public ListNode rotateRight(ListNode head, int k) {
        int len=1;
        ListNode tail=head;
        while(tail!=null && tail.next!=null){
            len++;
            tail=tail.next;
        }
        if(k%len ==0)return head;
        k=k%len;
        tail.next=head;
        ListNode newLastNode=getNthNode(head,len-k);
        head=newLastNode.next;
        newLastNode.next=null;
        return head;
    }
}