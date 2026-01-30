package pl.buliasz.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDAO {

    IFabrykaSeans aktualizujSeans();

    IFabrykaRezerwacja aktualizujRezerwacja();

    void dodajSeans(ISeans seans);

    void usuńSeans(int id);

    void edytujSeans(ISeans seans);

    void dodajRezerwacja(IRezerwacja rezerwacja);

    void usuńRezerwacja(int id);

    void edytujRezerwacja(IRezerwacja rezerwacja);

    ResultSet getConnection(String sql);

    void voidConnection(String sql);

    void tryConnection() throws SQLException;

    String dajUsername();
}
