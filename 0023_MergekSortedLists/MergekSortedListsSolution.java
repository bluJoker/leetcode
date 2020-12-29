import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedListsSolution {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummyHead = new ListNode(-1);
        ListNode cur = dummyHead;

        // 最小堆中存的是ListNode，需自定义比较函数
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        // 先将各个链表的头结点均加入pq中
        for (ListNode node : lists) {

            // 若链表数组中有空，需判断
            if (node != null) {
                pq.offer(node);
            }
        }

        // 取出pq最小的，连接到cur后面
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            cur.next = minNode;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
            cur = cur.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 4, 5};
        int[] nums2 = {1, 3, 4};
        int[] nums3 = {2, 6};

        ListNode[] lists = {new ListNode(nums1), new ListNode(nums2), new ListNode(nums3)};
        System.out.println(Arrays.toString(lists));

        System.out.println(new MergekSortedListsSolution().mergeKLists(lists));
    }
}
