package stack_queue_without_collections_03.queue;

public class Node<T> {
    T element;
    Node<T> next;

    public Node(T element) {
        this.element = element;
        next = null;
    }

    public Node(T element, Node<T> next) {
        this.element = element;
        this.next = next;
    }
}
