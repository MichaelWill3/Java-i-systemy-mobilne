package z4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest extends Solution {

    @Test
    void NoSuchPairInArrayExceptionTest()
    {
        assertEquals(true, NoSuchPairInArrayExceptionInvoke());
    }

    boolean NoSuchPairInArrayExceptionInvoke() {
        float[] arr = {2, 7, 11, 15};
        float target = 600;

        try {
            int[] res = solution(arr, target);
            System.out.println("[" + res[0] + ", " + res[1] + "]");
        } catch (NoSuchPairInArrayException e) {
            return true;
        }
        return false;
    }
    @Test
    void solution() throws NoSuchPairInArrayException {
        float[] arr = {2, 7, 11, 15};
        float target = 9;

        assertArrayEquals(new int[]{0,1}, solution(arr, target));
    }

}