/**
 * @author: webin
 * @date: 2020/5/25 22:25
 * @description: 使用链表实现队列
 */
public class LinkedQueue<E> implements Queue<E> {

    private Node head;
    private Node tail;
    private int size;

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

    public LinkedQueue() {
        head = null;
        tail = null;
        size = 0;
    }


    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int capacity() {
        return 0;
    }

    /**
     *  入队操作
     * @param o
     */
    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    /**
     * 出队操作
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) {
            tail = null;
        }
        size --;
        return retNode.e;
    }


    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot getFront from an empty queue");
        }
        return head.e;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Queue: front");
        Node cur = head;
        while (cur.next != null) {
            sb.append(cur.e + "->");
            cur = cur.next;
        }

        sb.append("NULL tail");

        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedQueue linkedQueue = new LinkedQueue();
        for (int i = 0; i < 10; i++) {
            linkedQueue.enqueue(i);
            System.out.println(linkedQueue);
            if (i % 3 == 2) {
                linkedQueue.dequeue();
                System.out.println(linkedQueue);
            }
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            linkedQueue.enqueue(i);

        }
        System.out.println(linkedQueue);
        for (int i = 0; i < 1000000; i++) {
            linkedQueue.dequeue();
        }
        long end = System.currentTimeMillis();
        //System.out.println(arrayQueue.toString());
        System.out.println("消耗时间: " + (end - start)/1000.0);
    }
}
