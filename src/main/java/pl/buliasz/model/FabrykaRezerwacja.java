package pl.buliasz.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FabrykaRezerwacja implements IFabrykaRezerwacja{
    List<IRezerwacja> rezerwacjaList;
    FabrykaRezerwacja(ResultSet resultSet){
        List<IRezerwacja> list = new ArrayList<>();
        while (true) {
            try {
                if (!resultSet.next()) break;
                list.add(new Rezerwacja(resultSet.getInt(1),
                        resultSet.getInt(2),resultSet.getInt(3),
                        resultSet.getString(4),resultSet.getString(5),
                        resultSet.getString(6)) {
                });
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            resultSet.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        rezerwacjaList = list;
    }
    public ListaRezerwacja weźRezerwacje(){
        return new ListaRezerwacja(rezerwacjaList);
    }
}
