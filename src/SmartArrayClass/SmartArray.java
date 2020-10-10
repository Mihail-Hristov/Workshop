package SmartArrayClass;

import java.util.function.Consumer;

public class SmartArray {

    private static int INITIAL_CAPACITY = 4;

    private int[] data;
    private int size;
    private int capacity;

    public SmartArray() {
        this.data = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    private void resize() {
        this.capacity = this.capacity * 2;
        int[] copy = new int[this.capacity];

        for (int i = 0; i < this.data.length; i++) {
            copy[i] = this.data[i];
        }

        this.data = copy;
    }

    public void add(int element) {
        if (this.size == this.capacity){
            this.resize();
        }
        this.data[this.size] = element;
        this.size ++;
    }

    private void checkForValidIndex(int index) {
        if (index < 0 || index >= this.size) {
            String message = String.format("Index %d is out of bounds for length %d", index, this.size);
            throw new IndexOutOfBoundsException(message);
        }
    }

    public int get(int index) {
        checkForValidIndex(index);

        return this.data[index];
    }

    public int remove(int index) {
        checkForValidIndex(index);
        int removedElement = this.data[index];
        this.data[index] = 0;
        shift(index);
        this.size --;
        shrink();

        return removedElement;
    }

    private void shift(int index) {
        for (int i = index; i < this.size - 1; i++) {
            this.data[i] = this.data[i + 1];
        }
        this.data[this.size - 1] = 0;

    }

    private void shrink() {
        if (this.size <= this.capacity / 4) {
            this.capacity = this.capacity / 2;
            int[] copy = new int[this.capacity];
            for (int i = 0; i < this.size; i++) {
                copy[i] = this.data[i];
            }
            this.data = copy;
        }
    }

    public void add(int index, int element) {
        checkForValidIndex(index);
        if (this.size == this.capacity){
            this.resize();
        }
        this.size ++;
        shiftRight(index);
        this.data[index] = element;

    }

    private void shiftRight(int index) {
        for (int i = this.size -1; i > index ; i--) {
            this.data[i] = this.data[i - 1];
        }
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.size; i++) {
            if (this.data[i] == element){
                return true;
            }
        }
        return false;
    }

    public void forEach(Consumer<Integer> consumer) {
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.data[i]);
        }


    }

}
