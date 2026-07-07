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
        if(size == capacity) {
            resize();
        }
        data[size++] = element;
    }
    
    private void resize() {
        // Fix for capacity 0 or 1 edge cases
        capacity = capacity <= 1 ? 10 : (int) (capacity * 1.5);
        Object[] newData = new Object[capacity];
        System.arraycopy(data, 0, newData, 0, size);
        data = newData;
    }
    
    public void add(int index, T element) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        
        // Ensure capacity before shifting
        if(size == capacity) {
            resize();
        }
        
        // Shift elements to the right to make room
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }
    
    @SuppressWarnings("unchecked")
    public T get(int index) { 
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) data[index];
    }
    
    @SuppressWarnings("unchecked")
    public T remove(int index) { 
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        T removedElement = (T) data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null; // Clear last reference to avoid memory leaks
        return removedElement;
    }
    
    public int size() { 
        return size; 
    }
}
