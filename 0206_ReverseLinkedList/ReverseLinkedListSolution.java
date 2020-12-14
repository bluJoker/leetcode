import java.util.List;

public class ReverseLinkedListSolution {

    /**
     * Definition for singly-linked list.
     */


    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode cur = head;
        while (cur != null){
            ListNode next = cur.next;

            cur.next = prev;

            prev = cur;
            cur = next;
        }
        return prev;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = new ListNode(arr);
        System.out.println(head);

        ListNode head2 = new ReverseLinkedListSolution().reverseList(head);
        System.out.println(head2);

    }

}
