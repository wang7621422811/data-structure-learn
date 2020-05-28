
/**
 * @author: webin
 * @date: 2020/5/20 21:10
 * @description:
 * @version: 0.0.1
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    // front:指向队列的头 tail: 指向队里的尾部
    private int front,tail;
    // 队列的大小 TODO 实现使用front和tail实现知道队列的大小
    private int size;

    public LoopQueue(int capacity) {
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(0);
    }


    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int capacity() {
        return data.length;
    }

    @Override
    public void enqueue(E e) {

        // 判断队列是否为满的
        if ((tail + 1) % data.length == front) {
            this.resize((capacity()-1) * 2); // 扩容
        }
        data[tail] = e;
        tail = (tail+1) % data.length;
        size ++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[front+i % data.length];
        }
        data = newData;
        front = 0;
        tail = this.size;
    }

    @Override
    public E dequeue() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        this.size --;
        if (size == this.capacity() / 4 && capacity() / 2 != 0) {
            this.resize(capacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d, capacity = %d",size,(capacity()-1))).append("front [");
        for (int i = front;i != tail; i= (i + 1) % data.length) {
            sb.append(data[i]);
            if ((i + 1) % data.length != tail) {
                sb.append(",");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        LoopQueue LoopQueue = new LoopQueue(100000);

        for (int i = 0; i < 100000; i++) {
            LoopQueue.enqueue(i);
            //System.out.println(LoopQueue.toString());
//            if (i % 3 == 2) {
//                LoopQueue.dequeue();
//                //System.out.println(LoopQueue.toString());
//            }
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            LoopQueue.dequeue();
        }
        long end = System.currentTimeMillis();
        System.out.println(LoopQueue.toString());
        System.out.println("消耗时间: " + (end - start));
    }

}
