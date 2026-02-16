package rohit.generics;

import java.util.Arrays;
import java.util.List;

public class CustomGenericsArraylist<T> implements java.io.Serializable {
    private T[] data;
    private static final int DEFAULT_SIZE = 5;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public CustomGenericsArraylist() {
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

    public void getList(List<? extends Number> list){
        // Body

        // Although it is just an example of how u can use the wildcards here ....
    }

    public static void main(String[] args) {
        CustomGenericsArraylist<Object> array = new CustomGenericsArraylist<>();
        array.add(23);
        array.add(45);
        array.add(67);
        array.add(89);
        array.add(89.232F);
        array.add(-089.232D);
        array.add("This is it ");
        System.out.println(array.get(1));
        System.out.println(Arrays.toString(array.data));
        System.out.println("Size: " + array.size());
        System.out.println("Removed: " + array.remove());
        System.out.println(Arrays.toString(array.data));
        System.out.println("Size: " + array.size());

    }
}
