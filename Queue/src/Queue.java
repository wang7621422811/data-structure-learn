public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    int capacity();

    void enqueue(E e);

    E dequeue();

    E getFront();


}
