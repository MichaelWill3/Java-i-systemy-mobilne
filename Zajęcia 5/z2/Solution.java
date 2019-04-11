package z2;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    static int solution(List<Integer> a) throws InvalidArraySizeException, InvalidArrayElementException {
        if(a.size() > 100000)
            throw new InvalidArraySizeException(1);
        int output_ = 1;
        Collections.sort(a);
        System.out.println(a);
        for(int list_element : a)
        {
            if(list_element > 1000000 || list_element < -1000000)
                throw new InvalidArrayElementException(2);

            if(list_element>output_)
                return output_;
            else output_ = list_element + 1;
        }
        return output_;
    }

    //public static void main(String[] args){
    //    List<Integer> list = new ArrayList<Integer>();
    //    list.add(7);
    //    list.add(2);
    //    list.add(3);
    //    list.add(3);
    //    list.add(2);
    //    list.add(5);
    //    list.add(1);
    //    list.add(4);
    //    list.add(6);
    //    try {
    //        int ToPrint = solution(list);
    //
    //        System.out.println(ToPrint);
    //    }
    //    catch(InvalidArraySizeException error)
    //    {
    //        System.out.println(error);
    //    }
    //    catch(InvalidArrayElementException error)
    //    {
    //        System.out.println(error);
    //    }
    //}
}
