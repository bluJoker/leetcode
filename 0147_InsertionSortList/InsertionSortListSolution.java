public class InsertionSortListSolution {
    /**
     *
     *时间复杂度：O(n2)，其中 n 是链表的长度。
     *空间复杂度：O(1)。
     *
     * 对于单向链表而言，只有指向后一个节点的指针，因此需要从链表的头节点开始往后遍历链表中的节点，寻找插入位置。
     *
     * 对链表进行插入排序的具体过程如下。
     *     1. 首先判断给定的链表是否为空，若为空，则不需要进行排序，直接返回。
     *     2. 创建哑节点 dummyHead，令 dummyHead.next = head。引入哑节点是为了便于在 head 节点之前插入节点。
     *     3. 维护 lastSorted 为链表的已排序部分的最后一个节点，初始时 lastSorted = head。
     *     4. 维护 curr 为待插入的元素，初始时 curr = head.next。
     *     5. 比较 lastSorted 和 curr 的节点值。
     *         若 lastSorted.val <= curr.val，说明 curr 应该位于 lastSorted 之后，将 lastSorted 后移一位，curr 变成新的 lastSorted。
     *         否则，从链表的头节点开始往后遍历链表中的节点，寻找插入 curr 的位置。令 prev 为插入 curr 的位置的前一个节点，进行如下操作，完成对 curr 的插入：
     *
     *             lastSorted.next = curr.next
     *             curr.next = prev.next
     *             prev.next = curr
     *
     *     6. 令 curr = lastSorted.next，此时 curr 为下一个待插入的元素。
     *     7. 重复第 5 步和第 6 步，直到 curr 变成空，排序结束。
     *     8. 返回 dummyHead.next，为排序后的链表的头节点。
     * */
    public ListNode insertionSortList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode cur = head.next;
        ListNode lastSorted = head;

        while (cur != null){
            if (cur.val >= lastSorted.val){
                lastSorted = lastSorted.next;
            }else {

                ListNode prev = dummyHead;
                while (prev.next.val <= cur.val){
                    prev = prev.next;
                }

                lastSorted.next = cur.next;
                cur.next = prev.next;
                prev.next = cur;
            }

            // 下一个待插入的元素为已排序尾结点lastSorted的next
            cur = lastSorted.next;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {-1,5,3,4,0};
        ListNode head= new ListNode(nums);
        System.out.println(head);

        System.out.println(new InsertionSortListSolution().insertionSortList(head));
    }
}
