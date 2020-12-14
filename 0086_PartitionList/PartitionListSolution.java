public class PartitionListSolution {

    public ListNode partition(ListNode head, int x) {

        // 空间复杂度: O(1)O(1)O(1)，我们没有申请任何新空间。值得注意的是，我们只移动了原有的结点，因此没有使用任何额外空间。

        // 要将before尾和after首连接，初始不知道before和after的头结点，则只能设立虚拟头结点
        ListNode dummyBefore = new ListNode(-1);
        ListNode dummyAfter = new ListNode(-1);

        ListNode before = dummyBefore;
        ListNode after = dummyAfter;

        while (head != null){

            if (head.val < x){
                before.next = head;
                before = before.next;
            }else {
                after.next = head;
                after = after.next;
            }

            head = head.next;
        }

        after.next = null;

        // 连接两个链表
        before.next = dummyAfter.next;
        dummyAfter = null;

        return dummyBefore.next;
    }


    public static void main(String[] args) {
        int[] nums = {1,4,3,2,5,2};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode resHead = new PartitionListSolution().partition(head, 3);
        System.out.println(resHead);
    }

}
