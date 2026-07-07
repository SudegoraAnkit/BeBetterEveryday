package array;

public class DynamicArray<T> {
    private Object[] data;
    private int size;
    private int capacity;

    public DynamicArray() { this(10); }
    public DynamicArray(int initialCapacity) {
        this.capacity = initialCapacity;
        this.data = new Object[capacity];
        this.size = 0;
    }

    public void add(T element) { 
        /* Implement resize at 100% capacity (grow 1.5x) */
        if(size == capacity) {
            resize();
        }
        data[size++] = element;
    }
    private void resize() {
        capacity = (int) (capacity * 1.5); //because int will remove decimal value and it will take only integer value
        Object[] newData = new Object[capacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }
    public void add(int index, T element) {
         /* Shift right, insert */ 
        if(index < 0 || index > size) {

            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        data[index] = element;
    }
    @SuppressWarnings("unchecked")
    public T get(int index) { 
        /* O(1) read, range check */ 
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) data[index];
    }
    public T remove(int index) { 
        /* Shift left, clear last reference to avoid memory leaks */ 
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T removedElement = (T) data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null; // Clear last reference
        return removedElement;
    }
    public int size() { 
        return size; 
    }
}
