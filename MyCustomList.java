public class MyCustomList implements CustomList{
    private static int defaultCapasity = 10;
    private Object[] data;
    private int size;

    public MyCustomList(int initialCapasity) {
        data = new Object[initialCapasity];
        size = 0;
    }

    public MyCustomList() {
        data = new Object[defaultCapasity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object element) {
        int i = 0;
        while ((i < data.length) && (!element.equals(data[i])))
            i++;
        return i != data.length;
    }

    private boolean checkCapacity(int neсessarySize) {
        if (neсessarySize > data.length) {
            Object[] newData = new Object[data.length * 2];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
        return true;
    }

    public boolean add(Object element) {
        checkCapacity(size + 1);
        data[size++] = element;
        return true;
    }

    public boolean remove(Object element) {
        int i = 0;
        while ((i < size) && (element.equals(data[i]) == false))
            i++;
        if (i != size) {
            System.arraycopy(data, i + 1, data, i, size - i - 1);
            data[--size] = null;
            return true;
        }
        else
            return false;
    }

    public boolean containsAll(MyCustomList anotherMyCustomList) {
        if (anotherMyCustomList == null)
            return false;
        if (size != anotherMyCustomList.size)
            return false;
        if (anotherMyCustomList == this)
            return false;
        int i = 0;
        while ((i < size) && (data[i] == anotherMyCustomList.data[i]))
            i++;
        if (i == size)
            return true;
        else
            return false;
    }

    public boolean containsSublist(MyCustomList anotherMyCustomList) {
        if (size == anotherMyCustomList.size)
            containsAll(anotherMyCustomList);
        if (anotherMyCustomList == null)
            return false;
        if (size < anotherMyCustomList.size)
            return false;
        for (int i = 0; i < size - anotherMyCustomList.size; i++) {
            Object[] check = new Object[anotherMyCustomList.size];
            System.arraycopy(data, i, check, 0, anotherMyCustomList.size);
            if (anotherMyCustomList.data.equals(check) == true)
                return true;
        }
        return false;
    }

    private boolean checkIndex(int index) {
        if ((index < 0) || (index >= size - 1))
            return false;
        return true;
    }

    public Object get(int index) {
        if (checkIndex(index) == false)
            return null;
        else
            return data[index];
    }
}
