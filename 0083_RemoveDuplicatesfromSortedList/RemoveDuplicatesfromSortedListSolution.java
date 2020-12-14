public class RemoveDuplicatesfromSortedListSolution {

    public ListNode deleteDuplicates(ListNode head) {
//        // 自己想出来
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode prev = head;
//        ListNode cur = head.next;
//
//        while (cur != null) {
//            if (cur.val == prev.val) {
//                prev.next = cur.next;
//            } else {
//                prev = cur;
//            }
//
//            cur = cur.next;
//        }
//        return head;


        // 官方
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;

    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode resHead = new RemoveDuplicatesfromSortedListSolution().deleteDuplicates(head);
        System.out.println(resHead);

    }

}
