package pl.buliasz.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FabrykaSeans implements IFabrykaSeans{
    List<ISeans> seansList;
    FabrykaSeans(ResultSet resultSet){
        List<ISeans> list = new ArrayList<>();
        while (true) {
            try {
                if (!resultSet.next()) break;
                list.add(new Seans(resultSet.getInt(1),
                        resultSet.getInt(2),resultSet.getInt(3),
                        resultSet.getString(4),resultSet.getString(5),
                        resultSet.getBoolean(6),resultSet.getBoolean(7),
                        resultSet.getBoolean(8)) {
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
        seansList = list;
    }
    public ListaSeans weźSeans(){
        return new ListaSeans(seansList);
    }
}
