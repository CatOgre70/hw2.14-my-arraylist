package pro.sky;

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

    }
}