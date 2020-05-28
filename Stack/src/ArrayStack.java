/**
 * @author: webin
 * @date: 2020/5/19 21:20
 * @description:  动态数组栈
 *                栈的时间复杂度都是O(1)的
 *                因为是动态数组实现的,如果出发resize时间就是O(n)的,可以忽略
 * @version: 0.0.1
 */
public class ArrayStack<E> implements Stack<E> {

    private Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removelast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEnmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack: ").append("[");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i));
            if (array.getSize() -1 != i) {
                sb.append(",");
            }
        }
        sb.append("] top");
        return sb.toString();
    }
}
