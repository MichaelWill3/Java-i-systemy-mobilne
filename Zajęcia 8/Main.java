import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        primaryStage.setTitle("Kanban 100% LEGIT >>>FREE<<< 2019 NO VIRUS");
        primaryStage.setScene(new Scene(root, 600,400));
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
