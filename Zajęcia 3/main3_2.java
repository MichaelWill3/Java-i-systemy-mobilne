import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
class Substring
{
    int substring(String a, String b)
    {
        ArrayList<Integer> InitialSearchPoints = new ArrayList<Integer>();
        int out_;
        boolean FoundBInA = false;
        for(int i = 0; i < b.length(); i++)
        {
            if(b.charAt(i) == a.charAt(0))
            {
                FoundBInA = true;
                InitialSearchPoints.add(i);
            }
        }

        if(FoundBInA == false)
            return -1;
        boolean AddPrefix;
        boolean AddSuffix;

        for(Integer StartPoint : InitialSearchPoints)
        {
            boolean ok = true;
            if(StartPoint == 0)
            {
                AddPrefix = false;
            }
            else
            {
                AddPrefix = true;
            }
            for(int i = 0; i < a.length(); i++)
            {
                if(i != a.length())
                {
                    
                }
                ok = true;
                if(b.charAt((StartPoint + i)%b.length()) != a.charAt(i))
                {
                    ok = false;
                }
            }
            if(ok)
            {
                return out_;
            }
        }
    }
}
public class main3_2{
    //ArrayList<Integer> InitialSearchPoints = new ArrayList<Integer>();
    static int substring(String a, String b)
    {
        ArrayList<Integer> InitialSearchPoints = new ArrayList<Integer>();
        int out_ = a.length()/b.length();
        boolean FoundBInA = false;
        int InitialPosition;
        for(InitialPosition = 0; InitialPosition < b.length(); InitialPosition++)
        {
            if(b.charAt(InitialPosition) == a.charAt(0))
            {
                //if(InitialPosition != 0)
                //    out_ = out_ + 1;
                FoundBInA = true;
                InitialSearchPoints.add(InitialPosition);
                //break;

            }
        }
        if(!FoundBInA)
            return -1;
        for(Integer InitPos : InitialSearchPoints)
        {
            boolean ok = false;
            int i = InitPos;
            for(int j = 0; i < a.length(); i++, j++)
            {
                ok = true;
                if(a.charAt(j) != b.charAt(i % b.length())) {
                    ok = false;
                    break;
                }
            }
            //if(i % b.length() != b.length())
            //    out_ = out_ + 1;
            if(ok)
            {
                return out_;
            }

        }
        return -1;
    }


    public static void main(String[] args){
        String a = "asananasananasananasanan";
        String b = "ananas";
        System.out.println(substring(a,b));
    }
}
