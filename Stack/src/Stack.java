/**
 * 自定义栈的顶级接口
 */
public interface Stack<E> {

    /** 向栈中添加元素 */
    void push(E e);

    /**
     * 弹栈
     * @return
     */
    E pop();

    /**
     * 查看栈顶的元素
     * @return
     */
    E peek();

    /**
     * 获取栈的大小
     * @return
     */
    int getSize();

    /**
     * 判断栈是否为空
     * @return
     */
    boolean isEmpty();




}
