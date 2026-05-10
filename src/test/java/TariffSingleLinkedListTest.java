import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TariffSingleLinkedListTest {

    private List<Tariff> list;
    private Tariff t1;
    private Tariff t2;
    private Tariff t3;

    @BeforeEach
    public void setUp() {
        list = new TariffSingleLinkedList();
        t1 = new Tariff("Tariff 1", 100, 1000);
        t2 = new Tariff("Tariff 2", 200, 2000);
        t3 = new Tariff("Tariff 3", 300, 3000);

    }

    @Test
    public void testEmptyConstructor() {
        assertTrue(list.isEmpty());
        assertEquals(list.size(), 0);
    }

    @Test
    public void testAddAndGet() {
        list.add(t1);
        list.add(t2);
        list.add(t3);

        assertEquals(3, list.size());
        assertEquals(t1, list.get(1));
        assertEquals(t2, list.get(2));
        assertEquals(t3, list.get(3));
    }

    @Test
    void testRemoveFirstElement() {
        list.add(t1);
        list.add(t2);

        Tariff removed = list.remove(0);

        assertEquals(t1, removed);
        assertEquals(1, list.size(), "Size should decrease to 1");
        assertEquals(t2, list.get(0), "Second element should change to index 0");
    }

    @Test
    void testRemoveMiddleElement() {
        list.add(t1);
        list.add(t2);
        list.add(t3);

        Tariff removed = list.remove(1);

        assertEquals(t2, removed);
        assertEquals(2, list.size() );
        assertEquals(t3, list.get(1) );
    }

    @Test
    void testCollectionConstructor() {
        List<Tariff> standardList = new ArrayList<>();
        standardList.add(t1);
        standardList.add(t2);

        List<Tariff> customList = new TariffSingleLinkedList(standardList);

        assertEquals(2, customList.size());
        assertEquals(t1, customList.get(0));
    }

    @Test
    void testClear() {
        list.add(t1);
        list.add(t2);
        list.clear();

        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0), "Using get() in clear list should throw IndexOutOfBoundsException");

    }
    @Test
    void testOutOfBoundsExceptions() {
        list.add(t1);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
    }
}
