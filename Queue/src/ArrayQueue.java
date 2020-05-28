/**
 * @author: webin
 * @date: 2020/5/20 20:51
 * @description:
 * @version: 0.0.1
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEnmpty();
    }

    @Override
    public int capacity() {
        return array.getCapacity();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue: ").append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i));
            if (array.getSize() -1 != i) {
                sb.append(",");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(1000000);

        for (int i = 0; i < 1000000; i++) {
            arrayQueue.enqueue(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            arrayQueue.dequeue();
        }
        long end = System.currentTimeMillis();
        //System.out.println(arrayQueue.toString());
        System.out.println("消耗时间: " + (end - start)/1000.0);
    }
}
