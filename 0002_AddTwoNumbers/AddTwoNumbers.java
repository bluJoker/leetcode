public class AddTwoNumbers {

    // 解法1：递归
    public ListNode addTwoNumbersPositive(ListNode l1, ListNode l2) {
        return addTwoNumbersPositive(l1, l2, 0);
    }

    private ListNode addTwoNumbersPositive(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        ListNode result = new ListNode(0);
        int value = carry;
        if (l1 != null) {
            value += l1.val;
        }
        if (l2 != null) {
            value += l2.val;
        }

        result.val = value % 10; /* 数字的第二个数位 */

        /* 递归 */
        if (l1 != null || l2 != null) {
            ListNode more = addTwoNumbersPositive(l1 == null ? null : l1.next, l2 == null ? null : l2.next, value >= 10 ? 1 : 0);
            result.next = more;
        }
        return result;
    }

    // 解法2：迭代。
    // 请注意，我们使用哑结点来简化代码。如果没有哑结点，则必须编写额外的条件语句来初始化表头的值。
    public ListNode addTwoNumbersPositive2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;

        while (p1 != null || p2 != null) {
            int sum = 0;
            if (p1 != null) {
                sum += p1.val;
            }
            if (p2 != null) {
                sum += p2.val;
            }
            sum += carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 4, 5};
        ListNode head1 = new ListNode(nums1);

        int[] nums2 = {5, 6, 4};
        ListNode head2 = new ListNode(nums2);

        System.out.println(new AddTwoNumbers().addTwoNumbersPositive2(head1, head2));
        System.out.println("");
    }
}
