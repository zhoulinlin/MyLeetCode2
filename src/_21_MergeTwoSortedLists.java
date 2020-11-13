import helper.ListNode;

/**
 * 21. Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new sorted list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example 1:
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 */
public class _21_MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        ListNode head = new ListNode();
        ListNode p = head;

        while(l1 != null && l2 != null){
            if(l1.val >= l2.val){
                p.next = l2;
                l2 = l2.next;
            }else{
                p.next = l1;
                l1 = l1.next;
            }
            p = p.next;
        }

        p.next =l1 == null?l2:l1;

        return head.next;
    }
}
