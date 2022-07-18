package pro.sky;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        // String MyArrayList tests
        MyArrayList<String> test = new MyArrayListImpl<>();
        System.out.println("test.contains(\"123\") = " + test.contains("123"));
        test.add("123");
        System.out.println("test.contains(\"123\") = " + test.contains("123"));
        test.remove("123");
        System.out.println("test.size() = " + test.size());

        test.add("");
        test.add("");
        test.add("");
        System.out.println("test = " + test);
        System.out.println("test.size() = " + test.size());
        test.remove("");
        System.out.println("test.size() = " + test.size());
        System.out.println("test.indexOf(\"\") = " + test.indexOf(""));
        test.add("abc");
        test.add("Папа у Васи силен в математике");
        test.add("Где это видано, где это слышано");
        test.add("Папа решает, а Вася сдает");
        test.add(test.indexOf("Где это видано, где это слышано"), "Учится папа за Васю весь год");
        System.out.println("test = " + test);
        test.clear();
        System.out.println("test.size() = " + test.size());
        test.add("Папа у Васи силен в математике");
        test.add("Учится папа за Васю весь год");
        test.add("Где это видано, где это слышано");
        test.add("Папа решает, а Вася сдает");
        System.out.println("test = " + test);
        test.set(test.indexOf("Папа решает, а Вася сдает"), "Вася решает, а папа пьет пиво с мужиками в гараже");
        System.out.println("test = " + test);
        test.add("Потому что Вася - ботан!");
        System.out.println("test = " + test);

        String[] test1 = new String[test.size()];
        test1 = test.toArray(test1);

        // Output the String[] to console
        StringBuilder str = new StringBuilder();
        str.append("test1 = [");
        for(int i = 0; i < test1.length-1; i++){
            str.append(test1[i]);
            str.append(", ");
        }
        str.append(test1[test1.length-1]);
        str.append("]");
        System.out.println(str);

        // Employee MyArrayList tests
        MyArrayList<Employee> test2 = new MyArrayListImpl<>();
        test2.add(new Employee("Иван", "Иванович", "Иванцов", 0, 50_000));
        test2.add(new Employee("Петр", "Иннокентьевич", "Петров", 0, 150_000));
        test2.add(new Employee("Семен", "Семенович", "Горбунков", 1, 101_000));
        test2.add(new Employee("Иннокентий", "Борисович", "Чулков", 1, 120_000));
        test2.add(new Employee("Сергей", "Ануфриевич", "Ябеда", 2, 40_000));
        test2.add(new Employee("Иосиф", "Вахтангович", "Гришин", 2, 91_000));
        test2.add(new Employee("Иван", "Иванович", "Иванов", 3, 50_000));
        test2.add(new Employee("Алибек", "Джунгарович", "Хомяков", 3, 42_000));
        test2.add(new Employee("Рустам", "Ибрагимович", "Сулейбеков", 4, 22_000));
        test2.add(new Employee("Зухра", "Петровна", "Джугашвилли", 4, 173_000));
        test2.add(new Employee("Казбек", "Дмитриевич", "Светлый", 5, 17_500));
        test2.add(new Employee("Сулейман", "Мыколович", "Беспамятный", 5, 23_700));
        test2.add(new Employee("Михайло", "Дмитриевич", "Главко", 6, 110_300));
        test2.add(new Employee("Елена", "Арменовна", "Акопян", 6, 199_999.99));
        test2.add(new Employee("Гюльчатай", "Зурабовна", "Сухова", 7, 69_000));
        test2.add(new Employee("Наталья", "Альбертовна", "Рабинович", 7, 29_794));

        System.out.println("test2 = " + test2);

        Employee e = new Employee("Гюльчатай", "Зурабовна", "Сухова", 7, 69_000);
        System.out.println("test2.indexOf(e) = " + test2.indexOf(e));
        System.out.println("test2.remove(e) = " + test2.remove(e));
        System.out.println("test2.size() = " + test2.size());
        System.out.println("test2.add(14, e) = " + test2.add(14, e));
        System.out.println("test2.size() = " + test2.size());
        Employee e1 = new Employee("Гюльчатай", "Зурабовна", "Сухова", 7, 159_000);
        System.out.println("test2.set(14, e1) = " + test2.set(14, e1));
        System.out.println("test2.isEmpty() = " + test2.isEmpty());
        System.out.println("test2.contains(e1) = " + test2.contains(e1));
        System.out.println("test2.contains(e) = " + test2.contains(e));
        test2.clear();
        System.out.println("test2.contains(e1) = " + test2.contains(e1));
        System.out.println("test2.isEmpty() = " + test2.isEmpty());

        // Homework 2.15 Sort

        // Generate random array of 100 000 integers
        final int MIN_NUMBER = -100_000;
        final int MAX_NUMBER = 100_000;
        MyArrayList<Integer> intArray = new MyArrayListImpl<>(100_000);

        generateNewRandomArray(intArray, MIN_NUMBER, MAX_NUMBER);
        System.out.println("intArray.size() = " + intArray.size());
        // Bubble sort method
        long start = System.currentTimeMillis();
        sortByBubble(intArray);
        printFirst10ElementsOfArray(intArray);
        System.out.println("Время работы пузырькового метода сортировки: " + (System.currentTimeMillis()-start));

        // Sort by choosing min
        generateNewRandomArray(intArray, MIN_NUMBER, MAX_NUMBER);
        System.out.println("intArray.size() = " + intArray.size());
        start = System.currentTimeMillis();
        intArray.sortByChoosingMin(intArray);
        printFirst10ElementsOfArray(intArray);
        System.out.println("Время работы метода сортировки выбором минимального элемента: " + (System.currentTimeMillis()-start));

        // Sort by inserting method
        generateNewRandomArray(intArray, MIN_NUMBER, MAX_NUMBER);
        System.out.println("intArray.size() = " + intArray.size());
        start = System.currentTimeMillis();
        sortByInserting(intArray);
        printFirst10ElementsOfArray(intArray);
        System.out.println("Время работы метода сортировки вставкой: " + (System.currentTimeMillis()-start));

    }

    public static void generateNewRandomArray(MyArrayList<Integer> array, int minNumber, int maxNumber){
        array.clear();
        for (int i = 0; i < 100_000; i++) {
            array.add((int) ((Math.random() * (maxNumber - minNumber)) + minNumber));
        }
    }

    public static void printFirst10ElementsOfArray(MyArrayList array){
        int elementsNumber = Math.min(array.size(), 10);
        System.out.print("Первые " + elementsNumber + " элементов массива: [ ");
        for(int i = 0; i < elementsNumber - 1; i++){
            System.out.print(array.get(i) + ", ");
        }
        System.out.println(array.get(elementsNumber - 1) + " ]");
    }

    public static void sortByBubble(MyArrayList<Integer> array){
        for (int i = 0; i < array.size() - 1 ; i++) {
            for(int j = 0; j < array.size() - 1 - i; j++)
                if(array.get(j) > array.get(j+1)) {
                    int temp = array.get(j+1);
                    array.set(j+1, array.get(j));
                    array.set(j, temp);
                }
        }
    }

    public static void sortByInserting(MyArrayList<Integer> array){
        for (int i = 1; i < array.size(); i++) {
            int temp = array.get(i);
            int j = i;
            while (j > 0 && array.get(j - 1) >= temp) {
                array.set(j, array.get(j - 1));
                j--;
            }
            array.set(j, temp);
        }
    }

}