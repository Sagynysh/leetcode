import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class randomSampleTest {
    private static randomSample randomSample;

    @Before
    public void testBefore(){
        System.out.println("before");
    }
    @BeforeAll
    public static void initClass(){
        randomSample = new randomSample();
        System.out.println("BeforeAll");
    }

    @Test
    void findKthLargest() {
        System.out.println("Test itself");
        int [] res = new int[]{10,15,1,4,5,6,7,8};
        assertEquals(6,randomSample.findKthLargest(res,5));
    }
}