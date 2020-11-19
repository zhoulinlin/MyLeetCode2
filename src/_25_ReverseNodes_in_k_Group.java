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

        ListNode temp = head;
        ListNode preTemp = newHead,prehead = newHead,t = null;

        for(int i=1;temp != null;i++){

            System.out.println("\nreverseKGroup temp:"+temp + " prehead:" + prehead +" t:" + t);

            if(i%k == 1){
                prehead = preTemp;
                t = prehead.next;
            }else if(i%k == 0 && prehead != null){
                swapOneGroup(prehead,k);
                temp = t;
            }
            preTemp = temp;
            temp = temp.next;
        }

        return newHead.next;
    }

    private void swapOneGroup(ListNode preHead,int k){

        System.out.println("\nswapOneGroup preHead:"+preHead);

        ListNode left,leftPre ,right,rightPre;

        for(int i=1;i<=k/2;i++){
            left = preHead.next;
            leftPre = preHead;
            right = preHead.next;
            rightPre = preHead;

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
    }

    private ListNode swapTwoNodes(ListNode left,ListNode leftPre,ListNode right,ListNode rightPre){

        System.out.println("\nleft:" +left + " leftPre:" + leftPre + " right:" + right + " rightPre:" + rightPre);

        if(left == null || right == null){
            return leftPre;
        }

        if(left.next == right){
            leftPre.next = right;
            left.next = right.next;
            right.next = left;
        }else{
            ListNode leftNext = left.next;
            left.next = right.next;
            right.next = leftNext;
            leftPre.next = right;
            rightPre.next = left;
        }

        return leftPre;
    }


    public static void printList(ListNode t){
        while (t != null){
            System.out.print(t);
            t=t.next;
        }
        System.out.print("\n");
    }
}
