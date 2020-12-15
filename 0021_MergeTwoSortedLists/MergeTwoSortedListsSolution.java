public class MergeTwoSortedListsSolution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        /*
        while (l1 != null) {
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }

        while (l2 != null) {
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        */

        // 优化如下，不需要再连接剩下的所有，只需要连接到头结点即可
        cur.next = (l1 == null) ? l2 : l1;

        return dummyHead.next;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4};
        int[] nums2 = {1, 3, 4};

        ListNode l1 = new ListNode(nums1);
        ListNode l2 = new ListNode(nums2);
        System.out.println(l1);
        System.out.println(l2);

        System.out.println(new MergeTwoSortedListsSolution().mergeTwoLists(l1, l2));

    }

}
