package pl.edu.agh.xp;


import org.junit.Test;
import static org.junit.Assert.*;

public class MainTest {

    @Test
    public void testIfHelloWorks() {
        try {
            new Main();
        } catch (Exception e) {
            fail("Construction failed.");
        }
    }
}