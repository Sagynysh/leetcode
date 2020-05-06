package JUnit;

import leetcode.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    private static Main main;

    @BeforeAll
    public static void initMain(){
        main = new Main();
    }
    @BeforeEach
    public void beforeEachTest() {
        System.out.println("This is executed before each Test");
    }

    @AfterEach
    public void afterEachTest() {
        System.out.println("This is executed after each Test");
    }

    @Test
    public void testSearchInsert() {
        int result = main.searchInsert(new int[]{1,3,5,6}, 5);

        assertEquals(2, result);
    }

    @Test
    public void testSQRT() {
        int result = main.mySqrt(5);

        assertEquals(2, result);
    }

}
