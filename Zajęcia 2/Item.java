import java.util.Collections;

public class Item implements Comparable<Item>{
    String nazwa;
    ItemCondition stan;
    double masa;
    //int ilość;

    public Item(String _nazwa, ItemCondition _stan, double _masa/*, int _ilość*/)
    {
        System.out.println("Tworzenie obiektu Item");
        nazwa = _nazwa;
        stan = _stan;
        masa = _masa;
        //ilość = _ilość;
    }

    public void print()
    {
        System.out.println("Wypisywanie cech Przedmiotu:");
        System.out.println("Nazwa: " + nazwa);
        System.out.println("Stan: " + stan);
        System.out.println("Masa: " + masa);
        //System.out.println("Ilość: " + ilość);
    }

    @Override
    public int compareTo(Item _item) {
        return this.nazwa.compareTo(_item.nazwa);
    }

    @Override
    public String toString()
    {
        return "Nazwa: " + nazwa + "\n" + "Stan: " + stan.toString() + "\n" + "Masa: " + masa + "\n" + "\n";
    }

    public int ilość(FulfillmentCenter FC)
    {
        return FC.lista_produktów.get(this);
    }
}
