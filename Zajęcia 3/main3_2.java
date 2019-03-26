import java.util.List;
import java.util.ArrayList;
public class main3_2{
    static int substring(String a, String b)
    {
        //b contains a
        int out_ = -1;
        boolean FOUNDaINb = false;
        ArrayList<Integer> SearchStartingPoints = new ArrayList();
        ArrayList<Integer> out = new ArrayList();
        for(int i = 0; i < a.length(); i++)
        {
            if(a.charAt(i) == b.charAt(0))
            {
                SearchStartingPoints.add(i);
                FOUNDaINb = true;
            }
        }

        int TheRightStartingPointThatDoesNotLetMeDownEvenThoughItCan = -1;
        for(int StartingPoint : SearchStartingPoints)
        {
            boolean ok = true;
            for(int i = 0; i < b.length(); i++)
            {
                if(b.charAt(i) != a.charAt((i+StartingPoint)%a.length()))
                {
                    ok = false;
                }
            }
            if(ok)
            {
                TheRightStartingPointThatDoesNotLetMeDownEvenThoughItCan = StartingPoint;
                break;
            }
        }
        if(TheRightStartingPointThatDoesNotLetMeDownEvenThoughItCan == -1)
            return -1;

        boolean prefix = false;
        boolean suffix = false;
        if(TheRightStartingPointThatDoesNotLetMeDownEvenThoughItCan != 0)
            prefix = true;
        String tmp = b.substring(TheRightStartingPointThatDoesNotLetMeDownEvenThoughItCan);
        if(tmp.length()/a.length() == (int)tmp.length()/a.length())
            suffix = true;

        out_ = (int)tmp.length()/a.length();

        if(suffix)
            out_ = out_ + 1;
        if(prefix)
            out_ = out_ + 1;

        return out_;
    }


    public static void main(String[] args){
        String a = "ananas";
        String b = "asananasananasan";
        System.out.println(substring(a,b));
    }
}
