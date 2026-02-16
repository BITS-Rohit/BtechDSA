package rohit.generics;

import java.util.Arrays;

public class Wildcards<T extends Number> {
    private T[] data;
    private static final int DEFAULT_SIZE = 2;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public Wildcards() {
        data = (T[]) new Object[DEFAULT_SIZE];
    }

    public void add(T value) {
        if (isFull()) {
            resize();
        }
        data[size++] = value;
    }

    private boolean isFull() {
        return size == data.length;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        T[] temp = (T[]) new Object[data.length * 2];
        System.arraycopy(data, 0, temp, 0, data.length);
        data = temp;
    }

    public T remove() {
        if (size == 0) {
            throw new IllegalStateException("Cannot remove from an empty array");
        }
        return data[--size];
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return data[index];
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Wildcards<Integer> array = new Wildcards<>();
        array.add(23);
        array.add(45);
        array.add(67);
        array.add(89);

        System.out.println(Arrays.toString(array.data));
        System.out.println("Size: " + array.size());
        System.out.println("Removed: " + array.remove());
        System.out.println(Arrays.toString(array.data));
        System.out.println("Size: " + array.size());
    }
}
