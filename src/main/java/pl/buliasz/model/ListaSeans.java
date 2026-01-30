package pl.buliasz.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListaSeans {
    List<ISeans> listaSeans;

    ListaSeans(List<ISeans> listaSeans){
        this.listaSeans = listaSeans;
    }

    List<ISeans> weźWszystko(){
        return listaSeans;
    }
    ISeans znajdźSeans(int id){
        for (ISeans seans:listaSeans){
            if (seans.getId()==id) return seans;
        }
        return null;
    }
}
