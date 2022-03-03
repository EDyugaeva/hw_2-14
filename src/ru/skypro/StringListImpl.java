package ru.skypro;

import ru.skypro.exceptions.*;

public class StringListImpl implements StringList {
    public int size;
    public String[] arr;

    public StringListImpl() {
        this.arr = new String[10];
    }


    @Override
    public String add(String item) {
        if (item == null) {
            throw new EmptyParameterException("Объект не задан");
        }
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == null) {
                arr[i] = item;
                size++;
                return item;
            }
        }
        throw new IndexOutOfListException("Нет места в листе");
    }

    @Override
    public String add(int index, String item) {
        if (item == null || index <0) {
            throw new EmptyParameterException("Объект не задан или задан не верно");
        }
        arr[index] = item;
        size++;
        for (int i = arr.length-1; i > 1 ; i--) {
            if (arr[i] != null && arr[i - 1] == null) {
                arr[i - 1] = arr[i];
                arr[i] = null;
            }
        }        return item;
    }


    @Override
    public String set(int index, String item) {
        if (item == null || index <0) {
            throw new EmptyParameterException("Объект не задан или задан не верно");
        }
        if (index - 1 > size) {
            throw new MissingNumberException("Нет элемента с таким номером");
        }
        arr[index] = item;


        return item;
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new EmptyParameterException("Объект не задан");
        }
        boolean found = false;
        for (int i = 0; i < size ; i++) {
            if (arr[i].equals(item)) {
                found = true;
                arr[i] = null;
            }

        }
            for (int j = 0; j < size ; j++) {
                if (arr[j] == null) {
                    arr[j] = arr[j+1];
                    arr[j+1] = null;
                }
            }
        if (!found) {
            throw new MissingElementException("Данная строка не найдена");
        }
            return item;


    }

    @Override
    public String remove(int index) {
        if (index <0) {
            throw new EmptyParameterException("Объект задан не верно");
        }
        if (index - 1 > size) {
            throw new MissingNumberException("Нет элемента с таким номером");
        }
        String deletedElement = arr[index];
        arr[index] = null;
        for (int i = 0; i < size ; i++) {
            if (arr[i] == null) {
                arr[i] = arr[i+1];
                arr[i+1] = null;
            }
        }
        return deletedElement;
    }

    @Override
    public boolean contains(String item) {
        if (item == null) {
            throw new EmptyParameterException("Объект не задан");
        }
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        if (item == null) {
            throw new EmptyParameterException("Объект не задан");
        }
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        if (item == null) {
            throw new EmptyParameterException("Объект не задан");
        }
        for (int i = size-1; i > 0; i--) {
            if (arr[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index <0) {
            throw new EmptyParameterException("Объект задан не верно");
        }
        if (index - 1 > size) {
            throw new MissingNumberException("Нет элемента с таким номером");
        }
        return arr[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new EmptyParameterException("Объект не задан");
        }
        if (otherList.isEmpty()) {
            throw new EmptyListException("Сравнение с пустным листом");
        }
        if (size != otherList.size()) {
            return false;
        }
        boolean result = true;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < otherList.size(); j++) {
                if (otherList.get(j) == null) {
                    j--;
                }
                if (!otherList.get(j).equals(arr[i])) {
                    result = false;
                }
            }
        }
        return result;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return arr == null;
    }

    @Override
    public void clear() {
        arr = null;
    }

    @Override
    public String[] toArray(String[] newArray) {
        if (newArray == null) {
            throw new EmptyParameterException("Объект не задан");
        }

        for (int i = 0; i < newArray.length-1; i++) {
            arr[i] = newArray[i];
        }
        return newArray;
    }


}
