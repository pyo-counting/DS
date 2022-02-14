package ds.linear.list;


import java.util.*;

public class SinglyLinkedList<E> implements List<E> {

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.addFirst(1);
        list1.addFirst(0);
        list1.add(7);
        list1.add(8);
        list1.add(0, -1);
        list1.add(0, -2);
        list1.add(7, 6);
        list1.add(7, 5);

        // Standard output result: -2 -1 0 1 2 3 4 5 6 7 8
        while (list1.size() != 0)
            System.out.print(list1.removeFirst() + " ");
    }

    private Node<E> head, tail;
    private int length;

    @Override
    public boolean add(E e) {
        if (length == 0)
            addFirst(e);
        else {
            Node<E> newNode = new Node<>(e);
            tail.setNext(newNode);
            tail = newNode;
            length++;
        }
        return true;
    }

    @Override
    public void add(int index, E e) {
        if (index > length || index < 0)
            throw new IndexOutOfBoundsException("Index parameter is out of bound");
        else if (index == 0)
            addFirst(e);
        else if (index == length)
            add(e);
        else {
            Node<E> cursor = head;
            for (int cursorIndex = 0; cursorIndex != index - 1; cursorIndex++)
                cursor = cursor.getNext();
            Node<E> newNode = new Node<>(e, cursor.getNext());
            cursor.setNext(newNode);
            length++;
        }
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (length == 0)
            tail = head;
        length++;
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
        else if (index == 0)
            return removeFirst();
        else {
            Node<E> cursor = head;
            E removedData = null;
            for (int cursorIndex = 0; cursorIndex != index - 1; cursorIndex++)
                cursor = cursor.getNext();
            removedData = cursor.getNext().getData();
            cursor.setNext(cursor.getNext().getNext());
            if (index == length - 1)
                tail = cursor;
            length--;
            return removedData;
        }
    }

    public E removeFirst() {
        if (length == 0)
            throw new NoSuchElementException("List is empty");
        else {
            E removedData = head.getData();
            head = head.getNext();
            if (length == 1)
                tail = head;
            length--;
            return removedData;
        }
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
