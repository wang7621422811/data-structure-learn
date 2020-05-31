/**
 * @author: webin
 * @date: 2020/5/28 22:45
 * @description:
 * @version: 0.0.1
 */
public class Solution3 {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return head;
        }

        ListNode res = removeElements(head.next, val);
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }

    }

    public static void main(String[] args) {
        int[] vals = {1,2,6,3,4,5,6};
        Solution3 solution = new Solution3();
        ListNode listNode = solution.removeElements(new ListNode(vals), 6);
        System.out.println(listNode);
    }
}
