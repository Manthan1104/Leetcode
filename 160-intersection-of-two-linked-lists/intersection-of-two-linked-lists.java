/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//public class Solution {
//     public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//         ListNode t1=headA;
//         int N1=0;
//         ListNode t2=headB;
//         int N2=0;
//         while(t1!=null){
//             N1++;
//             t1=t1.next;
//         }
//         while(t2!=null){
//             N2++;
//             t2=t2.next;
//         }
//         if(N1<N2){
//             return collisionPoint(headA,headB,N2-N1);
//         }else return collisionPoint(headB,headA,N1-N2);
//     }

//     public static ListNode collisionPoint(ListNode t1,ListNode t2,int d){
//         while(d>0){
//             d--;
//             t2=t2.next;
//         }
//         while(t1!=t2){
//             t1=t1.next;
//             t2=t2.next;
//         }
//         return t1;
//     }
// }


public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)return null;
        ListNode t1=headA;
        ListNode t2=headB;
        while (t1 != t2) {
            t1 = (t1 == null) ? headB : t1.next;
            t2 = (t2 == null) ? headA : t2.next;
        }
        return t1;
    }
}