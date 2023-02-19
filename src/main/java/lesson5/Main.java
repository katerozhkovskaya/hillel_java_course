package main.java.lesson5;

public class Main {
    public static void main(String[] args) {
        MyList list1 = new MyList();
        list1.add("1"); //--0
        list1.add("2"); //--1
        list1.add("3"); //--2
        list1.add("4"); //--3
        list1.add("5"); //--4
        list1.add("6"); //--5
        list1.add("7"); //--6
        list1.add("8"); //--7
        list1.add("9"); //--8
        list1.add("10"); //--9
        list1.add("11"); //--10
        list1.add("12"); //--11
        System.out.println(list1.size());

        String[] test = list1.getAll();
        for (int i = 0; i < test.length; i++) {
            System.out.println("print el" + i + " " + test[i]);
        }

        System.out.println(list1.remove(3));
        System.out.println(list1.size());
        String[] test2 = list1.getAll();
        for (int i = 0; i < test2.length; i++) {
            System.out.println("print el" + i + " " + test2[i]);
        }
    }
}
