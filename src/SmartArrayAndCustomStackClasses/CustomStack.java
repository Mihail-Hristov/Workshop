package SmartArrayAndCustomStackClasses;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class CustomStack {

    private static final int INITIAL_CAPACITY = 4;

    private int[] items;
    private int size;
    private int capacity;

    public CustomStack() {
        this.capacity = INITIAL_CAPACITY;
        this.items = new int[this.capacity];
        this.size = 0;
    }

    public int getSize() {
        return this.size;
    }

    public void push(int element) {
        if (this.size == this.capacity){
            this.resize();
        }

        this.items[this.size] = element;
        this.size ++;
    }

    public void resize() {
        this.capacity = this.capacity * 2;
        int[] copy = new int[this.capacity];
        for (int i = 0; i < this.size; i++) {
            copy[i] = this.items[i];
        }

        this.items = copy;
    }

    public int pop() {
        checkEmpty();

        int popElement = this.items[this.size - 1];
        this.items[this.size - 1] = 0;
        this.size --;

        return popElement;
    }

    private void checkEmpty() {
        if (this.size == 0){
            throw new NoSuchElementException("CustomStack is empty");
        }
    }

    public int peek() {
        checkEmpty();

        return this.items[this.size - 1];
    }

    public void forEach (Consumer<Integer> consumer) {
        for (int i = this.size - 1; i >= 0; i--) {
            consumer.accept(this.items[i]);
        }
    }
}
