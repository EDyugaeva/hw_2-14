package ru.skypro;

public class Main {

    public static void main(String[] args) {
        StringList test = new StringListImpl();
        test.add(2,"123");

        for (int i = 0; i < 9; i++) {
            System.out.println(i + ". " + test.get(i));
        }


    }
}
