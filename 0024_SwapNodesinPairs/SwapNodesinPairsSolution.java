public class SwapNodesinPairsSolution {


    // dummyHead ->  1  ->  2  ->  3  ->  4  ->  null
    //     p       node1  node2

    // node1.next = node2.next;
    // node2.next = node1;
    // p.next = node2;
    //
    // dummyHead ->  2  ->  1  ->  3  ->  4  ->  null
    //     p       node2  node1
    //
    //下一次循环的p指向node1，反转3 -> 4
    // dummyHead ->  2  ->  1  ->  3  ->  4  ->  null
    //                      p
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode p = dummyHead;

        while (p.next != null && p.next.next != null){
            ListNode node1 = p.next;
            ListNode node2 = p.next.next;

            node1.next = node2.next;
            node2.next = node1;
            p.next = node2;

            p = node1;
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        System.out.println(new SwapNodesinPairsSolution().swapPairs(head));
    }
}
