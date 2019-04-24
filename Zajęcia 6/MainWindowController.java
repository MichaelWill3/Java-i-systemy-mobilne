import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
    @FXML
    TextArea description;
    @FXML
    ListView ToDoList, InProgressList, DoneList;
    MyListView MyToDoList, MyInProgressList, MyDoneList;

    @FXML
    void showPopup()
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Popup.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        PopupController Popup = loader.getController();
        Popup.giveList(MyToDoList);

        Parent p = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(p));
        stage.show();

    }


    private void swapItems(MyListView from, MyListView to)
    {
        String title = from.List.getSelectionModel().getSelectedItem();
        Item taskToMove = from.getTaskFromName(title);
        to.addTask(taskToMove);
        from.removeTask(title);

        from.List.getItems().removeAll(from.List.getSelectionModel().getSelectedItems());
    }
    @FXML
    void fromToDoToInProgress()
    {
        swapItems(MyToDoList, MyInProgressList);
    }
    @FXML
    void FromInProgressToToDo()
    {
        swapItems(MyInProgressList, MyToDoList);
    }
    @FXML
    void FromInProgressToDone()
    {
        swapItems(MyInProgressList, MyDoneList);
    }
    @FXML
    void FromDoneToInProgress()
    {
        swapItems(MyDoneList, MyInProgressList);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MyToDoList = new MyListView(ToDoList);
        MyInProgressList = new MyListView(InProgressList);
        MyDoneList = new MyListView(DoneList);

        ContextMenu ToDo = new ContextMenu();
        MenuItem removeToDo = new MenuItem("remove");
        ToDo.getItems().add(removeToDo);
        MenuItem alterToDo = new MenuItem("alter");
        ToDo.getItems().add(alterToDo);
        ToDoList.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent t) {
                if(t.getButton() == MouseButton.SECONDARY) {
                    String focused = ToDoList.getSelectionModel().getSelectedItem().toString();
                    MyToDoList.removeTask(focused);
                }
            }
        });



        /*
        MyToDoList.List.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> list) {
                final ListCell cell = new ListCell();
                cell.setOnMouseEntered(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        Item task = MyToDoList.getTaskFromName(cell.getText());
                        description.setText(
                            cell.getText() + "\n\n" +
                            task.getDescription() + "\n\n" +
                            task.getPriority().toString()
                        );

                    }
                });
                return cell;
            }
        });
        */
    }
    @FXML
    void clickOnToDoList()
    {
        String title = MyToDoList.List.getSelectionModel().getSelectedItem();
        Item item = MyToDoList.getTaskFromName(title);
        description.setText(
                item.getTitle() + "\n\n" +
                        "Description:\n" + item.getDescription() + "\n\n" +
                        "Priority: " + item.getPriority().toString() +
                        "\n\nDeadline:\n" + item.getDeadline().toString()
        );
    }
    @FXML
    void clickOnInProgressList()
    {
        String title = MyInProgressList.List.getSelectionModel().getSelectedItem();
        Item item = MyInProgressList.getTaskFromName(title);
        description.setText(
                item.getTitle() + "\n\n" +
                        "Description:\n" + item.getDescription() + "\n\n" +
                        "Priority: " + item.getPriority().toString() +
                        "\nDeadline:\n" + item.getDeadline().toString()
        );
    }
    @FXML
    void clickOnDoneList()
    {
        String title = MyDoneList.List.getSelectionModel().getSelectedItem();
        Item item = MyDoneList.getTaskFromName(title);
        description.setText(
                item.getTitle() + "\n\n" +
                        "Description:\n" + item.getDescription() + "\n\n" +
                        "Priority: " + item.getPriority().toString() +
                        "\nDeadline:\n" + item.getDeadline().toString()
        );
    }
}
