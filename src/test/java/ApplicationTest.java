package test;

import static org.junit.jupiter.api.Assertions.*;

import Objects.DrawRandom;
import Objects.UserPick;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.TreeSet;
import java.util.Iterator;

public class ApplicationTest
{
    private DrawRandom rand;
    private UserPick up;
    private UserPick upVar;

    @BeforeAll
    void init()
    {
        rand = new DrawRandom(20, 10, 2);
    }

    @Test
    void DrawRandomTest()
    {
        TreeSet<Integer> ts = rand.draw();
        Iterator<Integer> it = ts.iterator();

        assertEquals(ts.size(), 10);

        while(it.hasNext())
        {
            assertTrue((it.next() >= 1) && (it.next() <= 20));
        }
    }

    @Test
    void UserPickTest()
    {
        upVar = new UserPick(3);
        upVar.setNumber(21);
        upVar.setNumber(12);
        upVar.setNumber(56);
        assertEquals(upVar.getNumbers().size(), 2);
        assertEquals(upVar.getNumbers().get(0), 21);
        assertEquals(upVar.getNumbers().get(0), 12);

        up = new UserPick();


    }


}
