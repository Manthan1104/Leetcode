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

//class Solution {
//     public boolean isPalindrome(ListNode head) {
//         Stack <Integer> st=new Stack<>();
//         ListNode temp=head;
//         while(temp!=null){
//             st.push(temp.val);
//             temp=temp.next;
//         }
//         temp=head;
//         while(temp!=null){
//             if(temp.val!=st.peek())return false;
//             temp=temp.next;
//             st.pop();
//         }
//         return true;
//     }
// }


class Solution {

    ListNode reverseLinkedList(ListNode head){
        if(head==null||head.next==null)return head;
        ListNode newHead=reverseLinkedList(head.next);
        ListNode front=head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }

    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode newHead=reverseLinkedList(slow.next);
        ListNode first=head;
        ListNode second=newHead;
        while(second!=null){
            if(first.val!=second.val){
                reverseLinkedList(newHead);
                return false;
            }
            first=first.next;
            second=second.next;
        }
        reverseLinkedList(newHead);
        return true;
    }
}