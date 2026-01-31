package pl.buliasz.widok;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RezerwacjeWindow {
    public void open() throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(KontrolerPWindow.class.getResource("rezerwacje-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        stage.setTitle("Kino Rezerwacje");
        stage.setScene(scene);
        stage.show();
    }
}
