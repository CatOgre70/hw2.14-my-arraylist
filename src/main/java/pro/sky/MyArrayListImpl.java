package pro.sky;

import java.util.Arrays;

public class MyArrayListImpl<T> implements MyArrayList<T>{

    private static final int DEFAULT_SIZE = 10;
    private Object[] array;
    int size;

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
            throw new IllegalArgumentException("Illegal MyArrayList class constructor argument size = " + size);

    }

    @Override
    public T add(T item) {
        if(item == null)
            throw new NullPointerException("Illegal MyArrayList class add() method argument item = null");
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
            throw new NullPointerException("Illegal MyArrayList class add() method argument item = null");
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Illegal MyArrayList class add() method argument index = " + index);
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
            throw new NullPointerException("Illegal MyArrayList class set() method argument item = null");
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Illegal MyArrayList class set() method argument index = " + index);
        array[index] = item;
        return (T)array[index];
    }

    @Override
    public T remove(T item) {
        int index = this.indexOf(item);
        if(index == -1)
            throw new RuntimeException("Such item is not found in the MyArrayList by remove() method");
        return this.remove(index);
    }

    @Override
    public T remove(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Illegal MyArrayList class remove() method argument index = " + index);
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
    public int indexOf(T item) {
        if(item == null)
            throw new NullPointerException("Illegal argument in MyArrayList method indexOf() item = null");
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
            throw new IndexOutOfBoundsException("Illegal MyArrayList class remove() method argument index = " + index);
        return (T)array[index];
    }

    @Override
    public boolean equals(MyArrayList otherList) {
        if(otherList == null)
            throw new NullPointerException("Illegal MyArrayList method equals() argument otherList = null");
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
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if(a.length != size)
            throw new RuntimeException("Array a in MyArrayList.toArray() method should be the same size as MyArrayList. size()");
        return (T[]) Arrays.copyOf(array, size, a.getClass());
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
