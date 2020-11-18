import helper.ListNode;

/**
 * 25. Reverse Nodes in k-Group
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * Follow up:
 *
 * Could you solve the problem in O(1) extra memory space?
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 *
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range sz.
 * 1 <= sz <= 5000
 * 0 <= Node.val <= 1000
 * 1 <= k <= sz
 */
public class _25_ReverseNodes_in_k_Group {

    public ListNode reverseKGroup(ListNode head, int k) {

        if(head.next == null || k==1){
            return head;
        }

        ListNode newHead = new ListNode();
        newHead.next = head;

        ListNode temp = newHead;

        for(int i=1;temp != null && temp.next != null;i++){
            if(i%k == 1){
                swapOneGroup(temp,k);
            }
            temp = temp.next;
        }

        return newHead.next;
    }

    private ListNode swapOneGroup(ListNode preHead,int k){

        ListNode left = preHead.next,leftPre = preHead,right = preHead.next,rightPre = preHead;

        for(int i=1;i<=k/2;i++){

            for(int j=1;j<i;j++){
                leftPre = left;
                left = left.next;
            }

            for(int j=1;j<=k-i;j++){
                rightPre = right;
                right = right.next;
            }

            swapTwoNodes(left,leftPre,right,rightPre);
            System.out.println("\nswapTwoNodes:");
            printList(preHead);
        }

        return preHead;
    }

    private ListNode swapTwoNodes(ListNode left,ListNode leftPre,ListNode right,ListNode rightPre){

        System.out.println("\nleft:" +left + " leftPre:" + leftPre + " right:" + right + " rightPre:" + rightPre);

        ListNode leftNext = left.next;
        ListNode rightNext = right.next;

        left.next = rightNext;
        right.next = leftNext;
        leftPre.next = right;
        rightPre.next = left;

        return leftPre;
    }


    public static void printList(ListNode t){
        while (t != null){
            System.out.print(t);
            t=t.next;
        }
    }
}
