package CustomArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomArrayListTest {

    private CustomArrayList<Integer> list;

    @BeforeEach
    public void beforeEach() {
        list = new CustomArrayList<Integer>();
    }

    @Test
    public void testAddAndGet() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    @Test
    public void testArrayGrow() {
        for(int i = 0; i < 15; i++) {
            list.add(i);
        }
        assertEquals(15, list.size());
    }

    @Test
    public void testArrayDelete() {
        list.add(1);
        list.add(2);
        assertEquals(2, list.size());
        assertEquals(2, list.get(1));
        list.remove(1);
        assertEquals(1, list.size());
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1), "Index of bound");
    }
}
