public class Solution {

    public ListNode removeElements(ListNode head,int val) {

        if (head == null) {
            return null;
        }
        // 将一开始连续的节点等于给定节点的删除
        while (head != null &&head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }
        // 1,2,6,3,4,5,6
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode tail = null;
        ListNode listNode = new ListNode(1); //[1,2,6,3,4,5,6]
        listNode = new ListNode(1);
//        listNode.next = new ListNode(2);
//        listNode.next.next = new ListNode(6);
//        listNode.next.next.next = new ListNode(3);
//        listNode.next.next.next.next = new ListNode(4);
//        listNode.next.next.next.next.next = new ListNode(5);
//        listNode.next.next.next.next.next.next = new ListNode(6);
        solution.removeElements(listNode,1);
    }
}
