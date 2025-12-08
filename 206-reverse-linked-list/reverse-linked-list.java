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

// class Solution {
//     public ListNode reverseList(ListNode head) {
//         if(head==null||head.next==null)return head;
//         ListNode Last=null;
//         ListNode Current=head;
//         while(Current!=null){
//             ListNode op=Current.next;
//             Current.next=Last;
//             Last=Current;
//             Current=op;
//         }
//         return Last; 
//     }
// }




class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode temp=head;
        Stack<Integer>st=new Stack<>();
        while(temp!=null){
            st.push(temp.val);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            temp.val=st.pop();
            //st.pop();
            temp=temp.next;
        }
        return head;
    }
}