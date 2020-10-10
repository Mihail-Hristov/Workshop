package SmartArrayClass;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        SmartArray list = new SmartArray();

        list.add(2);
        list.add(10);
        list.add(34);
        list.add(71);
        list.add(1112);
        list.add(34);
        list.add(43);
        list.add(25);
        list.add(87);
        list.add(98);
        list.add(103);

        int current = list.get(3);

        System.out.println(current);

        for (int i = 0; i < 6; i++) {
            int temp = list.remove(1);
            System.out.println(temp);
        }

        list.add(2, 434);

        boolean chek = list.contains(222);

        System.out.println(chek);


    }


}
