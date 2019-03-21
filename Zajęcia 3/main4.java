import java.util.Collections;
import java.util.Arrays;
public class main4 {

    static int[] solution (float[] arr, float target) throws NoSuchPairInArrayException{
        int first = 0;
        int second = 0;
        boolean found = false;
        for(int i = 0; i < arr.length; i++)
        {
            Arrays.sort(arr);
            int result = Arrays.binarySearch(arr,target-arr[i]);
            if(result >= 0)
            {
                first = result;
                second = i;
                if(first != second)
                    found = true;
            }

        }
        if(!found)
        {
            throw new NoSuchPairInArrayException();
        }
        int [] out_ = {first, second};
        return out_;
    }
    public static void main(String[] args){
        float[] arr = {2, 7, 11, 15};
        float target = 18;
        try {
            int[] res = solution(arr, target);
            System.out.println("[" + res[0] + ", " + res[1] + "]");
        }
        catch(NoSuchPairInArrayException error)
        {
            System.out.println(error);
        }
    }
}
