package z3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubstringTest extends Substring {

    @Test
    void substring() {
        assertEquals(4, substring("ananas", "asananasananasan"));
    }
}