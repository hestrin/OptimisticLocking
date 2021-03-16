package collections;

public class SinglyLinkedList {
    Node first;

    public SinglyLinkedList(int size) {
        for (int i = 0; i < size; i++)
            this.addOnTop(new Node("Info" + (size - i -1)));
    }

    public void addOnTop(Node node) {
        node.next = first;
        first = node;
    }

    public Node getFirst() {
        return first;
    }
}
