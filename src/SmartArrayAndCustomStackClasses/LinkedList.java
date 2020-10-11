package SmartArrayAndCustomStackClasses;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class LinkedList {

    private Node head;
    private Node tail;
    private int size;

    private static class Node {
        private int element;
        private Node next;
        private Node prev;

        private Node(int element) {
            this.element = element;
        }
    }

    public void addFirst(int element) {
        Node newHead = new Node(element);
        if (this.size == 0) {
            this.head = newHead;
            this.tail = newHead;
        }else {
            if (this.size == 1) {
                this.tail.prev = newHead;
            }
            this.head.prev = newHead;
            newHead.next = this.head;
            this.head = newHead;
        }
       this.size ++;
    }

    public int get(int index) {
        checkSize();
        validateIndex(index);
        int element = 0;
        int count = 0;
        Node current = this.head;
        while (current.next != null) {
            if (count++ == index){
                element = current.element;
                break;
            }
            current = current.next;
        }
        return element;
    }

    public void validateIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bound for size " + this.size);
        }
    }

    public int removeFirst() {
        checkSize();

        int firstElement = this.head.element;
        this.head = this.head.next;
        this.head.prev = null;

        size--;
        return firstElement;
    }

    public void forEach(Consumer<Integer> consumer) {
        Node current = this.head;

        while (current != null) {
            consumer.accept(current.element);
            current = current.next;
        }
    }

    public int[] toArray() {
        int[] arr = new int[this.size];
        Node current = this.head;
        int count = 0;
        while (current != null) {
            arr[count++] = current.element;
            current = current.next;
        }
        return arr;
    }

    public void checkSize() {
        if (this.size == 0) {
            throw  new IllegalStateException("The list is empty");
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void addLast(int element) {
        Node newItem = new Node(element);
        if (this.size == 0) {
            this.head = this.tail = newItem;
        }else {
            this.tail.next = newItem;
            this.tail.next.prev = this.tail;
            this.tail = newItem;
        }

        size ++;
    }

    public int removeLast() {
        int result = this.tail.element;

        this.tail.prev.next = null;
        this.tail = this.tail.prev;

        size --;
        return result;
    }

}
