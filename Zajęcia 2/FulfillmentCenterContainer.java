import javax.swing.text.html.parser.Entity;
import java.util.*;
public class FulfillmentCenterContainer {
    Map<String, FulfillmentCenter> magazyny = new HashMap<String, FulfillmentCenter>();

    void addCenter(String _nazwa, double _pojemność)
    {
        System.out.println("Dodawanie Fulfillment Center...");
        FulfillmentCenter FFC = new FulfillmentCenter(_nazwa, _pojemność);
        magazyny.put(_nazwa, FFC);
    }

    void removeCenter(String _nazwa)
    {
        System.out.println("Usuwanie Fulfillment Center...");
        magazyny.remove(_nazwa);
    }

    List<FulfillmentCenter> findEmpty()
    {
        System.out.println("Szukanie pustych Fulfillment Center");
        List<FulfillmentCenter> list_ = new ArrayList<FulfillmentCenter>();

        for(FulfillmentCenter FC : magazyny.values())
        {
            if(FC.lista_produktów.isEmpty())
            {
                list_.add(FC);
            }
        }

        return list_;
    }

    void summary()
    {
        System.out.println("Podsumowanie:");
        for(Map.Entry<String, FulfillmentCenter> wpis : magazyny.entrySet())
        {
            System.out.print(wpis.getKey() + " ");
            System.out.print(100*wpis.getValue().aktualnie_magazynowana_masa/wpis.getValue().maksymalna_pojemność_magazynu);
            System.out.println("%");
        }
    }
}
