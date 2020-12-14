public class SortListSolution {

    // TODO:官方自顶向下，官方找中间结点其实不是真正的mid!
    public ListNode sortList(ListNode head) {
        return null;
    }

    // TODO:自底向上
    // ......

    public static void main(String[] args) {
        int[] nums = {-1, 5, 4, 3, 0};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        System.out.println(new SortListSolution().sortList(head));
    }
}
