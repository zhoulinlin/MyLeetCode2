import helper.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes. Only nodes itself may be changed.
 *
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 */
public class _24_SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = new ListNode();
        ListNode cur = head,temp,pre = newHead;
        while(cur != null && cur.next != null){
            temp = cur.next;
            cur.next = temp.next;
            temp.next = cur;
            pre.next = temp;

            pre = cur;
            cur = cur.next;
        }

        return newHead.next;

    }
}
