package pl.edu.agh.xp;


import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testIfAppWorks() {
        try {
            new Main();
        } catch (Exception e) {
            fail("Construction failed.");
        }
    }
}