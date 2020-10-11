package SmartArrayAndCustomStackClasses;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList customList = new LinkedList();

        customList.forEach(i -> System.out.println(i));

        customList.addFirst(12);
        customList.addFirst(21);
        customList.addFirst(43);
        customList.addFirst(56);
        customList.addFirst(78);
        customList.addFirst(112);

        customList.addLast(656);
        customList.addLast(929);

        int cer = customList.removeLast();
        System.out.println(cer);

        customList.removeFirst();


        int temp = customList.get(3);
        System.out.println(temp);
        System.out.println();

        int[] newArr = customList.toArray();

        for (int elem : newArr) {
            System.out.println(elem);
        }

    }
}