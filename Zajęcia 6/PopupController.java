import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.awt.*;
import java.time.LocalDate;
import java.util.Date;

public class PopupController {
    @FXML
    DatePicker Deadline;
    private MyListView ToDoList;
    @FXML
    TextField Title;
    @FXML
    TextArea DescriptionInput;
    @FXML
    RadioButton RadioHigh, RadioMed, RadioLow;
    Priority radio = Priority.Low;
    @FXML
    void addTaskButtonController()
    {
        ToDoList.addTask(new Item(Title.getText(), DescriptionInput.getText(), radio, (LocalDate)Deadline.getValue()));
        Stage stage = (Stage) Title.getScene().getWindow();
        stage.close();
    }

    @FXML
    void setRadioLow()
    {
        radio = Priority.Low;
        RadioLow.setSelected(true);
        RadioMed.setSelected(false);
        RadioHigh.setSelected(false);
    }
    @FXML
    void setRadioMed()
    {
        radio = Priority.Medium;
        RadioLow.setSelected(false);
        RadioMed.setSelected(true);
        RadioHigh.setSelected(false);
    }
    @FXML
    void setRadioHigh()
    {
        radio = Priority.High;
        RadioLow.setSelected(false);
        RadioMed.setSelected(false);
        RadioHigh.setSelected(true);
    }

    public void giveList(MyListView _MyToDoList)
    {
        ToDoList = _MyToDoList;
    }

}
