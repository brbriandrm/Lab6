import java.util.Collection;
import java.util.List;

public class TariffSingleLinkedList implements List<Tariff> {


    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
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

}
