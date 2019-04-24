package z5;

import org.junit.jupiter.api.Test;
import z4.Solution;

import java.time.Duration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class SortingTest extends Solution {
    Sorting sort = new Sorting();
    private int[] arr =  new int[10000];
    Random RNG = new Random();
    void prepare()
    {
        for(int i = 0; i < 10000; i++)
        {
            arr[i] = RNG.nextInt(10000);
        }
    }

    @Test
    void bubbleSort() {
        prepare();
        assertTimeout(Duration.ofMinutes(1), () ->{sort.bubbleSort(arr, 10000);});
    }

    @Test
    void insertSort() {
        prepare();
        assertTimeout(Duration.ofMinutes(1), () ->{sort.insertSort(arr);});
    }

    @Test
    void mergeSort() {
        prepare();
        assertTimeout(Duration.ofMinutes(1), () ->{sort.mergeSort(arr, 0, 9999);});
    }

    @Test
    void pigeonholeSort() {
        prepare();
        assertTimeout(Duration.ofMinutes(1), () ->{sort.pigeonholeSort(arr, 10000);});
    }

    @Test
    void quickSort() {
        prepare();
        assertTimeout(Duration.ofMinutes(1), () ->{sort.quickSort(arr, 0, 9999);});
    }
}