package com.example.project;

public class DLL<T> {
    private DLLNode<T> head;
    private DLLNode<T> current;
    private int size;  

    public DLL() {
        head = current = null;
        size = 0;
    }

    public boolean empty() {
        return head == null;
    }

    public boolean last() {
        return current != null && current.next == null;
    }

    public boolean first() {
        return current != null && current.previous == null;
    }

    public boolean full() {
        return false;
    }

    public void findFirst() {
        current = head;
    }

    public void findNext() {
        if (current != null) {
            current = current.next;
        }
    }

    public void findPrevious() {
        if (current != null) {
            current = current.previous;
        }
    }

    public T retrieve() {
        if (current != null) {
            return current.data;
        }
        return null;
    }

    public void update(T val) {
        if (current != null) {
            current.data = val;
        }
    }

    public void insert(T val) {
        DLLNode<T> tmp = new DLLNode<>(val);
        if (empty()) {
            current = head = tmp;
        } else {
            tmp.next = current.next;
            tmp.previous = current;
            if (current.next != null) {
                current.next.previous = tmp;
            }
            current.next = tmp;
            current = tmp;
        }
        size++;
    }

    public void remove() {
        if (empty() || current == null) {
            return;
        }

        if (current == head) {
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
        } else {
            if (current.previous != null) {
                current.previous.next = current.next;
            }
            if (current.next != null) {
                current.next.previous = current.previous;
            }
        }

        DLLNode<T> nextCurrent = current.next;
        if (nextCurrent != null) {
            current = nextCurrent;
        } else {
            current = current.previous;
        }

        size--;
    }

    public void removeBetween(T e1, T e2) {
        if (empty()) {
            return;
        }

        DLLNode<T> node1 = head;
        while (node1 != null && !node1.data.equals(e1)) {
            node1 = node1.next;
        }

        if (node1 == null || node1.next == null) {
            return;
        }

        DLLNode<T> node2 = node1.next;
        while (node2 != null && !node2.data.equals(e2)) {
            node2 = node2.next;
        }

        if (node2 == null) {
            return;
        }

        node1.next = node2.next;
        if (node2.next != null) {
            node2.next.previous = node1;
        }

        current = head;
        size -= 2;
    }

    public int size() {
        return size;
    }

    public boolean contains(T val) {
        DLLNode<T> node = head;
        while (node != null) {
            if (node.data.equals(val)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }
}
