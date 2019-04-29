import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import java.time.LocalDate;
import java.util.Vector;

public class MyListView {
    public ListView<String> List;
    private ObservableList<String> Observable;
    private Vector<Item> Items = new Vector<>();

    public MyListView(ListView<String> _List)
    {
        List = _List;
        Observable = _List.getItems();

    }

    public Item getTaskFromName(String name)
    {
        Item item_ = new Item("","", Priority.UNDEFINED, LocalDate.MIN);
        for(Item item : Items){if(item.getTitle() == name){item_ = item; break;}}
        return item_;
    }
    public void addTask(Item item)
    {
        Items.add(item);
        Observable.add(item.getTitle());
    }
    public void removeTask(String title)
    {
        //Item itemToRemove = new Item("","",Priority.UNDEFINED, LocalDate.MIN);
        for(Item item : Items) {if(item.getTitle() == title) {Items.remove(item); return;}}
        //List.getItems().remove(itemToRemove.getTitle());
        //Items.remove(itemToRemove);
    }

    public String serialize()
    {
        if(Items.size() ==0)
            return "";
        String line = "";
        for(int i = 0;  i < Items.size(); i++)
        {
            line = line + "\"" + Items.get(i).getTitle() + "\",\"" +  Items.get(i).getDescription() + "\",\"" +  Items.get(i).getDeadline() + "\",\"" +  Items.get(i).getPriority() + "\",";

        }
        if(toString().length() > 1)
            line = line.substring(0, line.length()-1);
        return line;
    }
}
