package ds.linear.list;

import java.util.*;

public class DoublyCircularLinkedList<E> implements List<E> {

    private Node<E> head;
    private int length;

    private static class Node<E> {
        E data;
        Node<E> next, prev;

        private Node(E data, Node<E> next, Node<E> prev) {
            this(data);
            this.next = next;
            this.prev = prev;
        }

        private Node(E data) {
            this.data = data;
        }

        private E getData() {
            return data;
        }

        private Node<E> getNext() {
            return next;
        }

        public Node<E> getPrev() {
            return prev;
        }

        public void setPrev(Node<E> prev) {
            this.prev = prev;
        }

        private void setNext(Node<E> next) {
            this.next = next;
        }

        private void setData(E data) {
            this.data = data;
        }
    }

    @Override
    public boolean add(E e) {
        add(length, e);
        return true;
    }

    @Override
    public void add(int index, E e) {
        if (index > length || index < 0)
            throw new IndexOutOfBoundsException("Index parameter is out of bound");

        Node<E> newNode = null;
        if (length == 0) {
            newNode = new Node<>(e);
            newNode.setNext(newNode);
            newNode.setPrev(newNode);
            head = newNode;
        } else {
            Node<E> cursor = head;
            for (int cursorIndex = 0; cursorIndex != index; cursorIndex++)
                cursor = cursor.getNext();
            newNode = new Node<>(e, cursor, cursor.getPrev());
            newNode.getNext().setPrev(newNode);
            newNode.getPrev().setNext(newNode);
            if (index == 0)
                head = newNode;
        }
        length++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public E remove() {
        return remove();
    }

    @Override
    public E remove(int index) {
        if (length == 0)
            throw new NoSuchElementException("List is empty");
        else if (index < 0 || index >= length)
            throw new IndexOutOfBoundsException("Index parameter is out of bound");

        E removedData = null;
        if (length == 1) {
            removedData = head.getData();
            head = null;
        } else {
            Node<E> cursor = head;
            for (int cursorIndex = 0; cursorIndex != index; cursorIndex++)
                cursor = cursor.getNext();
            removedData = cursor.getData();
            cursor.getPrev().setNext(cursor.getNext());
            cursor.getNext().setPrev(cursor.getPrev());
            if (index == 0)
                head = cursor.getNext();
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
}
