package pl.buliasz.widok;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SeanseWindow {
    public void open() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(KontrolerPWindow.class.getResource("seanse-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Kino Kierownik");
        stage.setScene(scene);
        stage.show();
    }
}
