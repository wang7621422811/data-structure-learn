import com.sun.org.apache.bcel.internal.generic.LUSHR;

public class Solution2 {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        // 1,2,6,3,4,5,6
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        public ListNode(int[] arr) {
            if (arr == null || arr.length <= 0) {
                throw new IllegalArgumentException("arr can not be empty!");
            }
            this.val = arr[0];
            ListNode cur = this;
            for (int i = 1; i < arr.length; i++) {
                cur.next = new ListNode(arr[i]);
                cur = cur.next;
            }
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("top: ");
            ListNode cur = this;
            while (cur != null) {
                sb.append(cur.val + " -> ");
                cur = cur.next;
            }
            sb.append("NULL");

            return sb.toString();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode listNode = new ListNode(nums);
        Solution2 solution = new Solution2();
        System.out.println(solution.removeElements(listNode, 6).toString());
    }
}

