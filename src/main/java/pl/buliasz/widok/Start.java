package pl.buliasz.widok;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.buliasz.Instancje.DAOinstance;
import pl.buliasz.Instancje.KontrolerPracownikInstance;
import pl.buliasz.Instancje.ModelInstance;

import java.io.IOException;

public class Start extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        new DAOinstance();
        new ModelInstance();
        new KontrolerPracownikInstance();
        FXMLLoader fxmlLoader = new FXMLLoader(Start.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        stage.setTitle("Logowanie");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }


}