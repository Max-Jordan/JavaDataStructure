package CustomArrayList;

import java.util.Arrays;

public class CustomArrayList<T> {

    private Object[] elements;
    private static final int CAPACITY = 10;
    private int size;

    public CustomArrayList() {
        elements = new Object[CAPACITY];
        size = 0;
    }

    public void add(T data) {
        if (size == CAPACITY) {
            grow();
        }
        elements[size] = data;
        size++;
    }

    public int size() {
        return size;
    }

    public Object get(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index of bound exception");
        }
        return elements[index];
    }

    public void remove(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index of bound exception");
        }
        Object[] newArray = new Object[size - 1];
        for (int i = 0; i < size; i++) {
            if (i < index) newArray[i] = elements[i];
            else if (i > index) newArray[i - 1] = elements[i];
        }
        elements = newArray;
        size--;
    }

    private void grow() {
        elements = Arrays.copyOf(elements, CAPACITY * 2);
    }
}
