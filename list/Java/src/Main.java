import ds.linear.list.DoublyCircularLinkedList;
import ds.linear.list.SinglyLinkedList;

public class Main {
    public static void main(String[] args){
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
        System.out.println();

        DoublyCircularLinkedList<Integer> list2 = new DoublyCircularLinkedList<>();

        list2.add(0, 0);
        list2.add(1, 3);
        list2.add(1, 1);
        list2.add(2, 2);

        // standrad output result: 0 1 2 3
        while (list2.size() != 0)
            System.out.print(list2.removeFirst() + " ");
        System.out.println();
    }
}
