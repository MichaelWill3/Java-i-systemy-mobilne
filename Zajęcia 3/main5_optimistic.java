import java.util.Arrays;
import java.util.Random;

public class main5_optimistic {
    static void bubbleSort(int arr[], int n)
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++)
        {
            swapped = false;
            for (j = 0; j < n - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    // swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // IF no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
            {
                break;
            }
        }

    }
    static void insertSort(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    static void mergeSort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    static void pigeonholeSort(int arr[], int n)
    {
        int min = arr[0];
        int max = arr[0];
        int range, i, j, index;

        for(int a=0; a<n; a++)
        {
            if(arr[a] > max)
                max = arr[a];
            if(arr[a] < min)
                min = arr[a];
        }

        range = max - min + 1;
        int[] phole = new int[range];
        Arrays.fill(phole, 0);

        for(i = 0; i<n; i++)
            phole[arr[i] - min]++;


        index = 0;

        for(j = 0; j<range; j++)
            while(phole[j]-->0)
                arr[index++]=j+min;
    }
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
    static void quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
    public static void main(String[] args)
    {
        int n = 100000;
        int[] array1;
        int[] array2;
        int[] array3;
        int[] array4;
        int[] array5;
        array1 = new int[n];
        array2 = new int[n];
        array3 = new int[n];
        array4 = new int[n];
        array5 = new int[n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            array1[i] = rand.nextInt(100000);
            array2[i] = rand.nextInt(100000);
            array3[i] = rand.nextInt(100000);
            array4[i] = rand.nextInt(100000);
            array5[i] = rand.nextInt(100000);
        }

        quickSort(array1, 0, n - 1);
        quickSort(array2, 0, n - 1);
        quickSort(array3, 0, n - 1);
        quickSort(array4, 0, n - 1);
        quickSort(array5, 0, n - 1);
        System.out.println("n=" + n);

        long tStart2 = System.currentTimeMillis();
        bubbleSort(array1, n);
        long tEnd2 = System.currentTimeMillis();
        long tDelta2 = tEnd2 - tStart2;
        double elapsedSeconds2 = tDelta2 / 1000.0;
        System.out.println("bubbleSort: " + elapsedSeconds2 + "s");

        long tStart1 = System.currentTimeMillis();
        insertSort(array2);
        long tEnd1 = System.currentTimeMillis();
        long tDelta1 = tEnd1 - tStart1;
        double elapsedSeconds1 = tDelta1 / 1000.0;
        System.out.println("insertSort: " + elapsedSeconds1 + "s");

        long tStart3 = System.currentTimeMillis();
        mergeSort(array3, 0, n - 1);
        long tEnd3 = System.currentTimeMillis();
        long tDelta3 = tEnd3 - tStart3;
        double elapsedSeconds3 = tDelta3 / 1000.0;
        System.out.println("mergeSort: " + elapsedSeconds3 + "s");

        long tStart4 = System.currentTimeMillis();
        pigeonholeSort(array4, n);
        long tEnd4 = System.currentTimeMillis();
        long tDelta4 = tEnd4 - tStart4;
        double elapsedSeconds4 = tDelta4 / 1000.0;
        System.out.println("pigeonholeSort: " + elapsedSeconds4 + "s");

        long tStart5 = System.currentTimeMillis();
        quickSort(array5, 0, n - 1);
        long tEnd5 = System.currentTimeMillis();
        long tDelta5 = tEnd5 - tStart5;
        double elapsedSeconds5 = tDelta5 / 1000.0;
        System.out.println("quickSort: " + elapsedSeconds5 + "s");
        }

    }
