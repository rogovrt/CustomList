public class CustomList {
    protected static int defaultCapasity = 10;
    protected Object[] data;
    protected int size;

    public CustomList(int initialCapasity) {
        data = new Object[initialCapasity];
        size = 0;
    }

    public CustomList() {
        data = new Object[defaultCapasity];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        if (size == 0)
            return true;
        else
            return false;
    }

    public boolean contains(Object element) {
        int i = 0;
        while ((i < data.length) && (element.equals(data[i]) == false))
            i++;
        if (i != data.length)
            return true;
        else
            return false;
    }

    protected boolean checkCapacity(int neсessarySize) {
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

    public boolean containsAll(CustomList anotherCustomList) {
        if (anotherCustomList == null)
            return false;
        if (size != anotherCustomList.size)
            return false;
        int i = 0;
        while ((i < size) && (data[i] == anotherCustomList.data[i]))
            i++;
        if (i == size)
            return true;
        else
            return false;
    }

    public boolean containsSublist(CustomList anotherCustomList) {
        if (size == anotherCustomList.size)
            containsAll(anotherCustomList);
        if (anotherCustomList == null)
            return false;
        if (size < anotherCustomList.size)
            return false;
        int i = 0;
        int k = 0;
        while ((i < size) && (k < anotherCustomList.size)) {
            k = 0;
            if (data[i] == anotherCustomList.data[0]) {
                k++;
                int j = 1;
                while ((data[i + j] == anotherCustomList.data[j]) && (i + j < size) && (j < anotherCustomList.size)) {
                    k++;
                    j++;
                }
            }
            i++;
        }
        if (k == anotherCustomList.size)
            return true;
        else
            return false;
    }

    protected boolean checkIndex(int index) {
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
