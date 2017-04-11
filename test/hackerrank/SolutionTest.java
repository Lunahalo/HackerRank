package hackerrank;

import bstchecker.Solution;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Jared
 */
public class SolutionTest {
    
    public SolutionTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testArrayLeftRotation() {
        System.out.println("Testing arrayLeftRotation()");
        //Odd length
        int[] a;
        a = new int[] {1,2,3,4,5};
        int n = 5;
        int k = 4;
        int[] expResult;
        expResult = new int[] {5,1,2,3,4};
        int[] result;
        result = Solution.arrayLeftRotation(a, n, k);
        assertArrayEquals(expResult, result);
        //Even length
        a = new int[] {1,2,3,4};
        expResult = new int[] {3,4,1,2};
        n = 4;
        k = 2;
        result = Solution.arrayLeftRotation(a, n, k);
        assertArrayEquals(expResult, result);
      
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testWrapOffset() {
        System.out.println("Testing getOffset()");
        int arrayLegth = 0;
        int source = 0;
        int offset = 0;
        Solution instance = new Solution();
        //Loop back to beginning
        int expResult = 3;
        int result = instance.wrapOffset(4, 3, 4);
        assertEquals(expResult, result);
        //Loop to 0 index
        expResult = 0;
        result = instance.wrapOffset(4, 3, 3);
        assertEquals(expResult, result);
        //Loop around to end
        expResult = 3;
        result = instance.wrapOffset(4, 0, 1);
        assertEquals(expResult, result);
        //Loop 
        expResult = 3;
        result = instance.wrapOffset(4, 1, 2);
        assertEquals(expResult, result);
    }

    @Ignore
    @Test
    public void testMain() throws Exception {
        System.out.println("main");
        String[] args = null;
        Solution.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
