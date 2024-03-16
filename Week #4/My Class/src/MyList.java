public class MyList<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private T[] arr;
    private int size;

    public MyList() {
        arr = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyList(int capacity) {
        arr = (T[]) new Object[capacity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public int getCapacity() {
        return arr.length;
    }

    public void add(T data) {
        if (size == arr.length) {
            resize();
        }
        arr[size++] = data;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return arr[index];
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = null;
        size--;
    }

    public void set(int index, T data) {
        if (index < 0 || index >= size) {
            return;
        }
        arr[index] = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(arr[i]);
            if (i < size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private void resize() {
        int newSize = arr.length * 2;
        T[] newArr = (T[]) new Object[newSize];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
    }

    public int indexOf(T data) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T[] toArray() {
        T[] newArr = (T[]) new Object[size];
        System.arraycopy(arr, 0, newArr, 0, size);
        return newArr;
    }

    public void clear() {
        arr = (T[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyList<T> sublist(int start, int finish) {
        if (start < 0 || finish >= size || start > finish) {
            return null;
        }
        MyList<T> subList = new MyList<>();
        for (int i = start; i <= finish; i++) {
            subList.add(arr[i]);
        }
        return subList;
    }

    public boolean contains(T data) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(data)) {
                return true;
            }
        }
        return false;
    }


}
