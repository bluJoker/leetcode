public class RemoveDuplicatesfromSortedListIISolution {

    public ListNode deleteDuplicates(ListNode head) {

        // 双指针
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // prev指向重复元素前一结点；cur指向重复元素后一结点
        ListNode prev = dummyHead;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            if (prev.next.val == cur.next.val) {
                while (cur != null && cur.next != null && prev.next.val == cur.next.val) {
                    cur = cur.next;
                }
                prev.next = cur.next;
                cur = cur.next;

            } else {
                prev = prev.next;
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 3, 4, 4, 5};
        int[] nums2 = {1, 1, 1, 2, 3};

        ListNode head1 = new ListNode(nums1);
        ListNode head2 = new ListNode(nums2);

        System.out.println(new RemoveDuplicatesfromSortedListIISolution().deleteDuplicates(head1));
        System.out.println(new RemoveDuplicatesfromSortedListIISolution().deleteDuplicates(head2));

    }

}
