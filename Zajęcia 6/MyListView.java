import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.time.LocalDate;
import java.util.Date;
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
        Item itemToRemove = new Item("","",Priority.UNDEFINED, LocalDate.MIN);
        for(Item item :Items) {if(item.getTitle() == title) {itemToRemove = item; return;}}
        List.getItems().remove(itemToRemove.getTitle());
        Items.remove(itemToRemove);
    }
}
