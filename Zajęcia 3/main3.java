import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class main3{
    static int substring(String a, String b)
    {
        int out_ = a.length()/b.length();
        boolean FoundBInA = false;
        int InitialPosition;
        for(InitialPosition = 0; InitialPosition < b.length(); InitialPosition++)
        {
            if(b.charAt(InitialPosition) == a.charAt(0))
            {
                if(InitialPosition != 0)
                    out_ = out_ + 1;
                FoundBInA = true;
                break;

            }
        }
        if(FoundBInA == false)
            return -1;
        int i = InitialPosition;
        for(int j = 0; i < a.length(); i++, j++)
        {

            if(a.charAt(j) != b.charAt(i % b.length()))
                return -1;
        }
        if(i % b.length() != b.length())
            out_ = out_ + 1;

            return out_;
    }


    public static void main(String[] args){
        String a = "cdabcdab";
        String b = "abcd";
        System.out.println(substring(a,b));
    }
}
