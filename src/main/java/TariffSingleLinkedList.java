import java.util.Collection;
import java.util.List;

public class TariffSingleLinkedList implements List<Tariff> {


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

    public TariffSingleLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public TariffSingleLinkedList(Tariff singleTariff) {
        this();
        add(singleTariff);
    }

    public TariffSingleLinkedList(Collection<? extends Tariff> collection) {
        this();
        for (Tariff t : collection) {
            add(t);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean add(Tariff t){
        Node newNode = new Node(t);
        if(head == null) {
            head = newNode;
        }
        Node current = head;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        current.next = newNode;
        return true;
    }

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


}
