package z2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest extends Solution {

    boolean InvalidArraySizeExceptionInvoke()
    {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < 1000001; i++)
        {
            list.add(0);
        }
        try {
            solution(list);
        } catch (InvalidArrayElementException e) {
            return false;
        } catch (InvalidArraySizeException e) {
            return true;
        }
        return false;
    }

    @Test
    void InvalidArraySizeExceptionTest()
    {
        assertEquals(true, InvalidArraySizeExceptionInvoke());
    }

}