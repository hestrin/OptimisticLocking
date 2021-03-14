package collections;

public class Node {
    String name;
    Node next;

    public Node(String name) {
        this.name = name;
    }

    public Node getNext() {
        return next;
    }

    public String getName() {
        return name;
    }
}
