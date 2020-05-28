/**
 * @author: webin
 * @date: 2020/5/19 21:33
 * @description:
 * @version: 0.0.1
 */
public class Main {

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            arrayStack.push(i);
            System.out.println(arrayStack.toString());
        }
        arrayStack.pop();
        System.out.println(arrayStack.toString());
    }
}
