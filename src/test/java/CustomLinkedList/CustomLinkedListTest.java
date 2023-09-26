package CustomLinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CustomLinkedListTest {

    private CustomLinkedList<Integer> linkedList;

    @BeforeEach
    public void setUp() {
        linkedList = new CustomLinkedList<Integer>();
    }

    @Test
    public void testEmptyListSize() {
        assertEquals(0, linkedList.size());
    }

    @Test
    public void testAddElement() {
        linkedList.add(42);
        assertEquals(1, linkedList.size());
    }

    @Test
    public void testAddAndGetElement() {
        linkedList.add(42);
        assertEquals(42, linkedList.get(0));
    }

    @Test
    public void testRemoveElement() {
        linkedList.add(42);
        linkedList.remove(0);
        assertEquals(0, linkedList.size());
    }

    @Test
    public void testGetFirstElement() {
        linkedList.add(42);
        linkedList.add(100);
        assertEquals(42, linkedList.getFirst());
    }

    @Test
    public void testGetLastElement() {
        linkedList.add(42);
        linkedList.add(100);
        assertEquals(100, linkedList.getLast());
    }

    @Test
    public void testRemoveElementAtIndex() {
        linkedList.add(42);
        linkedList.add(100);
        linkedList.add(7);

        linkedList.remove(1);

        assertEquals(2, linkedList.size());
        assertEquals(42, linkedList.get(0));
        assertEquals(7, linkedList.get(1));
    }

    @Test
    public void testOutOfBoundsIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.add(42);
            linkedList.get(1);
        });
    }
}
