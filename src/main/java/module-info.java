module pl.buliasz.bazydanychfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens pl.buliasz.bazydanychfx to javafx.fxml;
    exports pl.buliasz.bazydanychfx;
}