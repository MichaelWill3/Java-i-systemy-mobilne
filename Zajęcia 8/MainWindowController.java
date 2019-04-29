import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {
    static private Boolean S;
    static private Boolean H;
    static private Boolean O;
    static private Boolean W;
    static private Boolean T;
    static private Boolean I;
    static private Boolean M;
    static private Boolean E;
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
        Scene s = new Scene(p);

        s.setOnKeyPressed(e -> {
            switch(e.getCode())
            {
                case S:
                    System.out.println("Pressed S");
                    S = true;
                    break;
                case H:
                    if(S)
                        H = true;
                    else {
                        S = false;
                        H = false;
                        O = false;
                        W = false;
                        T = false;
                        I = false;
                        M = false;
                        E = false;
                    }
                    break;
                case O:
                    if(S && H)
                        O = true;
                    else {
                        S = false;
                        H = false;
                        O = false;
                        W = false;
                        T = false;
                        I = false;
                        M = false;
                        E = false;
                    }
                    break;
                case W:
                    if(S && H && O)
                        W = true;
                    else {
                        S = false;
                        H = false;
                        O = false;
                        W = false;
                        T = false;
                        I = false;
                        M = false;
                        E = false;
                    }
                    break;
                case T:
                    if(S && H && O && W)
                        T = true;
                    else {
                        S = false;
                        H = false;
                        O = false;
                        W = false;
                        T = false;
                        I = false;
                        M = false;
                        E = false;
                    }
                    break;
                case I:
                    if(S && H && O && W && T)
                        I = true;
                    else {
                        S = false;
                        H = false;
                        O = false;
                        W = false;
                        T = false;
                        I = false;
                        M = false;
                        E = false;
                    }
                    break;
                case M:
                    if(S && H && O && W && T && I)
                        M = true;
                    else {
                        S = false;
                        H = false;
                        O = false;
                        W = false;
                        T = false;
                        I = false;
                        M = false;
                        E = false;
                    }
                    break;
                case E:
                    if(S && H && O && W && T && I) {
                        E = true;
                        SHOWTIME();
                    }
                    else {
                        S = false;
                        H = false;
                        O = false;
                        W = false;
                        T = false;
                        I = false;
                        M = false;
                        E = false;
                    }
                    break;
                default:
                    S = false;
                    H = false;
                    O = false;
                    W = false;
                    T = false;
                    I = false;
                    M = false;
                    E = false;
                    break;

            }
        });

        stage.setScene(s);
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
        S = false;
        H = false;
        O = false;
        W = false;
        T = false;
        I = false;
        M = false;
        E = false;
        Scene s = ToDoList.getScene();
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
    @FXML
    void serialize() throws IOException
    {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Text files", "csv", "txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();

            if(!file.exists()) {
                file.createNewFile();
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(MyToDoList.serialize());
            writer.newLine();
            writer.append(MyInProgressList.serialize());
            writer.newLine();
            writer.append(MyDoneList.serialize());
            writer.close();
        }
    }
    @FXML
    void deserialize() throws IOException {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Text files", "csv", "txt");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);

        boolean doList1 = true;
        boolean doList2 = true;
        boolean doList3 = true;

        File file = chooser.getSelectedFile();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line1 = reader.readLine();
        try {
            String[] data1 = line1.split(",");

            for (int i = 0; i < data1.length; i += 4) {
                String title = data1[i].substring(1, data1[i].length() - 1);

                String description = data1[i + 1].substring(1, data1[i+1].length() - 1);
                LocalDate localDate = LocalDate.now();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = data1[i + 2].substring(1, data1[i+2].length() - 1);
                try {
                    Date date = format.parse(dateString);
                    localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Priority priority;
                if (data1[i+3].substring(1, data1[i+3].length() - 1) == "Low") {
                    priority = Priority.Low;
                } else if (data1[i+3].substring(1, data1[i+3].length() - 1) == "Medium") {
                    priority = Priority.Medium;
                } else {
                    priority = Priority.High;
                }

                MyToDoList.addTask(new Item(title, description, priority, localDate));
            }

        }catch(NullPointerException e)
        {
        }
        String line2 = reader.readLine();
        try {
            String[] data2 = line2.split(",");
            for (int i = 0; i < data2.length; i += 4) {
                String title = data2[i].substring(1, data2[i].length() - 1);

                String description = data2[i + 1].substring(1, data2[i+1].length() - 1);
                LocalDate localDate = LocalDate.now();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = data2[i + 2].substring(1, data2[i+2].length() - 1);
                try {
                    Date date = format.parse(dateString);
                    localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Priority priority;
                if (data2[i+3].substring(1, data2[i+3].length() - 1) == "Low") {
                    priority = Priority.Low;
                } else if (data2[i+3].substring(1, data2[i+3].length() - 1) == "Medium") {
                    priority = Priority.Medium;
                } else {
                    priority = Priority.High;
                }

                MyInProgressList.addTask(new Item(title, description, priority, localDate));
            }

        }catch(NullPointerException e)
        {
        }
        String line3 = reader.readLine();
        try {
            String[] data3 = line3.split(",");

            for (int i = 0; i < data3.length; i += 4) {
                String title = data3[i].substring(1, data3[i].length() - 1);

                String description = data3[i + 1].substring(1, data3[i+1].length() - 1);
                LocalDate localDate = LocalDate.now();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = data3[i + 2].substring(1, data3[i+2].length() - 1);
                try {
                    Date date = format.parse(dateString);
                    localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Priority priority;
                if (data3[i+3].substring(1, data3[i+3].length() - 1) == "Low") {
                    priority = Priority.Low;
                } else if (data3[i+3].substring(1, data3[i+3].length() - 1) == "Medium") {
                    priority = Priority.Medium;
                } else {
                    priority = Priority.High;
                }

                MyDoneList.addTask(new Item(title, description, priority, localDate));
            }
        }catch(NullPointerException e)
        {
        }

    }

    void SHOWTIME()
    {
        MyToDoList.addTask(new Item("A", "Aaaaaa aaaaa a", Priority.Low, LocalDate.now()));
        MyInProgressList.addTask(new Item("Aa", "Aaaaaa aaaaa a", Priority.High, LocalDate.now()));
        MyDoneList.addTask(new Item("Aaa", "Aaaaaa aaaaa a", Priority.High, LocalDate.now()));


        MyToDoList.addTask(new Item("B", "Bbbb Bb", Priority.Low, LocalDate.now()));
        MyInProgressList.addTask(new Item("Bb", "Bbbbbb", Priority.High, LocalDate.now()));
        MyDoneList.addTask(new Item("Bbb", "bbbbbbbbbbbbbbbbbbbbbbbbbbb b b b b bbbbb", Priority.High, LocalDate.now()));

        MyToDoList.addTask(new Item("C", "CCcccccccccccccccCc", Priority.Low, LocalDate.now()));
        MyInProgressList.addTask(new Item("Cc", "Ccccccccccccc c cccccccc", Priority.High, LocalDate.now()));
        MyDoneList.addTask(new Item("Ccc", "Ccccccccccccccccccccccccccccbccccccccc", Priority.Low, LocalDate.now()));
    }
}
