public class RemoveLinkedListElementsSolution {

    public ListNode removeElements(ListNode head, int val) {

        // 不设立虚拟头结点，则对要删除的就是头结点的情况需要单独进行逻辑处理
        /*
        while (head != null && head.val == val){
            head = head.next;
        }

        if (head == null){
            return null;
        }
        */

        // 设立虚拟头结点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode cur = dummyHead;

        while (cur.next != null) {

            if (cur.next.val == val) {
                // 删除cur.next
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        System.out.println(new RemoveLinkedListElementsSolution().removeElements(head, 6));
    }
}
