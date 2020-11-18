import helper.ListNode;

import java.util.Arrays;
import java.util.Comparator;

/**
 *You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *Example 1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 *
 * Constraints:
 *
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length won't exceed 10^4.
 *
 */
public class _23_Merge_k_SortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        ListNode head = new ListNode();
        int minIndex = 0;
        ListNode p = head;

        while (true){
            minIndex = findMin(lists);
            if(minIndex < 0){
                break;
            }
            p.next = lists[minIndex];
            p = p.next;
            lists[minIndex] = lists[minIndex].next;

        }

        return head.next;

    }


    private int findMin(ListNode[] lists){
        int minV = 10001;
        int minIndex = -1;
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null && lists[i].val <minV){
                minIndex = i;
                minV=lists[i].val;
            }
        }
        return minIndex;
    }


}
