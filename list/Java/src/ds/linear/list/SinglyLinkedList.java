package ds.linear.list;


import java.util.*;

public class SinglyLinkedList<E> implements List<E> {
    private Node<E> head, tail;
    private int length;

    @Override
    public boolean add(E e) {
        add(length, e);
        return true;
    }

    @Override
    public void add(int index, E e) {
        if (index > length || index < 0)
            throw new IndexOutOfBoundsException("Index parameter is out of bound");

        if (index == 0) {
            head = new Node<>(e, head);
            if (length == 0)
                tail = head;
        } else if (index == length) {
            Node<E> newNode = new Node<>(e);
            tail.setNext(newNode);
            tail = newNode;
        } else {
            Node<E> cursor = head;
            for (int cursorIndex = 0; cursorIndex != index - 1; cursorIndex++)
                cursor = cursor.getNext();
            Node<E> newNode = new Node<>(e, cursor.getNext());
            cursor.setNext(newNode);
        }
        length++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public E remove() {
        return removeFirst();
    }

    @Override
    public E remove(int index) {
        if (length == 0)
            throw new NoSuchElementException("List is empty");
        else if (index < 0 || index >= length)
            throw new IndexOutOfBoundsException("Index parameter is out of bound");

        E removedData = null;
        if (index == 0) {
            removedData = head.getData();
            head = head.getNext();
            if (length == 1)
                tail = head;
        } else {
            Node<E> cursor = head;
            for (int cursorIndex = 0; cursorIndex != index - 1; cursorIndex++)
                cursor = cursor.getNext();
            removedData = cursor.getNext().getData();
            cursor.setNext(cursor.getNext().getNext());
            if (index == length - 1)
                tail = cursor;
        }
        length--;
        return removedData;
    }

    public E removeFirst() {
        return remove(0);
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    private static class Node<E> {
        E data;
        Node<E> next;

        private Node(E data, Node<E> next) {
            this(data);
            this.next = next;
        }

        private Node(E data) {
            this.data = data;
        }

        private E getData() {
            return data;
        }

        private void setData(E data) {
            this.data = data;
        }

        private Node<E> getNext() {
            return next;
        }

        private void setNext(Node<E> next) {
            this.next = next;
        }
    }
}
