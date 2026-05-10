import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Custom collection  to store Tariff type objects
 * Based on single linked list
 *
 */
public class TariffSingleLinkedList implements List<Tariff> {
    /**
     * Private class that represents an element of linked list
     */

    private class Node {
        Tariff data;
        Node next;

        public Node(Tariff data) {
            this.data = data;
            next = null;
        }

        public Tariff getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }

    private Node head;
    private int size;

    /**
     * Constructor that creates empty linked list
     */
    public TariffSingleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Constructor that creates linked list and adds a tariff
     * @param singleTariff tariff, that becomes the head of the list
     */
    public TariffSingleLinkedList(Tariff singleTariff) {
        this();
        add(singleTariff);
    }

    /**
     * Constructor that creates linked list filled with tariffs from already existing collection
     * @param collection default collection of tariffs
     */
    public TariffSingleLinkedList(Collection<? extends Tariff> collection) {
        this();
        for (Tariff t : collection) {
            add(t);
        }
    }

    /**
     * Returns the tariff count in the linked list
     * @return size of linked list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the linked list is empty
     * @return true, if list is empty, otherwise false
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }


    /**
     * Adds new tariff in the end of the linked list
     * @param t tariff to be added
     * @return always true
     */
    @Override
    public boolean add(Tariff t){
        Node newNode = new Node(t);
        if(head == null) {
            head = newNode;
            size++;
            return true;
        }
        Node current = head;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        current.next = newNode;
        size++;
        return true;
    }

    /**
     * Clears the list
     */
    public void clear() {
        head = null;
        size = 0;
    }

    /**
     * Returns tariff with certain index
     * @param index position of the element
     * @return tariff object
     * @throws  IndexOutOfBoundsException if given index is out of list's bounds
     */
    @Override
    public Tariff get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node current = head;
        for(int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.data;
    }

    /**
     * Removes the node from the list
     * Connects previous node link to the post-current node, removing the current one
     * @param index position of element
     * @return tariff object
     * @throws IndexOutOfBoundsException if given index is out of list's bounds
     */
    @Override
    public Tariff remove(int index) {
        if(index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        Node previous = null;
        Node current = head;
        if(index == 0) {
            Tariff result = current.data;
            head = head.next;
            size -= 1;
            return result;

        }
        for(int i = 0; i < index; i++) {
            previous = current;
            current = current.getNext();
        }
        previous.next = current.getNext();
        size -= 1;
        return current.data;

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Tariff> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Tariff> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection<? extends Tariff> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }



    @Override
    public Tariff set(int i, Tariff tariff) {
        return null;
    }

    @Override
    public void add(int i, Tariff tariff) {

    }


    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Tariff> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Tariff> listIterator(int i) {
        return null;
    }

    @Override
    public List<Tariff> subList(int i, int i1) {
        return List.of();
    }


}
