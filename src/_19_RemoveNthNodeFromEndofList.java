import helper.ListNode;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * Follow up: Could you do this in one pass?
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 *
 * Example 2:
 * Input: head = [1], n = 1
 * Output: []
 *
 * Example 3:
 * Input: head = [1,2], n = 1
 * Output: [1]
 */
public class _19_RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){
            return null;
        }

        ListNode firstP = head,secondP = head;
        for(int i=0;i<n ;i++){
            secondP = secondP.next;
        }

        if(secondP == null){
            return head.next;
        }

        while(secondP.next != null){
            firstP = firstP.next;
            secondP = secondP.next;
        }

        firstP.next = firstP.next.next;

        return head;
    }

}
