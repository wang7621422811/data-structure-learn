/**
 * @author: webin
 * @date: 2020/5/31 13:17
 * @description:    自定义二分搜索树<b>Binary Search Tree</b>
 *      要实现一个二分搜索树,元素的值必须是可以比较的,因此我们要传递的值是集成Comparable
 *      这个二分搜索树的实现是不包含两个相同的元素的
 *      <ul>
 *          <li>二分搜索树添加元素的非递归方式和链表很像</li>
 *          <li>本类关注的是二分搜索树的递归实现方式</li>
 *          <li>二分搜索树非一些方法的非递归的实现,自己实现</li>
 *      </ul>
 * @version: 0.0.1
 */
public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left,right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }
    // 需要一个跟节点
    private Node root;
    // 记录二分搜索树存储了多少个元素
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    // 返回树的长度
    public int getSize() {
        return size;
    }

    // 是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size ++;
        } else {
            add(root, e);
        }
    }

    // 向以node为跟节点的二分搜索树种插入元素E,递归算法
    private void add(Node node, E e) {
        if (e.equals(node.e))
            return;
        else if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
            return;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
            return;
        }

        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }

    }

}
