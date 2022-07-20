package pro.sky;

import pro.sky.exceptions.*;

import java.util.Arrays;
import java.util.List;

public class MyArrayListImpl<T extends Comparable <T>> implements MyArrayList<T> {

    private static final int DEFAULT_SIZE = 10;
    private Object[] array;
    int size;

    public MyArrayListImpl(List<T> listOfObjects) {
        array = new Object[listOfObjects.size()];
        for(int i = 0; i < listOfObjects.size(); i++) {
            array[i] = listOfObjects.get(i);
        }
        size = listOfObjects.size();
    }

    private void increaseArraySize(int increment){
        Object[] newArray = new Object[size + increment];
        System.arraycopy(this.array, 0, newArray, 0, size);
        this.array = newArray;
    }

    public MyArrayListImpl() {
        this.array = new Object[DEFAULT_SIZE];
        this.size = 0;
    }

    public MyArrayListImpl(int size) {
        if(size > 0) {
            this.array = new Object[size];
            this.size = 0;
        } else if(size == 0) {
            this.array = new Object[DEFAULT_SIZE];
            this.size = 0;
        } else
            throw new IllegalArrayListSizeException("Illegal MyArrayList class constructor argument size = " + size);

    }

    @Override
    public T add(T item) {
        if(item == null)
            throw new NullArgumentException("Illegal MyArrayList class add() method argument item = null");
        if (this.size == this.array.length) {
            this.increaseArraySize(DEFAULT_SIZE);
        }
        this.array[size] = item;
        this.size++;
        return (T)this.array[size-1];
    }

    @Override
    public T add(int index, T item) {
        if(item == null)
            throw new NullArgumentException("Illegal MyArrayList class add() method argument item = null");
        if(index < 0 || index >= size)
            throw new WrongIndexException("Illegal MyArrayList class add() method argument index = " + index);
        if(size == array.length)
            increaseArraySize(DEFAULT_SIZE);
        for(int i = size-1; i >= index; i--)
            array[i+1] = array[i];
        array[index] = item;
        size++;

        return (T)array[index];
    }

    @Override
    public T set(int index, T item) {
        if(item == null)
            throw new NullArgumentException("Illegal MyArrayList class set() method argument item = null");
        if(index < 0 || index >= size)
            throw new WrongIndexException("Illegal MyArrayList class set() method argument index = " + index);
        array[index] = item;
        return (T)array[index];
    }

    @Override
    public T remove(T item) {
        int index = this.indexOf(item);
        if(index == -1)
            throw new ElementNotFoundInTheArrayListException("Such item is not found in the MyArrayList by remove() method");
        return this.remove(index);
    }

    @Override
    public T remove(int index) {
        if(index < 0 || index >= size)
            throw new WrongIndexException("Illegal MyArrayList class remove() method argument index = " + index);
        Object item = array[index];
        for(int i = index; i < size-1; i++){
            array[i] = array[i+1];
        }
        size--;
        return (T)item;
    }

    @Override
    public boolean contains(T item) {
        for(int i = 0; i < size; i++){
            if(array[i].equals(item))
                return true;
        }
        return false;
    }

    @Override
    public boolean containsByBinarySearch(T item) {
        MyArrayList<T> newArray = new MyArrayListImpl<>();
        for (int i = 0; i < size; i++) {
            newArray.add((T)array[i]);
        }
        this.sortByChoosingMin(newArray);
        int min = 0;
        int max = newArray.size() - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item.compareTo(newArray.get(mid)) == 0) {
                return true;
            }

            if (item.compareTo(newArray.get(mid)) < 0)  {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(T item) {
        if(item == null)
            throw new NullArgumentException("Illegal argument in MyArrayList method indexOf() item = null");
        for(int i = 0; i < size; i++){
            T arrayElement = (T) this.array[i];
            if(item.equals(arrayElement))
                return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T item) {
        for(int i = size-1; i >= 0; i--){
            if(array[i].equals(item))
                return i;
        }
        return -1;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size)
            throw new WrongIndexException("Illegal MyArrayList class remove() method argument index = " + index);
        return (T)array[index];
    }

    @Override
    public boolean equals(MyArrayList otherList) {
        if(otherList == null)
            throw new NullArgumentException("Illegal MyArrayList method equals() argument otherList = null");
        if(otherList.size() != this.size())
            return false;
        boolean isEquals = true;
        for(int i = 0; i < this.size(); i++)
            if(!this.get(i).equals(otherList.get(i)))
                isEquals = false;
        return isEquals;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if(a.length != size)
            throw new WrongArraySizeException("Array a in MyArrayList.toArray() method should be the same size as MyArrayList. size()");
        return (T[]) Arrays.copyOf(array, size, a.getClass());
    }

    @Override
    public void sortByChoosingMin(MyArrayList<T> array) {
        for (int i = 0; i < array.size(); i++) {
            T minCurrent = (T) array.get(i); // First element of the current array is the start minimum
            int indexMinCurrent = i; // Index of minimum element
            for(int j = i; j < array.size(); j++) {
                if (minCurrent.compareTo(array.get(j)) > 0) {
                    minCurrent = (T) array.get(j);
                    indexMinCurrent = j;
                }
            }
            T temp = array.get(i);
            array.set(i, array.get(indexMinCurrent));
            array.set(indexMinCurrent, temp);
        }
    }

    @Override
    public void quickSortByRecursion(MyArrayList<T> array, int begin, int end){
        if(begin < end) {
            T pivot = array.get(end);
            int i = begin - 1;
            for(int j = begin; j < end; j++){
                if(array.get(j).compareTo(pivot) <= 0){
                    i++;
                    T temp = array.get(i);
                    array.set(i, array.get(j));
                    array.set(j, temp);
                }
            }
            T temp = array.get(i + 1);
            array.set(i + 1, array.get(end));
            array.set(end, temp);
            int partitionIndex = i + 1;
            quickSortByRecursion(array, begin, partitionIndex - 1);
            quickSortByRecursion(array, partitionIndex + 1, end);
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("MyArrayListImpl{size=");
        str.append(size);
        str.append(", array=[");
        for(int i = 0; i < size-1; i++) {
            str.append(array[i].toString());
            str.append(", ");
        }
        str.append(array[size-1].toString());
        str.append("]}");
        return str.toString();
    }

}
