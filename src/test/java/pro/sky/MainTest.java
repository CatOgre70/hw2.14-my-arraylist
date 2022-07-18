package pro.sky;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.exceptions.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private final MyArrayList<String> test = new MyArrayListImpl<>();

    private static final String TEST_STRING_1 = "Вася решает, а папа сдает!";
    private static final String TEST_STRING_2 = "Где это видано, где это слышано";
    private static final String TEST_STRING_3 = "Папа решает, а Вася сдает";


    @BeforeEach
    public void myArrayListInit(){
        test.add("");
        test.add("abc");
        test.add("Папа у Васи силен в математике");
        test.add("Учится папа за Васю весь год");
        test.add("Где это видано, где это слышано");
        test.add("Папа решает, а Вася сдает");
    }

    // Добавление элемента.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    // String add(String item);

    @Test
    public void testAdd(){
        int expectedSize = this.test.size()+1;
        assertEquals(TEST_STRING_1, this.test.add(TEST_STRING_1));
        assertEquals(TEST_STRING_1, this.test.get(6));
        assertEquals(expectedSize, this.test.size());
    }

    // Добавление элемента
    // на определенную позицию списка.
    // Если выходит за пределы фактического
    // количества элементов или массива,
    // выбросить исключение.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
    // String add(int index, String item);

    @Test
    public void testAddWithIndex(){
        int expectedSize = test.size()+1;
        assertEquals(TEST_STRING_1, test.add(4, TEST_STRING_1));
        assertEquals(TEST_STRING_1, test.get(4));
        assertEquals(TEST_STRING_2, test.get(5));
        assertEquals(expectedSize, test.size());
    }

    @Test
    public void testAddWithIndexOnException(){
        assertThrows(WrongIndexException.class, () -> test.add(-1, TEST_STRING_1));
        assertThrows(WrongIndexException.class, () -> test.add(test.size(), TEST_STRING_1));
        assertThrows(WrongIndexException.class, () -> test.add(test.size() + 100, TEST_STRING_1));
    }

    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс больше
    // фактического количества элементов
    // или выходит за пределы массива.
    // String set(int index, String item);

    @Test
    public void testSetWithIndex(){
        int expectedSize = test.size();
        assertEquals(TEST_STRING_1, test.set(4, TEST_STRING_1));
        assertEquals(TEST_STRING_1, test.get(4));
        assertEquals(expectedSize, test.size());
    }

    @Test
    public void testSetWithIndexOnException(){
        assertThrows(WrongIndexException.class, () -> test.set(-1, TEST_STRING_1));
        assertThrows(WrongIndexException.class, () -> test.set(test.size(), TEST_STRING_1));
        assertThrows(WrongIndexException.class, () -> test.set(test.size() + 100, TEST_STRING_1));
    }

    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    // String remove(String item);

    @Test
    public void testRemove(){
        int expectedSize = test.size()-1;
        assertEquals(TEST_STRING_2, test.remove(TEST_STRING_2));
        assertEquals(TEST_STRING_3, test.get(4));
        assertEquals(expectedSize, test.size());
    }

    @Test
    public void testRemoveOnException(){
        assertThrows(ElementNotFoundInTheArrayListException.class, () -> test.remove(TEST_STRING_1));
    }

    // Удаление элемента по индексу.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    // String remove(int index);

    @Test
    public void testRemoveByIndex(){
        int expectedSize = test.size()-1;
        assertEquals(TEST_STRING_2, test.remove(4));
        assertEquals(TEST_STRING_3, test.get(4));
        assertEquals(expectedSize, test.size());
    }

    @Test
    public void testRemoveByIndexOnException(){
        assertThrows(WrongIndexException.class, () -> test.remove(16));
        assertThrows(WrongIndexException.class, () -> test.remove(-1));
        assertThrows(WrongIndexException.class, () -> test.remove(test.size()));
    }

    // Проверка на существование элемента.
    // Вернуть true/false;
    // boolean contains(String item);

    @Test
    public void testContains(){
        assertTrue(test.contains(TEST_STRING_2));
        assertTrue(test.contains(TEST_STRING_3));
        assertFalse(test.contains(TEST_STRING_1));
    }

    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    // int indexOf(String item);

    @Test
    public void testIndexOf(){
        assertEquals(4, test.indexOf(TEST_STRING_2));
        assertEquals(5, test.indexOf(TEST_STRING_3));
        assertEquals(-1, test.indexOf(TEST_STRING_1));
    }

    // Поиск элемента с конца.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    // int lastIndexOf(String item);

    @Test
    public void testLastIndexOf(){
        assertEquals(4, test.lastIndexOf(TEST_STRING_2));
        assertEquals(5, test.lastIndexOf(TEST_STRING_3));
        assertEquals(-1, test.lastIndexOf(TEST_STRING_1));
    }

    // Получить элемент по индексу.
    // Вернуть элемент или исключение,
    // если выходит за рамки фактического
    // количества элементов.
    // String get(int index);

    @Test
    public void testGet(){
        assertEquals(TEST_STRING_2, test.get(4));
        assertEquals(TEST_STRING_3, test.get(5));
    }

    @Test
    public void testGetOnException(){
        assertThrows(WrongIndexException.class, () -> test.get(-1));
        assertThrows(WrongIndexException.class, () -> test.get(test.size()));
        assertThrows(WrongIndexException.class, () -> test.get(test.size()+100));
    }

    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.
    // boolean equals(StringList otherList);

    @Test
    public void testEquals(){
        MyArrayList<String> test1 = new MyArrayListImpl<>();
        test1.add("");
        test1.add("abc");
        test1.add("Папа у Васи силен в математике");
        test1.add("Учится папа за Васю весь год");
        test1.add("Где это видано, где это слышано");
        test1.add("Папа решает, а Вася сдает");
        assertTrue(this.test.equals(test1));
        test1.set(0, "abc");
        assertFalse(this.test.equals(test1));
    }

    @Test
    public void testEqualsOnException(){
        assertThrows(NullArgumentException.class, () -> test.equals(null));
    }

    // Вернуть фактическое количество элементов.
    // int size();

    @Test
    public void testSize(){
        assertEquals(6, test.size());
        test.clear();
        assertEquals(0, test.size());
        test.add("abc");
        assertEquals(1, test.size());
    }

    // Вернуть true,
    // если элементов в списке нет,
    // иначе false.
    // boolean isEmpty();

    @Test
    public void testIsEmpty(){
        assertFalse(test.isEmpty());
        test.clear();
        assertTrue(test.isEmpty());
    }

    // Удалить все элементы из списка.
    // void clear();

    @Test
    public void testClear(){
        test.clear();
        assertTrue(test.isEmpty());
    }

    // Создать новый массив
    // из строк в списке
    // и вернуть его.
    // String[] toArray();

    @Test
    public void testToArray(){
        String[] expected = new String[]{
                "",
                "abc",
                "Папа у Васи силен в математике",
                "Учится папа за Васю весь год",
                "Где это видано, где это слышано",
                "Папа решает, а Вася сдает"
        };
        String[] result = new String[test.size()];
        result = test.toArray(result);
        boolean isArraysEquals = true;
        for(int i = 0; i < test.size(); i++) {
            if(!result[i].equals(expected[i]))
                isArraysEquals = false;
        }
        assertTrue(isArraysEquals);
    }

    @Test
    public void testToArrayOnWrongArraySizeException(){
        String[] result = new String[test.size()+1];
        assertThrows(WrongArraySizeException.class, () -> test.toArray(result));
    }

    @Test
    public void testSortByChoosingMethod(){
        MyArrayList<Integer> expected = new MyArrayListImpl<>(List.of(2, 5, 15, 35, 60, 81, 123, 216));
        MyArrayList<Integer> result = new MyArrayListImpl<>(List.of(123, 15, 5, 216, 2, 60, 81, 35));
        result.sortByChoosingMin(result);
        assertTrue(expected.equals(result));
    }

    @Test
    public void testContainsByBinarySearch(){
        MyArrayList<Integer> intTest = new MyArrayListImpl<>(List.of(123, 15, 5, 216, 2, 60, 81, 35));
        assertTrue(intTest.containsByBinarySearch(216));
    }

}
