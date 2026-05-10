import java.util.ArrayList;
import java.util.List;
/**
 * Entry point for the executive class
 * Creates a custom single linked list with Tariffs as objects,
 * performing main functional methods, adding, removing, getting, etc.
 */
public class Main {
    public static void main(String[] args) {

    Tariff t1 = new Tariff("Extra LTE", 200, 150000);
    Tariff t2 = new Tariff("Business Blue", 350, 54000);
    Tariff t3 = new Tariff("Unlimited", 300, 1650000);

        List<Tariff> emptyList = new TariffSingleLinkedList();
        emptyList.add(t1);
        System.out.println("Empty list size: " + emptyList.size());
        System.out.printf("Element of the empty list: " + emptyList.get(0));
        System.out.println();


        List<Tariff> singleList = new TariffSingleLinkedList(t2);
        singleList.add(t1);
        System.out.println("Single list size: " + singleList.size());
        System.out.println(singleList.remove(0));
        System.out.println("Single list size after object removal: " + singleList.size());
        System.out.println();


        List<Tariff> defaultList = new ArrayList<>();
        defaultList.add(t1);
        defaultList.add(t2);
        defaultList.add(t3);
        List<Tariff> collectionList = new TariffSingleLinkedList(defaultList);
        System.out.println("Collection list size: " + collectionList.size());
        System.out.println("Remove second element " + collectionList.get(1));
        collectionList.remove(1);
        System.out.println("Collection list size after removal: " + collectionList.size());
        collectionList.clear();
        System.out.println("Collection list size after using clear(): " +  collectionList.size());
        System.out.println("Is collection list empty?: " + collectionList.isEmpty());

    }
}
