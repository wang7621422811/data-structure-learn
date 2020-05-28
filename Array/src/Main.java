/**
 * @author: webin
 * @date: 2020/5/17 21:00
 * @description:
 * @version: 0.0.1
 */
public class Main {

    public static void main(String[] args) {
        Array<Integer> array = new Array<Integer>(20);
        for (int i = 0; i < 40; i++) {
            array.addLast(i);
        }
        System.out.println(array.toString());
        array.remove(1);
        array.removeElement(9);
        array.removelast();
        System.out.println(array.toString());
    }
}
