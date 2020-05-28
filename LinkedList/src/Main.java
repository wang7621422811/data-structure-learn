/**
 * @author: webin
 * @date: 2020/5/21 21:11
 * @description:
 * @version: 0.0.1
 */
public class Main {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addFirst("a");
        linkedList.addFirst("b");
        linkedList.addFirst("c");
        linkedList.addFirst("d");
        linkedList.add(2,"e");
        System.out.println(linkedList.toString());
        System.out.println(linkedList.remove(2));
        System.out.println(linkedList.toString());
    }
}
