package com.example.project;

public class ArrayList<T> implements List<T> {
    private int maxsize;
    private int size;
    private int current;
    private T[] nodes;

    /** Creates a new instance of ArrayList */
    public ArrayList(int n) {
        maxsize = n;
        size = 0;
        current = -1;
        nodes = (T[]) new Object[n];
    }

    // التحقق مما إذا كانت القائمة ممتلئة
    public boolean full() {
        return size == maxsize;
    }

    // التحقق مما إذا كانت القائمة فارغة
    public boolean empty() {
        return size == 0;
    }

    // التحقق مما إذا كان العنصر الحالي هو الأخير
    public boolean last() {
        return current == size - 1;
    }

    // الانتقال إلى العنصر الأول
    public void findFirst() {
        if (!empty()) {
            current = 0;
        }
    }

    // الانتقال إلى العنصر التالي
    public void findNext() {
        if (current < size - 1) {
            current++;
        }
    }

    // استرجاع العنصر الحالي
    public T retrieve() {
        if (current >= 0 && current < size) {
            return nodes[current];
        }
        return null; // أو throw Exception إذا كان الوضع غير مسموح
    }

    // تحديث العنصر الحالي بقيمة جديدة
    public void update(T val) {
        if (current >= 0 && current < size) {
            nodes[current] = val;
        }
    }

    // إدخال عنصر جديد
    public void insert(T val) {
        if (full()) {
            throw new IllegalStateException("The list is full");
        }
        for (int i = size - 1; i > current; --i) {
            nodes[i + 1] = nodes[i];
        }
        current++;
        nodes[current] = val;
        size++;
    }

    // إزالة العنصر الحالي
    public void remove() {
        if (empty()) {
            throw new IllegalStateException("The list is empty");
        }
        for (int i = current + 1; i < size; i++) {
            nodes[i - 1] = nodes[i];
        }
        size--;
        if (size == 0) {
            current = -1;
        } else if (current == size) {
            current = 0;
        }
    }

    // الحصول على حجم القائمة الحالي
    public int size() {
        return size;
    }
}
