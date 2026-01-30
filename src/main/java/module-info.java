module pl.buliasz.widok {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens pl.buliasz.widok to javafx.fxml;
    exports pl.buliasz.widok;
    exports pl.buliasz.Instancje;
    opens pl.buliasz.Instancje to javafx.fxml;
}