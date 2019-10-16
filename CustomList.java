public interface CustomList {
    int size();
    boolean isEmpty();
    boolean contains(Object element);
    boolean add(Object element);
    boolean remove(Object element);
    boolean containsAll(MyCustomList anotherMyCustomList);
    boolean containsSublist(MyCustomList anotherMyCustomList);
    Object get(int index);
}
