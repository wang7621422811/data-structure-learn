/**
 * @author: webin
 * @date: 2020/5/21 20:50
 * @description: 实现链表的数据结构
 *                  Node节点设置为私有的,只有在链表内部才可以访问
 *                  原因:
 *                      对于用户来说不需要了解链表内部是怎样实现的,也就不需要知道Node的存在,只需要知道链表是一个线性的
 *                      数据结构,可以存储数据修改删除数据
 * @version: 0.0.1
 */
public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e,Node next) {
            this.e = e;
            this.next  = next;
        }

        public Node(E e) {
            this(e,null);
        }

        public Node() {
            this(null,null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        this.dummyHead = new Node(null,null);
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向链表的头部添加元素
     * @param e
     */
    public void addFirst(E e) {
        add(0,e);
    }

    /**
     * 在链表任意位置添加元素 使用虚拟头结点
     */
    public void add(int index,E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        // index - 1 的原因是 prev的next元素是要插入的节点位置
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
       // prev.next = new Node(e, prev.next);
        size ++;
    }


    public void addLast(E e) {
        add(size,e);
    }

    /**
     * 获得链表指定索引位置的元素
     */
    public E  get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取链表的第一个元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 获取链表的最后一个元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 更新链表的操作
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node node = dummyHead;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        node.e = e;
    }

    /**
     * 在链表中查看是否有元素e
     */
    public boolean contains(E e) {
        Node cur = dummyHead;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除元素
     * @return
     */
    public E remove(int index) {

        Node delNode = dummyHead;
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size -1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Node cur = dummyHead;
        while (cur.next != null) {
            sb.append(cur + "->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
