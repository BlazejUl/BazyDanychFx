package pl.buliasz.kontroler;

import pl.buliasz.model.DAO;
import pl.buliasz.model.IDAO;

import java.io.IOException;
import java.sql.SQLException;

public class SystemKina {
    public static void main(String[] args) throws SQLException, IOException {
        IDAO dao = new DAO("KierownikPass1!","kierownik","jdbc:mysql://localhost:3306/kino");


    }
}