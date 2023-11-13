package CustomLinkedList;

public class CustomLinkedList<T> {

    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    public CustomLinkedList() {
    }

    public void linkFirst(T data) {
        if (first == null)
            first = new Node<>(data, null, null);
        else
            first = new Node<>(data, null, first);
    }

    public void linkLast(T data) {
        if (last == null) {
            last = new Node<>(data, first, null);
            if(first != null) {
                first.next = last;
            }
        } else {
            Node<T> newNode = new Node<>(data, last, null);
            last.next = newNode;
            last = newNode;
        }
    }

    public void add(T data) {
        if (first == null)
            linkFirst(data);
        else
            linkLast(data);
        size++;
    }

    public int size() {
        return size;
    }

    public T getFirst() {
        return first.data;
    }

    public T getLast() {
        return last.data;
    }

    public T get(int index) {
        checkIndex(index);
        return findNode(index).data;
    }

    public void remove(int index) {
        checkIndex(index);
        Node<T> node = findNode(index);
        Node<T> prevNode = node.prev;
        Node<T> nextNode = node.next;
        if(prevNode == null) {
            first = nextNode;
        } else {
            prevNode.next = nextNode;
            node.prev = null;
        }
        if(nextNode == null) {
            last = prevNode;
        } else {
            nextNode.prev = prevNode;
            node.next = null;
        }
        size--;
    }

    private Node<T> findNode(int index) {
        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    private void checkIndex(int index) {
        if(index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index of bound exception");
        }
    }
    private static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}