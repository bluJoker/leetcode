public class OddEvenLinkedListSolution {

    public ListNode oddEvenList(ListNode head) {
        // 官方解法
//        if (head == null) {
//            return head;
//        }
//
//        ListNode odd = head;
//        ListNode even = head.next;
//        ListNode evenHead = head.next;
//
//        // 易错点：while条件
//        while (even != null && even.next != null) {
//            odd.next = even.next;
//            odd = odd.next;
//
//            even.next = odd.next;
//            even = even.next;
//        }
//        odd.next = evenHead;
//
//        return head;


        // 参考0086，易于理解，采用！
        ListNode dummyOddHead = new ListNode(-1);
        ListNode dummyEvenHead = new ListNode(-1);

        ListNode oddHead = dummyOddHead;
        ListNode evenHead = dummyEvenHead;

        int index = 1;
        while (head != null) {
            if (index % 2 == 1) {
                oddHead.next = head;
                oddHead = oddHead.next;
            } else {
                evenHead.next = head;
                evenHead = evenHead.next;
            }

            head = head.next;
            index++;
        }

        evenHead.next = null;

        oddHead.next = dummyEvenHead.next;

        return dummyOddHead.next;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 5, 6, 4, 7};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode resHead = new OddEvenLinkedListSolution().oddEvenList(head);
        System.out.println(resHead);
    }

}
