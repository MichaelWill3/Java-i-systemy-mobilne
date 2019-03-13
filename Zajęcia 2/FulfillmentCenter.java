import javax.management.openmbean.ArrayType;
import java.util.*;

public class FulfillmentCenter {
    FulfillmentCenter(String _nazwa, double _pojemność)
    {
        nazwa_magazynu = _nazwa;
        maksymalna_pojemność_magazynu = _pojemność;
    }
    String nazwa_magazynu;
    Map<Item, Integer> lista_produktów = new HashMap<Item, Integer>();
    double maksymalna_pojemność_magazynu;//masa maksymalna wszystkich produktw
    double aktualnie_magazynowana_masa = 0;

    void addProduct(Item item)
    {
        System.out.println("Dodawanie produktu.");
        if(aktualnie_magazynowana_masa+item.masa > maksymalna_pojemność_magazynu)
            return;
        if(lista_produktów.containsKey(item))
        {
            lista_produktów.put(item, lista_produktów.get(item) + 1);
            aktualnie_magazynowana_masa+=item.masa;
        }
        else
        {
            lista_produktów.put(item, 1);
            aktualnie_magazynowana_masa+=item.masa;
        }
    }

    void getProduct(Item item) {
        System.out.println("Wybieranie produktu.");
        if (lista_produktów.containsValue(item))
            if (lista_produktów.get(item) != 1)
            {
                lista_produktów.put(item, lista_produktów.get(item) - 1);
                aktualnie_magazynowana_masa-=item.masa;
            }
            else
            {
                lista_produktów.remove(item);
                aktualnie_magazynowana_masa-=item.masa;
            }
    }

    void removeProduct(Item item)
    {
        System.out.println("Uwsuwanie produktu.");
        aktualnie_magazynowana_masa-=(item.masa*lista_produktów.get(item));
        lista_produktów.remove(item);
    }

    Item search(String _nazwa_produktu)
    {
        System.out.println("Szukanie produktu o nazwie " + _nazwa_produktu);
        Item item_do_porównania = new Item(_nazwa_produktu, ItemCondition.NEW, 0);
        for(Item item: lista_produktów.keySet())
        {
            if(item.compareTo(item_do_porównania) == 0)
            {
                return item;
            }
        }
        return null;
    }

    List<Item> searchPartial(String _kawałek_nazwy)
    {
        System.out.println("Szukanie nazw produktu zawierającycj \"" + _kawałek_nazwy + "\"");
        List<Item> lista_ = new ArrayList<Item>();
        for(Item item: lista_produktów.keySet())
        {
            if(item.nazwa.toLowerCase().contains(_kawałek_nazwy.toLowerCase()))
            {
                lista_.add(item);
            }
        }
        return lista_;
    }

    int countByCondition(ItemCondition stan)
    {

        System.out.println("Liczenie Produktów" + stan.toString() );
        int ilość = 0;
        for(Item item: lista_produktów.keySet())
        {
            if(item.stan == stan)
            {
                ilość = ilość + lista_produktów.get(item);
            }
        }
        return ilość;
    }

    void summary()
    {

        System.out.println("Podsumowanie:");
        for(Item item: lista_produktów.keySet())
        {
            System.out.println(item);
            System.out.println("Ilość: " + lista_produktów.get(item));
        }
    }

    List<Item> sortByName()
    {
        System.out.println("Sortowanie po nazwie...");
        boolean posortowane = false;
        List<Item> lista_ = new ArrayList<Item>();
        Set<Item> lista = new HashSet<Item>(lista_produktów.keySet());
        int i_max = lista_produktów.size();
        for(int i = 0; i < i_max; i++)
        {
            Item the = lista.iterator().next();
            for(Item item : lista)
            {
                if(the.nazwa.compareToIgnoreCase(item.nazwa) == -1) { the = item; }
            }
            lista_.add(the);
            lista.remove(the);
        }
        return lista_;
    }

    List<Item> sortByName2()
    {
        System.out.println("Sortowanie po nazwie...");
        boolean posortowane = false;
        List<Item> lista_ = new ArrayList<Item>();
        Set<Item> lista = new HashSet<Item>(lista_produktów.keySet());
        int i_max = lista_produktów.size();
        for(int i = 0; i < i_max; i++)
        {
            Item the = lista.iterator().next();
            for(Item item : lista)
            {
                if(the.nazwa.compareToIgnoreCase(item.nazwa) == -1) { the = item; }
            }
            lista_.add(the);
            lista.remove(the);
        }
        return lista_;
    }


    List<Item> sortByAmount()
    {

        System.out.println("Sortowanie według ilości");
        List<Item> lista_ = new ArrayList<Item>();
        for(int i = 0; i < lista_produktów.size(); i++)
        {
            Item the = lista_produktów.entrySet().iterator().next().getKey();
            for(Item item : lista_produktów.keySet())
            {
                if(lista_produktów.get(item) > lista_produktów.get(the))
                {
                    the = item;
                }

            }
            lista_.add(the);
            lista_.remove(the);
        }
        return lista_;
    }

    Item max()
    {

        System.out.println("Zwracanie najliczniejszego produktu");
        Item the = lista_produktów.entrySet().iterator().next().getKey();
        for(Item item : lista_produktów.keySet())
        {
            if(lista_produktów.get(item) > lista_produktów.get(the))
            {
                the = item;
            }
        }

        //Collections.max(lista_produktów.values());
        return the;
    }
}
