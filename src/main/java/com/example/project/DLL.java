public class DLL<T> {
    private DLLNode<T> head;
    private DLLNode<T> tail;
    private int size;

    public DLL() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean empty() {
        return size == 0;
    }

    public void insert(T val) {
        DLLNode<T> newNode = new DLLNode<>(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.previous = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void remove() {
        if (empty()) throw new IllegalStateException("The list is empty");
        if (tail == head) {
            head = null;
            tail = null;
        } else {
            tail = tail.previous;
            tail.next = null;
        }
        size--;
    }

    public void removeBetween(T e1, T e2) {
        if (empty()) return;

        DLLNode<T> node1 = head;
        while (node1 != null && !node1.data.equals(e1)) {
            node1 = node1.next;
        }

        if (node1 == null) return;

        DLLNode<T> node2 = node1.next;
        while (node2 != null && !node2.data.equals(e2)) {
            node2 = node2.next;
        }

        if (node2 == null) return;

        node1.next = node2.next;
        if (node2.next != null) {
            node2.next.previous = node1;
        }
        
        size -= (node2 == null ? 1 : 2);
    }

    public void findFirst() {
        // This method needs to be implemented for iteration
    }

    public void findNext() {
        // This method needs to be implemented for iteration
    }

    public T retrieve() {
        // This method needs to be implemented to return the current element
        return null; // Return the appropriate element
    }
}
