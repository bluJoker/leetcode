import java.util.Stack;

public class AddTwoNumbersIISolution {

    // 解法1：利用栈结构求解
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        ListNode cur = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int sum = 0;
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }
            sum += carry;
            carry = sum / 10;

            //每次在链表头插入！
            head = new ListNode(sum % 10);
            head.next = cur;
            cur = head;

        }

        if (carry != 0) {
            head = new ListNode(carry);
            head.next = cur;
        }
        return head;
    }

    // 解法2：利用链表的逆序求解，可以节省用栈的空间
    // 将两个链表逆序，就和AddTwoNumbers解法类似，再将结果链表逆序即为所求
    public ListNode addListNonReversed2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        l1 = reverseList(l1);
        l2 = reverseList(l2);

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
        return reverseList(dummyHead.next);
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;

            prev = head;
            head = next;
        }
        return prev;
    }


    public static void main(String[] args) {
        int[] nums1 = {7, 2, 4, 3};
        int[] nums2 = {5, 6, 4};

        ListNode head1 = new ListNode(nums1);
        ListNode head2 = new ListNode(nums2);
        System.out.println(head1);
        System.out.println(head2);

        System.out.println();
        ListNode resHead = new AddTwoNumbersIISolution().addListNonReversed2(head1, head2);
        System.out.println(resHead);
    }

}
