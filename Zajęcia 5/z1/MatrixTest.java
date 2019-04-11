package z1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixTest extends Matrix {
    double[] array = new double[]{1,3,2,5,6,78,5,2.6, 0};
    Matrix M = new Matrix(3,3, array);

    @Test
    void returnMatrix() {
        assertArrayEquals(array, M.values());
    }

    @org.junit.jupiter.api.Test
    void add() {
        M.add(array);
        for(double item : array) { item = 2*item; }
        assertArrayEquals(array, M.values());
    }
}