/**
 * @author: webin
 * @date: 2020/5/12 23:12
 * @description: 自定义数组
 * @version: 0.0.1
 */
public class Array<E> {

    private E[] data;
    private int size;

    /**
     *  构造函数,传入数组的容量capacity构造的Array
     * @param capacity 初始化容量
     */
    public Array(int capacity) {
        data = (E[])new java.lang.Object[capacity];
        size = 0;
    }



    /**
     *  无参构造函数,默认数组的容量capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取元素个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     *  获取数组的容量
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     *  获取数组的容量
     * @return
     */
    public boolean isEnmpty() {
        return size == 0;
    }

    /**
     * 向所有的元素后端添加一个新元素
     * 时间复杂度 O(1)
     * @param e
     */
    public void addLast(E e) {
       /* if (size != data.length) {
            data[size] = e;
            size++;
            // data[size++] = e;
        } else {
            throw new ArrayIndexOutOfBoundsException("AddLast failed. Array is full.");
        }*/
        add(size,e);
    }

    /**
     * 在所有的元素头添加元素
     * 时间复杂度 O(n)
     * @param e
     */
    public void addFrist(E e) {
        add(0,e);
    }

    /**
     * 向指定位置添加元素
     * -----------------
     * 增加数组空间扩容
     * @param e
     * @param index
     */
    public void add(int index,E e) {

//        if (size == data.length) {
//            throw new ArrayIndexOutOfBoundsException("Add failed. Array is full.");
//        }
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Add failed.Require index >= 0 and index <= size");
        }
        if (data.length == size) {
            resize(2 * data.length);
        }
        for (int i = size-1; i >= index ; i--) {
            data[i+1] = data[i];

        }

        data[index] =  e;
        size ++;
    }

    /**
     * 动态扩容数组
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new java.lang.Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 获取index索引位置的元素
     */
    public E get(int index) {
        if (index <0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * 向指定位置添加元素
     */
    public void set (int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     *  查看数组中是否包含 e 元素
     * @param e 给定的元素
     * @return 包含返回true,否则返回false
     */
    public boolean contains(E e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     *  根据元素查找索引,如果不存在返回-1
     * @param e 给定的元素
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从指定位置删除元素
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        E ret = data[index];
        for (int i = index + 1; i < data.length; i++) {
                data[i - 1] = data[i];
        }
        size--;
        data[size] = null; // loitering objects != memory leak

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length /2);
        }
        return ret;
    }

    /**
     * 删除第一个元素
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    public E removelast() {
        return remove(size - 1);
    }

    /**
     *  如果数组中有相对应的元素则删除
     * @param e
     */
    public boolean removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    /**
     *  打印数据长度和内容
     * @return
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n",size,data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }

    public E getFirst() {
        return data[0];
    }
}
