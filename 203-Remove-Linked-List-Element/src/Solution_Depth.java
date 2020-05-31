/**
 * @author: webin
 * @date: 2020/5/28 22:45
 * @description:
 * @version: 0.0.1
 */
public class Solution_Depth {

    public ListNode removeElements(ListNode head, int val, int depth) {

        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call:remove " + val + " in " + head);
        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return: " + head);
            return head;
        }

        ListNode res = removeElements(head.next, val, depth + 1);
        System.out.print(depthString);
        System.out.println("After remove " + val + " : " + res);
        ListNode ret;
        if (head.val == val) {
            ret = res;
        } else {
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return " + ret);
        return ret;
    }

    private String generateDepthString(int depth) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] vals = {1,2,6,3,4,5,6};
        Solution_Depth solution = new Solution_Depth();
        ListNode listNode = solution.removeElements(new ListNode(vals), 6,0);
        System.out.println(listNode);
    }
}
