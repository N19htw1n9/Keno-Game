import Objects.DrawRandom;
import Objects.UserPick;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import java.util.TreeSet;

public class ApplicationTest {
    private DrawRandom rand;
    private UserPick up;
    private UserPick upVar;

    @Test
    public void DrawRandomTest() {
        rand = new DrawRandom(20, 10, 2);

        TreeSet<Integer> ts = rand.draw();

        assertEquals(ts.size(), 10);
        assertEquals(rand.getMax(), 20);
        assertEquals(rand.getDraws(), 10);
        assertEquals(rand.getNumDraws(), 2);

        rand.setMax(30);
        rand.setDraws(12);
        rand.setNumDraws(3);
        assertEquals(rand.getMax(), 30);
        assertEquals(rand.getDraws(), 12);
        assertEquals(rand.getNumDraws(), 3);
        assertEquals(ts.size(), 10);

        for (int val : ts) {
            assertTrue((val >= 1) && (val <= 20));
            assertTrue((val >= 1) && (val <= 20));
        }
    }

    @Test
    public void UserPickTest() {
        upVar = new UserPick(3);
        upVar.setNumber(21);
        assertEquals(upVar.getNumbers().size(), 1);
        assertEquals(upVar.getNumbers().get(0), 21);
        assertEquals(upVar.getNumbers().get(0), 21);
        assertEquals(upVar.getSpots(), 3);

        up = new UserPick();
        up.setSpots(10);
        assertEquals(up.getNumbers().size(), 0);
        up.randomPick();
        assertEquals(up.getNumbers().size(), 10);

        Set<Integer> set = new HashSet<>();
        Set<Integer> duplicateElements = new HashSet<>();

        for (Integer element : up.getNumbers())
            if (!set.add(element))
                duplicateElements.add(element);

        assertTrue(duplicateElements.isEmpty());

        for (int k = 0; k < up.getNumbers().size(); k++)
            assertTrue((up.getNumbers().get(k) <= 80) && (up.getNumbers().get(k) >= 1));

        up.setSpots(15);
        assertEquals(up.getNumbers().size(), 10);
        up.randomPick();
        assertEquals(up.getNumbers().size(), 15);

        Set<Integer> set2 = new HashSet<>();
        Set<Integer> duplicateElements2 = new HashSet<>();

        for (Integer element : up.getNumbers())
            if (!set2.add(element))
                duplicateElements2.add(element);

        assertTrue(duplicateElements2.isEmpty());

        for (int k = 0; k < up.getNumbers().size(); k++)
            assertTrue((up.getNumbers().get(k) <= 80) && (up.getNumbers().get(k) >= 1));

        assertEquals(up.getSpots(), 15);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(11);
        list.add(22);
        list.add(33);
        up.setNumbers(list);
        assertEquals(up.getNumbers().size(), 3);

        for (int k = 0; k < up.getNumbers().size(); k++)
            assertEquals(up.getNumbers().get(k), list.get(k));
    }
}