module pl.buliasz.bazydanychfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens pl.buliasz.bazydanychfx to javafx.fxml;
    exports pl.buliasz.bazydanychfx;
}