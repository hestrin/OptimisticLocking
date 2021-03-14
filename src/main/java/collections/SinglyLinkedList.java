package collections;

public class SinglyLinkedList {
    Node first;
    public void add(Node node){
        node.next = first;
        first = node;
    }

    public Node getFirst() {
        return first;
    }
}
