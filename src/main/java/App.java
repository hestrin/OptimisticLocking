import collections.Node;
import collections.SinglyLinkedList;

public class App {

    public static void main(String[] args) {
        SinglyLinkedList list = createList();

        Node currentNode = list.getFirst();
        while (currentNode != null) {
            currentNode = currentNode.getNext();
            System.out.println(currentNode.getName());
        }

        System.out.println("Hello world!!");
    }

    private static SinglyLinkedList createList() {
        SinglyLinkedList list = new SinglyLinkedList();
        for (int i = 0; i < 4; i++)
            list.add(new Node("Info" + i));
        return list;
    }
}
