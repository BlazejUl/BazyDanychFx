package pl.buliasz.widok;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class KontrolerPWindow {
    public void open() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(KontrolerPWindow.class.getResource("kontrolerP-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Kino Pracownik");
        stage.setScene(scene);
        stage.show();
    }
}
