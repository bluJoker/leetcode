import java.util.List;
import java.util.Stack;

/**
 * 左程云 p66
 * */
public class AddTwoNumbersNonReversed {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    private ListNode head1;

    // 在链表尾添加新的元素e
    public void add1(int e) {
        ListNode node = new ListNode(e);
        ListNode x = head1;
        if (x == null) {
            head1 = node;
        } else {
            while (x.next != null) {
                x = x.next;
            }
            x.next = node;
        }
    }

    private ListNode head2;

    // 在链表尾添加新的元素e
    public void add2(int e) {
        ListNode node = new ListNode(e);
        ListNode x = head2;
        if (x == null) {
            head2 = node;
        } else {
            while (x.next != null) {
                x = x.next;
            }
            x.next = node;
        }
    }

    public void print(ListNode head) {
        ListNode node = head;

        while (node != null) {

            System.out.print(node.val + " -> ");
            node = node.next;
        }
    }

    // 解法1：利用栈结构求解
    public ListNode addListNonReversed(ListNode l1, ListNode l2){
        if (l1 == null && l2 == null){
            return null;
        }

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }
//        ListNode dummyHead = new ListNode(0);
//        ListNode curr = dummyHead;
//        int carry = 0;
//        while (!s1.isEmpty() || !s2.isEmpty()){
//            int sum = 0;
//            if (!s1.isEmpty()){
//                sum += s1.pop();
//            }
//            if (!s2.isEmpty()){
//                sum += s2.pop();
//            }
//            sum += carry;
//
//
////            curr.next = new ListNode(sum % 10);
////            curr = curr.next;
//            carry = sum / 10;

//         需要反向连接
        ListNode node = null;
        ListNode prev = null;
        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty()){
            int sum = 0;
            if (!s1.isEmpty()){
                sum += s1.pop();
            }
            if (!s2.isEmpty()){
                sum += s2.pop();
            }
            sum += carry;

            // Tips1：如何反向构建链表
            prev = node;
            node = new ListNode(sum % 10);
            node.next = prev;
            carry = sum / 10;
        }
        if (carry > 0){
            prev = node;
            node = new ListNode(carry);
            node.next = prev;
        }
        return node;
    }

    // 解法2：利用链表的逆序求解，可以节省用栈的空间
    // 将两个链表逆序，就和AddTwoNumbers解法类似，再将结果链表逆序即为所求
    public ListNode addListNonReversed2(ListNode l1, ListNode l2){
        if (l1 == null && l2 == null){
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

    public ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode next = null;
        while (head != null){
            next = head.next;
            head.next = prev;

            prev = head;
            head = next;
        }
        return prev;
    }


    public static void main(String[] args) {
        AddTwoNumbersNonReversed addTwoNumbersNonReversed = new AddTwoNumbersNonReversed();
        addTwoNumbersNonReversed.add1(3);
        addTwoNumbersNonReversed.add1(4);
        addTwoNumbersNonReversed.add1(2);

        addTwoNumbersNonReversed.print(addTwoNumbersNonReversed.head1);
        System.out.println("");

        addTwoNumbersNonReversed.add2(4);
        addTwoNumbersNonReversed.add2(6);
        addTwoNumbersNonReversed.add2(5);
        addTwoNumbersNonReversed.print(addTwoNumbersNonReversed.head2);
        System.out.println("");

        ListNode resList = addTwoNumbersNonReversed.addListNonReversed2(addTwoNumbersNonReversed.head1, addTwoNumbersNonReversed.head2);

        addTwoNumbersNonReversed.print(resList);
    }
}
