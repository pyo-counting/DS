package ds.linear.stack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<E> {

    private Object[] arr;
    private int length;

    public ArrayStack(int initSize) {
        arr = new Object[initSize];
    }

    public boolean empty() {
        return length == 0;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        if (empty())
            throw new EmptyStackException();
        return (E) arr[length - 1];
    }

    @SuppressWarnings("unchecked")
    public E pop() {
        if (empty())
            throw new EmptyStackException();
        E removedData = (E) arr[length - 1];
        arr[length - 1] = null;
        length--;
        return removedData;
    }

    public E push(E item) {
        if (arr.length == length)
            arr = Arrays.copyOf(arr, arr.length * 2);
        arr[length++] = item;
        return item;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }

    // 객체 E에 대한 비교를 정의하기 위해 Comparator 또는 Comparable 인터페이스 구현 필요
//    public int search(E item) {
//    }
}
